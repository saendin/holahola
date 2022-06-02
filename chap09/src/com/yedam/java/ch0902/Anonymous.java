package com.yedam.java.ch0902;

public class Anonymous {
	//필드
	//이름없이 덩그러니 인스턴스 생성
	Person field = new Person() {
		//필드
		String job = "회사원";
		
		//메소드
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
			
		}
	};
//생성자

//메소드
	void method1() {
		//로컬변수
		//var에서 생성되는 인스턴스는 또 별개로 생성됨.
		Person var = new Person() {
			//로컬변수로 선언할 땐 내부에 같이 있으면 됨.
			//필드
			String job = "백수";
			//메소드
			void walk() {
				System.out.println("산책합니다.");
			}
			@Override
			void wake() {
				
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
		//접근할 수가 없음. 부모클래스에서 사용하는 wake만 접근 가능.
		var.wake();
	}
	
	void method2(Person person) {
		person.wake();
		
	}
}
