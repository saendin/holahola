package com.yedam.java.home;

import java.util.Scanner;

public class MainProgram {
	//필드
	private Scanner sc = new Scanner(System.in);
	private BookAccess dao = BookRepo.getInstance();
	private BookSystem pro = new BookSystem();
	
	//생성자
	public MainProgram() {
		
		while (true) {
			//메뉴출력
			pro.menuPrint();
			//메뉴선택
			int menuNo = menuSelect();
			//각 메뉴 실행
			if (menuNo == 1) {
				pro.inputInfo(dao);
			} else if (menuNo == 2) {
				pro.printAllInfo(dao);
			} else if (menuNo == 3) {
				pro.printInfo(dao);
			} else if (menuNo == 4) {
				pro.printReport(dao);
			} else if (menuNo == 5) {
				exit();
				break;
			}
		}
	}
	
	//메소드
	private int menuSelect() {
		System.out.println("번호를 선택하시오 > ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("프로그램을 종료하시오");
		
	}
}
