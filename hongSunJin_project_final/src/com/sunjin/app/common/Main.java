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
	//메인메뉴
	public Main() {
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 입장하기
				new Login();
			} else if (menuNo == 0) {
				// 끝내기
				// --> 정말 나가시겠습니까?
				int bye = exit();
				if (bye == 1) {
					break;
				} else if (bye == 0)
					continue;
			} else {
				showInputError();
			}
		}
	}
	// 메뉴
	private void menuPrint() {
		System.out.println();
		System.out.println("                               럭셔리모먼트에 오신것을 환영합니다!     ");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println();
		System.out.println("                              [1] 입장하기             [0] 종료");
		System.out.println();
		System.out.println(
				"=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		
	}
	// 메뉴선택
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("                                     잘못된 입력입니다!");
			System.out.println();
		}
		return menuNo;
	}
	//오류문구 출력
	private void showInputError() {
		System.out.println("                                         잘못된 입력입니다 !");
	}
	//종료확인 출력
	private int exit() {
		int answer = YesOrNo();
		while (true) {
			if (answer == 1) {
				System.out.println();
				System.out.println("                                   프로그램을 종료합니다 !");
				System.out.println();
			}
			return answer;
		}
	}
	//종료확인
	private int YesOrNo() {
		int answer = 0;
		try {
			System.out.println();
			System.out.println("                           아직 대여가능한 무궁무진한 상품들이 남아있습니다.");
			System.out.println("                                그래도 프로그램을 종료하시겠습니까 ?");
			System.out.println();
			System.out.println("                             [1] 종료할래요  |  [0] 더 구경할래요!");
			System.out.println();
			answer = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("                                     잘못된 입력입니다 !");
			System.out.println();
		}
		return answer;
	}
}
