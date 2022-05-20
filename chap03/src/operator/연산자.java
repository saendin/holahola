package operator;

import java.io.IOException;
import java.util.Scanner;

public class 연산자 {

	public static void main(String[] args) {
		// 짝수검사(); 
		// 산술연산();
		// 부호연산자();
		// incDesOP();
		// denyLogicOP();
		// toLower();
		// compareOp();
		// isDigit();
		// isChar();
		 conditionOp();

	}

	// 짝수인지검사
	public static void 짝수검사() {

		int n1 = 6;
		boolean result = 0 == n1 % 2;
		System.out.println(result);

	}

// 산술연산자

	public static void 산술연산() {

		int n1 = 10;
		int n2 = 3;

		int n3 = n1 / n2; // 몫
		int n4 = n1 % n2; // 나머지

		System.out.println(n3 + ":" + n4);

	}

	public static void 부호연산자() {

		int i1 = +100;
		int i2 = -100;

		byte x = 100;
		int result = -x;

	}

//증감연산자
	public static void incDesOP() {

		int x = 10;
		int y = 10;
		x--;
		// x = x - 1;
		y++;

		System.out.println(x + ", " + y);

		int a = 10;
		int b = 10;
		int c = a++ + ++b;
		System.out.println(c);

	}

//논리부정
	public static void denyLogicOP() {

		boolean play = true;
		play = !play;

		System.out.println(play);

	}

	// 강제형연산자
	public static void toLower() {
		char c = 'A';
		char p = (char) (c + 32);

		System.out.println(c + ":" + p);
	}

	// 비교연산(윤년계산)
	public static void compareOp() {
		int year = 2020;
		boolean result = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		System.out.println(result);

	}

	// 입력값이 숫자인지 판단
	public static void isDigit() {

		Scanner scanner = new Scanner(System.in);
		try {
			int key = System.in.read();
			boolean result = (key >= 48) && (key <= 57);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	// 문자 값을 받아 숫자로 변환한 뒤 연산 실행.
	public static void isChar() {

		Scanner scanner = new Scanner(System.in);
		try {
			int key = System.in.read();
			boolean result = (key >= 65 && key <= 90) || (key >= 97 && key <= 122);
			String str = result ? "문자" : "문자아님";
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void conditionOp() {
		int score = 70;
		String grade = score >= 90 ? "A등급" : (score >= 80 ? "B등급" : "C등급");
		System.out.printf("%d점은 %s입니다.", score, grade);

	}

}
