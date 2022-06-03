package com.yedam.java.ch1101;

public class SystemTest {
	//실제 시간을 계산할 때 많이 사용.
	public static void main(String[] args) {
		long time1 = System.nanoTime();
		int sum = 0;
		for(int i=1; i<=1000000; i++) {
			sum+=1;
		}
		long time2 = System.nanoTime();
		System.out.println("1~10000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2 - time1)  + "나노초가 소요되었습니다.");
	}

}
