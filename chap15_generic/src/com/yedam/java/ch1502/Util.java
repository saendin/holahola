package com.yedam.java.ch1502;

public class Util {
	// 넘버를 상속받는 클래스만 제네릭 타입으로 받을고임
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}

}
