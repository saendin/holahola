package Homework_review;

import java.util.Scanner;

public class MainProgram {
	private Program pro = new BookProgram();

	public MainProgram() {
		while (true) {
			// 메뉴출력
			pro.menuPrint();
			// 메뉴선택
			int menuNo = inputMenu();
			// 각 메뉴 실행
			if (menuNo == 1) {
				pro.inputInfo();
			} else if (menuNo == 2) {
				pro.printAllInfo();
			} else if (menuNo == 3) {
				pro.printInfo();
			} else if (menuNo == 4) {
				pro.printReport();
			} else if (menuNo == 5) {
				exit();
				break;
			}
		}
	}
	
	private void exit() {
		System.out.println("프로그램 종료.");
	}
	
	private int inputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 > ");
		return Integer.parseInt(sc.nextLine());
	}
}
