package com.sunjin.app.stock;

import java.util.ArrayList;
import java.util.List;

import com.sunjin.app.common.Management;
import com.sunjin.app.product.Product;

public class StockManagement extends Management {

	public StockManagement() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();

			// 입고
			if (menuNo == 1) {
				stockIn();

				// 출고
			} else if (menuNo == 2) {
				stockOut();

				// 재고
			} else if (menuNo == 3) {
				stock();
				
			} else if (menuNo == 4) {	
				// 전체 재고
				AllStock();
				
				// 거래 내역
			} else if (menuNo == 5) {
				dealList();

				// 메인으로 돌아가기
			} else if (menuNo == 0) {
				break;

				// 입력 오류
			} else {
				showInputError();
			}
		}
	}
	//재고느낌에 맞게 DAO에 추가하고 수정.
	private void AllStock() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out
				  .println("- - - - - - - - - - - - - - - - - - -     전체 재고      - - - - - - - - - - - - - - - - - - -");
		System.out.println();
		List<Product> list = proDAO.showAllList();
		System.out.println("검색결과: "+ list.size() + "개");
		System.out.println();

		for (Product product : list) {
			System.out.println(product);
		}
	}

	protected void menuPrint() {
		System.out.println();
		System.out.println("=====================================        관리       =====================================");
		System.out.println();
		System.out.println("    [1] 입고  | [2] 출고  | [3] 선택상품재고조회  | [4] 전체재고조회  | [5] 입/출고거래내역  | [0] 뒤로가기"); // role에 따라 구성된 메뉴만 출력
		System.out.println();
		System.out.println("============================================================================================");
		System.out.println();
	}

	// 입고
	private void stockIn() {
		// 제품과 입고 수량 입력
		StockInfo info = inputAmount();

		// 해당 제품 등록 여부
		Product product = proDAO.findIsn(info.getIsn());

		if (product == null) {
			System.out.println("                                제품을 먼저 등록해주세요!");
			return;
		}
		info.setIsn(product.getIsn());
		sInDAO.insert(info);

		updateProductStock(info.getIsn());
		return;
	}

	// 재고 업데이트
	private void updateProductStock(int isn) {
		// 입고량
		int inStock = sInDAO.SelectedAmount(isn);
		// 출고량
		int outStock = sOutDAO.SelectAmount(isn);

		int stock = inStock - outStock;

		Product product = new Product();
		product.setIsn(isn);
		product.setStock(stock);
		proDAO.updateStock(product);
	}

	// 출고
	private void stockOut() {
		// 제품과 입고 수량 입력
		StockInfo info = inputAmount();

		// 해당 제품 등록 여부
		Product product = proDAO.findIsn(info.getIsn());

		if (product == null) {
			System.out.println();
			System.out.println("                                   제품을 먼저 등록해주세요!");
			System.out.println();
			return;
		}
		// 재고 수량이 출고수량보다 클 경우 출고처리
		if (product.getStock() < info.getAmount()) {
			System.out.println();
			System.out.println("                                 출고할 수 있는 수량이 부족합니다!");
			System.out.println();
			return;
		} else {
			info.setIsn(product.getIsn());
			sOutDAO.insert(info);

			updateProductStock(info.getIsn());
		}
	}

	// 입, 출고 수량 받을
	private StockInfo inputAmount() {

		StockInfo info = new StockInfo();
		// 입고할 픔번 입력
		System.out.println();
		System.out.print("                                   품번을 입력하세요 > ");
		info.setIsn(Integer.parseInt(sc.nextLine()));
		System.out.println();
		// 입고 수량
		System.out.println();
		System.out.print("                                  수량을 입력해주세요 > ");
		info.setAmount(Integer.parseInt(sc.nextLine()));
		System.out.println();
		return info;
	}

	// 재고 조회
	private void stock() {
		// 재고 조회원하는 품번 입력
		int isn = inputIsn();
		Product product = proDAO.findIsn(isn);

		if (product == null) {
			System.out.println();
			System.out.println("                                 제품을 먼저 등록해주세요!");
			System.out.println();
			return;
		}
		System.out.println();
		System.out.println();
		System.out.println(product);
	}

	private int inputIsn() {
		System.out.println();
		 System.out.print("                               조회할 품번을 입력하세요 > ");
		return Integer.parseInt(sc.nextLine());
	}

	// 입고/ 출고 각 리스트 조회
	private void dealList() {
		int choice = inputInOutSelect();

		List<StockInfo> list = new ArrayList<>();

		// 선택에 따라 값 가지공
		if (choice == 1) {
			list = sInDAO.selectAll();
		} else if (choice == 2) {
			list = sOutDAO.selectAll();
		} else if (choice == 3) {

		}
		for (StockInfo info : list) {
			System.out.println(info);
		}
	}

	private int inputInOutSelect() {
		int selected = 0;
		try {
		System.out.println();
			System.out.println("                                     입고내역 / 출고내역 조회");
		System.out.println();
			System.out.println("                                    1 입고내역  |  2 출고내역");
		System.out.println();
		selected = Integer.parseInt(sc.nextLine());
		if (selected == 1) {
			System.out.println();
			System.out.println("====================================        입고조회       ====================================");
			System.out.println();
		} else if (selected == 2) {
			System.out.println();
			System.out.println("====================================        출고조회       ====================================");
			System.out.println();
		}
		System.out.println();
		} catch (NumberFormatException e) {
			System.out.println("                                        잘못된 입력입니다 !");
		}
		return selected;
	}
//	   //날짜로 리스트 조회
//	   private void dateList() {
//	      int choice = inputDateSelect();
//	      List<StockInfo> list = new ArrayList<>();
//	      
//	      Date stockDate = StockInfo.getStockDate();
//	      
//	      if (choice == 1) {
//	         list = sInDAO.selectAll(stockDate);
//	      } else if (choice == 2) {
//	         list = sOutDAO.selectAll(stockDate);
//	      }
//	      for (StockInfo info : list) {
//	         System.out.println(info);
//	   }
//	}
//
//	   private int inputDateSelect() {
//	      System.out.println("해당 날짜의 입/출고내역 조회");
//	      System.out.println("1 입고내역  |  2 출고내역");
//	      int selected = Integer.parseInt(sc.nextLine());
//	      if (selected == 1) {
//	         System.out.println("======== 입고내역 조회");
//	      } else if (selected == 2) {
//	         System.out.println("======== 출고내역 조회");
//	      }
//	      System.out.println("잘못된 입력입니다!");
//	      System.out.println();
//	      return selected;
//	   }
}
