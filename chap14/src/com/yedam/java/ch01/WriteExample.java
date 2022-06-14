package com.yedam.java.ch01;


import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("D:/dev/temp/tempTest1.db");
		
		//바이트 값 넣기
		byte a = 10;
		byte b = 20;
		byte c = 30;
		byte d = 40;
		byte e = 50;
		byte f = 60;
		byte g = 70;
		
		
		//각 한개의 바이트씩 출력
		os.write(a);
		os.write(b);
		os.write(c);
		os.write(d);
		os.write(e);
		os.write(f);
		os.write(g);
		
		//출력 버퍼에 잔류하는 모든 바이트를 출력
		os.flush();
		
		//출력 스트림을 닫음.
		os.close();
		
		
		
		//배열타입으로 한번에 여러개의 바이트 보내기
		//기존의 것은 이미 os.close로 닫았기 때문에 새롭게 생성.
		os = new FileOutputStream("D:/dev/temp/tempTest2.db");
		
		
		byte[] array = { 10,20,30 };
		
		os.write(array);
		
		os.flush();
		os.close();
		
		
		//배열에서 원하는 값만 가져오기
		os = new FileOutputStream("D:/dev/temp/tempTest3.db");
		
		
		byte[] array2 = { 10,20,30,40,50 };
		
		os.write(array2, 3,2); //배열 array2 안에서 인덱스 3번째 부터 2개의 값을 가져오겠단 소리. => 값 40,50 내보내기
		
		os.flush();
		os.close();
		
	}

}
