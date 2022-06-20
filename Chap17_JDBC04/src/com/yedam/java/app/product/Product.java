package com.yedam.java.app.product;

public class Product {
	//필드
	private int productId;
	private String productName;
	private int productPrice;
	private int productStock;
	
	//필드에 관한 정보만 받아올거라

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

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	@Override
	public String toString() {
		return "품번 : " + productId
				+ ", 제품명 : " + productName
				+ ", 가격 : " + productPrice
				+ ", 제품재고=" + productStock
				+ ", 현 재고기반 가치 : " + (productPrice * productStock);
	}

	
	
	
}
