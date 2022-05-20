package chap01;
/* 과제1
 */
public class work01 {
	public static void main(String[] args) {
		변수선언();
	}
	
	//아래의 변수 앞에 알맞은 타입을 적고 아래의 결과처럼 변수를 출력하시오.
	public static void 변수선언() {
		
		char grade 			= '상' ;
		String schoolName 	= "예담";
		int score 			= 85;
		double average		= 4.235;
		int flag			= 0b10000000;
		char firstChar		= '\uAC00'; 
		char secondChar		= 0xAC01;
		int	 salary			= 1_000_000;
		boolean useYn		= true;
	
		System.out.println("grade=" + grade + "\t, schoolName=" + schoolName + "\t, score=" + score);
		System.out.println("average=\t" + average);
		System.out.println("flag=\t\t" + flag);
		System.out.println("firstChar=\t" + firstChar);
		System.out.println("secondChar=\t" + secondChar);
		System.out.println("salary=\t\t" + salary);
		System.out.println("useYn=\t\t" + useYn);
		
	}
}
