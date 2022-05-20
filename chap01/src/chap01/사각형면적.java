package chap01;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {

		int w, h, area; //변수선언

		Scanner scan = new Scanner(System.in);

		
		System.out.println("가로입력:");
		w = Integer.parseInt(scan.nextLine()); // 가로값을 키보드로 입력받아서 W 변수에 저장

		
		System.out.println("가로입력");
		h = Integer.parseInt(scan.nextLine()); // 세로값을 키보드로 입력받아서 H 변수에 저장

		
		area = w * h; // 가로와 세로를 곱해서 면적 게산해서 area 변수에 저장
		System.out.println("면적=" + area); // 면적 출력
	}

}
