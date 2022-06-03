package com.yedam.java.ch1101;

public class Key {
	public int number;

	public Key(int number) {
		this.number = number;
	}
	//같은 타입에 필드값이 같으면 두개가 논리적으로 동등하다고 인식.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Key) {
			Key key = (Key) obj;
			if (number == key.number) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return number;
	}
	//
	@Override
	public String toString() {
		return "Key [number=" + number + "]";
	}
	
	

}
