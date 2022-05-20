package operator;

import java.util.Scanner;

/*
 * 메뉴가 1이면 사각형, 메뉴가 2면 삼각형, 0 넣으면 종료.
 * 	
 */
public class menuArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu; // 메뉴 입력
		String shape = ""; // 모양

		// 0번이 나오기 전까지는 반복 실행.
		do { // 반복 실행
				// 키보드로부터 입력 받은 값을 menu 변수에 저장.
			menu = Integer.parseInt(scan.nextLine());

			// 탈출 조건
			if (menu == 0) {
				break; // 0이면 종료(break)
			}
			// 모양을 결정하는 조건문
			if (menu == 1) {
				shape = "사각형"; // 1이면 "사각형" 출력
				System.out.println();
			} else if (menu == 2) {
				shape = "삼각형"; // 2이면 "삼각형" 출력
				System.out.println();
			} else {
				shape = "\n1다시 입력하센 ㅋㅋ";
				System.out.println();
			}
			// 모양 결과 출력
			System.out.printf("%d 모양은 %s입니다.", menu, shape);
		} while (menu != 0);

		System.out.println("\n프로그램을 종료합니다.");
	}

}
