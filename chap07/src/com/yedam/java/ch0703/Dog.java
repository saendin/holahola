package com.yedam.java.ch0703;

public class Dog extends Animal {
//Animal이 추상 클래스 이면서 추상 메소드까지 같이 겸용되므로 빨간 줄 생김. = 정의해줘야됨.

	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}
