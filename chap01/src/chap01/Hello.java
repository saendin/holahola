package chap01;

public class Hello {

	public static void main(String[] args) {
		// 영어로 인사
		greetEn(); // 메서드 실행(호출)

		// 한글로 인사
		greet();

		// 자기 이름
		info();

		//
	}

	//메서드 선언
	public static void greet() {
		System.out.println("안녕");
	}

	public static void greetEn() {
		System.out.println("Hello");
	}

	public static void info() {
		System.out.println("홍선진");
	}
}