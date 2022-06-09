package com.yedam.java.ch1202;

public class ThreadA extends Thread {
	//stop이면 false
	private boolean stop;
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		//stop이 아니면 = true면 실행중
		while(!stop) {
			System.out.println("실행중");
		}
		//그게 아니면 자원정리 종료 출력
		System.out.println("자원 정리");
		System.out.println("종료");
	}

	
}
