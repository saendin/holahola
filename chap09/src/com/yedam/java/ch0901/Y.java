package com.yedam.java.ch0901;

public class Y {
	// 필드
	int field1;
	static int field2;

	// 메소드
	void method1() {
	}

	static void method2() {
	}

	// 인스턴스 멤버 클래스 -> Y클래스의 인스턴스가 반드시 필요함.
	// -> 인스턴스가 접근할 수 있는 모든 내부 멤버를 호출할 수 있음.
	// 인스턴스가 존재한다는 전제조건 하에 사용 가능.
	class B {
		void method() {
			field1 = 1;
			field2 = 1;

			method1();
			method2();
		}
	}

	// 정적 멤버 클래스
	// Y클래스가 인스턴스를 가지고 있는지 확신 X -> Y클래스의 인스턴스가 존재하지 않음. (인스턴스가 없을 때 접근할 수 있는 필드와 메소드
	// 사용 가능)
	// (사용 가능 = 정적필드, 정적메소드) -> Y클래스의 정적 내부 멤버들만 호출할 수 있음.

	static class C {
		void method() {
			field1 = 1; // 정적필드로 선언되지 않은 것은 사용 불가
			field2 = 1;

			method1();
			method2();
		}
	}
	//Y클래스의 메소드
	int method(int arg) {
		int var = 1;	//final구문이 없지만 final구문으로 규정지어져 있음. = final int var = 1;
		//arg = 100;
		//var = 90;
		//로컬클래스로 D생성
		//메소드가 호출될 때만 생성됨.
		class D {
			void method() {
				int result = arg + var; //처음 시작값을 복사하는 이유? 끝나는 시점을 정확히 파악할 수 없음.
			}
		} 
		D d = new D(); 	//바깥에서 썼을 때 값이 변하지 않는 것을 전제
		d.method();		//
		var = 2;
		return var; 	//명확하게 한번만 리턴하는 경우는 상관 없지만, 그걸 알 수 없기 때문에 처음 시작값을 복사함.
	}

}
