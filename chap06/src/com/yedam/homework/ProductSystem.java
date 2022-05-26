package com.yedam.homework;

/*
 * 1. 상품 수 입력 		( 등록기능 구현 )
 * 2. 상품 및 가격 입력 	( 등록기능 구현 )
 * 3. 제품별 가격 출력 	( 조회 구현 )
 * 4. 분석			( 분석기능 구현 )
 */

public class ProductSystem {
	// 우리가 받아야 될 것은 상품이라서 필드가 달라짐. (필드 = 타입)
	// 상품 사이즈는 입력에 따라 달라지므로 Product[]
	private Product[] list;
	// 실제로 몇개를 부여받는지 알고자 index를 따로 인수로 부여
	private int index;
	int productName = 0;
	int sum = 0;

	// 생성자
	public ProductSystem() {
		index = -1; // 배열로 들어감. 시작값=0
	}

	// -----------------------------------
	// 1. 상품 수 입력
	// 기존에 줬던 int타입이 아니라 프로덕트 타입으로
	public void setListSize(int size) {
		// new 생산자로 상품 입력 수([size]) 만큼의 프로덕트 생성 = list
		list = new Product[size];
	}

	// 2. 상품 및 가격 입력
	// 두가지 값을 가지는 product(상품 이름, 가격)
	// 리스트에 값을 넣기위해 임시로 인스턴스 만든고
	public void putProduct(String name, int price) {
		// Product필드에서 가져오는 product라는 이름의 새 변수
		Product product = new Product();
		product.setName(name); // 프로덕트 필드의 setName호출
		product.setPrice(price); // 프로덕트의 setPrice호출
		// index 값을 -1로 줬으니 ++해서 0으로 초기화
		// list의 배열 값이 곧 상품
		list[++index] = product;
	}

	// 3. 제품별 가격 출력
	public void printList() {
		for (int i = 0; i <= index; i++) {
			// 변수 하나 출력해서 list에 있는 i번째 값 불러오기
			Product product = list[i];
			// 상품 이름 : 상품 가격 호출
			System.out.println(product.getName() + " : " + product.getPrice()); // 상품명 출력

			// 변수를 사용하지 않는 방법
			// Product product = list[i];
			// System.out.println(list[i].getName() + " : " + list[i].getPrice()); //상품명 출력

			// 위에것 말고 showInfo쓰는 법(쇼 인포에 저장딘 name : price 불러옴)
			// Product product = list[i];
			// list[i].showInfo();
		}
	}

	// 4. 분석
	// 최고 가격을 가지는 제품 & 나머지 제품들의 총합
	// int일때는 바로바로 데이터를 집어넣고 뺄 수 있지만
	// class를 사용하면 getter나 setter를 거쳐야됨(메소드 이용) - 그거 외엔 거의 동일
	// getPrice
	// 4-1. 최고점수 구하기
	public void getMaxPrice() {
		// Product max = list[0];
		// for (int i = 1; i <= index; i++) {
		// if(max.getPrice() < list[i].getPrice()) {
		// max = list[i];
		// }
		// }
		// return max;
		int max = list[0].getPrice();
		for (int i = 1; i <= index; i++) {
			int temp = list[i].getPrice();
			if (max < temp) {
				max = temp;
			}
			productName = i;
		}
		System.out.println("최고가 제품 : " + list[productName].getName());
	}

	// 4-1. 나머지 제품들의 총합 구하기
	// int sum = 0;
	// for(Product temp : list) {
	// sum +=temp.getPrice();
	// }
	// +Product max = getMaxPrice();
	/*
	 * int result = sum - max.getPrice(); int result = sum -
	 * getMaxPrice().getPrice();
	 */
	// ->getMaxPrice가 사실 제품을 호출하는 거기 때문에
	//
	// for(Product temp : list) {
	// if(temp.getPrice() == max.getPrice());
	// continue;
	// result += temp.getPrice();
	/*
	 * if(temp.getPrice() < max.getPrice()) { result += temp.getPrice();
	 */
	// }
	// return result;
	public void getSumPrice() {
		for (int i = 0; i <= index; i++) {
			sum += list[i].getPrice();
		}
		sum -= list[productName].getPrice();

		System.out.println("나머지 제품들의 가격 총 합" + sum);
	}
}

//시험 - 수 입력 받아 정보 입력받고 분석하고 출력하고
//근데 이제 class가 추가된.. ex) 점수, 학생 등등..
