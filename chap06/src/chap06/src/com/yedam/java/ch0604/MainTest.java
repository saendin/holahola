package chap06.src.com.yedam.java.ch0604;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		Program program = new Program(); // while문 안에 선언하게 되면 조건이 반복될 때 마다 값이 초기화됨.(new연산자를 계속 만들어냄.. 무한new는 어렵지..)
											// new연산자는 한번이면 됩니다.
		
		while (run) {
			System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료 ");
			System.out.println("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());
			// 
			//
			if (selectNo == 1) {
				System.out.print("학생 수> ");
				int student = Integer.parseInt(scanner.nextLine());
				program.setStudentNum(student);

			} else if (selectNo == 2) {
				System.out.print("점수입력> ");
				int score = Integer.parseInt(scanner.nextLine());
				program.setStudentScore(score);

			} else if (selectNo == 3) {
				program.printScores();

			} else if (selectNo == 4) {
				program.printResult();
			} else if (selectNo == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}

		System.out.println();

	}

}
