package workspace02;

import java.util.Scanner;

public class 과제2 {

	public static void main(String[] args) {
		// while조건문을 만족하면(run=true) 계속 반복실행
		boolean run = true;
		// balance=통장잔고
		int balance = 0; // 초기 통장잔고 값을 0으로 설정
		int menu; // menu는 정수임
		String result; // result는 문자값임
		// 스캐너를 사용하여 입력값을 받아내시오
		Scanner scan = new Scanner(System.in);

		// 계속 반복 실행
		while(run) {
			// 아래와 같은 양식이 반복 출력 되도록 하시오.
			System.out.println("--------------------------------------");
			System.out.println("1. 예금 : 2. 출금 : 3. 조회 : 4. 종료");
			System.out.print("선택> ");
			// 메뉴값은 스캐너로 입력 받은 것을 사용
			menu = Integer.parseInt(scan.nextLine());

			// 조건-입력값이 1이면 예금액 입력. 입력 된 예금액은 통장잔고와 합산.
			if (menu == 1) {
				//밑에서 변수를 통해 한번에 할 수 있는 방법 찾아보기
				System.out.printf("예금액> ");
				
				balance += Integer.parseInt(scan.nextLine()); // 각각은 break를 써서 끝낼 필요가 없음. 어쩌피 무한반복이니 프로그램 종료시에만 브레이크를 써서
																// 빠져나와주면 됨.
			} else if (menu == 2) {
				System.out.printf("출금액> ");
				balance -= Integer.parseInt(scan.nextLine()); // 입력받는 nextLine값이 string값이므로 Integer.parseInt로 강제형변환 필요.
			} else if (menu == 3) {
				System.out.printf("잔고> ");
				System.out.println(balance);
			} else if (menu == 4) {
				break;
			}
			// 그 외에 값을 입력받으면 오류 문구 출력 후 종료
			else {
				System.out.println("잘못 입력된 번호입니다.");
				break;
			}

		}

		System.out.println("프로그램 종료");
	}

}
