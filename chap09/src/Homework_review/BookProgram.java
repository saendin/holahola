package Homework_review;

import java.util.Scanner;

public class BookProgram implements Program {
	private Access dao = BookDAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	// 메뉴 출력
	@Override
	public void menuPrint() {
		System.out.println("============================================");
		System.out.println("1.정보 입력 | 2.전체조회 | 3.검색 | 4.분석 | 5. 종료");
		System.out.println("============================================");
	}

	// 리스트 출력
	@Override
	public void printAllInfo() {
		Book[] list = dao.selectAll(); // 여기서 listIndex가 아니라 list를 쓴 이유는
		for (Book data : list) { // ->향상된 for문. (*향상된 for문은 null값을 가질 수 없음.)
			data.showInfo();
		}
	}

	// isbn입력하면 showInfo출력
	@Override
	public void printInfo() {
		// isbn 정보 입력
		int keyword = inputOne();
		// DAO에서 검색
		Book data = dao.selectOne(keyword);
		// 출력
		data.showInfo();
	}

	// isbn 검색기능
	private int inputOne() {
		System.out.println("isbn > ");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void inputInfo() {
		Book data = inputAll();
		dao.insert(data);
	}

	private Book inputAll() {
		System.out.println("제목 > ");
		String title = sc.nextLine();
		System.out.println("가격 > ");
		int price = Integer.parseInt(sc.nextLine());

		return new Book(title, price);

	}

	@Override
	public void printReport() {
		// 가장 비싼 책
		Book maxInfo = selectMaxInfo();
		System.out.println("가장 가격이 비싼 책 > ");
		maxInfo.showInfo();

		// 가장 가격이 낮은 책
		Book minInfo = selectMinInfo();
		System.out.println("가장 가격이 낮은 책 > ");
		minInfo.showInfo();

		// 두 가지를 제외한 책들의 정보와 평균 가격
	}
	
	//최댓값
	private Book selectMaxInfo() {
		// 전체 조회
		Book[] list = dao.selectAll();

		// 검색
		Book maxInfo = list[0];
		for (Book data : list) {
			if (maxInfo.getPrice() < data.getPrice()) {
				maxInfo = data;
			}
		}
		// 반환
		return maxInfo;
	}

	//최솟값
	private Book selectMinInfo() {
		// 전체 조회
		Book[] list = dao.selectAll();

		// 검색
		Book minInfo = list[0];
		for (Book data : list) {
			if (minInfo.getPrice() > data.getPrice()) {
				minInfo = data;
			}
		}
		// 반환
		return minInfo;
	}

	//나머지 평균값 계산
	private void calcAvgInfo() {
		Book maxInfo = selectMaxInfo();
		Book minInfo = selectMinInfo();

		Book[] list = dao.selectAll();
		int sum = 0;
		for (Book data : list) {
			if (data.getPrice() > minInfo.getPrice() && data.getPrice() < maxInfo.getPrice()) {
				//조건에 만족하는 경우의 총합
				sum += data.getPrice();
				//조건에 만족하는 경우의 정보를 출력
				data.showInfo();
			}
		}
		double avg = (double)sum / (list.length -2);
		System.out.println("최고가와 최저가를 제외한 평균 > ");
		System.out.printf("%.2f\n", avg);
		
	
	}
}
