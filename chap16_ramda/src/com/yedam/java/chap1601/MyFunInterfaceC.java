package com.yedam.java.chap1601;
//MyFunInterfaceC라는 인터페이스에 method(int x, int y)라는 메소드를 선언했다.
//매개변수도 있고 리턴값도 있는 람다식
@FunctionalInterface
public interface MyFunInterfaceC {
	public int method(int num1, int num2);	//int는 return타입임
}
