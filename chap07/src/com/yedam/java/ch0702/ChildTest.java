package com.yedam.java.ch0702;

public class ChildTest {

	public static void main(String[] args) {
		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();
		
		//타입변환
		GranPa pa = father;
		pa.method();
		pa = uncle;
		pa.method();
		pa = child;
		pa.method();
		pa = cousin;
		pa.method();
		pa = father;
		
		//타입변환X
		//*타입변환은 반드시 관계가 있는 것 사이에서만 가능하다~!
		
		Father fa = child;	//uncle은 X. father은 uncle을 담아줄 수 없음. child는 가능.
		//fa = child;
		//fa = cousin;
		fa.method();	//fa가 가지고 있는 method는 child. 즉, child의 메소드를 실행.
		
		Child ch = (Child)fa; //child가 father에 있는거 가져오고 싶으면 강제로 ()씌워줘서 가능하긴 함.
		//Cousin co = (Cousin)fa; //그치만 전혀 관련없는 사촌은 아빠의것을 가져올 수 없지 ㅋㅋ
		System.out.println();
		Uncle un = cousin;	//uncle이 받아줄 수 있는건 오직 cousin뿐ㅋㅋ father이나 child는 안됨. 강제 타입변환도 안됨. ㅠ
		//un = father;
		//un = child;
		un.method();
		
		
		//다형성. 클래스가 사용되는 모든 곳에서 가능.
		
		
		
		
	}

}
