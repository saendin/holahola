package com.yedam.java.app.common;

import java.sql.SQLException;
import java.util.Scanner;

import com.yedam.app.members.Member;
import com.yedam.app.members.MembersDAO;

public class LoginControl {
	private Scanner sc = new Scanner(System.in);
	private static Member LoginInfo = null;
	public static Member getLoginInfo() {
		return LoginInfo;
	}
	
	public LoginControl() {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//로그인
				login();
			} else if(menuNo == 2) {
				//죵료
				exit();
				break;
			} else {
				showInputError();
			}
		}
	}

	private void showInputError() {
		System.out.println("메뉴를 다시 확인해주세요.");
	}

	private void exit() {
		System.out.println("프로그램이 종료되었습니다.");
	}

	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요");
		}
		return menuNo;
	}

	private void menuPrint() {
		System.out.println("==============");
		System.out.println("1.로그인  2.종료");
		System.out.println("==============");
	}
	
	private void login() {
		//로그인 되는 권한에 따라 실행되는 클래스가 다르도록
		//아이디와 비밀번호 입력
		Member inputInfo = inputMember();
		
		//로그인 시도
		LoginInfo = MembersDAO.getInstance().selectRole(inputInfo);
		
		//실패할 경우 종료(메뉴로 리턴)
		if(LoginInfo == null) return;
		
		
		//성공할 경우에만 프로그램 -> 매니지먼트 실행
		new Management().run();
	}

	private Member inputMember() {
		Member info = new Member();
		System.out.println("아이디 > ");
		info.setMemberId(sc.nextLine());
		System.out.println("비밀번호 > ");
		info.setMemberPassword(sc.nextLine());
		
		return info;
	}
}
