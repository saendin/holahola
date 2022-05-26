package com.yedam.homework;

// 문제) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
// 1) 메뉴는 다음과 같이 구성하세요.
// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
// 3) 제품별 가격을 출력하세요.
//	출력예시, "상품명 : 가격"
// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
//+0523과제 + class개념
public class Product {	//상품에 대한 정보를 가지는 클래스 만들기(상품 관리 프로그램)
						//상품 = 객체 (Student 참고)
	//필드 설정
	//1. 이름, 2. 가격
	private String name;
	private int price;

	//생성자 만들기(갖다 쓸 수 있도록)
	//필드에 대한 값 초기화는 마음대로
	//프로덕트에 대한 것 하나(외부에서 쓸 수 있도록 new연산자로 새로운 인스턴스 생성 가능)
	public Product() {
	} 
	// 프로덕트의 이름과 가격에 대한것들 하나
	public Product(String name, int price) { 
		this.name = name;
		this.price = price;
	}
	
	//방법2. setter getter주기
	public void setName(String name) {	//set + this
		this.name = name;
	}
	public String getName() {	//get + return
		return name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}

	//메소드
	//방법3. getter나 setter안주고 정보 출력 메소드인 showInfo주면 바로 사용 가능
	public void showInfo() {
		System.out.println(name + " : " + price);
	}

}
