package com.yedam.example2;

public class Card {
	//필드
	//카드를 만들기(정보 없이 그냥 카드번호만)
	//+카드 번호 1100번부터 시작되도록
	
	//정적필드
	//시리얼번호
	private static int serialNum = 1100;
	
	
	//카드를 만들기 위해 카드에 대한 정보를 생성
	//1. 카드번호
	private int cardNum;
	//2. 카드종류
	private String cardName;
	
	
	//생성자
	public Card(String cardName) {
		serialNum++;
		this.cardNum = serialNum;
		this.cardName = cardName;
		}
		
	//메소드
	//getter이용
	public static int getSerialNum() {
		return serialNum;
	}
	public String getCardName() {
		return cardName;
	}
	public int getCardNum() {
		return cardNum;
	}
}
	
