package memory;

public class EqualTest {

	public static void main(String[] args) {

		int[] a = new int[5]; // 배열은 0으로 초기화
								// a가 참조하는 값이 5개
		int[] b = a; // b=a, b 역시 a가 참조하는 값을 그대로 참조 = 같은 객체 참조

		b[0] = 100;

		System.out.println(a[0]); // 즉, b가 참조하는 0값이 100이므로, a역시 같은 값인 100 도출

		System.out.println(a == b); // 같은 객체를 참조하는가? T or F
									// 근데 같은 객체를 참고할 일은 거의 없음 ㅋㅋ 별 의미 ㄴ

		System.out.println();
		
		// 스트링;
		String s1 = new String("hello"); // s1이 참조하는 new값
		String s2 = new String("hello"); // s2가 참조하는 new값 별개인고~
		System.out.println(s1 == s2); // s1과 s2의 참조값을 비교. 각각의 new이기 때문에서로 다른 변수임. 오해ㄴ
		System.out.println(s1.equals(s2)); // s1와 s2의 값을 비교하는 것. 그래서 같게 나옴.
		
		System.out.println();
		
		String s3 = "hi"; // 상수값인 hi가져와서 같은 객체 참조하게 됨. 뉴 스트링이 아니라서 ㅋㅋ
		String s4 = "hi";
		System.out.println(s3 == s4);
		
		System.out.println();
		
		s1 = null; 	//위의 s1이 참조하는 값을 끊어버림. 아무것도 참조하지 않는 쓰레기 값. 가비지 값. JVM이 슥 보다가
					// 안쓰니까 나중에 지움ㅋ
		s2 = null;
	}

}
