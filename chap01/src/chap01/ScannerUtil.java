package chap01;

import java.util.Scanner;

public class ScannerUtil {

	public static void main(String[] args) {
		
		String name, job;
		int age;
	
		
		//문자열 입력
		Scanner scan = new Scanner(System.in);
		
		//프롬프트 출력
		System.out.print("이름입력:");
		//문자열 입력받아서 변수에 저장
		name = scan.nextLine();  //엔터키 이전까지 입력
		
		System.out.print("직업입력:");
		//문자열 입력받아서 변수에 저장
		job = scan.nextLine();
		
		System.out.print("나이입력:");
		//입력받은 문자열을 출력
		age = Integer.parseInt(scan.nextLine() );
		
		
		
		
		System.out.printf("이름 %s 직업 %s 나이 %d", name, job, age);
		
		
		//문자열 입력
		String str = scan.nextLine();
		//입력받은 문자열을 출력
		System.out.println(str);
	}
}
