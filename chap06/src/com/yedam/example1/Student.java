package com.yedam.example1;

public class Student {
	//대중교통을 타는 학생을 코드로 만들기
	//이름, 돈

	//필드
	private String name;
	private int money;
	
	
	//생성자
	//학생이 가지는 특징으로 생성자 만들기
	public Student(String name, int money) {
		this.name = name;	//for 식별
		this.money = money;	
	}
	
	//메서드
	//무엇을 탈 것인지 매개변수로 받기
	//이 학생이 지하철 몇호선을 탈건지 뭐 이런 정보 받아와야 되니까
	public void take(Subway subway) {
		int pay = subway.getPay();
		//내가 가진 돈에서 요금 빼기
		this.money -= pay;
		//지하철 탑승
		subway.take(pay);
	}
	
	public void take(Bus bus) {		//버스에서 이부분 추가해줌
		int pay = bus.getPay();
		//내가 가진 돈에서 요금 빼기
		this.money -= pay;
		//지하철 탑승
		bus.take(pay);

		
	}
	
	public void showInfo() {
		System.out.println(name + "님의 남은 돈은 " + money + "입니다.");
	}
}
