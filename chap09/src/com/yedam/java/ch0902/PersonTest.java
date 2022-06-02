package com.yedam.java.ch0902;

public class PersonTest {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();

		// 필드가 익명객체인경우
		anony.field.wake();

		System.out.println();

		
		
		// 로컬변수가 익명객체인경우
		anony.method1();

		System.out.println();

		
		
		// 매개변수가 익명객체인경우
		anony.method2(new Person() { // -> 익명 자식객체로 변함
			// 필드
			String job = "학생";

			// 메소드
			void study() {
				System.out.println("공부합니다.");
			}

			
			// 필드와 메소드는 가질 수 있지만 외부의 것을 가져올 순 없음.
			@Override
			//study나 job을 호출하고 싶어도 불가능. 오직 wake만 실행 가능.
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
			// anony.method2(null);
		});

	}
}
