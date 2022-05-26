package com.yedam.java.ch0702;

public class DriverTest {

	public static void main(String[] args) {
		//드라이버 한명 만들고 탈 수 있는 것은 다 운전하게끔 설정.
		//드라이브라는 메소드의 변수는 vehicle밖에 없으나, 드라이버가 운전하고자 하는 차종은 3가지가 됨.
		//새로운 변수로 설정해서 넣어줘도 작동ㅇ

		/* 인스턴스를 선언할 떄 반드시 변수가 필요한건 아니다.
		 * 변수 선언 = 외부에서 사용할거니까 하나 새롭게 담아달라
		 * Bus bus = new Bus();
		 * driver. drive(bus);
		 * bus.run();
		 */
		//new 뒤의 것이 매개변수.
		//매개변수만 바꿔줘도 잘 사용하고 있음. -> 부모클래스에서 동일한 메소드가 다 정의가 되어 있으니까.
		//= 부모의 것 호출해서 사용ㄱㄴ
		Driver driver = new Driver(); //
		driver.drive(new Bus()); 
		driver.drive(new Taxi());
		driver.drive(new Vehicle());
	}

}
