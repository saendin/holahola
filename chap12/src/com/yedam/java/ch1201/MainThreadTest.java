package com.yedam.java.ch1201;

public class MainThreadTest {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			System.out.println("현재 순서 : " + i);
			try {
				Thread.sleep(500);	//0.5초(sleep mils단위)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
