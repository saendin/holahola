package com.yedam.java.ch1003;

import com.yedam.java.ch1001.MainTest;

public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();

		account.deposit(100000);
		System.out.println("예금액 : " + account.getBalance());

		try {
			account.withDraw(3000000);
		} catch (BalanceInsufficientException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

}
