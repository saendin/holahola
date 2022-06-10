package com.yedam.java.chap1601;

//MyFunInterfaceB라는 인터페이스에 method(int num)라는 메소드를 선언했다.
//매개변수가 있고 리턴타입이 없는 람다식
@FunctionalInterface
public interface MyFunInterfaceB {
	public void method(int num);
}
