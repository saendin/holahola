package Switchtest;

import java.util.Scanner;

public class SwitchTest {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//test1(); 
		//test2();
		//test3();
		test4();
	}

	// 브레이크 없는 경우
	public static void test1() {
		char menu = scan.next().charAt(0);
		switch (menu) {
		case 'a':
			System.out.println("일");
		case 'b':
			System.out.println("이");
		default:
			System.out.println("기타");
		}
	}

	public static void test2() {
		String menu = scan.next();
		switch (menu) {
		case "부장":
			System.out.println("700만원");
		case "과장":
			System.out.println("500만원");
		default:
			System.out.println("기타");
		}
	}

	public static void test3() {
		int menu = scan.nextInt();
		// 1~5 : 평일 6,7 : 주말
		switch (menu) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("평일");
			break;
		case 6:
		case 7:
			System.out.println("주말");
		}
	}

	public static void test4() {
		//내가 입력한 score의 값을 스캔하시오.
		int score = scan.nextInt();
		// score를 10으로 나눈 값이 90이상은 A등급 80이상은 B등급 70이상은 C등급 나머지는 D등급
		switch (score/10) {		//보통 점수체계가 100점이니까...ㅣㅏㅓㅁ나이ㅓㄻㄴㅇㄹ
		case 10: // 내 점수가 100점일 때 10으로 나누면 10이므로 case 10이 여기서 나타낼 수 있는 최대 등급임.
		case 9: System.out.println("A등급"); break;
		case 8: System.out.println("B등급"); break;
		case 7: System.out.println("C등급"); break;
		default: System.out.println("D등급");
		}
	}

}
