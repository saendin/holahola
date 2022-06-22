package com.yedam.java.app.product;
//프로덕트에 대한 정보 관리

import java.util.List;

import com.yedam.java.app.common.Management;

//Sub program
public class ProductInfoManagement extends Management {
	// 제품에 대한 정보를 등록, 수정, 삭제
	public ProductInfoManagement() {
		boolean role = selectRole();
		while (true) {
			menuPrint(role);
			int menuNo = menuSelect();
			if (menuNo == 1 && role) {
				// 제품 정보 등록
				insertProductInfo(); // 이 안에서 간단한 기능이 실행되는 것이 아니라 프로그램을 실행시키도록
			} else if (menuNo == 2 && role) {
				// 제품 정보 수정 (가격)
				updateProductInfo();
			} else if (menuNo == 3 && role) {
				// 제품 정보 삭제 (가격)
				deleteProductInfo();
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

	protected void menuPrint(boolean role) {
		// 권한에 따라 메뉴를 프린트하기 위한 것
		String menu = "";
		if (role) {
			menu += "1.제품등록  2.제품수정  3.제품삭제"; // 권한 0이 트루면 1,2,3
		}
		menu += "4.제품검색  5.전체조회  9.뒤로가기";// 권한이 1일때는 2,9만 가능하도록.

		// 해당 메뉴 출력
		System.out.println("===============================");
		System.out.println(menu); // role에 따라 구성된 메뉴만 출력
		System.out.println("===============================");
	}

	// Management(메인)로 돌아감.
	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}

	private void insertProductInfo() {
		// 제품정보 입력 - VO클래스 가져오기
		Product product = inputAll();
		// DB에 저장
		pDAO.insert(product);
	}

	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품 이름> ");
		product.setProductName(sc.nextLine());
		System.out.println("제품 가격> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}

	private String inputName() {
		System.out.println("제품 이름> ");
		return sc.nextLine();
	}

	private Product inputUpdateInfo(Product product) {
//		-2. 이름, 가격만 수정하도록(재고 제외)

		// 이름만 수정하거나 가격만 수정하고자 하면 입력하지 않은 부분은 null로 들어가게 되므로 입력하지 않는다면 기존의 값을 불러오는 형태로
		// 가야함.
		System.out.println("기존 제품명> " + product.getProductName());
		System.out.println("수정 (수정하지 않을 경우 0 입력)> ");
		String name = sc.nextLine(); // 이름 가격 받고
		if (!name.equals("0")) { // 네임이 0이 라면 TRUE 값 반환. 여기선 0이 아니라면 TRUE 반환. -> 0 이외의 값이 들어왔을 때만 값 교체
			product.setProductName(name); // productName 받아옴
		}

		System.out.println("기존 가격> " + product.getProductName());
		System.out.println("수정 (수정하지 않을 경우 -1 입력)> ");
		
		int price = Integer.parseInt(sc.nextLine());
		
		if (price > -1) {
			product.setProductPrice(price); // -> 가격이 -1보다 큰 정수일때만 값 교체
		}
		return product;
	}

	private void updateProductInfo() {
		// 제품 이름 입력
		String productName = inputName();

		// 제품 정보 검색
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// 수정할 정보 입력 - 기존의 정보를 받아 새로운 형태의 정보를 반환하는 형태
		product = inputUpdateInfo(product);

		// DB 수정
		pDAO.updateInfo(product);
	}

	private void deleteProductInfo() {
		// 제품 이름 입력
		String productName = inputName();

		// 제품 정보 검색
		// -1 products 테이블에서 정보 가져옴
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// -2 입고내역에서 검색 (fk constraint가 들어가있어서 거기서 가져오도록)
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		// DB에서 삭제
		if (!isSelected) { // isSelected는 트루값이 나오면 삭제가 안됨. 여기서는 반전연산자 써서 실행시키도록 해줌. 마약에 isSelected쓸거면
							// sysout먼저 나오게 하고 else에 delete 넣어주면 됨.
			// isSelected = true
			// System.out.println("만약에 거래내역이 있어도 삭제하시겠습니까?"); 아니요시엔 다시 메뉴 선택창으로 돌아가도록
			// 번호 받고 (스캔으로 받기)
			// if문 no일 때 리턴해서 다시 선택
			// yes일때는 productDAO로 넘어가서 delete 실행.
			pDAO.delete(product.getProductId()); // 만약에 거래내역이 있어도 삭제하시겠습니까?
		} else {
			System.out.println("거래내역이 존재합니다.");
		}
	}

	private void selectAll() {
		List<Product> list = pDAO.selectAll();

		for (Product product : list) {
			System.out.println(product);
		}
	}

	private void selectOne() {
		String productName = inputName();

		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		System.out.println(product);
	}

}
