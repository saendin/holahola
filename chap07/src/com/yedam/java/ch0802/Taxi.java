package com.yedam.java.ch0802;

//자동차 중에 하나므로 Vehicle의 운행방법을 따를 것임. 
public class Taxi implements Vehicle {

	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	
	}
}