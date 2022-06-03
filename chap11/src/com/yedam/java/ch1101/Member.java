package com.yedam.java.ch1101;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// 논리적으로 동등한지

		// 1. 동일한 타입인지
		if (obj instanceof Member) {
			// 2. 내부 필드 값이 같은지
			// 비교하고 둘다 만족하면 트루 아니면 펄즈,, 밤 하늘의 퍼얼ㄴ
			Member member = (Member) obj;
			if (id.equals(member.id)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "id : " + id;
	}
	
	

}
