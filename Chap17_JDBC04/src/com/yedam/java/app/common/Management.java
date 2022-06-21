package com.yedam.java.app.common;

import java.util.Scanner;

import com.yedam.java.app.deal.ReceivingGoodsDAO;
import com.yedam.java.app.deal.TakeOutGoodsDAO;
import com.yedam.java.app.product.ProductInfoManagement;
import com.yedam.java.app.product.ProductsDAO;

//Management를 부모프로그램으로 하는 섭프로그램 (재고 - 입/출고) 만들고임
public class Management {
	// 필드
	protected Scanner sc = new Scanner(System.in);
	protected ProductsDAO pDAO = ProductsDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();

	// 생성자 - 무조건 실행 됨. 그래서 여기선 쓸 수 없음(무한루프에 빠질 가능성ㅇ)
//	public void Management() {
	// 생성자 없이 메소드 run(목적이 있기 때문에)으로 변경.
	public void run() { //run = 실행시키고자 하는 코드를 감싸고자 하는 역할만 수행.
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품 정보 관리
				//(ProductInfoManagemen에서 back했을 때 얘는 생성자에 있기 때문에 실행될 수가 없음.
				new ProductInfoManagement(); // 이 안에서 간단한 기능이 실행되는 것이 아니라 프로그램을 실행시키도록
			} else if (menuNo == 2) {
				// 제품 관리
//				new ProductStockManagement();
			} else if (menuNo == 9) {
				// 프로그램 종료
				exit();
			} else {
				// 입력 오류
				showInputError();
			}
		}
	}

	// 메소드
	protected void menuPrint() {
		System.out.println("=============================");
		System.out.println("1.제품정보관리  2.제품재고관리  9.종료");
		System.out.println("=============================");
	}

	protected int menuSelect() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine()); // 메뉴값 입력받기
		} catch (NumberFormatException e) { // 번호에 대한 오류가 났을 때 아래 구문 표시
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menu;
	}

	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	protected void showInputError() {
		System.out.println("메뉴를 참고해서 입력해주세요");
	}
}
