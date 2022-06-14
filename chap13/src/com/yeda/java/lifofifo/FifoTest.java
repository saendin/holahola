package com.yeda.java.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {

	public static void main(String[] args) {
		//들어간 순서대로 나오는 que FIFO
		Queue<Integer> que = new LinkedList<>();//LinkedList의 Queue타입만 사용하도록 제한
		
		que.offer(100);
		que.offer(200);
		que.offer(300);
		que.offer(400);
		que.offer(500);
		
		
		while(!que.isEmpty()) {
			int value = que.poll();
			
//			System.out.println("꺼내온 값 : " + value);
			//->출력해보면 입력한 순서의 정 반대로 값 출력. 100~> 500
			
			//눈으로 확인해보기
			System.out.println("\t box 수: " + que.size()) ;
			System.out.println("꺼내온 값 : " + value);
		}
	}

}
