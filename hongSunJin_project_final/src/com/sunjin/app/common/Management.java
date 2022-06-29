package com.sunjin.app.common;

import java.util.Scanner;

import com.sunjin.app.product.ProductDAO;
import com.sunjin.app.rental.RentalDAO;
import com.sunjin.app.rental.ReturnDAO;
import com.sunjin.app.stock.StockInDAO;
import com.sunjin.app.stock.StockManagement;
import com.sunjin.app.stock.StockOutDAO;

public class Management {

	// 필드
	protected Scanner sc = new Scanner(System.in);
	protected ProductDAO proDAO = ProductDAO.getInstance();
	protected StockInDAO sInDAO = StockInDAO.getInstance();
	protected StockOutDAO sOutDAO = StockOutDAO.getInstance();
	protected RentalDAO rentalDAO = RentalDAO.getInstance();
	protected ReturnDAO returnDAO = ReturnDAO.getInstance();

	// +관리자일떄만 아래의 run이 돌아감 / 회원일경우에는 제품 정보 관리가 막힘.
	// 생성자 - 무조건 실행 됨. 그래서 여기선 쓸 수 없음(무한루프에 빠질 가능성ㅇ)
	// -->public void Management() {
	// 생성자 없이 메소드 run(목적이 있기 때문에)으로 변경.
	// run = 실행시키고자 하는 코드를 감싸고자 하는 역할만 수행
	public void run() {
		// 권한 확인 - 권한에 따라 제어하는법(웬만하면 기존의 것 건들이지 않게끔)
		// 메뉴에 따라 프로그램 실행 시키도록.
		while (true) {
			// 메뉴 출력 - 제품 정보 관리/ 제품 재고 관리/ 종료
			menuPrint();

			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품 정보 관리
			} else if (menuNo == 2) {
				// 제품 재고 관리
				new StockManagement();
			} else if (menuNo == 9) {
				// 프로그램 종료
				exit();
				break;
			} else {
				// 입력 오류
				showInputError();
			}
		}
	}

	protected boolean selectRole() {
		int role = Login.getLogin().getRole();
		if (role == 0) {
			return true; // 관리자 권한으로 실행
		} else {
			return false; // 회원 권한으로 실행
		}
	}

	// 관리자용 메뉴
	protected void menuPrint() {
		System.out.println("=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
		System.out.println("                             1 상품정보관리  2 상품재고관리  9 종료"); // role에 따라 구성된 메뉴만 출력
		System.out.println("=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^=^");
	}

	protected int menuSelect() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요!");
		}
		return menu;
	}

	protected void exit() {
		System.out.println("프로그램을 종료합니다");
	}

	protected void showInputError() {
		System.out.println("잘못된 입력입니다");
	}

}
