package com.yedam.java.ch0901;
//버튼 내부에 있는 interface를 구현하도록 정의
public class CallListener implements Button.OnClickListener {
	//버튼이 동작할때 전화를 걸도록 동작
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}
	
}
