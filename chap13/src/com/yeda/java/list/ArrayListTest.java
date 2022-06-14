package com.yeda.java.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<> ();
		
		//인덱스에 값 추가
		list.add("안녕");		//0
		list.add("헬로");		//1
		list.add("오하이요");	//3
		list.add(2,"따쟈하오");//2	//인덱스 주소 2번에 따쟈하오 넣어랑
		list.add("올라");		//4
	
		//객체 몇갠지 size조회 (000.size)
		int howMany = list.size();
		System.out.println("객체 몇 개? " + howMany);
		System.out.println("------------");
		
		//인덱스 2번값 조회
		String getTwo = list.get(2);
		System.out.println("2번째 INDEX 값 : " + getTwo);
		System.out.println("------------");

		//인덱스에 있는 전체 값 조회
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println("------------");
		
		list.remove(2); 	//따쟈하오 삭제
		list.remove(2);		//오하이오 삭제
		list.remove("올라");	//올라 삭제
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
	}
}
