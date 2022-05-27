package com.yedam.java.ch0801;
//두개를 가지면서 내것도 추가할 수 있음.
//둘 다 상속 받았다고 해서 TV와 완전한 상속 관계는 아님. (Control은 TV를 담을 수 없음.)
//TV는 구현하는 역할 Control은 상속하는 역할. 동일한 인터페이스 인건 맞지만 서로는 관련은 없음.
public interface Control extends RemoteControl, SmartControl{
	public void plusService();
	
	
	
	
}
