package com.yedam.app.history;

public class History {
	//필드 설정
	// 오라클은 boolean타입이 없으므로 특정한 값을통해서 구분함.
	// 다음과 같이 임의로 설정. 1:입고, 2:출고
	private int productId;
	private int productCategory;
	private int productAmount;
	
	//getter setter (toString 안함 - 클래스 정보만 따로 출력할 일이 없으므로)
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
	
	
}
