package com.yedam.java.example2;

public interface Program {
	//메뉴 출력
	public void menuPrint();
	//정보 입력
	public void inputInfo(Access access);
	//입력된 전체 정보 출력
	public void printAllInfo(Access access);
	//특정 조건의 정보를 출력
	public void printInfo(Access access);
	//분석
	public void printReport(Access access);
}
