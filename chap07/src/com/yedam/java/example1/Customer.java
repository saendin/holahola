package com.yedam.java.example1;
/*
Customer 클래스
	- 고객 아이디, 이름, 고객등급
	- 보너스포인트, 보너스포인트 적립율
 	- 등급 : SILVER(최초등급)
 	- 보너스 포인트 적립율 : 1%
*/
public class Customer {
	// 필드
	int customerId;
	String customerName;
	String customerGrade;
	int bonusPoint;
	double bonusRatio;// 적립비율은 %이므로 double로 보통 많이 씀.

	// 생성자
	// 고객에게 받아야 하는 정보
	public Customer(int customerId, String customerName) { // ()에는 고객에게 받아야할 정보 입력.
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}

	
	
	// 메소드
	// 서비스를 결정하는 기준은 보통 가격.
	//등급과 보너스 포인트율 계산하는것
	public int calcPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		return price; // 반환하는건 가격.
	}
	
	//정보 출력 스트링
	public String showInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
		
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String setCustomerName(String customerName) {
		return customerName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setBousPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	} 
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}

}
