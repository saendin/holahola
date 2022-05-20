package task;

import java.util.Scanner;

public class 삼각형면적 {

	
	public static void main(String[] args) {
		
	
		double w, h, area; // area를 double 값으로 변수 선언
	
		
		
		Scanner scan = new Scanner(System.in); // 직접 값 입력받아 값 도출
	
		System.out.println("밑변:");
		w = Double.parseDouble( scan.nextLine() ); // w 값을 입력 받아서 밑변 값 도출
		
		System.out.println("높이:");
		h = Double.parseDouble( scan.nextLine() ); // h 값을 입력 받아서 높이 값 도출
		
	
		area = 0.5 * w * h;
		System.out.printf("면적:%.2f", area); // 삼각형 면적을 계산해서 소수점 2번째 자리 까지 나타내기
		
	}

}
