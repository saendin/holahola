package chap06.src.com.yedam.java.ch0602;

public class Main2 {
	//생성자를 통해 값을 변경하면서 우리가 원하는대로 값을 변경할 수 있음.
	public static void main(String[] args) {
		
		Car myCar = new Car("Blue"); 	//기본 생성자 my Car()을 없애면 new Car()안의 ()에 값을 넣지 않는 이상 실행이 안됨.
	
		Car yourCar = new Car("티볼리", "Silver");	
		
		Car newCar = new Car("레이", "yellow", 120);
		
		System.out.print(myCar.model + "\t");
		System.out.print(myCar.color + "\t");
		System.out.println(myCar.maxSpeed);
		
		System.out.println();
		
		System.out.print(yourCar.model + "\t");
		System.out.print(yourCar.color + "\t");
		System.out.println(yourCar.maxSpeed);
		
		System.out.println();
		
		System.out.print(newCar.model + "\t");
		System.out.print(newCar.color + "\t");
		System.out.println(newCar.maxSpeed);
	
	}
	
	

}
