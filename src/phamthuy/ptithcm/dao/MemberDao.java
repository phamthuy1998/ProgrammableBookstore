package phamthuy.ptithcm.dao;

import java.util.List;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.mapper.MemberMapper;
import phamthuy.ptithcm.model.Member;

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

	public int getMemberIDByEmail(String email) {
		List<Member> listMember = getJdbcTemplate().query("SELECT * FROM dbo.Member WHERE Email = ?",
				new MemberMapper(), email);
		if (listMember.size() > 0) {
			return listMember.get(0).getId();
		}
		return -1;
	}
}
