package Question1;
/*4) 아래와 같은 출력결과가 나오도록 실행코드를 구현하다.
- 출력결과
	홍길동님의 신장 168, 몸무게 45, 표준체중 61.2 입니다.
	박둘이님의 신장 168, 몸무게 90, 비만입니다.
- 조건
	변수는 Human 클래스 타입으로 선언하여 하나만 사용한다.
*/

public class MainTest {

	public static void main(String[] args) {
//		 Human human;	//int num; = 변수의 정의? 선언?
//		 human = new StandardWeightInfo("홍길동", 168, 45); = 초기화 선언
		 Human human = new StandardWeightInfo("홍길동", 168, 45);	//홍길동의 정보를 넣어서 새로 정의하겠다.
		 human.getInformation();
		 
		 //위의 부모클래스 Human에서 정의한 변수값 human을 다시 쓸 수 있음(=약간 덮어쓰기 너낌)
		 human = new ObesityInfo("박돌이", 168, 90);
		 human.getInformation();
	}
	
	
}
