package com.yedam.java.ch1003;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withDraw(int money) throws BalanceInsufficientException {
		if(balance < money) {
			//새로운 예외를 발생시키고 싶을 때 throw를 붙이면 됨. 그럼 뒤는 실행시키지 않고 메소드를 호출한 곳으로 떠넘김.
			//트라이캐치 쓰지 않는 이유. 임의로 강제성띄워 일으키긴거기 때문에 문법적으로 틀리진 않았지만 논리적으로 메소드를 호출하는 곳에서 처리하도록 하기위해 throw로 내부에서 처리하도록 유도
			//원래 예외클래스가 발생하면 종료됨. 근데 드로우 쓰며는 예외 발생한 곳에서 강제 스탑시키고 메소드를 불러오는 곳에서 알아서 처리하도록 유도하는거임.
			//경우에 따라 일부러 발생시켜서 사용하기 때문에 알아둘 필요는 있음.
			throw new BalanceInsufficientException("잔고부족 : " + (money - balance) + "원 모자랍니다.");
		}
		balance -= money; //throw new처리하면 뒤에 처리를 해주지 않는 이상 실행 ㄴ
		
	}
}
