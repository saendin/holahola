package com.yedam.java.ch0801;

public class RemoteTest {

	public static void main(String[] args) {
		RemoteControl rc = new Audio();
		//RemoteControl rc = new TV();
		rc.turnOn();
		rc.setVolume(5);;
		rc.turnOff();
		
		
		SmartControl sc = new TV();
		sc.searchInternet("네이버");
		sc.executeApp("구글");
		
		
		TV tv = new TV();
		tv.turnOn();
		
		//RemoteControl과 SmartControl을 상속하고 있는 Control(interface) 그리고 그걸 구현하는 TV
		//Control은 상속받은 두개가 어떤 기능을 가지고 있는지 아니까 TV에 연결하면 어떤 기능을 구현할 수 있는지 알 수 있다.
		//각각 제한된 기능이지만 TV를 제어할 수 있음.
		//implement는 TV에서 사용 검지 ㅋㅋ
		Control con = new TV();
		con.turnOn();
		con.executeApp("게임");
	}

}
