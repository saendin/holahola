package com.yedam.java.example2;

import java.util.Scanner;

public class StudentProgram implements Program {
	private Scanner sc = new Scanner(System.in);

	@Override
	public void menuPrint() {
		System.out.println("============================================");
		System.out.println("1.정보 입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.ㅂㅂ");
		System.out.println("============================================");
	}

	@Override
	// Access를 매개변수로 받는 이유. DB를 분리시킨 상황. 매개변수를 통해 저장소 주소를 받아 옴.
	// 필요에 따라 저장소를 연결할 수 있게끔
	public void inputInfo(Access access) {
		// 사용자가 정보를 입력
		Student info = inputAll();
		// 저장소에 등록
		access.insert(info);
	}

	private Student inputAll() {
		System.out.println("학번 > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("이름 > ");
		String name = sc.nextLine();
		System.out.println("점수 > ");
		int score = Integer.parseInt(sc.nextLine());

		return new Student(id, name, score);
	}

	@Override
	// 저장소에 저장된 정보 모두 가져오기
	public void printAllInfo(Access access) {
		// 저장소에서 데디터를 가져옴
		Student[] list = access.selectAll();

		// 데이터 전체 출력
		for (Student student : list) {
			student.showInfo();
		}
	}

	@Override
	public void printInfo(Access access) {
		// 검색 조건 입력
		int id = inputId();
		// 저장소에서 검색
		Student info = access.selectOne(id);
		// 출력
		info.showInfo();
	}

	private int inputId() {
		System.out.println("검색 학번 > ");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printReport(Access access) {
		// 최고점수
		System.out.println("최고 점수 > ");
		Student maxInfo = selectMaxScore(access);
		maxInfo.showInfo();

		// 최저점수
		Student minInfo = selectMinScore(access);
		System.out.println("최저 점수 > ");
		minInfo.showInfo();

		// 두개를 제외한 값의 평균점수
		System.out.println("최고 점수와 최저 점수를 제외한 총합의 평균 점수 > ");
		double avgResult = calAvg(access);
		System.out.println(avgResult);

	}

	private Student selectMaxScore(Access access) {
		Student[] list = access.selectAll();

		Student maxInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (maxInfo.getScore() < list[i].getScore()) {
				maxInfo = list[i];
			}
		}
		return maxInfo;
	}

	private Student selectMinScore(Access access) {
		Student[] list = access.selectAll();

		Student minInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (minInfo.getScore() > list[i].getScore()) {
				minInfo = list[i];
			}
		}
		return minInfo;
	}

	private double calAvg(Access access) {
		Student[] list = access.selectAll();

		int sum = 0;
		for (Student info : list) {
			sum += info.getScore();
		}
		return (double) sum / list.length;

	}

}
