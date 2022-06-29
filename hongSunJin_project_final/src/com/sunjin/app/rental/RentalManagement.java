package com.sunjin.app.rental;

import java.util.List;

import com.sunjin.app.common.Login;
import com.sunjin.app.common.Management;
import com.sunjin.app.product.Product;

public class RentalManagement extends Management {

	public RentalManagement() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();

			// 대여
			if (menuNo == 1) {
				rentOut();

				// 반납
				// 대여한 상품만 보이도록
			} else if (menuNo == 2) {
				returnIn();
			}
//			// 전체 상품
//			else if (menuNo == 3) {
//				showAllList();
//
//				// 메인으로 돌아가기
//			}
			else if (menuNo == 0) {
				break;

				// 입력 오류
			} else {
				showInputError();
			}
		}
	}

	protected void menuPrint() {
		System.out.println();
		System.out.println("=====================================       대여/반납       =====================================");
		System.out.println();
		System.out.println("                                  1 대여  | 2 반납  | 0 뒤로가기"); // role에 따라 구성된 메뉴만 출력
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println();
	}

	// 대여 가능한 제품 표시
	private void showRentable() {
		List<Product> list = proDAO.inStock();
		System.out.println("검색결과: " + list.size() + "개");
		System.out.println();
		for (Product product : list) {
			if (product != null) {
				System.out.println(product);
			} else {
				System.out.println("대여 가능한 상품이 없습니다ㅠㅠ");
			}
		}
	}

	// 렌탈
	private void rentOut() {
		showRentable();
		// 제품과 입고 수량 입력
		RentalInfo info = outAmount();

		// 해당 제품 등록 여부
		Product product = proDAO.findIsn(info.getIsn());

		if (product == null) {
			System.out.println();
			System.out.println("등록되지 않은 제품입니다 !");
			System.out.println("품번을 다시 확인해주세요 !");
			return;
		}
		// 재고 수량이 렌탈수량보다 클 경우 렌탈처리 가능
		if (product.getStock() < info.getAmount()) {
			System.out.println("대여 가능한 수량을 확인해주세요! T T");
			return;
		} else {
			info.setId(Login.getLogin().getId());
			rentalDAO.insert(info);

			updateProductStockOut(info);
		}
	}

	// 대여 출고 품번, 수량 입력
	private RentalInfo outAmount() {

		RentalInfo info = new RentalInfo();

		// 대여할 품번 입력
		System.out.println();
		System.out.println("대여하실 상품의 품번을 입력하세요!");
		info.setIsn(Integer.parseInt(sc.nextLine()));
		// 대여할 수량 입력
		System.out.println();
		System.out.println("대여하실 수량을 입력해주세요!");
		info.setAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}

	// 재고 업데이트
	private void updateProductStockOut(RentalInfo info) {

		// 현재 재고
		int stock = proDAO.SelectAmount(info.getIsn());

		// 대여하는 수량
		int rental = info.getAmount();

		// 현재 재고 - 대여 수량
		stock -= rental;

		Product product = new Product();
		product.setIsn(info.getIsn());
		product.setStock(stock);
		proDAO.updateStock(product);
	}

	// 반납
	private void returnIn() {
		// 제품과 입고 수량 입력
		RentalInfo info = inAmount();

		// 해당 제품 등록 여부
		RentalInfo rental = rentalDAO.findIsn(info.getIsn());

		if (rental == null) {
			System.out.println();
			System.out.println("대여하신 품번이 아닙니다!!");
			return;
		}
		info.setIsn(rental.getIsn());
		returnDAO.insert(info);

		updateProductStockIn(info);
		return;
	}

	private void updateProductStockIn(RentalInfo info) {
		// 현재 재고
		int stock = proDAO.SelectAmount(info.getIsn());

		// 대여하는 수량
		int rental = info.getAmount();

		// 현재 재고 - 대여 수량
		stock += rental;

		Product product = new Product();
		product.setIsn(info.getIsn());
		product.setStock(stock);
		proDAO.updateStock(product);
	}

	// 반납 품번, 수량 입력
	private RentalInfo inAmount() {
		RentalInfo info = new RentalInfo();

		// 대여할 품번 입력
		System.out.println();
		System.out.println("반납하실 상품의 품번을 입력하세요!");
		info.setIsn(Integer.parseInt(sc.nextLine()));
		// 대여할 수량 입력
		System.out.println();
		System.out.println("반납하실 수량을 입력해주세요!");
		info.setAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}

}
