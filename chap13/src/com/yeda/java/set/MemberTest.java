package com.yeda.java.set;

import java.util.HashSet;
import java.util.Set;
//Member객체를 중복 없이 저장하는 HashSet
public class MemberTest {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		//인스턴스가 다르지만 이름과 나이가 동일할 때 -> 각각 새로운 인스턴스로 정의해줬기 때문에 다른 값으로 인식. => 2개 나옴
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		System.out.println("set에 들어있는 총 객체 수 : " + set.size()); 
	}

}
//멤버에 아래의 코드를 추가해주면 인스턴스가 달라도 이름과 나이가 같다면 동일  객체로 간주하여 중복 값 저장하지 않음.
//hashCode() 와 equlas()메소드 재정의

//@Override
//public int hashCode() {
//	return name.hashCode() + age;
//}
//
//@Override
//public boolean equals(Object obj) {
//	if (obj instanceof Member) { // instanceof로 현재 클래스와 동일한 타입 가지는지 확인
//		Member m = (Member)obj;
//		return name.equals(m.name)&& (age == m.age); 
//	}
//		return false;