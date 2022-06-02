package com.yedam.java.example1;

/*
 GOLD 클래스
	- 고객 아이디, 이름, 등급
	- 보너스 포인트, 보너스 포인트 적립율, 할인율
	- 등급 : GOLD
	- 보너스 포인트 적립율 : 2%
	- 물건을 살 때 할인율 : 10%
*/
public class Gold extends Customer {
	double discountRatio;

	public Gold(int customerId, String customerName) {
		super(customerId, customerName);
		this.customerGrade = "GOLD";
		this.bonusRatio = 0.02;
		this.discountRatio = 0.1;

	}

	@Override
	// 1. 보너스 포인트 적림
	// 2. 할인율이 적용된 가격 반환
	public int calcPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		return (int) (price * (1 - this.discountRatio)); // 가격은 소수점을 나올 수 없으므로 int형을 강제 형변환
	}

	@Override
	public String showInfo() {

		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "로" + discountRatio
				+ "의 할인율이 적용 됩니다.";

	}

	public void setdiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	public double getdiscountRatio() {
		return discountRatio;
	}
}
