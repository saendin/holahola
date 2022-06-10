package com.yedam.java.chap1601;

public class MainTest {

	public static void main(String[] args) {
		// 여러개의 메소드가 있으면 어떤것과 매칭해야하는지 알 수 없게되므로
		// 람다식이 타겟하는 메소드 딱 하나만 있어야 함.
		// 일반메소드처럼 상수 등을 가지지 않으며,
		// 람다식에 대해 딱 하나만 정의하게 됨.
		
		//매개변수가 없고 = ()안이 비어있음, 리턴값이 없는 람다식 = 실행부분에서 return 값이 없음.
		MyFunctionalInterface fi = () -> {
			System.out.println("람다식 다람쥐");
		};

		fi.method();

		// =람다식
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			@Override
			public void method() {
				System.out.println("익명 구현 객체 실행~!~!!!!~!!");
			}
		};
		
		mfi.method();
	
	
		MyFunctionalInterface nm;
		
		nm = () -> {System.out.println("내마음대로~!!~!");
		};
		
		nm.method();
	}
	
	
}
