package com.yedam.java.ch1101;

public class StringTest2 {

	public static void main(String[] args) {
		// toLowerCase & toUpperCase
		String str1 = "Java Programing";
		String str2 = "JAVA PROGRAMING";
		if (str1.equals(str2)) {
			System.out.println("str1 과 str2 는 같은 값입니다.");
		} else {
			System.out.println("str1 과 str2 는 다른 값입니다.");
		}
		
		
System.out.println();

		//둘 다 소문자로 만들어주니 같은 값으로 인식.
		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		if (val1.equals(val2)) {
			System.out.println("str1 과 str2 는 같은 값입니다.");
		} else {
			System.out.println("str1 과 str2 는 다른 값입니다.");
		}
		
		
System.out.println();

		//equalsIgnoreCase : 대소문자 구분없이 값 비교할 수 있음.
		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("str1 과 str2 는 같은 값입니다.");
		} else {
			System.out.println("str1 과 str2 는 다른 값입니다.");
		}

		
System.out.println();

		//"           자바       프로그래밍" 다음의 글자를 공백을 없앤 상태로 출력해 보시오.

		//trim : 앞의 공백을 없애줌
		String subject = "     자바       프로그래밍";
		String newData = subject.trim();
//		System.out.println(newData);
		//답안
//		String data1 = newData.substring(0,2);
//		String data2 = newData.substring(newData.indexOf("프로그래밍"));
//		String result = data1 + " " + data2;
//		System.out.println(newData);
//		System.out.println(result);
		//해보기
		String subject1 = newData.substring(0,2);
		String result = subject.substring(subject.indexOf("프로그래밍"));

		System.out.println(subject1 + " " + result);
	
		
		//ValueOf
		//값을 바꿀 수 있음.
		String value1 = String.valueOf(10);
		String value2 = String.valueOf(10.5);
		String value3 = String.valueOf(true);
		
		//정석
		//(코드상으로 깨끗하진 않지만 이렇게도 사용 가능)
		String value4 = "" + 100;
		
		
//		String ssn1 = "880815-1234567";
//		//매개변수가 두개일 때는 시작하는 인덱스부터 매개변수 두번째 숫자 바로 앞까지 끊음. 그래서 인덱스 너버는 0,1,2, ..부터 시작하지만 실질적으로 5까지만 읽는거임.
//		System.out.println("생년월일 : " + ssn1.substring(0, 6)); 
//		System.out.println("개별정보 : " + ssn1.substring(7)); //인덱스 주소 7부터 불러오기
//		
	}
}
