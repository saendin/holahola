package com.yedam.java.test;

// mjk@yedam.ac
public class Student {
	// 학생수 입력
	// 학생 정보 등록
	// 학생 정보 전체조회
	// 학생 정보 분석
	// 종료
	// 필드
	// 학번(입력받아 넣을 학번)
	private int studentId;
	// 이름(입력 받아 넣을 이름)
	private String name;
	// 점수(입력 받아 넣을 점수)
	private int score;

	// 학생에 대한 정보 외부에서 new연산자로 쓸 수 있도록 필드값 초기화
	public Student() {
	}

	// 생성자
	// 학생이 가지는 특징으로 생성자 만들기. (학번, 이름, 점수)
	// 인스턴스 생성 시 값을 초기화 할 수 있도록 생성자를 가짐
	public Student(int studentId, String name, int score) {
		this.studentId = studentId;
		this.name = name;
		this.score = score;
	}

	// 메소드
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}
}
