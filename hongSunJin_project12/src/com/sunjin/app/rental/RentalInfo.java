package com.sunjin.app.rental;
//import lombok.*;
//
//@Getter
//@Setter

import java.sql.Date;

//입력받은 품번이 존재하는 제품인지 확인
//존재하면-> 재고가 있는지 확인
//재고가 있으면->
//그 재고를 인트 변수에 담아주고


//품번
public class RentalInfo {
private String id;
private String Name;
private int isn;
private String brand;
private int period;
private Date rentalDate;
private Date returnDate;
private int amount;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getIsn() {
	return isn;
}
public void setIsn(int isn) {
	this.isn = isn;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}

public int getPeriod() {
	return period;
}
public void setPeriod(int period) {
	this.period = period;
}

public Date getRentalDate() {
	return rentalDate;
}
public void setRentalDate(Date rentalDate) {
	this.rentalDate = rentalDate;
}
public Date getReturnDate() {
	return returnDate;
}
public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
}


public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "대여자 [id] " + id 
			+ " [이름] " + Name 
			+ " No." + isn 
			+ "  | 브랜드 " + brand 
			+ "  | 대여기간 " + period
			+ "  | 대여일 " + rentalDate
			+ "  | 반납일 " + returnDate;
}
}
