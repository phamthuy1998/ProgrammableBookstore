package phamthuy.ptithcm.dao;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.model.Member;

public class MemberDao extends AstractDao {
	public int add(Member obj) {
		obj.setId(Helper.randomLong());
		int a = getJdbcTemplate().update(
				"INSERT INTO Member(MemberId, Username, Password, Email, Gender, Tel, Address) VALUES(?, ?, ?, ?, ?, ?, ?)",
				obj.getId(), obj.getUsername(), Helper.bCrypt(obj.getPassword()), obj.getEmail(), obj.isGender(),
				obj.getTel(), obj.getAddress());
		int b = getJdbcTemplate().update("INSERT INTO MemberInRole(MemberId, RoleId) VALUES(?, ?)", obj.getId(), 1);
		return a + b;
	}
}
