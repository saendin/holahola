package com.yedam.java.example2;

import java.util.Scanner;

public class MainProgram {
	// 필드
	private Scanner sc = new Scanner(System.in);
	private Access dao = StudentRepo.getInstance(); // 저장소 역할
	private Program pro = new StudentProgram(); // 실제 돌아가는 프로그램 역할

	// 생성자
	public MainProgram() {
		//프로그램과 저장소에 따라 기능이 달라짐.
		while (true) {
			// 메뉴출력
			pro.menuPrint();
			// 메뉴선택
			int menuNo = menuSelect();
			// 각 메뉴 실행
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

	// 메소드
	private int menuSelect() {
		System.out.println("선택을 해보시지 > ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("프로그램을 종료종료~!");
		
	}
	
}

