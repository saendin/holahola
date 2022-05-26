package com.yedam.example2;

public class CardFactory {

	//싱글톤 만들기~!
	
	//필드
	private static CardFactory instance = new CardFactory();
	
	//생성자
	//외부에서 사용 못하게 프라이빗으로 막기잼(클래스 내부에서만 쓸 수 있도록->클래스 내부의 인스턴스 만들기(new연산자 사용)
	private CardFactory() {}
	
	
	//메소드
	//내가 만든 메소드를 통해서만 공유시킬 수 있도록
	public static CardFactory getInstance() {
		return instance;
	}
	//실제 기능하는 싱글톤의 인스턴스에 대해선 static뺌
	//싱글톤은 인스턴스의 생성에서, 그 인스턴스를 통해 기능을 수행하게 함.
	//그래서 static을 넣으면 인스턴트 자체의 기능을 없애버려 getter를 써주는 의미를 잃게 됨.
	//
	public Card createCard() {
		return new Card("");
	}
}
