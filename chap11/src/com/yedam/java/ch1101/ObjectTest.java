package com.yedam.java.ch1101;

public class ObjectTest {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}

		if (obj1 == obj2) {
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}
	}

}
