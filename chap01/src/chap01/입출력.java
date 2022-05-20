package chap01;

import java.io.IOException;

public class 입출력 {

	public static void main(String[] args) throws IOException {
		String korName="국어";
		String engName="영어";
		int kor = System.in.read();
		int eng = System.in.read();
		double avg = (kor + eng) /2.0;
		System.out.println("국어는=" + kor + "\t영어는=" + eng);
		System.out.printf("%s는=%d\t%s는=%d", korName, kor, engName, eng);
	}

}
