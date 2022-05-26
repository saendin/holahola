package com.yedam.java.ch0702;

public class Hankook extends Tire {

	public Hankook(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() { // 타이어가 굴러감.
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire 수명 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println("*** " + location + " HankookTire");
			return false;
		}
	}
}
