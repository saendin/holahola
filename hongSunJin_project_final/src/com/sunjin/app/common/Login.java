package com.sunjin.app.common;

import java.util.Scanner;

import com.sunjin.app.member.Member;
import com.sunjin.app.member.MemberDAO;

public class Login {
	private Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	private static Member Login = null;
	private int roleOut;

	public static Member getLogin() {
		return Login;
	}

	public Login() {
		roleOut = 0;
		
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 로그인
				roleOut = login();
				if(roleOut == 1) {
					return;
				}
			} else if (menuNo == 2) {
				// 회원가입
				signUp();
			} else if (menuNo == 0) {
				// 뒤로가기
				break;
			} else {
				showInputError();
			}
		}
	}
	

	// 메뉴프린트
	private void menuPrint() {
		System.out.println();
		System.out.println("                                  이미 럭셔리모먼트 회원이신가요?    ");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("                              [1] 네   [2] 아니오   [0] 뒤로가기");
		System.out.println("                                        (회원가입)");
		System.out.println();
	}

	// 메뉴받기
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("                                  잘못된 입력입니다 !");
		}
		return menuNo;
	}

	// 로그인
	private int login() {
		// 아이디와 비밀번호 입력
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("                                       로그인 해주세요 !");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		Member inputIdPwd = inputMember();

		// role값에 따라 로그임 - 관리자(0) / 회원(1)
		Login = MemberDAO.getInstance().selectRole(inputIdPwd);

		// 실패할 경우 종료(첫 화면으로 리턴)
		if (Login == null) {
			System.out.println("                                 아이디나 비밀번호를 확인해주세요 !");
			return 0;
		}
		// 성공할 경우 메뉴 실행
		roleOut = new LogInSys().run();
		return roleOut;
	}

	// 아이디, 비밀번호 입력받기
	private Member inputMember() {
		Member info = new Member();
		System.out.println();
		System.out.println();
		System.out.print("                                  아이디 -> ");
		info.setId(sc.nextLine());
		System.out.println();
		System.out.println();
		System.out.print("                                 비밀번호 -> ");
		info.setPwd(sc.nextLine());
		System.out.println();
		System.out.println();
		return info;
	}

	// 회원가입
	private void signUp() {
		// insert
		Member member = inputMemberInfo();
		mDAO.insert(member); // ->회원등록
	}

	// --회원가입 정보 기입
	private Member inputMemberInfo() {
		Member member = new Member();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println();
		System.out.println("                                  아래에 정보를 기입해주세요!");
		System.out.println();
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();

		// 아이디 중복체크 후 회원가입
		while (true) {
			String newId = inputId();
			Member id = mDAO.findId(newId);
			if (id == null) {
				System.out.println();
				System.out.println("                                  사용 가능한 아이디입니다 !");
				System.out.println();
				member.setId(newId);

				System.out.print("                               비밀번호 -> ");
				member.setPwd(sc.nextLine());
				System.out.println();

				System.out.print("                                  이름 -> ");
				member.setName(sc.nextLine());
				System.out.println();

				System.out.print("                                 이메일 ->");
				member.setEmail(sc.nextLine());
				System.out.println();

				System.out.print("                                 휴대폰 -> ");
				member.setPhone(Integer.parseInt(sc.nextLine()));
				System.out.println();

				return member;
			} else {
				System.out.println();
				System.out.println("                                   사용중인 아이디입니다 !");
				System.out.println("                                새로운 아이디를 입력해주세요 !");
				System.out.println();
			}
		}
	}

	private String inputId() {
		System.out.println();
		System.out.println();
		System.out.print("                                아이디 -> ");
		return sc.nextLine();
	}

	private void showInputError() {
		System.out.println();
		System.out.println("                                      잘못된 입력입니다 !");
		System.out.println();
	}

}
