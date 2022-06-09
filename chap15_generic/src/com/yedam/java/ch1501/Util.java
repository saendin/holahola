package com.yedam.java.ch1501;

public class Util {
	//내가 사용하고자 하는 제네릭타입 <T>. = 제네릭 타입 쓰겠다고 선언. 제네릭타입의 리턴 BoxA<T>
	public static <T> BoxA<T> boxing(T t) {
		BoxA<T> box = new BoxA<>();
		box.setT(t);
		return box;
	}
	// public static <K, V> 여기서 정의한 제네릭 타입 K와 V만 밑에서 지정해서 쓸 수 있음.
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		//논리적 비교는 equlas를 통해서 비교함.
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	public static <K, V> V printInfo(K key) {
		V v = null;
			return v;
		}
	}

