package com.yeda.java.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
      List<Integer> list = new ArrayList<>();
      List<String> list2 = new Vector<>();
      ThreadA thA = new ThreadA();
      thA.setList(list);
      thA.start();
      
      ThreadA thB = new ThreadA();
      thB.setList(list);
      thB.start();
	}

//		List<Integer> list = new ArrayList<>();
//		List<String> list = new Vector<>();
//
//		ThreadA thA = new ThreadA();
//		thA.setList(list);
//		thA.start();
//
//		ThreadA thB = new ThreadA();
//		thB.setList(list);
//		thB.start();

//		// 인덱스에 값 추가
//		list2.add("안녕"); // 0
//		list2.add("헬로"); // 1
//		list2.add("오하이요"); // 3
//		list2.add(2, "따쟈하오");// 2 //인덱스 주소 2번에 따쟈하오 넣어랑
//		list2.add("올라"); // 4
//
//		// 객체 몇갠지 size조회 (000.size)
//		int howMany = list2.size();
//		System.out.println("객체 몇 개? " + howMany);
//		System.out.println("------------");
//
//		// 인덱스 2번값 조회
//		String getTwo = list2.get(2);
//		System.out.println("2번째 INDEX 값 : " + getTwo);
//		System.out.println("------------");
//
//		// 인덱스에 있는 전체 값 조회
//		for (int i = 0; i < list.size(); i++) {
//			String str = list2.get(i);
//			System.out.println(i + " : " + str);
//		}
//		System.out.println("------------");
//
//		list2.remove(2); // 따쟈하오 삭제
//		list2.remove(2); // 오하이오 삭제
//		list2.remove("올라"); // 올라 삭제
//
//		for (int i = 0; i < list.size(); i++) {
//			String str = list2.get(i);
//			System.out.println(i + " : " + str);
//		}
//	}
}
