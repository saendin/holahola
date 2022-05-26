package com.yedam.homework;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		ProductSystem prdctSys = new ProductSystem();
		
		while (run) {
			System.out.println("1.상품 수 | 2.상품 및 가격 입력 | 3.제품별 가격 | 4.분석 | 5.종료 ");
			System.out.print("번호를 선택하세요> ");
			//next는 통일해서 써주기 nextLine이면 nextLine, nextInt면 nextInt
			int select = Integer.parseInt(scan.nextLine());
			
			System.out.println();
			
			//상품 수 입력
			if (select == 1) {
				System.out.print("상품 수> ");
				int size = Integer.parseInt(scan.nextLine());
				prdctSys.setListSize(size);
				
				System.out.println();
			}
			//상품과 가격 입력
			if (select == 2) {
				System.out.println("상품 이름> ");
				String name = scan.nextLine();
				System.out.println("상품 가격> ");
				int price = Integer.parseInt(scan.nextLine());
				prdctSys.putProduct(name, price);
				
				System.out.println();
			}
			//제품별 가격 출력
				
			if (select == 3) {
				System.out.println("제품별 가격> ");
				prdctSys.printList();
				
				System.out.println();
				
				}
			else if (select == 4) {
				System.out.println("분석> ");
				prdctSys.getMaxPrice();
				prdctSys.getSumPrice();
				
				System.out.println();
				
				}
			else if (select == 5) {
				run = false;
				}
			else {
				System.out.println("잘못된 입력입니다");
				break;
			}
			}	System.out.println("프로그램을 종료합니다");
	}

}
