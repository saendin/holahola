package com.yedam.java.home;
//무엇을 호출해 줄지에 대해 결정하는
public interface BookProgram {

	//메뉴 출력
	public void menuPrint();
	//정보 입력
	public void inputInfo(BookAccess access);
	//입력된 전체 정보 출력
	public void printAllInfo(BookAccess access);
	//특정 조건의 정보를 출력
	public void printInfo(BookAccess access);
	//분석
	public void printReport(BookAccess access);
	
	
}

