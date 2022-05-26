package array;

//JVM에서 주소값을주고 값을 찾아오라는고!~!!!~! 그게 배열임,, 주소값 찾기..

public class Array2 {
	public static void main(String[] agrs) {

		int[] intAry = new int[2]; // 배열 선언법(길이를 정해줘야함) 1차원 배열
		for (int i = 0; i < intAry.length; i++) {
			System.out.println("intAry[" + i + "] : " + intAry[i]);
		}

		System.out.println();

		int[][] intAry2 = new int[3][2];
		// 다차원 배열. 1차원 배열과 기본적 형태는 같지만, 앞에 있는 int[](정수 배열) 을 몇개나 가지느냐를 묻는 것임
		// ex) new int[3][2] = int[2](int값이 2인 배열이) 총 3개 존재하는 2차원 배열
		// for문 : 초기값에서 배열의 길이보다 작을 때 index값을 1씩 올리며 반복(즉, index값은 배열의 길이를 넘어서면 안됨.)
		for (int i = 0; i < intAry2.length; i++) {
			int[] tempAry = intAry2[i]; // tempAry를 intAry2로 다 옮김(??)
			for (int j = 0; j < tempAry.length; j++) {
				System.out.println("tempAry[" + j + "]:" + tempAry[j]);
			}
		}

		System.out.println();

		for (int i = 0; i < intAry2.length; i++) {
			for (int j = 0; j < intAry2[1].length; j++) {
				System.out.println("intAry2[" + i + "][" + j + "]:" + intAry2[i][j]);
			}
		}

		System.out.println();

		int[][] intAry3 = new int[2][]; // 2차원의 배열이 2개
		intAry3[0] = new int[3];
		intAry3[1] = new int[5];

		for (int i = 0; i < intAry3.length; i++) {
			for (int j = 0; j < intAry3[i].length; j++) {
				System.out.println("intAry3[" + i + "][" + j + "]:" + intAry3[i][j]);
			}
		}

		System.out.println();

		int[][] javaScores = { { 95, 80 }, { 92, 96, 80 } }; // 행,열 개념 [][]면 첫번째 []는 행이고 두번째 []는 열이다. 행, 열을 따라가 값 찾아내기
																// 엑셀로 치면 vlookup이나 hlookup함수같은 느낌이랄까,,
																// 주어진 행, 열 값에 대응하는 값을 찾아 뽑아내는 개념.
		// { 92, 96, 80 } };
		for (int i = 0; i < javaScores.length; i++) { // 배열 초기값은 무족권 0임ㅋㅋ. 배열을 찾아서 for문을 돌렸는데 그 for문의 값이 여러개일때
			for (int j = 0; j < javaScores[i].length; j++) { // 다시한번 for문을 돌리는것
				System.out.println("javaScores[" + i + "][" + j + "]:" + javaScores[i][j]); // i번째에서의 j값을 출력. i행과 j행이
																							// 겹치는 부분을 모두 출력
			}
		}
		
		System.out.println();
		
		for(int[] tempAry : javaScores) {	//향상된 for문 : 지정 된 값을 꺼내오는 것이 아닌, 단순히 배열값을 하나하나 끄집어 낼 때 편리함.
			for(int temp : tempAry) {		//1차원 배열인지 2차원 배열인지를 구분하기는 힘듦. (for문의 특징을 단순화 시킨거라 편하긴 하지만 세부적이진 않음)
				System.out.println(temp); //위의 주소지정 for문과 값이 같음.
			}
			
		}

		
		
	}

}
