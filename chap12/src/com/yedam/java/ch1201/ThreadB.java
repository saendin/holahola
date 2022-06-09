package com.yedam.java.ch1201;

//방법은 런어블을 구현하는 형식과 Thread를 상속받는 형식 두개가 있음.
//2. Thread를 상속받는 자식클래스 안에 run을 오버라이딩 하는 방식.
public class ThreadB extends Thread {

	//run 메소드 오버라이딩	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("현재 순서 : " + i);
			try {
				Thread.sleep(500);	//0.5초(sleep mils단위)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
