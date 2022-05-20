package task;

import java.util.Scanner;

public class workspace01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 스캐너를 통해 입력 받으시오
		
		System.out.print("첫번째 수:");
		// "첫번째 수:"를 출력하시오.
		String StrNum1 = scanner.nextLine();
		// StrNum1 라는 변수명을 scanner.nextLine() 메소드를 사용하여 문자인 입력 값을 받아냄.
		
		System.out.print("두번째 수:");
		// "두번째 수:"를 출력하시오.
		String StrNum2 = scanner.nextLine();
		// StrNum2 라는 변수명을 scanner.nextLine() 메소드를 사용하여 문자인 입력 값을 받아냄.
		int num1 = Integer.parseInt(StrNum1);
		// num1은 Interger.parseInt 메소드를 이용해 StrNum1을 정수값으로 정의한다.
		int num2 = Integer.parseInt(StrNum2);
		// num2는 Interger.parseInt 메소드를 이용해 StrNum2를 정수값으로 정의한다.
		int result = num1 + num2;
		// result 변수는 num1과 num2를 더한 값이다.
		System.out.println("덧셈 결과:" + result);
		// "덧셈 결과:" 와 result값을 출력하시오.
		
				
	}

}
