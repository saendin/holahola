package control;

public class ForTest {

	public static void main(String[] args) {

		//test1();
		test2();
	}

	public static void test1() {
		// 10번 실행
		for (int i = 0; i < 10; i++) {
			// *을 줄바꿈 없이 10번 반복 = * 10개가 찍혀 나옴
			for (int j = 0; j < 10; j++) {
				System.out.print("*");
			}
			// * 10개가 위의 포문을 돌아서 10번 출력 됨. = * 10개 10줄
			System.out.println();
		}
	}

	public static void test2() {
		// 10번 실행
		for (int i=10; i>0; i--) {	//별이 반복되는 라인 수
			//
			for (int j=0; j<i; j++) {	//별 개수
				System.out.print("*");
			}
			// 
			System.out.println();
		}
	}
}