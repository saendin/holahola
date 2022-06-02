package com.yedam.java.example1;

public class Repo {
	// 필드
	private Customer[] dataList;
	private int listIndex;

	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드

	// 등록
	// customer등록
	public void insert(Customer customer) {
		dataList[++listIndex] = customer;

	}

	// 수정
	public void update(Customer customer) {
		// 기존에 있는 정보부터 들고와서
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customer.getCustomerId()) {
				dataList[i] = customer;
			}
		}
	}

	// 삭제
	public void delete(int customerId) {
		// 기존에 있는 정보부터 들고와서
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				dataList[i] = null; // 임의로 null로 준것임. for문 돌리면 오류 생길 가능성 큼.(처음이나 중간에서 빼낼 때 null값이 들어간다면)
			}
		}
		// 데이터 정리
		cleanDataList();
	}

	private void cleanDataList() {
		// 기존 데이터, 임시 변수에 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;

		// 기존 데이터를 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;

		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) { // 이면은 건너띄고
				continue;
			}
			dataList[++listIndex] = temp[i]; // 데이터리스트에 값을 넣는다.
		}
	}

	// 조회
	// delete는 삭제, select는 값 반환
	public Customer[] selectAll() {
		return dataList;
	}

	// for문 돌아서 데이터 select한다음에 리턴해줌.
	public Customer selectOne(int customerId) {
		Customer selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;

			}
		}
		return selected;
	}

}
