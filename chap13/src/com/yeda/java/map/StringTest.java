package com.yeda.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("신용재", 88);
		map.put("포맨", 99);
		map.put("안녕", 11);
		System.out.println("총 Entry(=객체=근데 이제 두개의 클래스를 가진) 수 : " + map.size());
		
		Integer returnVal = map.put("포맨", 188); //put을 넣으면 값은 무조건 대체되지만
		
		if(returnVal != null) { //리턴값을 사용해서 기존 값이 null이 아닐경우를 조회해 보면 원래 값을 알 수 있음.
			System.out.println("기존 값 : " + returnVal);
		}
		System.out.println("\t포맨 : " + map.get("포맨"));
		
		
		System.out.println();
	
	
		Set<String> keySet = map.keySet();//Set 중복되는 값 허용 X -> Set에서 Map 으로 옮겨갈 땐 Key 또는 Entry만 가능.
		
		Iterator<String> keyIterator = keySet.iterator();//KeySet에서 반복자 Interator가지고 옴
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		
		//향상된 for문도 사용 가능
		System.out.println();
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		
		
		System.out.println();
		
		
		map.remove("포맨"); //키 값 제거할 때는 식별할 수 있는 이름으로만 제거 가능.
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		for(Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
	}
}
