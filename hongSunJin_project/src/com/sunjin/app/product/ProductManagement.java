package com.sunjin.app.product;

import java.util.List;

import com.sunjin.app.common.LogInSys;
import com.sunjin.app.common.Login;

public class ProductManagement extends LogInSys {
//제품 정보 수정 가능한 생성자(등록, 수정, 삭제, 단건/전체 조회)
	public ProductManagement() {
		boolean role = selectRole(); // Management
		while (true) {
//			welcomeMessage();
//			showAllList();

			// 0 관리자 | 1 회원 메뉴 따로 구성
			
			menuPrint(role);

			int menuNo = menuSelect();
			// 0,1 - 검색기능
			if (menuNo == 1) {
				// 1 카테고리
				findCategory();
			} else if (menuNo == 2) {
				// 2 이름
				findProductName();
			} else if (menuNo == 3) {
				// 3 브랜드
				findBrand();
			} else if (menuNo == 4) {
				// 4 가격 범위
				findPriceRange();
			} else if (menuNo == 5) {
				// 5 대여가능
				inStock();
			}
			// 1 only control
			else if (menuNo == 6 && role) {
				// 6 제품 등록
					insertProduct(); // 이 안에서 간단한 기능이 실행되는 것이 아니라 프로그램을 실행시키도록
			} else if (menuNo == 7 && role) {
				// 7 제품 가격 수정
				updateProduct();
			} else if (menuNo == 8 && role) {
				// 8 제품 삭제
				deleteProduct();

				// 0,1 - 메인으로 돌아가기
			} else if (menuNo == 0) {
				// 0 뒤로가기 - 종료되면 전체 리스트로 돌아가도록
				back();
				break;
			} else {
				// 입력 오류
				showInputError();
			}
		}
	}

//	private void showAllList() {
//		
//	}
//
//	private void welcomeMessage() {
//		System.out.println("=+=+=+=+=+=+=+=+=+=+==+=+=+=+=+=+=+=+=+=+=럭셔리 모먼트=+=+=+=+=+=+=+=+=+=+==+=+=+=+=+=+=+=+=+=+=");
//	}

	private void back() {
		System.out.println("뒤로가기");
	}

	private void menuPrint(boolean role) {
		// 권한에 따라 메뉴를 프린트하기 위한 것
		String menu1 = "";
		String menu2 = "";
		if (!role) {
			// 회원[1]권한
			menu1 += "1 카테고리 | 2 상품명 | 3 브랜드 | 4 가격범위 | 5 대여가능상품 | 0 뒤로가기";
			System.out.println("======================       검색       ======================");
			System.out.println(menu1);
			System.out.println("=============================================================");
		} else {
			// 관리자[0]권한
			menu2 += "6 상품등록 | 7 상품가격수정 | 8 상품삭제 | 0 뒤로가기";
			System.out.println("================   상품관리   ===============");
			System.out.println(menu2);
			System.out.println("===========================================");
		}
	}

	// 관리자 & 회원
	// 1 카테고리
	private void findCategory() {
		List<Product> list = proDAO.findCategory();

		for (Product product : list) {
			System.out.println(product);
		}
	}

	// 2 이름
	private void findProductName() {
		// 검색할 이름 입력
		String name = inputName();

		// productDAO.findnName()
		List<Product> list = proDAO.findName(name);
		for (Product product : list) {
			if (product != null) {
				System.out.println(product);
			} else {
				System.out.println("검색 결과가 없습니다!");
			}
		}
	}

	private String inputName() {
		System.out.println("상품명을 입력하세요 ");
		return sc.nextLine();
	}

	// 3 브랜드
	private void findBrand() {
		// 검색할 브랜드 입력
		String brand = inputBrand();

		// productDAO.findBrand()
		List<Product> list = proDAO.findBrand();
		for (Product product : list) {
			if (product != null) {
				System.out.println(product);
			} else {
				System.out.println("검색 결과가 없습니다!");
			}
		}
	}

	private String inputBrand() {
		System.out.println("브랜드를 입력하세요 ");
		return sc.nextLine();
	}

	// 4 가격 범위
	private void findPriceRange() {
		// 검색할 가격범위 입력
		int price1 = inputPrice1();
		int price2 = inputPrice2();

		// productDAO.findPrandRange()
		List<Product> list = proDAO.findPriceRange(price1, price2);
		for (Product product : list) {
			if (product != null) {
				System.out.println(product);
			} else {
				System.out.println("검색한 조건에 맞는 결과가 없습니다!");
			}
		}
	}

	private int inputPrice1() {
		System.out.print("검색하고 싶은 가격 범위의 작은 값을 입력하세요  ");
		return Integer.parseInt(sc.nextLine());
	}

	private int inputPrice2() {
		System.out.print("검색하고 싶은 가격 범위의 큰 값을 입력하세요  ");
		return Integer.parseInt(sc.nextLine());
	}

	// 5 대여가능
	private void inStock() {
		List<Product> list = proDAO.inStock();

		for (Product product : list) {
			if (product != null) {
				System.out.println(product);
			} else {
				System.out.println("대여 가능한 상품이 없습니다ㅠㅠ");
			}
		}
	}

	// 관리자 only
	// 6 상품 등록
	private void insertProduct() {
		// 등록할 때 필요한 데이터 값 받기
		Product product = inputProductInfo();

		proDAO.insert(product);
	}

	private Product inputProductInfo() {
		Product product = new Product();

		System.out.println("상품명");
		sc.nextLine();
		product.setProductName(sc.nextLine());

		System.out.println("브랜드명");
		sc.nextLine();
		product.setBrand(sc.nextLine());
		
		System.out.println("가격");
		Integer.parseInt(sc.nextLine());
		product.setPrice(Integer.parseInt(sc.nextLine()));

		System.out.println("카테고리");
		Integer.parseInt(sc.nextLine());
		product.setPrice(Integer.parseInt(sc.nextLine()));

		return product;
	}

	// 7 상품 가격 수정
	private void updateProduct() {
		// 가격 수정할 품번 입력받기
		int isn = inputIsn();
		// 품번 검색
		Product findisn = proDAO.findIsn(isn);

		if (findisn == null) {
			// isn값이 없을경우 다음을 반환
			System.out.println("검색 결과가 없습니다!");
		} // 변경할 isn 값을 찾았을 경우 수정되도록
		findisn = inputUpdatePrice(findisn);

		proDAO.updateInfo(findisn);
	}

	private int inputIsn() {
		System.out.println("품번을 입력하세요 ");
		return Integer.parseInt(sc.nextLine());
	}

	private Product inputUpdatePrice(Product product) {
		System.out.println("기존 가격 " + product.getPrice());
		System.out.println("수정할 가격을 입력해주세요 ");
		System.out.println(">>수정을 원하지 않을 경우 -1 입력<<");
		// 수정을 원하지 않을 경우 원래 가격 반환
		int price = Integer.parseInt(sc.nextLine());

		if (price > -1) {
			product.setPrice(price);
		}
		return product;
	}

	private void deleteProduct() {
		int isn = inputIsn();
		// 품번 검색
		Product findisn = proDAO.findIsn(isn);

		if (findisn == null) {
			// isn값이 없을경우 다음을 반환
			System.out.println("검색 결과가 없습니다!");
			return;
		} //대여 내역이 있을 시 삭제할지 확인
		boolean stockInExist = sInDAO.selectedInfo(findisn.getIsn());
		
		if(stockInExist) {
			System.out.println("상품의 재고가 존재합니다.");
			//scanner로 여부 물어보고 실행
			int answer = YesOrNo(); 
			if(answer == 1) {
				//yes(1) = 삭제
				proDAO.delete(findisn.getPrice());
			} else if (answer == 0) {
				System.out.println("수정이 취소되었습니다");
			}
		}

	}
	private int YesOrNo() {
		System.out.println("그래도 삭제하시겠습니까?");
		System.out.println("네: 1  |  돌아가기:  0");
		return Integer.parseInt(sc.nextLine()); 
	}
}