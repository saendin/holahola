package com.yedam.java.ch0901;

public class Outter {
	String field = "바깥클래스 - 필드";

	void method() {
		System.out.println("바깥클래스 - 메소드");
	}

	// Outter클래스에만 존재하는 메소드
	void methodA() {
		System.out.println("바깥클래스 - 메소드 A");
	}

	// 인스턴스 멤버 클래스
	class Nested {
		String field = "중첩클래스 - 필드";

		void method() {
			System.out.println("충첩클래스 - 메소드");
		}

		void print() {
			methodA();
			System.out.println(this.field);
			method(); // Nested만 가지는 독립적 인스턴스를 사용하기 위해 this 사용 가능.
			System.out.println(Outter.this.field); // Outter의 것을 끌어다 쓰고 싶어도 this를 씀. 대신 끌어다 쓸 클래스 명시.
			Outter.this.method();

		}
	}

	interface I {
		int FIELD = 100;

		void method();
	}

	static interface N {
		int FIELD = 100;

		void method();
	}
}

//아우터와 네스티드는 각 다른 클래스이므로 똑같은 이름의 필드로 메소드 선언 가능.