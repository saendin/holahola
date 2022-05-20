package array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApp {

	// 배열선언
	static int[] scores; // []이 있으니 값을 정수 scores 값을 여러개 담을 거라는 그런 말씀 ㅋㅋ
							// 밖의 중괄호에 넣어무면 어디서나 다 쓸 수 있다.
	static Scanner scan = new Scanner(System.in); // 스캐너도 전체에 쓸 수 있도록 선언

	public static void main(String[] args) { // public static void 1개에는 꼭 중괄호 한쌍만 들어가야 함.
		init();
		int menu;
//		while (true) { // 반복문
//			System.out.println("--------------------------------------");
//			System.out.println("1. printAll 2. findMin 3. findMax 4. findAvg 5. 종료"); // 메뉴 출력
//			System.out.println("--------------------------------------");
//			System.out.print("선택> ");
//			scan.nextLine(); // scan.nextLine이라는 함수가 엔터 자체를 포함하고 있어서 조건문을 실행하게 되면 자동적으로 공백을 인식하게 된다.
//								// 그래서 위에 scan.nextLine()을 한번 더 써주면 그 문제가 해결 됨.
//			menu = Integer.parseInt(scan.nextLine());
//			//조건 입력값이 1이면 printAll메소드를 출력
//			if (menu == 1) {
//				printAll();
//			//조건 입력값이 2이면 findMin메소드를 출력
//			} else if (menu == 2) {
//				findMin();
//			//조건 입력값이 3이면 findMax메소드를 출력
//			} else if (menu == 3) {
//				findMax();
//			//조건 입력값이 4이면 findAvg메소드를 출력
//			} else if (menu == 4) {
//				findAvg();
//			//조건 입력값이 5이면 빠져나가기 프로그램 종료 출력
//			} else if (menu == 5) {
//				break;
//			} else {
//				System.out.println("잘못된 입력입니다.\n");
//				break;
//			}
//		}
//		System.out.println("프로그램 종료");	//while 반복문 밖에 써줘야지 break걸려서 빠져나왔을 때만 이 구문 출력
//		
		//switch문
		switchTest();
	}
		public static void switchTest() { // public static void 1개에는 꼭 중괄호 한쌍만 들어가야 함.
		int menu;
		do {
			System.out.println("--------------------------------------");
			System.out.println("1. printAll 2. findMin 3. findMax 4. findAvg 5. 종료"); // 메뉴 출력
			System.out.println("--------------------------------------");
			System.out.print("선택> ");
			scan.nextLine(); // scan.nextLine이라는 함수가 엔터 자체를 포함하고 있어서 조건문을 실행하게 되면 자동적으로 공백을 인식하게 된다.
								// 그래서 위에 scan.nextLine()을 한번 더 써주면 그 문제가 해결 됨.
			//메뉴는 입력값을 받아 쓰시오.
			menu = scan.nextInt();
			
			switch(menu) {
		//조건 입력값이 1이면 printAll메소드를 출력
			case 1:
				printAll();
				break;
			//조건 입력값이 2이면 findMin메소드를 출력
			case 2: 
				findMin();
				break;
			//조건 입력값이 3이면 findMax메소드를 출력
			case 3: 
				findMax();
				break;
			//조건 입력값이 4이면 findAvg메소드를 출력
			case 4: 
				findAvg();
				break;
			//조건 입력값이 5이면 빠져나가기 프로그램 종료 출력
			case 5: 
				break;
			default:
				System.out.println("잘못된 입력입니다.\n");
				break;
			}
		}while(menu != 5);
		
		System.out.println("프로그램 종료"); // while 반복문 밖에 써줘야지 break걸려서 빠져나왔을 때만 이 구문 출력
	}
		
	

	public static void init() { // public static void 에 init라는 메소드명을 하나씩 줘서 개별의 객체 그룹으로 만들어줌.
		System.out.println("값 입력");
		// 배열생성
		scores = new int[10]; // 정수를 10개 담겠다. (new해서 값을 담을 수 있는 공간 확보(10))
								// 모든 요소가 0으로 초기화 = 초기값을 설정 안해줘도 0으로 귀속됨.(원래 변수는 항상 초기값 설정해 줘야됐음)
								// 즉, default값이 0이다.

		// 배열 초기화
		for (int i = 0; i < 10; i++) { // 입력될 데이터 값이 많을 때에 사용하는 for문(일일히 적어줄 수 없으니까)
										// int i=1이면 혼동이 없지 않을까? -> 배열값은 무조건 0부터 시작함. 그래서 int i=1 안된다함.
			scores[i] = scan.nextInt();
		}
	}

	public static void printAll() {
		// 배열 값 전체 조회
		for (int i = 0; i < 10; i++) {
			System.out.println(scores[i]); // 값을 안넣어주면 0이 나옴.
		}
	}

	// 두번 째 학생의 성적 조회
	// System.out.printf("두번째 학생은 %d 입니다.\n", scores[1]); // i가 0부터 시작하기 때문에 두번째 학생은
	// 1을 넣어줘야함

	// 최솟값
	public static void findMin() {
		int min = scores[0]; // 배열의 첫번째 값이 최솟값(min)이다.
		for (int i = 1; i < 10; i++) {
			if (min > scores[i]) { // i에 들어가는 수가 최솟값(min)보다 작으면
				min = scores[i]; // i가 최솟값(min)이다.
			}
		}
		System.out.printf("최솟값은 %d입니다.\n", min);
	}

	// 최댓값
	public static void findMax() {
		int max = scores[0]; // 배열의 첫번째 값이 최댓값이다(max) 정의.
		for (int i = 1; i < 10; i++) {
			if (max < scores[i]) { // i에 들어가는 수가 최댓값(max)보다 크면
				max = scores[i]; // i가 최댓값(max)이다.
			}
		}
		System.out.printf("최댓값은 %d입니다.\n", max);
	}

	// 평균값
	public static void findAvg() {
		int avg = 0;
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += scores[i];
		}
		avg = sum / scores.length; // 평균은 마지막에 scores[i]값들의 합(for문 돌린 것)을 scores값 전체의 갯수로 나눠주는 것이므로 빠져나온 곳에 적어줌.
									// 갯수가 적다면 갯수를 적어줘도 되지만 ex) sum/ 10, 갯수가 너무 많아서 세기 힘들다면 scores.lenth 메소드로 갯수를
									// 불러올 수 있음.
		System.out.printf("평균값은 %d 입니다.", avg);
	}

}
