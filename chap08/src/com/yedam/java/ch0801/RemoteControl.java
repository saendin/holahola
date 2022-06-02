package com.yedam.java.ch0801;
//인터페이스 - 사용방법 
//상수필드
//추상메소드
public interface RemoteControl {
	//약간 만능 리모컨 느낌
	
	//상수 필드
	//*기존의 필드 선언과 유사하나 상수이기 때문에 초기값 꼭 줘야함.
	public static final int MAX_VOLUME = 10; 
	public static final int MIN_VOLUME = 0; 	//static final을 적지 않아도 자바언어에서 컴파일시 자동을 생성해줌
	
	//추상 메소드
	public abstract void turnOn(); //추상 메소드 선언
	public void turnOff(); //abstract 빼도 ㄱㅊ ( 자바가 대신 채워줄거임 )
	public void setVolume(int volume); 
	

	
	//일반 메소드
	//interface임에도 일반 메소드를 추가할 수 있게 되었음.(자바 1.8이상)
	//원랜 안됨 ㅠ
	public default void show() {			//일반 메소드로 만들 때 *default라는 어거지 값 ㅋㅋ 붙여주면 사용 가능
		System.out.println("추가한 메소드");	//기존의 코드를 건들면 위험성이 커지므로 일종의 편법형태로 구성해 놓은 것. 크게 사용은 X
	}
	
	//정적 메소드
	
}
