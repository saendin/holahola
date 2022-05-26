package com.yedam.example1;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student ("Hong", 5000);
		Subway green = new Subway("2호선", 1500);
		Student Jung = new Student ("Jung", 10000);
		Bus red = new Bus("급행", 1800);
		
		
		hong.take(green);
		//추가
		hong.take(red);
		hong.showInfo();
	
		System.out.println();
	
		
		Jung.take(red);
		Jung.showInfo();
		
		System.out.println();
		System.out.println("\n");
		
		
		green.showInfo();
		System.out.println();
		red.showInfo();
	}
}
