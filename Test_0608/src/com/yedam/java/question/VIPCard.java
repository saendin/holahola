package com.yedam.java.question;

//브앞은 이미 10퍼센트가 기본값이므로, 추가로 10%+3%가 되도록
public class VIPCard implements Payment {
	// 필드
	private String name;
	private String grade;
	private double saleRatio;
	private int point;
	private double pointRatio;

	// 생성자
	public VIPCard() {
		name = "VIPCard";
		grade = "GOLD";
		saleRatio = 0.1;
		point = 0;
		pointRatio = 0.03;

	};

	// 메소드
	// 전체 할인 받은 가격 = 100%-vip할인율-결제방식에 따른 할인율)* price
	public int offline(int price) {
		// 포인트값 = 입력받은 값에 포인트율 곱해준 정보가 point값에 저장 됨.
		point = (int) (price * pointRatio);
		price = (int) ((1 - this.saleRatio - OFFLINE_PAYMENT_RATIO) * price);
		return price;
	}

	public int online(int price) {
		point = (int) (price * pointRatio);
		price = (int) ((1 - this.saleRatio - ONLINE_PAYMENT_RATIO) * price);
		return price;
	}

	public int simple(int price) {
		point = (int) (price * pointRatio);
		price = (int) ((1 - this.saleRatio - SIMPLE_PAYMENT_RATIO) * price);
		return price;
	}

	public void showCardInfo() {
		System.out.println("====== 카드 정보 ======");
		System.out.println("카드명	: " + name);
		System.out.println("적용 등급	: " + grade);
		System.out.println("할인율	: " + saleRatio);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 : " + point);
	}
}
