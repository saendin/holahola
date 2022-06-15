package com.yedam.java.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

//문자 변환 보조 스트림
public class CharterConvertExample {
	
	public static void main(String[] args) throws Exception{
		System.out.println("문장 입력> ");
		String data = new Scanner(System.in).nextLine();
		write(data); //보조스트림을 사용해 출력해 파일에 저장한 것(스캐너로 받아올것)을 출력.
		
		read(); //출력받은 파일을 읽어옴 (System.out.println(data);//data출력 해줬으니까 Sysout됨)
	}

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("D:/dev/temp/text1.txt"); //파일 출력 스트림 만들기
		
		//바이트 기반 파일 출력 스트림 FileOutputStream과 문자 기반 출력 보조스트림 OutputStreamWriter을 매개변수 os로 연결
		Writer writer = new OutputStreamWriter(os); 
		
		writer.write(str); //String을 매개변수로 가지는 write를 쓰려고 Writer writer = new OutputStreamWriter(os) 쓴 것. os.write(os)를 바로 쓸 순 없음.
		writer.flush();
		writer.close();
		
		
	}
	
//읽어들이기
	public static String read() throws Exception {
		InputStream is = new FileInputStream("D:/dev/temp/text1.txt");
		
		//FileInputStream에 보조스트림 InputStreamReader(is)를 매개변수 is로 연결
		Reader reader = new InputStreamReader(is); //경로를 설정해줘야함. 직접적으로 데이터를 주고받을 수 없음. is.read(is) 불가.
		
		//buffer에 공간주기[100]개
		char[] buffer = new char[100];
		
		int readCharNum = reader.read(buffer); //InputStreamReader보조스트림을 이용해서 문자 입력
		reader.close();
		
		String data = new String(buffer, 0, readCharNum);//char에 있는 것을 문자열로 바꾸기 (버퍼에 있는 값을 인덱스 0부터 readCharNum값만큼 data에 넣어라.
		System.out.println(data);//data출력
		return data;
		
		
	}

}
