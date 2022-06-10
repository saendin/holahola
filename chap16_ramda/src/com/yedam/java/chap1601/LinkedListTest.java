package com.yedam.java.chap1601;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<> ();
		List<String> list2 = new LinkedList<> ();
		
		long start;
		long end;
		
		start = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("ArrayList가 0번 인덱스 값에 10000개의 객체를 추가하는데 걸린 속도 : " + (end - start) + "ns");
		
		System.out.println("---------------");
		
		start = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("LinkedList가 0번 인덱스 값에 10000개의 객체를 추가하는데 걸린 속도 : " + (end - start) + "ns");
	}

}
