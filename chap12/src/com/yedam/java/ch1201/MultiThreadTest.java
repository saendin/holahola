package com.yedam.java.ch1201;

public class MultiThreadTest {
	//방법은 런어블을 구현하는 형식과 Thread를 상속받는 형식 두개가 있음.
	public static void main(String[] args) {
		//Thread클래스를 따로 만들어 사용하는게 아니고 아니고 자바에 보낼 있는 것.
		//main이라는 변수명을 주고 Thread.currentThread()있는 위치에서 사용되고 있는 스레드의 내용을 가지고 옴(=main)
		Thread main = Thread.currentThread();	//프로그램이 시작하는 스레드를 main 스레드라고 함. main method랑은 다름.
		System.out.println("메인 스레드 : " + main.getName());
		//실제로 작동은 여기서 함.
		//동시에 구현하고 싶다면 런어블 인터페이스를 구현해서 run안에 집어넣으면 됨.
//		Runnable a = new ThreadA();
//		//실제로 동작하는건 Thread임.
//		Thread thread = new Thread(a);	
		ThreadB thread = new ThreadB();
		thread.setName("threadA"); 		//임의로 스레드의 이름을 바꾸고 싶을 때 setName을 사용하면 됨.
		System.out.println("작업 스레드 : " + thread.getName());
		thread.start();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
