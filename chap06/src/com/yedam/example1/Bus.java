package com.yedam.example1;

public class Bus {

	//팔두
		//버스에 필요한 정보 (지하철이 많으니 숫자대신 이름으로 ->String)
		private String busType;
		//요금이 얼마인지
		private int money;
		//승객이 몇 명이나 탔는지 확인
		private int passengerCount;
		private int pay;
	
	public Bus(String busType, int pay) {  //서브웨이에서 이것만 바꿈
		this.busType = busType;
		this.pay = pay;
		}
		
		//메서드
		//승객에게 탑승에 필요한 요금을 알려줘야함
		public int getPay() {
				return pay;
		}
		
		
		public void take(int money) {
			//승객이 타면 승객수 ++
			//가진 돈에 받은 요금 누적시키기
			this.money += money;
			this.passengerCount++;
		}
		
		public void showInfo() {
			System.out.printf("%s 의 승객은 %d 명이고, 수입은 %d 원 입니다.", busType, passengerCount, money);
		}
		
		
		
}

