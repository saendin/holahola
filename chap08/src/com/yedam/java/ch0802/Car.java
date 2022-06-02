package com.yedam.java.ch0802;

public class Car {
	Tire frontLeftTire = new KumhoTire();
	Tire frontRightTire = new KumhoTire();
	Tire backLeftTire = new KumhoTire();
	Tire backRightTire = new KumhoTire();
	//차 동작 - 네개의 타이어 모두 동작
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
	
}
