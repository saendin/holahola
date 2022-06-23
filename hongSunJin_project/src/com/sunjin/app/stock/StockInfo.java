package com.sunjin.app.stock;

import java.sql.Date;
import lombok.*;

@Getter
@Setter
public class StockInfo {

	//재고정보
	private Date stockDate;
	private int isn;
	private String productName;
	private int stock;
	
	
	@Override
	public String toString() {
		String result = "거래일 " + stockDate + "| 상품번호 " + isn;
		
		//필요에 따라 추가하거나 뺄 수 있도록
		if(productName != null) {
			result += "| 상품명 " + productName;
		}
		result +="| 수량 " + stock;
		
		return result;
	}
	
	
	
}
