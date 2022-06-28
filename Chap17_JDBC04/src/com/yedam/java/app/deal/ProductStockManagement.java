package com.yedam.java.app.deal;

import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.Management;
import com.yedam.java.app.product.Product;

//제품 입고, 출고, 재고를 관리하는 프로그램
public class ProductStockManagement extends Management {
	// 생성자를 이용해 while문 돌리기
	public ProductStockManagement() {
		boolean role = selectRole();

		while (true) {
			menuPrint(role);

			int menuNo = menuSelect();

			// 제품 입고
			if (menuNo == 1 && role) {
				productIn();

				// 제품 출고
			} else if (menuNo == 2 && role) {
				productOut();

				// 제품 재고
			} else if (menuNo == 3) {
				productStock();

				// 제품 거래 내역
			} else if (menuNo == 4 && role) {
				productDeal();

				// 뒤로가기
			} else if (menuNo == 9) {
				back();
				break;

				// 입력 오류
			} else {
				showInputError();
			}
		}
	}

	protected void menuPrint(boolean role) {
		String menu = "";
		if (role) {
			menu += "1.입고  2.출고  ";
		}

		menu += "3.재고  ";
		if (role) {
			menu += "4.거래내역  ";
		}
		menu += "9.뒤로가기";
		System.out.println("================================================");
		System.out.println(menu);
		System.out.println("================================================");
	}

	private void productIn() {
		// 제품과 입고 수량을 입력
		DealInfo info = inputAmount();// 수량과 제품에 대한 정보 불러옴

		// 해당 제품의 등록 여부
		Product product = pDAO.selectOne(info.getProductName());// 이름에 대한 정보 받아온 다음에

		if (product == null) { // 이름이 널값이면 안내문 출력하기.
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 등록 되었을 경우 입고 처리
		info.setProductId(product.getProductId()); // 널이 아니면 아이디만 넘겨서
		rDAO.insert(info);// info에 등록해줌

		// 제품정보-재고량 수정 (입고 처리가 완료되었을 경우 재고 수정 가능하도록)
		// 통해서 내용 정리 처리할때 한번에 처리할 수 없어서
		// 재고량= 입고량-출고량 -> 연산 일으켜야하기 때문에 독립적 메소드로 만들 것.
		// -재고는 빈번하게 업데이트 되니까 차라리 별도로 만들어서 관리되도록 설계한고
		updateProductStock(info.getProductId());

	}

	private void productOut() {
		// 제품 이름과 출고수량 입력
		DealInfo info = inputAmount();

		// 제품의 등록 여부
		Product product = pDAO.selectOne(info.getProductName());

		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 해당 제품의 재고와 출고수량을 비교
		// 1번 방법
//		if(product.getProductStock() >= info.getProductAmount()) {
//			// 재고수량이 출고수량보다 클 경우에만 출고처리 진행
//			info.setProductId(product.getProductId());
//			tDAO.insert(info); //TakeOutGoodsDAO tDAO
//		} else {
//			System.out.println("재고가 부족합니다.");
//		}
		// 2번 방법 - 일관성 유지를 위해 이거 사용
		if (product.getProductStock() < info.getProductAmount()) {
			System.out.println("재고가 부족합니다."); // 재고가
			return;
		}
		// 재고수량이 출고수량보다 클 경우에만 출고처리 진행
		info.setProductId(product.getProductId());
		tDAO.insert(info); // TakeOutGoodsDAO tDAO

		// 제품의 재고량 수정
		updateProductStock(info.getProductId());

	}

	private DealInfo inputAmount() {
		DealInfo info = new DealInfo();
		// 제품 이름
		System.out.println("제품 이름 > ");
		info.setProductName(sc.nextLine());
		// 제품 수량
		System.out.println("제품 수량 > ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}

	private void updateProductStock(int productId) {
		// 해당 제품의 재고량 확인 및 수정
		// 해당 제품의 입고량
		int inAmount = rDAO.SelectAmount(productId);
		// 해당 제품의 출고량
		int outAmount = tDAO.SelectAmount(productId);
		// 재고(입고량 - 출고량)을 수정
		int stock = inAmount - outAmount;
		
		if (outAmount > 0 ) {
		}
		Product product = new Product();
		product.setProductId(productId);
		product.setProductStock(stock);
		pDAO.updateStock(product);
	}

	private void productStock() {
		// 재고를 조회하고자하는 제품 이름 입력
		String productName = inputName();

		// 해당 제품의 정보 출력
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}

		// 해당 제품의 정보를 출력
		System.out.println(product);
	}

	private void productDeal() {
		// 입고, 출고 선택
		int choice = inputSelect();

		List<DealInfo> list = new ArrayList<>();

		// 선택에 따라 값을 가지고 와서 출력
		if (choice == 1) {
			list = rDAO.selectAll();
		} else if (choice == 2) {
			list = tDAO.selectAll();
		}

		for (DealInfo info : list) {
			System.out.println(info);
		}

	}

	private String inputName() {
		System.out.println("제품 이름 > ");
		return sc.nextLine();
	}

	private int inputSelect() {
		System.out.println("분류 : 1.입고  2.출고  3.전체조회");
		int selected = Integer.parseInt(sc.nextLine());
		if (selected == 1) {
			System.out.println("======== 입고내역");
		} else if (selected == 2){
			System.out.println("======== 출고내역");
		} else if (selected == 3) {
			System.out.println("======== 전체내역");
		}
		return selected;
	}

	// Management(메인)로 돌아감.
	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}

}
