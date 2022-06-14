package com.yeda.java.map;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		//아래 것으로 사용하면 Student의 오버라이딩 사용 안해도 됨. but임시 방편 느낌.
		
//		Student s = new Student(1, "포맨");
//		
//		map.put(s, 100);
//		map.put(s, 999);
		
		//새로운 객체 2개 생성. new Student(1, "포맨"), 100/ new Student(1, "포맨"), 80
		//해시코드가 두개 다 다름.
		map.put(new Student(1, "포맨"), 100);
		map.put(new Student(1, "포맨"), 999);

		System.out.println("총 Entry 수 : " + map.size());
		System.out.println("학번 : 1, 이름 : 포맨, 성적 : " + map.get(new Student(1, "포맨"))); // 또 다른 새로운 인스턴스 1개 더 생성.
		//->이걸 해시코드로 동일한 값을 가지고 있으면 같은 인스턴스로 인식하도록 훼이크 줌
		//내가 집어넣은 "포맨" 값 중 가장 마지막에 넣은 값이 반환 됨.
	}
}
