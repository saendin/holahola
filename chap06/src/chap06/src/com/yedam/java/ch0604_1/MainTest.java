package chap06.src.com.yedam.java.ch0604_1;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator();

		while (run) {
			System.out.println("1. 갯수 입력 | 2. 숫자 입력 | 3. 더하기 | 4. 빼기 | 5. 곱하기 | 6. 나누기 | 7. 종료");
			System.out.print("선택> ");

			int num = Integer.parseInt(scanner.nextLine());

			if (num == 1) {
				System.out.print("갯수 입력> ");
				//갯수 입력받기
				int size = Integer.parseInt(scanner.nextLine());
				//calculator.갯수입력 작동
				calculator.setArraySize(size);

				System.out.println();

			} else if (num == 2) {
				System.out.print("숫자 입력> ");
				//숫자 입력받기
				int setNum = Integer.parseInt(scanner.nextLine());
				//calculator.숫자입력 작동
				calculator.setNum(setNum);

				System.out.println();

			} else if (num == 3) {
				System.out.print("더하기> ");
				//더하기 프로그램 작동
				calculator.plus();

				System.out.println();

			} else if (num == 4) {
				System.out.print("뺴기> ");
				//빼기 프로그램 작동
				calculator.substract();

				System.out.println();

			} else if (num == 5) {
				System.out.print("곱하기> ");
				//곱하기 프로그램 작동
				calculator.multiply();

				System.out.println();

			} else if (num == 6) {
				System.out.print("나누기> ");
				//나누기 프로그램 작동
				calculator.divide();

				System.out.println();

			} else if (num == 7) {
				//빠져나가기. 종료문구 출력
				run = false;

				System.out.println();
				System.out.println("프로그램 종료");
			}
		}
	}

}
