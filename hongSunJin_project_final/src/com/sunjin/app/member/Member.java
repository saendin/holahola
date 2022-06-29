package com.sunjin.app.member;
//import lombok.*;
//
//@Getter
//@Setter
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int phone;
	
	//0: 관리자 / 1: 일반
	private int role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		//권한에 따라 다르게 출력하도록
		String info = "";
		if(role == 0) {
			info = "[관리자]";
		} else if (role == 1) {
			info = "[일반회원]"; 
		}
		return 	info + id
				+ "\n이름     " + name
				+ "\n휴대폰번호 0" + phone
				+ "\n이메일    " + email
				+ "\n";
	}
	
	
}
