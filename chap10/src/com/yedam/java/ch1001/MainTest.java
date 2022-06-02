package com.yedam.java.ch1001;

public class MainTest {

	public static void main(String[] args) {
		/*// 실행예외 = 문법적으로는 아무 문제가 없으나, 실제로 실행 하면 오류가 남. - 경험자으 ㅣ경험에 의거
		// NullPointerException
		String data = null; // null = 인스턴스가 없음 = 실행 주체가 없음 = 실행 주체가 없는데 뭔가를 요구하는거 자체가 에러를 일으킴.
		if (data != null) { // 예외가 발생해도 자연스럽게 처리되게 하는 것. (노란줄 : 필요없는 코드, 사용되지 않는 코드)
			System.out.println(data.toString()); // 메서드 호출엔 문제가 없으나 실행 주체가 없으니 눌포인트 에러남.
		}

		// ArrayIndexOutofBoudsException
		if (args.length >= 2) {
			String data1 = args[0];
			String data2 = args[1];

			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);
		}
		
		//NumberFormatException
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		
		int result = value1 + value2;
		*/
		
		//ClassCastException
		changeDog(new Dog());
		changeDog(new Cat());
		
		
	}
	//매서드 생성
	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) {	//타입변환할때 instanceof써주면 밀 ㅣ체크해줘서 classCastException 발생 거의 무
		Dog dog = (Dog) animal;
		}
	}
}
//상속관계 클래스 만들기
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
