package phamthuy.ptithcm.model;

import java.util.Date;

public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	private int gender;
	private Date addeddate;
	private String tel;
	
	
	public Member() {
		super();
	}
	
	public Member(String username, String password, String email, int gender, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.tel = tel;
	}

	public Member(String username, String password, String email, int gender, Date addeddate, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.addeddate = addeddate;
		this.tel = tel;
	}


	public Member(int id, String username, String password, String email, int gender, Date addeddate, String tel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.addeddate = addeddate;
		this.tel = tel;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getAddeddate() {
		return addeddate;
	}
	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
