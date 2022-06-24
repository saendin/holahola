package com.sunjin.app.product;

import lombok.*;

@Getter
@Setter
public class Product {
//상품 필드
	private int isn;
	private String productName;
	private String brand;
	private int price;
	private int stock;
	private int category; // 1번 가방, 2번 의류, 3번 신발, 4번 Acc

	@Override
	public String toString() {
		String str = "";
		if(stock == 0) {
			str = "대여 중";
		} else {
			str = "남은 재고는 " + stock + "개 입니다.";
		}
		return "상품번호 " + isn + "| 종류" + category + "| 상품명 " + productName + "| 브랜드 " + brand + "| 가격" + price
				+ "| " + str; //재고 계산되어 리턴되는지 확인할 것
	}

}
