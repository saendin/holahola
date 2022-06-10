package com.yedam.java.chap1601;

public class RamdaTest {

	public static void main(String[] args) {
		MyFunInterfaceA fa = () -> {
		String str = "give me a call";
		String str2 = "baby babe";
		String str3 = "지금바로 전화줘";
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);
		};
		fa.method();
		//*실행코드가 한줄만 있을 때는 {}없이 sysout바로 적어줘서 출력.
		//fa = () -> System.out.println("블라블라");
		//fa.method();

		System.out.println();

		//매개변수가 있고 리턴타입이 없는 람다식
		MyFunInterfaceB fb = (int x) -> {
			int result = x * 99;
			System.out.println(result);
		}; fb.method(10);
		 //()안에 원하는 매개변수값을 적으면 내가 정해둔 식에 적용됨.
		
		//------------------------------------
		//앞에 람다식 언어를 선언한 인터페이스에 method 메소드의 매개변수 값에 int타입의 x를 미리 선언해 뒀으므로 람다식으로 가져와서 쓸 때는 그냥 타입 없이 매개변수명만 써주면 됨.
		fb = (x) -> {
			System.out.println(x * 10);
		}; fb.method(9);

		//-------------------------------------
		//매개변수의 ()와 실행값의 {} 둘 다 사용 않고도 사용 가능.
		fb = x -> System.out.println(x * 100);
		fb.method(8);
		
		System.out.println();

		
		
		
		//매개변수도 있고 리턴값도 있는 형식
		MyFunInterfaceC fc =  (int x, int y) -> {
			int result = x + y;
			System.out.println(result);
			return result;
		}; fc.method(99,10);
		
		
		//이렇게도 가능1
		fc = (x, y) -> { return x + y ; };
		System.out.println(fc.method(2, 20));
		//이렇게도 가능2
		fc = (x, y) -> x + y;
		System.out.println(fc.method(30, 22));
		//이렇게도 가능3
		//x,y 중에 맥스값 리턴해라
		fc = (x, y) -> Math.max(x, y);
		fc = (x, y) -> {
			//int result = Math.max(x, y);  //원래
			//return result;				//이렇게 적어야하는건데
			return Math.max(x, y);			//요렇게 간단하게도 가능.
		}; fc = (x, y) -> Math.max(x, y);
			System.out.println(fc.method(11, 100));
			
		//익명 객체 구현할 때 00성을 가진다. ???
		//익명 객체 구현할 때 외부 변수를 가질 수 있음. 외부변수는 final 속성 가짐. (값만 가져오는거임.)
		//https://cornswrold.tistory.com/237
		int val1 = 10;
		int val2 = 20;
		
		fa = () -> {
			//val과 val2의 값을 더한다고 생각하는것이지 val1값과 val2값을 가져와서 그대로 쓴다고 생각하는게 아님.
			//그래서 내부에 부여된 값 외의 다른 값이 주어지면 오류 발생.
			int result = val1 + val2;
			System.out.println(result);
		};	//int val1 = 100; -> 그래서 이 코드 넣으면 오류 발생
			fa.method();
		}
}
