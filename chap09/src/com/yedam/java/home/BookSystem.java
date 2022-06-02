package com.yedam.java.home;



import java.util.Scanner;


public class BookSystem implements BookProgram {
	private Scanner sc = new Scanner(System.in);

	@Override
	public void menuPrint() {
		System.out.println("============================================");
		System.out.println("1.정보 입력 | 2.전체조회 | 3.검색 | 4.분석 | 5. 종료");
		System.out.println("============================================");
	}

	@Override
	public void inputInfo(BookAccess access) {
		// 저장소에 등록
		Book info = inputAll();
		access.insert(info);

	}

	private Book inputAll() {
		System.out.println("ISBN > " + Book.getSerialNum());
		System.out.println("책 제목 > ");
		String title = sc.nextLine();
		System.out.println("가격 > ");
		int price = Integer.parseInt(sc.nextLine());

		return new Book(title, price);
	}

	@Override
	// 저장소에 저장된 정보 모두 가져오기
	public void printAllInfo(BookAccess access) {
		// 저장소에서 데이터를 가져옴
		Book[] list = access.selectAll();
		// 데이터 전체 출력
		for (Book book : list) {
			book.showInfo();
		}
	}

	@Override
	public void printInfo(BookAccess access) {
		// 검색 조건 입력
		int id = inputIsbn();
		// 저장소에서 검색
		Book info = access.selectOne(id);
		// 출력
		info.showInfo();
	}

	private int inputIsbn() {
		System.out.println("검색 ISBN > ");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printReport(BookAccess access) {
		// 최고가
		System.out.println("최고가 > ");
		Book highInfo = selectHighPrice(access);
		highInfo.showInfo();
		// 최저가
		System.out.println("최저가 > ");
		Book lowInfo = selectLowPrice(access);
		lowInfo.showInfo();
		// 1,2 번을 제외한 책 정보 출력
		System.out.println("최고가와 최저가를 제외한 책 정보 > ");
		getPricePrint(access);
//		// 1,2 번을 제외한 평균점수
		System.out.print("가장 비싼 책과 가장 저렴한 책을 제외한 책들의 평균 가격 > ");
		int avgResult = Avg(access);
		System.out.println(avgResult);
		
	}

	// selectHighPrice 정의
	private Book selectHighPrice(BookAccess access) {
		Book[] list = access.selectAll();

		Book highInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (highInfo.getPrice() < list[i].getPrice()) {
				highInfo = list[i];
			}
		}
		return highInfo;
	}

	// selectLowPrice 정의
	private Book selectLowPrice(BookAccess access) {
		Book[] list = access.selectAll(); // Book 배열의 변수명 list는 access의 selectAll()과 같다.

		Book lowInfo = list[0]; // list값 0부터 시작
		for (int i = 1; i < list.length; i++) { // 점수 갯수만큼 반복
			if (lowInfo.getPrice() > list[i].getPrice()) { // list[i] 가격이 최저가보다 작으면
				lowInfo = list[i]; // 최저가 = list[i]
			}
		}
		return lowInfo; // 최저가 반환
	}

	// 최고 최저 가격을 제외한 책 정보 출력
	public void getPricePrint(BookAccess access) {
		Book[] list = access.selectAll();
		
		for (int i = 0; i < list.length; i++) {
			if ( selectLowPrice(access).getPrice() < list[i].getPrice()
					&& list[i].getPrice() < selectHighPrice(access).getPrice()) {
				list[i].showInfo();
			}
		}
			 }

	// 전체의 평균가격 구하기
	private int Avg(BookAccess access) {
		Book[] list = access.selectAll();
		int sum = 0;
		// for (Book info : list) {
		for (int i = 0; i < list.length; i++) {
			sum += list[i].getPrice(); // 총 합 for문
		}

		int avg = (sum - selectHighPrice(access).getPrice() - selectLowPrice(access).getPrice()) / (list.length - 2);
		return avg;
	}
}
