package com.yedam.java.chap1601;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable rn = () -> {
			System.out.println("람다식 구현한다람쥐");
			for(int i=0; i<11; i++) {
				System.out.println(i);
			}
		}; Thread thread = new Thread(rn);
			thread.start();
			
			//같은고
			System.out.println();
			
			thread = new Thread(()-> {
				System.out.println("매개변수 -> 람다식다람쥐");
				for(int i=0; i<11; i++) {
					System.out.println(i);
				}
			}); thread.start();
	}

}
