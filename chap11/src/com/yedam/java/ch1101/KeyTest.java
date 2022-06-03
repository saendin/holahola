package com.yedam.java.ch1101;

import java.util.HashMap;
import java.util.Map;

public class KeyTest {
	//HashCode는 메모리상 동일한 주소를 가지고 있는 인스턴스ㄹ
	//EQUALS 논리적으로 동등한지 물리적으로 동등한지
	public static void main(String[] args) {
		Map<Key, String> map = new HashMap<Key, String>(); //map : 기본적으로 (key와 value)를 묶어서 세트로 가지는 것.( 다양한 타입을 가질 수 있다. ) (일종의 배열이라 생각해도 됨)
	
		map.put(new Key(1), "홍길동");
		
		String value = map.get(new Key(1));
		System.out.println(value);
	}

}
