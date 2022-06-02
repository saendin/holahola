package com.yedam.java.ch1003;

public class BalanceInsufficientException extends Exception {
	
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message); //어떤 값이 들어가서 넘버포맷 메세지가 나왔는지.. 에 대한 메세지라 함
	}
	
}
