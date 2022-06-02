package com.yedam.java.ch0901;

public class Button {
	
	OnClickListener listener;
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	//touch()와 OnClickListener은 무조건 연관성이 있다.
	
	void touch() {
		listener.onClick();
	}
	
	static interface OnClickListener{
		void onClick();
	}
}
