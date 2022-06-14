package com.yedam.java.ch02;

import java.io.FileReader;
import java.io.Reader;

//한 문자씩 읽기
public class ReadExample {

	public static void main(String[] args) throws Exception {
		// 문자타입 읽어오기 하려면 -> (char)타입으로 변환해줘야함
		Reader reader = new FileReader("D:/dev/temp/test7.db");

		while (true) {
			int data = reader.read(); // 한글자씩 읽을 때 reader의 read()메소드 이용해서 읽음. 그걸 data 참조변수에 저장.
			if (data == -1)
				break;
			System.out.println((char) data); // char타입으로 변환시켜야 내가 원하는 대로 볼 수 있음
		}

		reader.close();

		System.out.println("----------------------");

		// int값 읽어들이기
		reader = new FileReader("D:/dev/temp/temptest1.db");
		while (true) {
			int data = reader.read(); // 한글자씩 읽을 때 reader의 read()메소드 이용해서 읽음. 그걸 data 참조변수에 저장.
			if (data == -1)
				break;
			System.out.println(data); //
		}

		System.out.println("----------------------");

		// char타입 배열 읽어들이기
		reader = new FileReader("D:/dev/temp/test8.db");

		char[] buffer = new char[100];

		while (true) {
			int readCharNum = reader.read(buffer);
			if (readCharNum == -1)
				break;
			for (int i = 0; i < readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}

		reader.close();

		System.out.println("----------------------");

		reader = new FileReader("D:/dev/temp/test10.db");

		int readCharNum = reader.read(buffer, 5, 10); // buffer에 있는 5번 인덱스로부터 10개의 값을 가져와라
		for (int i = 0; i < (5 + readCharNum); i++) {
			System.out.print(buffer[i]);
			//ABCD ABCDE 여기서 나오는 공백은 3, 4번째의 값을 대신하는 것. 
		}
	}
}
