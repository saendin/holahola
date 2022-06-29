package com.sunjin.app.common;

import java.util.Scanner;

import com.sunjin.app.member.Member;
import com.sunjin.app.member.MemberDAO;
import com.sunjin.app.member.MemberManagement;
import com.sunjin.app.product.ProductDAO;
import com.sunjin.app.product.ProductManagement;
import com.sunjin.app.rental.RentalManagement;
import com.sunjin.app.stock.StockInDAO;
import com.sunjin.app.stock.StockManagement;
import com.sunjin.app.stock.StockOutDAO;

public class LogInSys {
	protected MemberDAO mDAO = MemberDAO.getInstance();

	// 필드
	protected Scanner sc = new Scanner(System.in);

	protected ProductDAO proDAO = ProductDAO.getInstance();
	protected StockInDAO sInDAO = StockInDAO.getInstance();
	protected StockOutDAO sOutDAO = StockOutDAO.getInstance();
	private int roleOut = 0;

	// 로그인 후 권한에 따라 프로그램 실행
	public int run() {
		// 메뉴에 따라 프로그램 실행 시키도록.
		// 권한이 0일 때 관리자시스템 실행
		boolean role = selectRole();

		while (true) {
			// 메뉴 출력 - 제품 정보 관리/ 제품 재고 관리/ 종료
			menuPrint(role);

			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 상품 정보 관리
				new ProductManagement();
			} else if (menuNo == 2) {
				// 상품 대여/반납 시스템
				new RentalManagement();
			} else if (menuNo == 9) {

				// 마이페이지
				showMyInfo();
				roleOut = new MemberManagement().runOut();
				if (roleOut == 1) {
					return 1;
				}
			} else if (menuNo == 3 && role) {
				// 관리자만 실행 가능
				// 재고관리
				new StockManagement();
			} else if (menuNo == 0) {
				// 로그아웃
				logOut();
				break;
			} else {
				// 입력 오류
				showInputError();
			}
		}
		return 0;
	}

	// 권한에 따라 실행
	protected boolean selectRole() {
		int role = Login.getLogin().getRole();
		if (role == 0) {
			return true; // 관리자 권한으로 실행
		} else {
			return false; // 회원 권한으로 실행
		}
	}

	// 권한에 따른 메뉴 출력
	private void menuPrint(boolean role) {
		if (!role) {
			String menu1 = "";
			// 회원[1]권한
			menu1 += "[1] 구경하기 | [2] 대여/반납 | [9] 마이페이지 | [0] 로그아웃";
			System.out.println();
			System.out.println(
					"=+=+=+=+=+=+=+=+=+==+=+=+=      럭셔리 모먼트에 오신것을 환영합니다 !      =++=+=+=+=+=+=+==+=+=+=+=+=");
			System.out.println();
			System.out.println("                     " + menu1);
			System.out.println();
			System.out.println(
					"=============================================================================================");
			System.out.println();
		} else {
			String menu2 = "";
			// 관리자[0]권한
			menu2 += "[1] 상품관리 | [3] 재고관리 | [9] 회원관리 | [0] 로그아웃";
			System.out.println();
			System.out.println(
					"======================================      관리      ========================================");
			System.out.println();
			System.out.println("                      " + menu2);
			System.out.println();
			System.out.println(
					"=============================================================================================");
			System.out.println();
		}
	}

	// 메뉴 선택
	protected int menuSelect() {
		int menu = 0;
		try {
			System.out.println();
			menu = Integer.parseInt(sc.nextLine());
			System.out.println();
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("                                   숫자 형식으로 입력해주세요!");
			System.out.println();
		}
		return menu;
	}

	// 마이페이지 선택시 회원정보 보여주기
	private void showMyInfo() {
		String id = Login.getLogin().getId();
		Member member = mDAO.findId(id);
		System.out.println(member);
	}

	// 로그아웃 문구
	protected void logOut() {
		System.out.println();
		System.out.println("                                      정상적으로 로그아웃 되었습니다 !");
		System.out.println();
	}

	// 입력오류 메세지
	protected void showInputError() {
		System.out.println();
		System.out.println("                                            잘못된 입력입니다 !");
		System.out.println();
	}
}
