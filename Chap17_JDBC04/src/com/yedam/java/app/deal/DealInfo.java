package com.yedam.java.app.deal;

import java.sql.Date;

//하나의 VO클래스로 같이 사용할고임.
public class DealInfo {

	//필드
	private Date dealDate; 
	private int productId;
	private String productName;
	private int productAmount;
	
	//값 가져다 쓸 수 있도록

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	@Override
	public String toString() {
		String result = "거래일자 : " + dealDate + ", 제품번호" + productId;
		
		if(productName != null) {	 //필요에 따라 추가하거나 빼기 위해 이렇게 구성해줌.
			result += ", 제품이름 : " + productName;
		}
		
		result += ", 수량 : " + productAmount; //네임값이 있을때만 수량 넣어줄거라서
		
		return result;
	}
}
