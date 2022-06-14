package com.yeda.java.set;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// 각 다른 인스턴스지만 같은값을 가질 때, ==(등호 연산자)를 주어 비교하면 서로 다른 객체로 인식함.
		// 등호 연산자는 물리적 주소 비교.
		String data1 = "java";
		String data2 = new String("Java");
		
		if(data1 == data2) {
			System.out.println("서로 같은 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
		
		// Set에서 오버라이딩하면 서로 다른 인스턴스라도 같은 값이므로 중복으로 인식 -> set.size() 결과 1 도출.
		// HashCode와 equals라는 메소드를 이용해서 비교하면 단순 내부 값으로 비교하기 때문에(주소값은 읽지 않음) 같은 데이터로 인식 = 중복값처리해서 추가해주지 않음.
		Set<String> set = new HashSet<>();
		set.add(data1);
		set.add(data2);
		
		System.out.println("set안에 들어있는 총 객체 수 : " + set.size());
	}

}
