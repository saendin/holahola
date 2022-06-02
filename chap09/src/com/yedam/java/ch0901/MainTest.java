package com.yedam.java.ch0901;

public class MainTest {

	public static void main(String[] args) {
		A a = new A();

		System.out.println();
		
		// 중첩 클래스인 B클러스의 새로운 변수 생산법
		// 클래스 A를 이용하는게 아니고 A라는 클래스 내에 만들어진 인스턴스 변수명인 a를 통해 new 연산자를 생성
		A.B b = a.new B();
		b.field1 = 1;
		b.method1();

		System.out.println();
		
		// 실생해보면 둘이 각 각 움직여서 각 값을 호출
//		A 인스턴스가 생성됨.
//
//		B 인스턴스가 생성됨.
		//B랑 다른점 :
		
		//C : A클래스에 대해 새로운 인스턴스를 생성할 필요가 없음.
		//즉, 직접 접근 가능 (B는 A클래스에 대한 새로운 인스턴스 요함.)
		//C클래스가 정적 클래스라 바로 접근할 수 있으나, A클래스의 밑에 있기 때문에 A.C.으로 들어가는고
		
		
		A.C.field2 = 2;
		A.C.method2();
		
		A.C c = new A.C();
		c.field1 = 1;
		c.method1();
		
		System.out.println();
		//로컬 클래스
		a.method();
		
	}

}
