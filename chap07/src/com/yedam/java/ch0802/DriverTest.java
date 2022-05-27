package com.yedam.java.ch0802;

public class DriverTest {
//자동차를 운전할 수 있는 사람을 불러와라

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		//매개변수를 선언할 때 사용방법이 같은 것에 대해서는 하나의 메소드를 사용해서 여러개의 결과물을 출력할 수 있다.
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		//drive라는 매개변수 하나에 두개가 들어갈 수 있음.
		driver.drive(taxi);
		driver.drive(bus);
	}
}


//인터페이스를 구현하는 클래스도 기본 클래스다
//타입을 interface로 선언했을때는 I로 선언한 것만 실행 가능.
//But, 다른곳의 기능도 수행하고 싶을 땐 강제로 변환을 해줘서 호출해오는 것임.
//=구현에서 강제 타입변환 가능.
//인터페이스에 선언되어있는 변수를 구현클래스에서(?) 사용하고싶으면 instanceOf로 확인하고 사용해줘야 함.
