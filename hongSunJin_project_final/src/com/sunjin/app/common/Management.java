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

	protected boolean selectRole() {
		int role = Login.getLogin().getRole();
		if (role == 0) {
			return true; // 관리자 권한으로 실행
		} else {
			return false; // 회원 권한으로 실행
		}
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
	
	protected void showInputError() {
		System.out.println("잘못된 입력입니다");
	}

}
