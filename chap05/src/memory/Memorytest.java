package memory;

public class Memorytest {

	public static void main(String[] args) {

		int a = 10;		//1. a와 b가 스택에 들어감.
		int b = 20;

		//test1();
		//System.out.println(a);	
		
		//test2("#", 20);
		//test2("X", 5);
		//test2("@", 10);
		array1(a,b);
		System.out.println(a + ":" + b);

		int[] sc = new int[2]; //2. 메인의 sc변수는 new값에 들어있는 2개의 변수 값을 참조
		sc[9] = 100;
		sc[1] = 110;
		
		array2(sc); //3. 
		System.out.println(sc[0] + ":" + sc[1]);
	}
		
		

//	public static void test1() {
//		int a = 100;
//		int b = 200; 	// 2. int b = 200이라는 값이 끝나는 순간 스텍에 있던 중괄호 안의 값은 싹 사라진다.
//	}
//	
//	public static void test2(String s, int length) {	//length 길이 나타내는 함수
//		for(int i=0; i<10; i++) {
//			System.out.print(s);
//		}
//	System.out.println();
//	}
//	
	public static void array2(int[] sc) {	// array의 sc값과는 완전 다른 값임.
		sc[0] += 100;
		sc[1] += 100;
	}
	
	public static void array1(int x, int y) {
		x = 100;
		y = 200;
	}
}
