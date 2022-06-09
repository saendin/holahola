package com.yedam.java.ch1202;

public class PrintThread extends Thread {

	// 무한반복 스레드
	@Override
	public void run() {
		//interrupt -> 작업 스레드를 종료시킬 경우
		try {
			while (true) {
				System.out.println("실행중");
				Thread.sleep(1000); // 인터럽트 인셉션을 쓰려면 무조건 sleep을 써야함. (잠들어 있지 않으면 깨울 수 없음! 그래서 잠든 경우를 만든 것)
			}
		} catch (InterruptedException e) { // 인터럽트가 깨우는고 ㅋㅋ
			System.out.println("interrupt method 실행");
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	}

}


//+while 구문을 try catch구문 밖으로 빼주면 종료구문 실행 후에도 계속 실행됨.
//(= interrupt -> 작업 중 일시적인 추가작업 필요한 경우)