package com.yedam.java.ch0902;

public class Product {
	//필드
	RemoteControl field = new RemoteControl() {//인터페이스 기반이라 인터페이스 이용해 뉴 연산자 호출후 실행블록("{")을 통해 실제 구현 내용 정의
		//필드
		String message = "스마트TV";
		//메소드
		void print() {
			System.out.println("제품 종류 : " + message);
		}
		//인터페이스가 가지는 메소드기 때문에 반드시 오버라이딩 하라고 뜸.
		@Override
		public void turnOn() {
			print();
			System.out.println("전원을 켭니다.");
		}
		@Override
		public void turnOff() {
			print();
			System.out.println("전원을 끕니다.");
		}
	};
	//생성자
	RemoteControl method1() {	//RemoteControl method1() {  -> return var;
		int volume = 0;
		
		RemoteControl var = new RemoteControl() {
			
			//필드
			String message = "AUDIO";
			
			//메소드
			void print() {
				System.out.println("제품 종류 : " + message);
			}
			@Override
			public void turnOn() {
				print();
				System.out.println("전원을 켭니다.");
			}

			@Override
			public void turnOff() {
				print();
				System.out.println("전원을 끕니다.");
				System.out.println("현재 볼륨 : " + volume);
			}
			
		};
	
		var.turnOn();
		var.turnOff();
		return var; //(RemoteControl method1()일 때)
	}

	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
