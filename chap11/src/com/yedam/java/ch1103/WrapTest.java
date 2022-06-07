package com.yedam.java.ch1103;

public class WrapTest {

	public static void main(String[] args) {
		//박싱 Integer.valueOf
		Integer obj1 = new Integer(100); // 코드는 살아있지만 사용하지 말라고 자바에서 그어버림. (+대체 할 수 있는 기능 추가 되어 있단 의미)
		Integer obj2 = Integer.valueOf("100"); //Integer.valueOf 써주기(조금 다른점이 있다면 인티저 벨류오브는 wrapper class를 만드는 것). 그래도 Integer.parseInt랑 비섯비섯
		Integer obj3 = 100;
		//언박싱 intValue
		int val2 = obj2.intValue(); //int타입의 값을 끄집어내는 메소드.(공식적 언박싱 방식임.)
		int val3 = obj3; //obj3가 공식적으로는 클래스지만 인트타입의 val3로 언박싱 헤주는거임.
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);

		int result = obj2 + val3; //자동으로 인트타입으로 맞춰줌.
		
		System.out.println(result);
		
		
		System.out.println();
		
		
		Integer object1 = 300;
		Integer object2 = 300;
		
		
		System.out.println(object1);
		System.out.println(object2);		
		
		System.out.println("== 결과 : " + (object1 == object2));
		//언박싱 후에 비교해야지 정상적으로 내부 비교가 됨.
		System.out.println("언박싱 후 == 결과 : " + (object1.intValue() == object2.intValue()));
	}

}
