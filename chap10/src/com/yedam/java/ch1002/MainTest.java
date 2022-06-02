package com.yedam.java.ch1002;

public class MainTest {

	public static void main(String[] args) {
		try {
			// 원래 실행하고자 하는 코드
		} catch (Exception e) {
			// 예외가 발생했을 때 처리코드
		} finally {
			// 정상적으로 실행하든 예외가 발생했든
			// 반드시 실행되어야 하는 코드
		}

		String data1 = null;
		String data2 = null;

		// try로 묶은 부분만 처리. catch로 묶은 exception만 처리 가능.
		try {
			int value1 = Integer.parseInt(data1);
			data1 = args[0];
			data2 = args[1];
			//ArrayIndexOutOfBoundsException e와 NumberFormatException e는 동급이라 순서 상관 ㄴ
		} catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식에 맞춰 임력해주세요");
			return;
		} catch(Exception e) {
			System.out.println("기타");
			return; //리턴을 주면 맨 마지막에 있는 메소드는 실행이 안됨.
		} finally {	//항상 실행이라 원래는 숫자 형식 웅앵에서 끝나는데, finally덕에 밑에것도 실행되눈고임. 자원 정리에 많이 씀
			System.out.println("필수 구문");
		}
		System.out.println("메인 메소드 종료");
		
		//findClass(); //예외처리 안나서 오류남
		
	}

public static void findClass() throws ClassNotFoundException, NullPointerException{	//자바가 계속 처리하라고 요구하니까 보류하지 않고 지금 처리해서 떠넘기는 상태
	//Class가 가지는 것은 그냥 String클래스 자체에 대한 정보를 가짐.
	Class clazz = Class.forName("java.lang.String"); //class의 메타정보를 가지는 아이
	//해결방법 1. 트라이캐치 구문 사용
	//해결방법 2. 예외 떠넘기기 = throws ClassNotFoundException
}

}
