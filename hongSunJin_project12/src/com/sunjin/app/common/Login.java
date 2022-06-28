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
			} else if (menuNo == 0) {
				// 종료 -> 뒤로가기
				break;
			} else {
				showInputError();
			}
		}
	}

	private void menuPrint() {
		System.out.println();
		System.out.println("                                  이미 럭셔리모먼트 회원이신가요?    ");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("                              1 네   2 아니오(회원가입)   0 뒤로가기");
		System.out.println();
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
			System.out.println("아이디나 비밀번호를 다시 확인해주세요!");
			return;
		}
		// 성공할 경우에만 프로그램 -> Sys매니지먼트 실행
		new LogInSys().run();
	}

	private Member inputMember() {
		Member info = new Member();
		System.out.println();
		System.out.println("                                     아이디를 입력하세요!");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("아이디 -> ");
		info.setId(sc.nextLine());
		System.out.println();
		System.out.println("                                    비밀번호를 입력하세요!");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("비밀번호 -> ");
		info.setPwd(sc.nextLine());
		System.out.println();
		System.out.println();
		return info;
	}

	// 사인업 만들어주고 불러쓰면 회원가입도 할 수 있도록
	private void signUp() {
		// insert
		Member member = inputMemberInfo();
		mDAO.insert(member);
	}

	private Member inputMemberInfo() {
		Member member = new Member();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("                                  아래에 정보를 기입해주세요!");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();

		
		//아이디 중복체크 후 회원가입
		while (true) {
			String newId = inputId();
			Member id = mDAO.findId(newId);
			if (id == null) {
				System.out.println("사용 가능한 아이디입니다");
				member.setId(newId);

				System.out.println("비밀번호");
				member.setPwd(sc.nextLine());

				System.out.println("이름");
				member.setName(sc.nextLine());

				System.out.println("이메일");
				member.setEmail(sc.nextLine());

				System.out.println("휴대폰");
				member.setPhone(Integer.parseInt(sc.nextLine()));
				
				return member;
			} else {
				System.out.println();
				System.out.println("중복된 아이디입니다!");
				System.out.println("새로운 아이디를 입력해주세요");
				System.out.println();
			}
		}
	}

	private String inputId() {
		System.out.println("아이디");
		return sc.nextLine();
	}

	private void showInputError() {
		System.out.println("잘못된 입력입니다");
	}

}
