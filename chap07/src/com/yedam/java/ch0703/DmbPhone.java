package com.yedam.java.ch0703;

public class DmbPhone extends Phone {

	public DmbPhone(String model, String color) {
		super(model, color);
	}
	
	@Override
	//기존의 추상 가지고 있던 것을 
	public void powerOn() {
		super.powerOn();
		System.out.println("부팅이 완료되었습니다.");
	}
	
	//고유의 것을 만들 수 도 있음.
	public void showDmb() {
		System.out.println("DMB를 실행합니다.");
	}
	//메소드 재 정의 해줘야 오류 사라짐.
	//실제로 사용 하던 안하던 bell에 대해 꼭 정의를 해야된다는 강제성을 띔.
	
	@Override
	public void bell() {
		System.out.println("벨이 울립니다.");
		System.out.println("뤼우링잉딩딩륑");
	}
}
