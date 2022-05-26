package com.yedam.java.ch0701;

public class Phone {
	String model;
	String color;
	
	public Phone(String model, String color) {
		this.model = model;
		this.color= color;
	}
	//더이상 수정할 필요가 없을 때
	final void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	final void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	void bell() {
		System.out.println("벨이 울리고 진동을 일으킵니다.");
	}
	
	void call() {
		System.out.println("전화를 연결합니다.");
	}
	
	
}
