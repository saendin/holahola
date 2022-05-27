package com.yedam.java.example1;

public interface Scheduler {
	//직우너이 고객을 응대
	public void getNextCall();
	//관리자가 직접 대기열을 관리
	public void sendCallToAgent();
	//
}
