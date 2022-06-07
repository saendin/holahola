package com.yedam.java.ch1103;

public class MathExample {
	public static void main(String[] args) {

		// 절대값 Math.abs
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);

		// 올림값 Math.ceil (오른쪽으로 감. ex)-3.5 -> -3 (커짐))
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3=" + v3);
		System.out.println("v4=" + v4);

		// 버림값 Math.floor (왼쪽으로 감. ex)-3.5 -> -4 (작아짐))
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5=" + v5);
		System.out.println("v6=" + v6);

		// 최대값 Math.max
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.5);
		System.out.println("v7=" + v7);
		System.out.println("v8=" + v8);

		// 최소값 Math.min
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.3, 2.5);
		System.out.println("v9=" + v9);
		System.out.println("v10=" + v10);

		// 랜덤값	Math.random (말 그대로 랜덤값을 제공할 때) / 원하는 범위내의 랜덤값일 때(조절 필요) : Random class라는 것 사용하면 됨.
		double v11 = Math.random();
		System.out.println("v11=" + v11);

		// 가까운 정수의 실수값 Math.rint (rint보다는 반올림값이 더 정확함. 린트는 중간값이 애매~함(0.5))
		double v12 = Math.rint(5.3);
		double v13 = Math.rint(5.7);
		System.out.println("v12=" + v12);
		System.out.println("v13=" + v13);

		// 반올림값 Math.round (소숫점 이하 첫번째 자리에서만 반올림 가능)
		long v14 = Math.round(5.3);
		long v15 = Math.round(5.7);
		System.out.println("v14=" + v14);
		System.out.println("v15=" + v15);

		// 반올림값 Math.round를 소수 두번째자리까지 나타내고 싶을 때.
		double value = 12.3456;
		double temp1 = value * 100;
		long temp2 = Math.round(temp1);
		double v16 = temp2 / 100.0;
		System.out.println("v16=" + v16);
	}
}
