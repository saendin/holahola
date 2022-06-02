package com.yedam.java.ch0901;

import com.yedam.java.ch0901.Outter.Nested;

public class ZClassTest {

	public static void main(String[] args) {
		
		Outter outter = new Outter();
		
		Outter.Nested nested = outter.new Nested();
		nested.print();
		
	}

}
