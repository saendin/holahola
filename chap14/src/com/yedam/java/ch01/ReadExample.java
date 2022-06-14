package com.yedam.java.ch01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ReadExample {

	// 입력스트림

	public static void main(String[] args) throws Exception {
		// "D:/dev/temp/temptest1.db"의 데이터 읽어오기
		InputStream is = new FileInputStream("D:/dev/temp/temptest1.db"); //temptest1.db의 데이터를 기반으로 하는 입력 스트림 생성

		while (true) {
			int data = is.read(); // data에 is.read()로 값을 하나씩(1byte) 읽기
			if (data == -1)
				break; // 근데 그 값이 -1이라 더 이상 읽을 값이 없다면(파일의 끝에 도달했다면) -> break하라
			System.out.println(data);
		}
		is.close();

		System.out.println("----------------------------------------");

		// 배열 데이터 읽어오기
		is = new FileInputStream("D:/dev/temp/temptest1.db");

		byte[] buffer = new byte[5]; // 길이값 100인 buffer이란 이름의 배열 생성

		while (true) {
			int readByteNum = is.read(buffer); // 배열 길이만큼 읽어오기
			if (readByteNum == -1) //파일의 끝에 도달했다면 -> 값이 -1이라 더 이상 읽을 값이 없다
				break; // 그러면 break하라
			for (int i = 0; i < readByteNum; i++) {	// 위에서 읽은 바이트 수 만큼 반복하면서(횟수 = i) -> [3]이면 3개씩 [4]면 4개씩
				System.out.println(buffer[i]); // 배열에 저장된 바이트 출력
			}
			System.out.println();
		}
		is.close(); // 입력 스트림 close
		
		
		//지정한 길이만큼 읽기
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		is = new FileInputStream("D:/dev/temp/temptest3.db");
		
	
		int readByteNum = is.read(buffer, 3, 2); //입력 스트림으로부터 buffer[3],[4]에 2개의 값 저장.
		
		for (int i = 0; i <3+readByteNum; i++) {	//들고 있는 값 i만큼 for문을 돌리겠다.
			System.out.println(buffer[i]); //앞에 if문 에서 읽어온 두개는 빼고 다시 읽어들이기 시작
		}
		
		is.close();
		
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		
		System.out.println("\n test3.db===");
		is = new FileInputStream("D:/dev/temp/temptest3.db");
		while(true) {
			int data = is.read(); // data에 is.read()로 값을 하나씩(1byte) 읽기
			if (data == -1)
				break; // 근데 그 값이 -1이라 더 이상 읽을 값이 없다면(파일의 끝에 도달했다면) -> break하라
			System.out.println(data);
		}
		
		is.close();
		
	}
}
