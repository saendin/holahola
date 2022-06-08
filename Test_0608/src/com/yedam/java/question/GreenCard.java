package com.yedam.java.question;

public class GreenCard implements Payment {
	// 필드
	private String name;
	private String grade;
	private int point;
	private double pointRatio;

	// 생성자
	public GreenCard() {
		name = "GreenCard";
		grade = "SILVER";
		point = 0;
		pointRatio = 0.05;

	}

	// 메소드
	@Override
	public int offline(int price) {
		price = (int) (price * pointRatio);
		price = (int) ((1 - OFFLINE_PAYMENT_RATIO) * price);
		return price;
	}

	@Override
	public int online(int price) {
		price = (int) (price * pointRatio);
		price = (int) ((1 - ONLINE_PAYMENT_RATIO) * price);
		return price;
	}

	@Override
	public int simple(int price) {
		price = (int) (price * pointRatio);
		price = (int) ((1 - SIMPLE_PAYMENT_RATIO) * price);
		return price;
	}

	@Override
	public void showCardInfo() {
		System.out.println("====== 카드 정보 ======");
		System.out.println("카드명	: " + name);
		System.out.println("적용 등급	: " + grade);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 : " + point);
	}

}
