package phamthuy.ptithcm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.mapper.MemberMapper;
import phamthuy.ptithcm.model.Member;
import phamthuy.ptithcm.model.Role;

public class MemberDao extends AstractDao {

	public int add(Member member) {
		String pass = Helper.bCrypt(member.getPassword());
		int a = getJdbcTemplate().update(
				"INSERT INTO dbo.Member( Username ,Password ,Email ,Gender , Tel) VALUES(?,?,?,?,?)",
				member.getUsername(), pass, member.getEmail(), member.getGender(), member.getTel());

		System.out.println("so a: " + a);
		if (a > 0) {
			int id = getMemberIDByEmail(member.getEmail());
			System.out.println("id user: " + id);
			if (id != -1) {
				int b = getJdbcTemplate().update("INSERT INTO MemberInRole(MemberId, RoleId) VALUES(?, ?)", id, 1);
				return a + b;
			}
		}
		return a;
	}

	public int updatePassword(String newPass, String email) {
		String passbCrypt = Helper.bCrypt(newPass);
		int a = getJdbcTemplate().update(
				"UPDATE dbo.Member SET Password =? WHERE Email = ?",
				passbCrypt, email);
		return a;
	}
	
	public int getMemberIDByEmail(String email) {
		List<Member> listMember = getJdbcTemplate().query("SELECT * FROM dbo.Member WHERE Email = ?",
				new MemberMapper(), email);
		if (listMember.size() > 0) {
			return listMember.get(0).getId();
		}
		return -1;
	}

	public int getMemberIDByPhone(String phone) {
		List<Member> listMember = getJdbcTemplate().query("SELECT * FROM dbo.Member WHERE Tel = ?", new MemberMapper(),
				phone);
		if (listMember.size() > 0) {
			return listMember.get(0).getId();
		}
		return -1;
	}

	public Member login(String password, String email) {
		List<Member> listMember = getJdbcTemplate().query("SELECT * FROM dbo.Member WHERE (Email =? OR Tel =?)",
				new MemberMapper(), email, email);
		if (listMember.size() > 0) {
			if (Helper.encryptionBCrypt(password, listMember.get(0).getPassword()) == true)
				return listMember.get(0);
			//sai mat khau
			else
				return null;
		}
		return null;
	}

	public Role getRoleLogin(int id) {
		List<Role> role = getJdbcTemplate().query(
				"SELECT * FROM dbo.Role WHERE RoleId = (SELECT RoleId FROM dbo.MemberInRole WHERE MemberId = ?)",
				new RowMapper<Role>() {

					@Override
					public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Role(rs.getInt("RoleId"), rs.getString("RoleName"));
					}

				}, id);
		if (role.size() > 0) {
			return role.get(0);
		}
		return null;
	}
}
