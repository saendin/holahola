package com.yedam.java.ch02;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		//데이터 도착지를 text7로 하는 문자 기반 파일 출력 스트림 생성
		Writer writer = new FileWriter("D:/dev/temp/test7.db"); 
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(a); //한 문자씩 출력
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();
		
		
		
		//배열 전체를 출력하기
		Writer wrArray1 = new FileWriter("D:/dev/temp/test8.db"); 
		
		char[] array = { 'A', 'B', 'C', 'D' };
		
		wrArray1.write(array);
		
		wrArray1.flush();
		wrArray1.close();
		
		
		//배열 일부 출력하기
		Writer wrArray2 = new FileWriter("D:/dev/temp/test9.db"); 
		
		char[] array2 = { 'A', 'B', 'C', 'D', 'E' };
		
		wrArray2.write(array2, 3, 2); //array2배열의 3번 인덱스부터 2개 출력 -> D,E 출력됨.
		
		wrArray2.flush();
		wrArray2.close();
		
		
		//문자열 출력하기
		writer = new FileWriter("D:/dev/temp/test10.db"); 
		
		String str = "ABCDE\n"; // ->ABCDE로 출력
	
		String str2 = "abcde"; // ->de로 출력
		
		writer.write(str); //전체로 보내는 방식
		writer.write(str2, 3, 2); //잘라내서 일부만 보내는 방식
		
		writer.flush();
		writer.close();
		
		
	}

}
