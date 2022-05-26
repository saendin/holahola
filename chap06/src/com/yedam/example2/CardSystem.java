package com.yedam.example2;

public class CardSystem {

	public static void main(String[] args) {
		Card kb = new Card("kb국민은행");
		Card nh = new Card("농협은행");
		
		System.out.println(Card.getSerialNum());
		System.out.println(kb.getCardName() + "의 카드번호 : " + kb.getCardNum());
		
		System.out.println();
		System.out.println(Card.getSerialNum());
		System.out.println(nh.getCardName() + "의 카드번호 : " + nh.getCardNum());
		

	}

}
