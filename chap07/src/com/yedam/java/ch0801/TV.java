package com.yedam.java.ch0801;
//인터페이스 상속. 묶고, 추가로 필요한것 넣을 수도 있음.
public class TV implements Control { // 다중 인터페이스 구현은 그냥 원래있던 인터페이스에 추가하면 됨. 그리고 새로만든 컨트롤에 구현해주면 됨
//방법은 두개가 있으나, 재정립하는 것 선택해봄.
	private int volume; // volume에 대한 메소드를 가질 것임.
						// volume에 관한 정보를 들고 있어야 하는데, 보통 구현 상태에서 추가함.

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다. 또로롱");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다. 띠로링");
	}

	@Override
	public void setVolume(int volume) {
		// 현재 볼륨을 세팅
		System.out.println("볼륨을 설정합니다.");
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	
	
	@Override
	public void searchInternet(String url) {
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void executeApp(String app) {
		System.out.println(app + "을 실행합니다.");
	}

	@Override
	public void plusService() {
		// TODO Auto-generated method stub
		
	}
}
