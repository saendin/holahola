package com.yedam.java.ch0801;

public class Audio implements RemoteControl {
//클래스 생성시 interface에서 미리 정의하면 내가 구현하고자 하는 것들을 자동으로 표시해줌
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다. 또로롱");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다. 띠로링");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		} System.out.println("현재 오디오 볼륨 : " + this.volume);
	}

}
