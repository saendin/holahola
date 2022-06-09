package com.yedam.java.ch1201;

public class UserTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		//cal.setMemory(100);
		
		//새 인스턴스 만들고 각각의 스레드를 만들어 똑같이 넣어볼 것
		User user1 = new User();
		user1.setCalculator(cal);
		user1.start(); //=run(); 같은건데 다른 이름을 쓰는 이유는 run메소드를 또 써버리면 스레드 안의 스레드가 생성되어버림. like 인셉션 ㅋㅋ
		//user1이 가져야 하는값 200
		
	
		User user2 = new User();
		user2.setCalculator(cal);
		user2.start();
		//user2가 가져야하는 값은 300
		
		//인스턴스가 하난데 두개가 동시에 사용하니까
		//Calculator에 있는 memory user1이 접근해 100으로 바꾸고 user1스레드는 스탑됨.(일시적 멈춤 = 스레드만 멈춤, 인스턴스는 동작하고 있음.)
		//스레드에 종속된 것이 아니라 독립된 것.
		//user2가 들어가면서 300으로 바꿔버림. Calculator가 가지고 있는 메모리값이 출력 됨.
		//스레드는 값을 불러오거나 내보내는 것 밖에 안함. 인스턴스랑은 다름.
		
	}

}
