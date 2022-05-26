package com.yedam.java.ch0702;

public class Tire {
	//필드 ( 재료)
	public int maxRotation;				//타이어 수명 ex)최대 200번 회전 가능
	public int accumulatedRotation;	 	//누적 회전수
	public String location; 			//타이어의 위치
	
	//생성자 ( 초기값 = 기본 틀 설정 )
	public Tire(String location, int maxRotation) {
		this.location = location;		//this로 location상수 내려받기
		this.maxRotation = maxRotation;	//이상동문
	}
	
	//메소드 ( 여러번 돌려 먹을 값 미리 설정 )
	public boolean roll() {	//타이어가 굴러감.
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire 수명 : " + (maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("*** " + location + " Tire  펑크 ***");
			return false;
		}
	}
	
}
