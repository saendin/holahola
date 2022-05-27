package com.yedam.java.example2;

public class StudentRepo implements Access {
	// 인스턴스가 두개면 싱글톤 만들어서 사용
	// 싱글톤 생성
	// *외부에서 나를 만들 수 없게 막고 매서드로만 접근할 수 있게 만듦.
	private static StudentRepo instance = new StudentRepo();

	private StudentRepo() {
		init();
	}

	// 내부에 있는걸 반환해주는 역할만 ㅇ
	// 외부에서 접근할 수 있는 방법은 클래스 명으로만 접근 가능.
	// 내 책을 사용할 수 있게 공유만 함
	public static StudentRepo getInstance() {
		return instance;
	}

	// 실제 사용 필드 및 메소드
	private Student[] dataList; // 데이터 저장하기 위한 배열 ( 저장소는 원래 프로젝트내에서 하나임 )
	private int listIndex;

	private void init() {
		// 리턴되는 타입도 없고 매개변수도 없다.
		// 초기화 할때 많이 사용
		dataList = new Student[100];
		listIndex = -1;
	}

	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;
	}

	@Override
	public void update(Student student) {
		for (int i = 0; i <= listIndex; i++) {
			// 데이터 리스트의 아이디가 학생 아이디와 같으면 그 데이터가 그 학생의 전체 정보와 같다. (=아이디가 같으면 정보 전체 수정 가능)
			if (dataList[i].getId() == student.getId()) {
				dataList[i] = student;
			}
		}
	}

	@Override
	public void delete(int studentId) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == studentId) {
				dataList[i] = null;
			}
		}
		// 배열에서 데이터를 삭제하게 되면 빈 공간이 생겨나기 때문에, 그 공간을 없애주기 위해 만듦.
		cleanDataList();
		// 필드가 가진 값을 복사 -> 초기화

	}

	private void cleanDataList() {
		// 기존 데이터 -> 임시변수
		Student[] tempList = dataList;
		int tempIndex = listIndex;
		// 기존 필드 초기화
		init();
		// 임시변수에서 데이터만 기존 필드로 복사
		for (int i = 0; i <= tempIndex; i++) {
			if (tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
	}

	@Override
	public Student[] selectAll() {
		// 실제 크기 = index + 1 = 인덱스와 랭스 사이에는 1의 차이가 무조건 남
		Student[] list = new Student[listIndex + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;

	}

	@Override
	//향상된 포문은 정해진 수만큼 계속 돌림. 그러므로 여기선 부적합.
	public Student selectOne(int studentId) {
		Student selected = null;
		for (int i=0; i<= listIndex; i++) {
			if (dataList[i].getId() == studentId) {
				selected = dataList[i];
			}
		}
		return selected;
	}

}
