package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		
		//바꿀 수 없는걸 바꾸려하면 강제로 캐스팅변환 필요
		//값은 몽땅 쓸 수 있지만, 꺼내올 때 마다 뭘 쓸지 생각해줘야함.
		bag.set(new Note());
		Note note = (Note) bag.get(); //Note 대신 String 써줘도 문법적으론 문제ㄴ but 실행오류남 (밑도 마찬가지)
		
		bag.set("신운하");
		String name = (String)bag.get(); //
		
		//어떤 타입을 쓰겠다고 결정을 내려야 하고, 결정된 타입만 사용 가능.
		//이 외에 다른 타입을 쓰고 싶다면 새로운 변수 선언 요망.
		Box<Note, String, Integer> box = new Box<>();
		
		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();
		
		
		//ex)
		Box<Car, Bus, Taxi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setV(new Bus());
		vehicle.setK(new Taxi());
		
		Car car = vehicle.getT();
		Bus bus = vehicle.getV();
		Taxi taxi = vehicle.getK();
	}

}

class Car {}
class Bus {}
class Taxi {}
