package com.yedam.java.ch1501;

//<>안에 사용할 만큼의 제네릭타입 넣어주면 됨. (대문자 아무거나. like 임시)
public class Box<T, V, K> {
	// 원래 타입 선언해주는 위치에 써넣어주면 됨.
	T t;
	V v;
	K k;

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setV(V v) {
		this.v = v;
	}

	public V getV() {
		return v;
	}
	
	public void setK(K k) {
		this.k = k;
	}

	public K getK() {
		return k;
	}
}