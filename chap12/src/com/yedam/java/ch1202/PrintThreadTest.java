package com.yedam.java.ch1202;

import java.util.Scanner;

public class PrintThreadTest {

	public static void main(String[] args) {
		//new PrintThread().start();
		
		//스레드를 강제종료하고 싶지 않을 때
		Thread jobThread = new PrintThread();
		//jobThread를 실행. = 0 이외의 수 넣으면 jobThread.interrupt(); 실행
		jobThread.start();
		
		System.out.println("프로그램을 종료하시겠습니까?");
		//result값 입력받기
		int result = new Scanner(System.in).nextInt();
		//0이 아닌 값을 넣으면 종료되도록
		if(result > 0) {
			jobThread.interrupt();
		}
	}

}
