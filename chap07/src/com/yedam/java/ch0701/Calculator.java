package com.yedam.java.ch0701;
//상속
//부모 자식간에는 타입변환 가능
//자식이 부모타입으로 담기는건 상관 x
//자식은 부모에게 귀속되므로 자동 타입변환 가능.
//but 강제 타입변환은 웬만하면 잘 안하는편 ㅋㅋ
//부모타입에서 사용하는 타입은?
//동일한 메서드가 두개 있다면 



public class Calculator {
	double areaCircle(double r) {
		System.out.println("Calculator 객체");
		return 3.14159 * r * r;
		
	}
}
