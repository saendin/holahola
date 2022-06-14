package com.yeda.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<> ();
		
		//Set컬렉션) 값 추가
		set.add("훌랄라");
		set.add("집가고 싶네");
		set.add("금요일 못참겠네");
		set.add("적다보니 줄 맞춤같네");
		set.add("set은 순서없이 저장함");
		set.add("집가고 싶네");
//		set.add(new String("집가고 싶네"));
		set.add("따로 주소값이 없고.. 중복값 저장 안함");
		
		//set에 중복 값 포함해 add해준 값 몇개로 출력되나 보기
		System.out.println("set에 값 몇개 있나 함 보자 : " + set.size() + "개");	//총 7갠데 동일 값 한개 제외하고 6개 출력됨 ㅋㅋ
		
		System.out.println("------------------------------------");
		
		//Set 컬렉션 Iterator로 값 목록 조회 ( 중복 된 값 빼고 보여줌, 순서 무관 )
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println("------------------------------------");
		
		//Set 컬렉션) 값 지우기
		set.remove("적다보니 줄 맞춤같네");
		set.remove("금요일 못참겠네");
		
		//향상된 for문 이용해서 목록 값 출력( 순서 무관 )
		for(String data : set) {
			System.out.println("\t" + data);
		}
		
		System.out.println("------------------------------------");
		
		//Set컬렉션) clear 사용하여 모든 데이터 지우기
		set.clear();
		if(set.isEmpty()); {	//isEmpty는 논리값이므로 true false로 출력됨. 
			System.out.println("비어 있음");
		}
		
	}

}
