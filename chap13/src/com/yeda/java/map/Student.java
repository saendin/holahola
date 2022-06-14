package com.yeda.java.map;

import com.yeda.java.set.Member;

public class Student {
	public int stNum;
	public String name;
	
	public Student(int stNum, String name) {
		this.stNum = stNum;
		this.name = name;
	}
	//학번과 이름이 동일한 Student를 동등 키로 간주하기 위해 hashCode와 equals 사용
	//클래스와 동일 타입인지 확인하기 위한 hashCode = hashCode 동일한 메모리상에 존재함을 의미.
	//내가 위치한 메모리가 같다면 같다고 인식 함. ( 물리상의 위치가 같은지 )
	@Override
	public int hashCode() {
		return name.hashCode() + stNum; //같은 이름을 가진 값을 같은 객체로 인식하고 학번을 가져옴
	}
	//내부의 필드값이 같은지
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) { // 1. instanceof로 현재 클래스와 동일한 타입 가지는지 확인
			Student s = (Student)obj; // 2. 강제 타입 변환
			return name.equals(s.name)&&(stNum == s.stNum); //3. 각각의 필드 값 확인
															//-> 이름은 이름대로 같은지, 학번은 학번끼리 같은지 각각 트루값이 나오도록													
		}
			return false;
	}
	
	

}
