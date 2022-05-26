package com.yedam.example2;

public class Student {
	//필드
	//최소 3개
	
	//시리얼번호(정적필드)
	private static int serialNum = 1000;
	
	//1. 학번
	private int studentId;
	//2. 이름
	private String name;
	
	
	//생성자
	//생성자 호출됨. =학생 번호를 한개 호출하겠다
	public Student(String name) {
		//계속 누적된 시리얼 넘버 값으로 학번을 주는 것이기 때문에
		serialNum++;
		this.studentId = serialNum;
		this.name = name;
	}
	
	
	//메소드
	//시리얼 넘버는 static필드임. 
	public static int getSerialNum() {
		return serialNum;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
}
