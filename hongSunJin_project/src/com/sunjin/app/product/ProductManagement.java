package com.sunjin.app.product;

import java.util.List;

import com.sunjin.app.common.Management;

public class ProductManagement extends Management {
//제품 정보 수정 가능한 생성자(등록, 수정, 삭제, 단건/전체 조회)
	public ProductManagement() {
		boolean role = selectRole(); // Management
		while (true) {
			menuPrint(role);
			int menuNo = menuSelect();
			if (menuNo == 1 && role) {
				// 제품 정보 등록
				insertProduct(); // 이 안에서 간단한 기능이 실행되는 것이 아니라 프로그램을 실행시키도록
			} else if (menuNo == 2 && role) {
				// 제품 정보 수정 (가격)
				updateProduct();
			} else if (menuNo == 3 && role) {
				// 제품 정보 삭제 (가격)
				deleteProduct();
			} else if (menuNo == 4) {
				// 단품 정보 조회
				selectOne();
			} else if (menuNo == 5) {
				// 전체 정보 조회
				selectAll();
			} else if (menuNo == 9) {
				// 뒤로가기 - 종료되면 inputProductInfo()로 돌아감.
				back();
				break;
			} else {
				// 입력 오류
				showInputError();
			}
		}
	}

	private void back() {
		System.out.println("메인메뉴로 돌아갑니다");
	}

	private void selectAll() {
		List<Product> list = proDAO.selectAll();
		
		for (Product product : list) {
			System.out.println(product);
		}
	}

	private void selectOne() {
		String productName = inputName();
	}

	private void deleteProduct() {
		// TODO Auto-generated method stub

	}

	private void updateProduct() {
		// TODO Auto-generated method stub

	}

	private void insertProduct() {
		// TODO Auto-generated method stub

	}

	private void menuPrint(boolean role) {
		// TODO Auto-generated method stub

	}

}
