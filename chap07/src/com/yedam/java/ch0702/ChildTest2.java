package com.yedam.java.ch0702;

public class ChildTest2 {

	public static void main(String[] args) {
		GranPa pa = new Father();
		pa.method();
		pa = new Uncle(); 	//casting실패 오류 뜸.
		
		System.out.println();
		
		if(pa instanceof Father) {
		Father fa = (Father) pa;
		fa.method();
		fa.method2();
		} else {
			System.out.println("pa 변수가 가지고 있는 인스턴스는 Father가 아닙니다.");
		}
		
				//파더가 가지는 고유의 메소드를 원할 때 강제형변환 시켜주기 ( 변수는 하나지만 결과 출력은 동일 )
				//메소드를 오버라이딩 했을 때는 부모와 자식 중 자식 인스턴스가 가진 것만 실행된다.
				//자식이 먼저 있으니 자식이 처리하게 됨.
				
				
				//타입 변환이 일어나도 인스턴스엔 어떤 손상도 없음. (값의 손상ㄴ)
				//연결하는 타입들에만 변화 있는 것임.
				
				//부모 자식 관계는 1:1이 아니라서 한개의 부모에 여러개의 자식을 만들 수 있는 것.
				//=부모가 가진 인스턴스가 아주 많음.
				//그래서 그 여러개의 인스턴스를 딱 뭐라고 보장을 하기가 어려움.
				//그래서 타입형변환을 통해 확실하게 알려줘서 보장해주는 것임.
				
				//자바는 변수의 타입을 보고 요청하기 때문에. 이 타입을 실제로 실행할 수 있는지를 확실할 수 없기 때문에 강제형타입변환을 권장하진 않음.
				//그래서 굳이 사용하려면 실행할 수 있는지 확인부터 하라고 instanceof를 해주는 것.
				//ex)타입이 첫째면 자바는 그 타입을 보고 첫째가 할 수 있는 것들을 요청하게 됨.
				//	but 둘째는 첫째가 잘 하는 것을 할 수 있을지 알 수 없음.
				
	}

}
