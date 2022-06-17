package com.yedam.app;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.app.history.History;
import com.yedam.app.history.HistoryDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class StockManagement {
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDao = ProductDAO.getInstance();
	private HistoryDAO hDao = HistoryDAO.getInstance();

	public StockManagement() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			inputMenu();
			// 각 기능별 실행
		}
	}

	private void menuPrint() {
		System.out.println("===============================================");
		System.out.println("1.제품등록  2.입고  3.출고  4.제품재고  5.전체재고  9.종료");
		System.out.println("===============================================");
	}

	private void inputMenu() {
		int menuNum = selectMenu();
		if (menuNum == 1) {
			// 제품 등록
			putProduct();
		} else if (menuNum == 2) {
			// 제품 입고
			productIn();
		} else if (menuNum == 3) {
			// 제품 출고
			productOut();
		} else if (menuNum == 4) {
			// 제품 재고
			stock();
		} else if (menuNum == 5) {
			// 전체 재고
			allStock();
		} else if (menuNum == 9) {
			// 종료
			exit();
		} else {
			showInputError();
		}
	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine()); // 메뉴값 입력받기
		} catch (NumberFormatException e) { // 번호에 대한 오류가 났을 때 아래 구문 표시
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menu;

	}

	private void exit() {
		System.out.println("프로그램이 종료되었습니다.");
	}

	private void showInputError() {
		System.out.println("메뉴를 참고해서 입력해주세요");
	}

	// 기존에 있는 데이터를 확인하고 들어가는게 아님을 전제함.
	private void putProduct() {
		// 제품 정보 입력
		Product product = inputAll();
		// DB에 저장
		pDao.insert(product);
	}

	private void productIn() {
		// 입고할 제품과 수량 입력
		// common package의 Info 클래스 사용
		Info info = inputAmount();
		// 기존에 등록되어 있는 제품인지 확인(그것만 등록 가능)
		Product product = pDao.selectOne(info.getProductName());

		if (product != null) {
			// -1 기존에 등록된 제품일 경우 입고 처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());

			hDao.insert(history);
		} else {
			// -2 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품의 정보 우선 등록 요망");
		}
	}

	private void productOut() {
		// 출고할 제품과 수량 입력
		Info info = inputAmount();
		// 등록되어 있는 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		if (product == null) {
			System.out.println("해당 제품 정보 확인 요망");
			return; // 뒤에 있는 실행코드를 아에 막아버림.(이프문이 계속 도는 것을 방지하기 위해)
		}
		// 재고량이 있는지 확인
		int stock = selectStock(product.getProductId());
		// 재고량과 출고량 비교
		if (stock >= info.getProductAmount()) {// 재고량 안에서 출고할 수 있는 경우에만
			// -1 조건을 모두 만족하는 경우에만 출고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(2);
			history.setProductAmount(info.getProductAmount());

			hDao.insert(history);

			// -2 각조건이 만족 되지 않는 경우
		} else {
			System.out.println("재고량 부족");
		}
	}

	private void stock() {
		// 검색하고자 하는 제품 정보 입력
		String productName = inputName();
		// 등록된 제품인지 확인
		Product product = pDao.selectOne(productName);

		if (product == null) {
			System.out.println("해당 제품 정보 없음");
			return;
		}
		// 해당 제품의 제품 출력
		int stock = selectStock(product.getProductId());
		System.out.println(
				"제품번호 : " + product.getProductId() + ", 제품 이름 : " + product.getProductName() + ", 재고 : " + stock);
	}

	private void allStock() {
		//
		Map<Integer, Integer> list = hDao.selectAllAmount();
		// 제품이 코드로만 있음. 이것을 전체로 출력하기 위해
		Set<Integer> productList = list.keySet();
		for (int productId : productList) {
			Product product = pDao.selectOne(productId); // 아이디를 이용해서 정보를 가져와야 함
			int stock = list.get(productId);

			System.out.println(
					"제품번호 : " + product.getProductId() + ", 제품 이름 : " + product.getProductName() + ", 재고 : " + stock);
		}
	}
	
	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품 이름> ");
		product.setProductName(sc.nextLine());
		
		System.out.println("제품 가격> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		
		return product;
	}

	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품 이름> ");
		info.setProductName(sc.nextLine());
		
		System.out.println("제품 수량> ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		
		return info;
	}
	
	private String inputName() {
		System.out.println("제품 이름> ");
		return sc.nextLine();
	}
	
	
	private int selectStock(int productId) {
		int stock = 0;
		int in = hDao.selectInAmount(productId);
		int out = hDao.selectOutAmount(productId);
		return (in-out); //출고량이 없으면 없는대로 돌아와서 그냥 - 로 연산해주면 됨.
	}
}
