package com.yedam.java.ch1201;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	// 2초동안 접근한 스레드를 일시적으로 중지시키면 내가 넣은 값이 일시적으로 유지되는지(?)
	// 스레드 제어 위해 인터럽트 걸면 인터럽트가 뭔지 알기위해 출력하도록, 현재 메모리가 뭔지 표시하도록.
	//synchronized : 멀티 스레드가 동시에 접근할 때 사용 됨. 동시에 같은 메소드를 사용하게 되면 순차적으로 접근할 수 있도록 해줌.
	//synchronized 써주면 두개의 스레드 값이 다르고, 안써주면 같음.
	public synchronized void setMemory(int memory) { 
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {} //Interrupt구문 밖으로 나와야 실행됨.
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : " + info.getName() + ", memory : " + this.memory );
	}
}
