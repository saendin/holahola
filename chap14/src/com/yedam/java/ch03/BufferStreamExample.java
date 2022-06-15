package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//내보내기와 읽어들이기의 속도향상을 위한 보조스트림 버퍼스트림. 사용/ 미사용의 속도 차 알아보기
public class BufferStreamExample {

	// Buffer 스트림 사용하지 않았을 때
	public static void main(String[] args) throws Exception {

		// 내가 복사하고자 하는 파일의 주소 가져오기
		String originalFilePath1 = BufferStreamExample.class.getResource("originalFile1.jpg").getPath(); // BufferStreamExample.class->
																											// 이 class의 class정보를 담고있는 모든 정보 발생.
																											// getResource("originalFile.jpg")-> 에서 ()이름을 가지는 소스를 가져오기
																											// .getPath() -> 실제로 존재하는 확장자의 위치 가져오기
		String targetFilePath1 = "D:/dev/temp/targetFile1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(originalFilePath1);

		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을 때 : " + nonBufferTime + "ns");

		fis1.close();
		fos1.close();

		// Buffer 스트림 있는 경우

		// 내가 복사하고자 하는 파일의 주소 가져오기
		String originalFilePath2 = BufferStreamExample.class.getResource("originalFile2.jpg").getPath(); // BufferStreamExample.class->
																										 // 이 class의 class정보를 담고있는 모든 정보 발생.
																										 // getResource("originalFile.jpg")-> 에서 ()이름을 가지는 소스를 가져오기
																										 // .getPath() -> 실제로 존재하는 확장자의 위치 가져오기
		// getResource("originalFile.jpg")-> 에서 ()이름을 가지는 소스를 가져오기
		// .getPath() -> 실제로 존재하는 확장자의 위치 가져오기
		String targetFilePath2 = "D:/dev/temp/targetFile2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(originalFilePath2);

		BufferedInputStream bis = new BufferedInputStream(fis2); //인풋 스트림 통해서 정보 가져오는게 아니라 버퍼 스트림을 통해서 가져올고임이라고 선언
		BufferedOutputStream bos = new BufferedOutputStream(fos2); //아웃풋 스트림 통해서 정보 가져오는게 아니라 버퍼 스트림을 통해서 가져올고임
		long bufferTime = copy(fis2, fos2);
		System.out.println("버퍼를 사용했을 때 : " + bufferTime + "ns");

		fis2.close();
		fos2.close();

	}

	// 읽어들여서 바로 복사해보기
	static int data = -1;

	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		while (true) {
			data = is.read(); // OutputStream를 통해서 읽어들이고
			if (data == -1)
				break;
			os.write(data); // 끝이 아니면 출력
		}
		long end = System.nanoTime();

		return (end - start);

	}
}
