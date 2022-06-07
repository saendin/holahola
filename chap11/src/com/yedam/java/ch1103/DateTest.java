package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	//동일한 정보 출력
	public static void main(String[] args) {
		//현재의 시간과 정보 출력 Date
		Date now = new Date();
		System.out.println(now); //-> Tue Jun 07 11:31:56 KST 2022 출력
		
		//우리나라 식으로 바꾸기.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 mm월 dd일 hh시 mm분 ss초");
		String result = sdf.format(now);
		
		System.out.println(result);
		
	}
}
