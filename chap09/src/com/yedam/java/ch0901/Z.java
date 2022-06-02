package com.yedam.java.ch0901;

public class Z {
	//인스턴스 멤버 Z클래스 인스턴스가 있어야 함
	//
	B field1 = new B();	//Z클래스의 인스턴스가 존재
	C field2 = new C();	//Z클래스의 정보만 있으면 됨
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	//static(정적) 멤버 - Z클래스 인스턴스 없을 수 있다.
	static B field3 = new B();	// 반드시 Z클래스의 인스턴스가 필요 (B는 정적 멤버 아니니까)
	static C field4 = new C();	// Z클래스의 정보만 필요 (C가 정적 멤버니까)
	
	static void method2(); {
		B var1 = new B();
		C var2 = new C();
	}
	//바깥 클래스인경우 둘 다 사용 가능.
	//(인스턴스멤버나 정적 멤버클래스 둘다)
	//인스턴스 멤버 클래스
	class B{}
	//정적 멤버 클래스
	static class C {}
}
