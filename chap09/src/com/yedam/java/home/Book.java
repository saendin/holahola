package com.yedam.java.home;
//책 정보를 가져오는 북 클래스
public class Book {
	//필드
	private static int serialNum = 1000;
	
	private int bookIsbn;
	private String title;
	private int price;
	
	//생성자
	public Book() {}
	public Book(String title, int price) {
		serialNum++;	// 계속 누적된 시리얼 넘버 값으로 ISBN을 주겠다.
		this.bookIsbn = serialNum;
		this.title = title;
		this.price = price;
	}
	
	//메소드
	
	public static int getSerialNum() {
		return serialNum;
	}
	public int getBookIsbn() {
		return bookIsbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void showInfo() {
		System.out.println("ISBN : " + bookIsbn + ", 책 제목 : " + title + ", 가격 : " + price);
	}
}
