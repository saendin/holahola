package com.yeda.java.set;

//hashCode()와 equlas() 메소드 재정의
public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { // instanceof로 현재 클래스와 동일한 타입 가지는지 확인
			Member m = (Member)obj;
			return name.equals(m.name)&& (age == m.age); 
		}
			return false;
	}
}