package com.sunjin.app.stock;

//import lombok.*;
//
//@Getter
//@Setter
import java.sql.Date;
public class StockInfo {

	//재고정보
	private int isn;
	private String brand;
	private String productName;
	private int amount;
	private Date stockDate;
	
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


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getStockDate() {
		return stockDate;
	}


	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	@Override
	public String toString() {
		String result = "거래일 " + stockDate + "| 상품번호 " + isn + "| 브랜드 " + brand;
		
		//필요에 따라 추가하거나 뺄 수 있도록
		if(productName != null) {
			result += "| 상품명 " + productName;
		}
		result +="| 수량 " + amount;
		
		return result;
	}
	
	
	
}
