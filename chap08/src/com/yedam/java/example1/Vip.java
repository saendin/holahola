package com.yedam.java.example1;
/*
VIP 클래스
	- 고객 아이디, 이름, 고객등급
 	- 등급 : VIP
 	- 보너스 포인트 적립율 : 5%
 	- 할인율 : 15%
 	- 담당 전문 상담원
*/

public class Vip extends Customer {
	double discountRatio;
	String countSeller;
	// String[] countSeller = new String[3];

	// 고객 기본 정보
	public Vip(int customerId, String customerName, String countSeller) {
		super(customerId, customerName); // customer것을 그대로 씀.
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.discountRatio = 0.15;
		this.countSeller = countSeller; // 카운트 셀러에서 이름 가져오기
	}

//	public Vip(int customerId, String customerName) {	//와타시가 한거
//		super(customerId, customerName);
//		this.customerGrade = "VIP";
//		this.bonusRatio = 0.05;
//		this.discountRatio = 0.15;
//		this.countSeller = "미미";
	
	@Override
	// 1. 보너스 포인트 적림
	// 2. 할인율이 적용된 가격 반환
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return (int) (price * (1 - discountRatio)); // 가격은 소수점을 나올 수 없으므로 int형을 강제 형변환
	}

	// 변수의 범위 : 필드와 동일한 메소드를 메소드에 정의하면 메소드의 변수가 가장 우선순위가 된다.
	// 즉, 필드와 동일한 이름의 메소드를 메소드 안에 하나 더 정의했는데 필드의 그것을 쓰고 싶다면, 앞에 this를 써줌으로써 필드의 것을
	// 가져올 수 있다.
	// 필드(어느 메소드에서나 공용을 사용하눈고)
	@Override
	// this는 필드에서 들고와서 여기서 쓸 수 있는거고
	// super은 부모것 그대로
	public String showInfo() {
		return super.showInfo() + "\n" + "고객님의 담당 상담원은 " + countSeller + "입니다.";
	}

	public void setdiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	public double getdiscountRatio() {
		return discountRatio;
	}

	public void countSeller(String countSeller) {
		this.countSeller = countSeller;
	}

	public String countSeller() {
		return countSeller;
	}

}
