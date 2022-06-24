package com.sunjin.app.common;


import java.util.Scanner;

import com.sunjin.app.member.Member;
import com.sunjin.app.member.MemberDAO;

public class Login {
	private Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	private static Member Login = null;

	public static Member getLogin() {
		return Login;
	}

	public Login() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 로그인
				login();
			} else if (menuNo == 2) {
				// 회원가입
				signUp();
			} else if (menuNo == 2) {
				// 종료
				exit();
			} else {
				showInputError();
			}
		}
	}

	private void menuPrint() {
		System.out.println();
		System.out.println("     럭셔리모먼트에 오신것을 환영합니다!    ");
		System.out.println();
		System.out.println("=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=");
		System.out.println("   1 입장     2 회원가입     3 종료 ");
		System.out.println("=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=");
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요!");
		}
		return menuNo;
	}

	// 로그인
	private void login() {
		// 로그인 되는 권한에 따라 실행되는 클래스가 다르도록
		// 아이디와 비밀번호 입력
		System.out.println("로그인 해주세요!");
		System.out.println();
		Member inputIdPwd = inputMember();

		// 로그인 시도
		Login = MemberDAO.getInstance().selectRole(inputIdPwd);

		// 실패할 경우 종료(첫 화면으로 리턴)
		if (Login == null) {
			System.out.println("로그인 실패");
			return;
		}
		// 성공할 경우에만 프로그램 -> Sys매니지먼트 실행
		new LogInSys().run();
	}

	private Member inputMember() {
		Member info = new Member();
		System.out.println("아이디 -> ");
		info.setId(sc.nextLine());
		System.out.println("비밀번호 -> ");
		info.setPwd(sc.nextLine());

		return info;
	}

	// 사인업 만들어주고 불러쓰면 회원가입도 할 수 있도록
	private void signUp() {
		//insert
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다");
	}
	private void showInputError() {
		System.out.println("잘못된 입력입니다");
	}

}
