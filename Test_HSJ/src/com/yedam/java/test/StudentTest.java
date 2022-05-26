package com.yedam.java.test;
//캡쳐한것 setting에 넣고 테스트폴더 전체 압축해서 메일전송. 제목 : 3강의장 홍선진

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		StudentSystem SdntSys = new StudentSystem();

		while (run) {
			System.out.println("=== 1.학생수 입력  2.학생정보 등록  3.학생정보 전체조회  4.학생정보 분석  5.종료");
			System.out.println("선택 > ");

			int select = Integer.parseInt(scan.nextLine());

			// 학생 수 입력
			if (select == 1) {
				System.out.println("학생 수 > ");
				int size = Integer.parseInt(scan.nextLine());
				SdntSys.setListSize(size);
			}
			// 학생정보 등록
			else if (select == 2) {
				System.out.println("학번 > ");
				int studentId = Integer.parseInt(scan.nextLine());

				System.out.println("이름 > ");
				String name = scan.nextLine();

				System.out.println("점수 > ");
				int score = Integer.parseInt(scan.nextLine());

				SdntSys.putStudent(studentId, name, score);
			}
			// 학생정보 전체조회
			else if (select == 3) {
				SdntSys.printList();
				System.out.println();
			}
			// 최고점수+학번
			// 최저점수+학번
			// 나머지 값들의 평균값
			else if (select == 4) {
				System.out.println("분석> ");
				SdntSys.getMaxScore();
				SdntSys.getMinScore();
				SdntSys.getAvgScore();
			}
			// 종료
			else if (select == 5) {

				run = false;
			}
			// +번외
			else
				System.out.println("잘못 입력된 번호");
		}
		System.out.println("프로그램을 종료");
	}

}
