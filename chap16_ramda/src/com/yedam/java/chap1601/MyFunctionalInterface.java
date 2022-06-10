package com.yedam.java.chap1601;
//람다식 문법을 사용할고
@FunctionalInterface //람다식 언어로 사용 가능한 인터페이스라는 의미부여 = 1개 이상의 메소드를 선언할 수 없게 함.
//하나의 메소드만 사용하도록 보장함 ㅋㅋ

//MyFunctionalInterface라는 인터페이스에 method()라는 메소드를 선언했다.
public interface MyFunctionalInterface {
	//반드시 하나의 메소드만 포함하고 있어야 함.
	public void method();
}
