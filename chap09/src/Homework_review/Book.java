package Homework_review;

public class Book {
	// With teacher
	// 필드

	// 모든 인스턴스가 공유하는거 = static
	private static int serialNum = 1000;
	// 기본적으로 가지는 기호/ Book인스턴스에 독립적으로 가지는 인스턴스
	private int isbn;
	private String title;
	private int price;

	// 생성자

	public Book(String title, int price) {
		serialNum++; // 기준이 되는 시리얼 넘버를 하나씩 증가 시킴
		this.isbn = serialNum;
		this.title = title;
		this.price = price;
	}
	// 메소드

	// 게터세터 만들어주기.

	public static int getSerialNum() {
		return serialNum;
	}

	public int getIsbn() {
		return isbn;
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
		String info = "ISBN : " + this.isbn + ", 제목 : " + this.title + ", 가격 : " + this.price;
		System.out.println(info);
	}

}
