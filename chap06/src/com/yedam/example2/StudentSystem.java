package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
		Student jung = new Student("훈");
		Student hong = new Student("진");
		
		
		System.out.println(Student.getSerialNum());
		System.out.println(jung.getName() + "의 학번 : " + jung.getStudentId());
		
		
		System.out.println();
		
		
		
		System.out.println(Student.getSerialNum());
		System.out.println(hong.getName() + "의 학번 : " + hong.getStudentId());
	
		
		System.out.println();

		//시리얼 넘버는 올라가지만 학번은 그대로다.
		System.out.println(Student.getSerialNum());
		System.out.println(jung.getName() + "의 학번 : " + jung.getStudentId());
	}

}
