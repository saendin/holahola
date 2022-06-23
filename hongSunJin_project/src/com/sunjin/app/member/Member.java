package com.sunjin.app.member;
import lombok.*;

@Getter
@Setter
public class Member {
	private String id;
	private String pwd;
	
	//0: 관리자 / 1: 일반
	private int role;


	@Override
	public String toString() {
		//권한에 따라 다르게 출력하도록
		String info = "";
		if(role == 0) {
			info = "관리자 계정 : " + id;
			
		} else {
			info = "일반회원 계정 : " + id; 
		}
		return info;
	}
	
	
}
