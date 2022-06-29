package com.sunjin.app.product;
//import lombok.*;
//
//@Getter
//@Setter
public class Product {
//상품 필드
	private int isn;
	private String productName;
	private String brand;
	private int price;
	private int stock;
	private int category; // 1번 가방, 2번 의류, 3번 신발, 4번 Acc


	public int getIsn() {
		return isn;
	}


	public void setIsn(int isn) {
		this.isn = isn;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	@Override
	public String toString() {
		String str = "";
		if(stock == 0 || stock <0) {
			str = "대여가능한 수량이 없습니다!";
		} else {
			str = "남은 재고는 " + stock + "개 입니다.";
		}
		
		String num = "";
		if (category == 1) { 
			num = "가방";
		} else if (category == 2) {
			num = "의류";
		} else if (category == 3) {
			num = "신발";
		} else if (category == 4) {
			num = "Acc";
		}
		return "No." + isn
				+ " | " + num
				+ " | 브랜드 " + brand 
				+ " | 상품명 " + productName 
				+ " | 가격 " + price 
				+ " /4박 5일(수령 다음날부터 시작) "
				+ " | " + str + "\n"; //재고 계산되어 리턴되는지 확인할 것
	}

}
