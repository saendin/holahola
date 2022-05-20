package chap01;

/*
 * 변수의 타입(유형) : 
 * 				변수는 -> 메모리의 저장위치. 값을 저장하는 공간
 *				유형은 -> 메모리에 값을 저장하는 형식(구조와 크기가 다름)
 *
 *
 * 				 1		2		4	  		8
 * 숫자 	정수		byte < short <	 *int	 < 	long	<	BicDecimal
 * 				127		3만2천	21억			10^18
 * 				7			15
 * 		실수		float < *double		유효자리수 정밀도 차이임	ex) 0.0000012 -> 0,12*10^-5
 * 
 * 		 
 * 문자	한글자	char	<= 'a' '가'
 * 		단어		string	<= "홍길동"
 * 
 * 불린형		boolean		<- true , false
 * 날짜
 */
public class 변수 {

	public static void main(String[] args) {
		int korSore = 128;		// 상수값의 기본형은 int
		long rich =2000000000l; // 상수값 long을 사용하려면 접미어 L 또는 l 사용
		float avg = 0.123456789F; // float형 변수 avg를 선언하고 상수값 x를 변수에 저장
		double totalAvg = 0.1234567891234568742;
		int int2 = 0b1111111; // 2진수로 표현한 int형 값
		int int8 = 077; // 8진수로 표현한 int형 값
		int int16 = 0x7F; // 16진수로 표현한 int형 값
		
		System.out.println("int2= \n \\" + int2 + "\\");
		System.out.println("int8= \"" + int8 + "\"");
		System.out.println("int16= " + int16);

		
		
		int k = 60, e = 60, m = 60;
		boolean passYn = true;
		boolean fail = k>50 && e>50 && m>50;
		
		System.out.println("fail = " + fail);
				
		int engScore=98; //변수선언, 초기화
		int mathScore; //변수선언
		mathScore=100; //초기화
		
		System.out.println(avg);
		System.out.println(totalAvg);
		System.out.println(engScore);

	
		char grade = '가'; //67; //'A'; //문자는 작은 따옴표
		String grade2 =	"A+"; //문자열은 큰 따옴표로 표현
	
		System.out.println("grade = " + (int)grade);
	
	
	char code = 44033;
	System.out.println("code = " + code);
	}

}
