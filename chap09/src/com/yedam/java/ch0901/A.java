package com.yedam.java.ch0901;
//중첩 클래스

// 하나의 클래스가 있고 그 안에 또 하나의 클래스를 정의하는 것.

// 인스턴스 멤버 클래스(static 허용 X)
public class A {
	A() {
		System.out.println("A 인스턴스가 생성됨.");
	}

	class B {
		// 중첩 클래스도 인스턴스 생성 가능.
		// 직접적으로 관련된건 아니지만 인스턴스를 만들어 내야함.

		// 필드
		int field1;
		// static int field2;(이건 허용 안한단 말.)

		// 생성자
		B() {
			System.out.println("B 인스턴스가 생성됨.");
		}

		// 메소드
		void method1() {
		}
	}

	// 정적 멤버 클래스와의 차이점 알아보기

	// 정적 멤버 클래스
	// 정적 필드와 정적 메소드 존재.
	static class C {
		// 필드
		int field1;
		static int field2;

		// 생성자
		C() {
			System.out.println("C 인스턴스가 생성됨.");
		}

		// 메소드
		void method1() {
		}

		static void method2() {
		}
	}

	// A클래스 메소드
	void method() {
		// 로컬 클래스
		class D {
			// 필드
			int field1;

			// 생성자
			D() {
				System.out.println("D 인스턴스가 생성됨.");
			}

			// 메소드
			void method1() {
			}
		}
		D d = new D();
		d.field1 = 1;
		d.method1();

	}
}

//