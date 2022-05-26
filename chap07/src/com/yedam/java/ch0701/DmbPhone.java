package com.yedam.java.ch0701;

public class DmbPhone extends Phone{
	//extend = 상속
	//즉, DmbPhone은 Phone이라는 클래스를 자식으로 두는 부모 클래스이다.
	//자식 클래스인 DmbPhone은 추가되는 기능만 적어주면 됨.
	int ch;
	
	//어떤 모델을 할건지, 색은 뭔지 지정
	//아무것도 없는 디폴트 생성자만
	//
	public DmbPhone(String model, String color) {
		//부모클래스인 Phone의 클래스들에 접근할 수 있음.
		//Dmb에서 만든 인스턴스가 자신의 것 뿐만 아니라 부모의 것도 같이 만들 수 있음.
		//부모클래스의 호출하지 않더라도 자바가 알아서 집어 넣어놓음. super();
		//내부에서는 new를 쓰지않음. 왜 this가 아니고 super인가? this는 instance를 가리키는게 맞지만,
		//내것이면 this(단, 니가 콕 집어 부모의 것을 호출하고 싶으면) 쓰기.
		//This를 사용하는건 똑같으나 부모것은 super을 사용해도 됨.
		//super(model, color);
		//super.model = model;
		//super.color = color;
		super.model = model;
		super.color = color;
		this.ch = 10;	//super는 범위가 확 좁아져서 오류 뜸.
	
	}
	//Dmb기능 켜기
	void turnOnDmb() {
		System.out.println("채널 " + ch + "번 방송 수신을 시작합니다.");
	}
	//Dmb기능 끄기
	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}
	//채널 바꾸기
	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널" + ch + "번으로 바꿉니다.");
	}
	
	
	//method 정의 
	
	
}
