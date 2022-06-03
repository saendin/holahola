package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {

	public static void main(String[] args) {

		// Hello Java 출력하기
		// byte -> String
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		// bytes에서 인덱스 위치 6에서 4자리만 가지고 오겠다. -> Java 출력
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);

		System.out.println();

		// byte배열로 통신하거나 저장
		// String -> byte -> String
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes();
		System.out.println(bytes1);

		String strs1 = new String(bytes1);
		System.out.println(strs1);

		System.out.println();

		// EUC-KR : 대중적으로 알려져있는 문자set. 근데 우리는 UTF-8 더 많이 사용.
		// 자바가 이미 EUC-KR을 안다고 생각하고 전개하기 때문에 예외가 발생함. -> 알지 못한걸로 발생했기 때문에
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println(bytes2);
			String strs2 = new String(bytes2, "EUC-KR");
			System.out.println(strs1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println();

		// charAt
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}

		System.out.println();

		// charAt에 있는 글자 글자를 하나하나 따로 출력.
		for (int i = 0; i < ssn.length(); i++) {
			System.out.println(ssn.charAt(i));
		}

		System.out.println();

		// string타입에선 equals써서 비교하기** ==쓰지말고!
		// equals (object클래스 오버라이딩해서 만든고)
		// String은 new연산자 없이 ""로 바로 값 넣기 가능.
		// new없어도 "구교욱"이라는 동일한 인스턴스가 없으면 생성해줌. or 기존에 같은값인 인스턴스가 있으면 그곳에 공유되는 형태
		// new가 있으면 늘 새로운 인스턴스를 생성함.
		// 즉, String은 같은 값이더라도 new연산자를 쓰면 완전 새로운 인스턴스로 인식해버림.
		String val1 = "구교욱";
		String val2 = "구교욱";
		String val3 = new String("구교욱");

		if (val1.equals(val2)) {
			System.out.println("val1과 val2는 값이 같습니다.");
		} else {
			System.out.println("val1과 val2는 값이 다릅니다.");
		}
		
		if (val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else {
			System.out.println("val1과 val3는 값이 다릅니다.");
		}
		
		System.out.println();
		
		if(val1 ==val2) {
			System.out.println("val1과 val2는 같은 인스턴스입니다.");
		}else {
			System.out.println("val1과 val2는 다른 인스턴스입니다.");
		}
		
		if(val1 ==val3) {
			System.out.println("val1과 val3는 같은 인스턴스입니다.");
		}else {
			System.out.println("val1과 val3는 다른 인스턴스입니다.");
		}
		
		//indexOf
		//문자열 찾기 (문장 안에서 내가 지정한 단어가 어디에 위치해있는지를 찾음)
		//근데 실질적으로 그 목적보다 내가 지정한 단어가 있는지 없는지 여부를 아는데 쓰임. -> 정확히 어디 위치에 있다.. 로는 안쓰임 ㅋ
		String subject = "자바 프로그래밍 & 스프링 정석";	//공백도 인식함.
		//프로그래밍이라는 단어가 시작하는 위치
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		}else {
			System.out.println("자바와 관련없는 책");
		}
		
		//substring
		
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
	
		String ssn1 = "880815-1234567";
		//매개변수가 두개일 때는 시작하는 인덱스부터 매개변수 두번째 숫자 바로 앞까지 끊음. 그래서 인덱스 너버는 0,1,2, ..부터 시작하지만 실질적으로 5까지만 읽는거임.
		System.out.println("생년월일 : " + ssn1.substring(0, 6)); 
		System.out.println("개별정보 : " + ssn1.substring(7)); //인덱스 주소 7부터 불러오기
		
		
		//length
		String[] temp = {"1, 2"};
		int val = temp.length;
		
		System.out.println(ssn1.length());
		
		System.out.println();
		
		
		//replace
		String oldStr = "Java 프로그래밍";
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr + " -> " + newStr);
		
	}
}
