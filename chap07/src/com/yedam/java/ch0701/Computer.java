package com.yedam.java.ch0701;
//클래스 만들 때 브라우저에서 calculator선택하면 자동으로 자식클래스로 들어감.
public class Computer extends Calculator {
	
	@Override //오버라이드라고 한번 더 자바에게 정의해줌. 그러면 자바가 재정의한 메소드를 꼼꼼하게 확인해줌(부모의 것과 확실하게 일치하는지)
	//@: 간결한 문구로서 ~는 ~다 라는 것을 정의. 약간 요약어 만드는 느낌.(=약어)
	//붙여도 안붙여도 상관 없움 ㅋㅋ 근데 관례적으로 붙임.
	//1. 자바에게 확실하게 체크하도록 엄포
	//2. 내가 오버라이딩인지 아닌지를 구분하기 위해소
	//3. 내 거친 생각과 불안한 눈빛과 그걸 지켜보는 너 그건 아마도 
	double areaCircle(double r) {
		System.out.println("부모 : " + super.areaCircle(r));
		//만들 때 얘는 절대로 건들면 안댐. 그래야 오버라이딩인지 판단 가능.
		System.out.println("Computer 객체");
		return Math.PI * r * r;

	}
	void print() {
		super.areaCircle(5);
		areaCircle(5);
	}
}
