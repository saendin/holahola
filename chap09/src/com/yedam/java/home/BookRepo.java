package com.yedam.java.home;
//실제 저장소 역할을 해줄 곳
public class BookRepo implements BookAccess {
	// 인스턴스가 두개면 싱글톤 만들어서 사용
	// 외부에서 나를 만들수 없게 막고 메서드로만 접근할 수 있게 만듦.
	
		private static BookRepo instance = new BookRepo();
		
		private BookRepo() {
			init();
		}
		
		// 내부에 있는것을 변환해주는 역할만 한다.
		// 외부에서 접근할 수 있는 방법은 클래스 명으로만 접근 가능.
		// 내 책을 사용할 수 있게 공유만 하게 할고
		public static BookRepo getInstance() {
			return instance;
		}
		
		// 실제 사용 필드 및 메소드
		private Book[] dataList; // 데이터 저장하기 위하 배열 ( 저장소는 원래 프로젝트에서 하나임 )
		private int listIndex;
		
		private void init() {
		// 리턴되는 타입도 없고, 매개변수도 없다.
		// 초기화 할 때 많이 사용.
		dataList = new Book[100];
		listIndex = -1;
		}
		
	@Override
	public void insert(Book book) {
		dataList[++listIndex] = book;
	}

	@Override
	public void update(Book book) {
		for (int i=0; i <= listIndex; i++) {
			if (dataList[i].getBookIsbn() == book.getBookIsbn()) {
				dataList[i] = book;
			}
		}		
	}

	@Override
	public void delete(int bookIsbn) {
		for (int i = 0; i<= listIndex; i++) {
			if(dataList[i].getBookIsbn() == bookIsbn) {
				dataList[i] = null;
			}
		}
		// 배열에서 데이터를 삭제하게 되면 빈 공간이 생겨나기 때문에, 그 공간을 없애주기 위해 만듦.
		cleanDataList();
		//필드가 가진 값을 복사 -> 초기화
	}

	private void cleanDataList() {
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		//기존 필드 초기화
		init();
		//임시변수에서 데이터만 기존 필드로 복사
		for (int i=0; i<=tempIndex; i++ ) {
			if (tempList[i] !=null) {
				dataList[++listIndex] = tempList[i];
			}
		}
	}
	@Override
	public Book[] selectAll() {
		// 실제 크기 = index + 1 = index와 length의 차이가 무조건 남
		Book[] list = new Book[listIndex + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	//향상된 for문은 정해진 수만큼 계속 돌려라므로 여기선 부적함.
	public Book selectOne(int bookIsbn) {
		Book selected = null;
		for (int i=0; i<= listIndex; i++) {
			if(dataList[i].getBookIsbn() == bookIsbn) {
				selected = dataList[i];
			}
		}
		return selected;
	}

}
