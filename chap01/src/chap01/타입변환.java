package chap01;

/*
 * 데이터 타입을 다른 타입으로 변환
 * 강제형변환
 * 자동형변환
 * 
 * 
 * 
 * String  <---> 기본데이터형 (int, double..등등)
 */
public class 타입변환 {

	public static void main(String[] args) {
		// 자동
		int a = 100;
		long b = a;

		// 강제
		long c = 100;
		int d = (int) c;

		// 자동
		double e = c;

		// 강제
		double f = 5.2;
		long g = (long) f;

		System.out.println("g= " + g);

		
		double h = (double) 10 / 3;
		// 10과 3 둘다 int니까 왼쪽의 실수형 double로 출력하면 3.0이 된다.
		// 왼쪽에도 (double)을 붙여주면 정상적인 실수형의 답이 나오게 된다 ㅋㅋ
		System.out.println("h= " + h);
		
		
		System.out.println("결과= " + 10 + 20);
		/*string이 먼저 나오고, int보다 큰 단위이므로
		*뒤의 10과 20도 문자로 인식을 하게 된다 ㅋㅋ
		*/ 
		System.out.println( 10 + 20 + " = 결과");


		
		//int -> String
		int i = 100;
		String j = String.valueOf(i);
		
		
		//String -> int
		String k = "100";
		int l = Integer.parseInt(k);
		
	}

}
