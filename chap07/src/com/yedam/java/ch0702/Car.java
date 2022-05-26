package com.yedam.java.ch0702;

public class Car {
	// 필드
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);

	// 생성자

	// 메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		//tire가 roll할 때마다 false가 뜨는지. roll횟수의 수명에 따라 false가 뜨는 순간 펑크나는것. roll 횟수 최댓값 = 펑크 = 고장
		// 앞왼쪽 바퀴가 false일때 멈춰라, 리턴값 1 반환. -> 펑크 난 상황
		if (frontLeftTire.roll() == false) { 
			stop();
			return 1;
		}
		if (frontRightTire.roll() == false) {
			stop();
			return 2;

		}
		if (backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if (backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0; // if문을 벗어났을 때 어느 조건에도 만족하지 않으면 리턴값 0 반환.
	}

	void stop() {
		System.out.println("[자동차가 멈춥니다]");
	}
}
