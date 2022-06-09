package com.yedam.java.ch1201;
//Thread를 상속받는 클래스 User
//하나의 상속클래스를 통해 여러개의 스레드를 만들것.
public class User extends Thread {
	private static int serial = 0;
	private Calculator cal;
	private int numInfo;
	
	public void setCalculator(Calculator cal) {
		//this = Thread를 상속받을 유저
		//이 유저에 이름을 주기 위해 만든 코드
		//기존에 있던 값에서 100이 더해져 유저의 이름 구성.
		this.serial +=100;
		this.setName("User" + serial);
		this.cal = cal;
		this.numInfo = serial;
	}
	//Calculator안에서 run동작
	@Override
	public void run() {
		cal.setMemory(100 + numInfo);
	}
	
	
}
