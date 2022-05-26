package chap06.src.com.yedam.java.ch0601;

public class Main {

	public static void main(String[] args) {	//자바가 반드시 필요로하는 메소드. 얘를 감싸는 클래스 이름은 상관 무. method signature. 항상 동일해야 메인 메소드를 실행시킬 수 있음.
		
		Car myCar = new Car(); 	//new연산자를 쓰면 무조건 새로운 인스턴스가 생성됨.
								//기존의 것을 쓰고 싶다면 카피해서 쓸 것.
		System.out.println(myCar);
		
		Car yourCar = new Car();
		
		System.out.println(yourCar);
	}

}
