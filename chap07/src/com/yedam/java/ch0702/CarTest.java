package com.yedam.java.ch0702;

public class CarTest {

	public static void main(String[] args) {
		
		Car car = new Car();
		for (int i = 1; i < 5; i++) {
			//즉, run이 정상적으로 작동하면 switch구문 어디에도 걸리지 않고 그냥 돌아감.
			//임의로 준 숫자가 switch문에 따라 break가 된다면 교체.
			int problemLocation = car.run(); 
			

			// tire problem이 1,2,3,4가 나오면 고장난거(펑크)
			//펑크나면 다른거 써볼고임
			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire 교체");
				car.frontLeftTire = new Tire("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire 교체");
				car.frontRightTire = new Tire("앞오른쪽", 14);
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire 교체");
				car.backLeftTire = new Tire("뒤왼쪽", 13);
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire 교체");
				car.backRightTire = new Tire("뒤오른쪽", 12);
				break;
			}
			System.out.println("============================");
		}
	}

}
