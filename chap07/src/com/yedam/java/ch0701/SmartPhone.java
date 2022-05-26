package com.yedam.java.ch0701;
//상속은 가능한데 내부의 메소드들은 상속할 수 없는 애들임... 뭐래..
//
public class SmartPhone extends Phone {

	
	public SmartPhone(String model, String color) {
		super(model, color);
		
	}
	//둘 다 메소드 호출 불가능. private 자식x/ final 자식, 외부 됨.
	
	@Override
	public void bell() { //or protected  더 넓은 범위로 잡아줘야 
		// TODO Auto-generated method stub
		super.bell();
		System.out.println("벨 소리 : 싸이 - that that!");
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		super.call();
		System.out.println("안내 문구 : 전화는 용건만 간단히");
	}
	
	private void print() {
		System.out.println("테스트");
		
	}
	
}
