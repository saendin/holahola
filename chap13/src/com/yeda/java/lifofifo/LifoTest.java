package com.yeda.java.lifofifo;

import java.util.Stack;

public class LifoTest {

	public static void main(String[] args) {
		//가장 나중에 들어간게 가장 먼저 나오는 LIFO
		
		//Stack이라는 자체 클래스의 참조변수명 box라는 새로운 객체 생성.
		Stack<Integer> box = new Stack<>();
		//push해서 box라는 참조변수에 값을 넣음
		box.push(100);
		box.push(200);
		box.push(300);
		box.push(400);
		box.push(500);
		
		while(!box.isEmpty()) { //isEmpty()라는 while변수명을 사용. : 
			int value = box.pop();
//			System.out.println("꺼내온 값 : " + value);
			//->출력해보면 입력한 순서의 정 반대로 값 출력. 500~> 100
			//pop() = get() + remove() 정도의 개념으로 이해하면 됨. 빼내면 나에겐 이제 없는 값이 됨. -> 값 재사용 X
			
			//눈으로 확인해보기
			System.out.println("\t box 수: " + box.size()) ;
			System.out.println("꺼내온 값 : " + value);
		}
		
	}

}
