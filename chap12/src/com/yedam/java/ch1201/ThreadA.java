package com.yedam.java.ch1201;
//방법은 런어블을 구현하는 형식과 Thread를 상속받는 형식 두개가 있음.
//1. 동시에 구현하고 싶다면 런어블 인터페이스를 구현해서 run안에 집어넣으면 됨.
public class ThreadA implements Runnable {

	@Override
	public void run() {
		//스레드에 작동시키고자 하는 것을 여기에 넣으면 됨.
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
