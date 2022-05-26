package com.yedam.java.ch0703;

public abstract class Animal {
	// 추상 클래스에 추상 메서드가 필수는 아님.
	// But, 추상 메서드가 하나라도 존재하면 그 클래스는 추상 클래스가 되어줘야함. (뭐 어떻게 소리 낼건데.. 에 대한 정의 ㅋㅋ)

	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	public abstract void sound();

}
