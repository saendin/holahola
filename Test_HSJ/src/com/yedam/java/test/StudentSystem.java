package com.yedam.java.test;
/*
 * 1. 학생 수 입력		 (등록구현)
 * 2. 학생 정보 등록	 (등록구현)
 * 3. 학생정보 전체 조회 (조회구현)
 * 4. 학생정보 분석	 (분석기능 구현)
 * 5. 종료
 */

public class StudentSystem {
	// 우리가 받아야 할 입력정보는 학생 수.
	private Student[] list; // 학생 수는 입력에 따라 달라짐. = student[]
	private int index; // 실제로 몇 명을 입력받는지 알고자 index를 따로 변수로 부여
	int max;
	int min;
	int temp;
	double avg;
	int sum = 0;

	public StudentSystem() {
		index = -1; // 배열값 초기화
	}

	// 학생 수 입력
	public void setListSize(int size) {
		// new 생산자로 상품 입력 수 만큼(size)의 학생 수 생성 = 학생 수 리스트
		list = new Student[size];
	}

	// 학생 정보 등록
	// 세 가지 정보를 가지는 학생(학번, 이름, 점수)
	// *list에 넣어줄 값들임
	public void putStudent(int studentId, String name, int score) {
		Student student = new Student();
		// student 필드의 get 값들 호출
		student.setStudentId(studentId);
		student.setName(name);
		student.setScore(score);

		list[++index] = student;
	}

	// 학생 정보 출력
	public void printList() {
		for (int i = 0; i <= index; i++) {
			// student라는 변수에 list의 i값 담기
			Student student = list[i];
			// 00 학번의 점수는 00입니다.
			System.out.printf("%d 학번의 점수는 %d입니다\n", student.getStudentId(), student.getScore());
		}
	}

	// 학생 정보 분석
	// 최고점, 최저점, 1&2제외한 평균값(%.2f)
	// 최고점
	public int getMaxScore() {
//		int max = list[0].getScore();
//		for (int i = 1; i <= index; i++) {
//			int temp = list[i].getScore();
//			if (max < temp) {
//				max = temp;
//			} //점수와 학번 뽑아내기
//				stdnt = i;
		Student max = list[0];
		for (int i = 1; i <= index; i++) {
			if (max.getScore() < list[i].getScore()) {
				max = list[i];
			}
		}
		System.out.println("최고 점수 : " + max.getScore() + ", 학번 : " + max.getStudentId());
		return max.getScore();
	}

	// 최저점
	public int getMinScore() {
//		int min = list[0].getScore();
//		for (int i = 1; i <= index; i++) {
//			int temp = list[i].getScore();
//			if (min > temp) {
//				min = temp;
//			}
//				stdnt = i;
		Student min = list[0];
		for (int i = 1; i <= index; i++) {
			if (min.getScore() > list[i].getScore()) {
				min = list[i];
			}
		}
		System.out.println("최저 점수 : " + min.getScore() + ", 학번 : " + min.getStudentId());
		return min.getScore();
	}

	// 평균점수
	public void getAvgScore() {
		max = getMaxScore();
		min = getMinScore();

		for (int i = 0; i <= index; i++) {
			sum += list[i].getScore();
		}
		avg = (double)(sum - max - min) / (index - 1);

		System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점 입니다.\n", avg);
	}
}
