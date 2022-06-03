package com.yedam.java.ch1101;

import java.util.Date;

import javax.xml.crypto.Data;

public class ToStringTest {

	public static void main(String[] args) {
		//String타입으로 출력해주는 메소드
		Object obj1 = new Object();
		System.out.println(obj1.toString());
		
	//import할 때 util!. sql은 DB와 소통하기 위해 쓰는 것.
	Date date = new Date();
	System.out.println(date.toString());
	
	Member mem = new Member("홍선진");
	System.out.println(mem);
	
	}
	
	

}
