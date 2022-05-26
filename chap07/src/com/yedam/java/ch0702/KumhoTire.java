package com.yedam.java.ch0702;

public class KumhoTire extends Tire {

	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() { // 타이어가 굴러감.
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "KumhoTire 수명 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println("*** " + location + " KumhoTire");
			return false;
		}
	}
}
