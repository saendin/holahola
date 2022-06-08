package com.yedam.java.question;
//추상클래스
public abstract class Member {
	// 필드
	// 필드를 만들고 기준이 되는 상수르 집어넣음.
	static final int GRADE_STANDARD = 1000000; // 등급의 기준. (상수로 집어넣어서)
	int record;
	String grade;

	// 생성자
	// 멤버 정보(필드의 record 값 받아와서 사용)
	// record값에 따라서 멤버가 다르게 반환되어야 함.
	// record=전월실적 100만 < SILVER / > 100만 GOLD (스탠다드보다 크면 골드가 되고 작으면 실버가 되어야 함)
	public Member(int record) {
		this.record = record;
	}

	// 메소드
	// 멤버쉽 정보를 보여줘라 (내가 집어넣은 전월 실적에 따른 정보 출력)
	public void showMemberInfo() {
		System.out.println("현재 실적은 " + record + "이며, 회원등급은 " + grade +"입니다.");

	}

	// 겟 멤버쉽에서 넘겨받은 레코드를 집어넣음
	// 내가 집어넣은 실적에 따라 멤버의 등급이 값을 가짐.
	public static Member getMemberShip(int record) {
		Member grade = null;
		if (record > Member.GRADE_STANDARD) {
			grade = new Gold(record);
		} else {
			grade = new Silver(record);
		}
		return grade;
	}

}
