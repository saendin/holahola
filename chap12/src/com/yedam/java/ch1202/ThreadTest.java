package com.yedam.java.ch1202;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
		thread.start(); //run have stop값
		
		//어느정도 돌다가 정지시키고 싶으면
		//2초동안 돌다가 setStop하곘다.
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		thread.setStop(true);
		
		System.out.println("--------------------------------");
		
		Thread sub = new Thread() {
			//상속받는 관계의 익명 자식객체 생성 가능
			@Override
			public void run() {
				while(true) {
					if(Thread.interrupted())
						break;
					System.out.println("=========실행 중");
				}
				System.out.println("=========자원 정리");
				System.out.println("=========종료");
			}
		};
		
		sub.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub.interrupt();
	}
}

//스레드 만들고 제어하고 종료시키는 방법만 알면 됨.