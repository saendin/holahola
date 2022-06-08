package com.yedam.java.question;
//실적에 따라 등급을 나누고, 실버면 그린카드 골드면 븨앞카드 발급

//내가 오프라인 온라인 간편결제에 따라 할인율이 달라지게끔 구성.
/*
 * 오프라인일 때 1%
 * 온라인일 때 3%
 * 간편결제일 때 5%
 */
public interface Payment {

	// 각 결제방식별 할인율 상수로 지정.
	// 필드
	double OFFLINE_PAYMENT_RATIO = 0.01;
	double ONLINE_PAYMENT_RATIO = 0.03;
	double SIMPLE_PAYMENT_RATIO = 0.05;

	// 메소드
	// 오프라인일때 사용한 금액에 따른 할인율 계산
	public int offline(int price);

	// 온라인일때
	public int online(int price);

	// 간편결제일때
	public int simple(int price);

	// 카드정보 보여줘라
	public void showCardInfo();

}
