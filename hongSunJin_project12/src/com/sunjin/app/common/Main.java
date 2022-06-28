package com.sunjin.app.common;

import java.util.Scanner;

import com.sunjin.app.member.Member;
import com.sunjin.app.member.MemberDAO;

public class Main {
	private Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	private static Member Login = null;

	public static Member getLogin() {
		return Login;
	}

	public Main() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 입장하기
//				MemberOrNot();
				new Login();
			} else if (menuNo == 0) {
				// 끝내기
				exit(); // --> 정말 나가시겠습니까?
				break;
			} else {
				showInputError();
			}
		}
	}
//
//	private void MemberOrNot() {
//		int answer = YesOrNot();
//		while (true) {
//		System.out.println("이미 럭셔리모먼트 회원이신가요?");
//		System.out.println("1 네  |  2 아니오(회원가입)");
//			if (answer == 1) {
//				System.out.println("로그인을 해주세요!");
//					login();
//			} else if (answer == 0) {
//				System.out.println("회원이 되시면 무궁무진한 혜택이 기다리고 있어요!");
//				System.out.println("          가입 하시겠습니까?");
//				System.out.println("     1 네  | 2 아니오");
//				if (answer == 1) {
//					signUp();
//				} else if (answer == 0) {
//					break;
//				}
//			}
//		}
//	}

	private int YesOrNot() {
		return Integer.parseInt(sc.nextLine());
	}

	
	private void exit() {
		int answer = YesOrNo();
		while (true) {
			if (answer == 1) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else if (answer == 0) {
				// 뒤로가기
				break;
			}
		}
	}

	private int YesOrNo() {
		System.out.println();
		System.out.println("                                아직 대여가능한 무궁무진한 상품들이 남아있습니다.");
		System.out.println("                                     그래도 프로그램을 종료하시겠습니까?");
		System.out.println();
		System.out.println("                                     1 종료할래요  |  0 더 구경할래요!");
		return Integer.parseInt(sc.nextLine());
	}

	private void showInputError() {
		System.out.println("잘못된 입력입니다");
	}

	private void menuPrint() {
		System.out.println();
		System.out.println("                                 럭셔리모먼트에 오신것을 환영합니다!     ");
		System.out.println();
		System.out.println("=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("                                1 입장하기              0 종료");
		System.out.println();
		System.out.println("=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");

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
}
