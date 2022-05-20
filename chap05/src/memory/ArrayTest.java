package memory;

public class ArrayTest {

	public static void main(String[] args) {

		int[] month = new int[] {31, 28, 31, 30, 31, 31}; //{}안의 배열 개수가 month가 가지는 공간값임
		//2월달의 마지막 날을 알려면?
		System.out.println(month[1]);
		
		
		
		int[] week = {'월', '화', '수'}; //{}로 직접 배열 나열해줄거면 new int 생략 가능

		//int[] score = new int[];
		//score = {4, 6, 10, 3, 5};// 는 안됨. 틀린거 ㅇㅇ. 배열 값은 초기값을 설정할 때 같이 입력해줘야함 ㅋㅋ 따로는 놉
		//new int 쓰면 가능 -> score = new int[]{,,,}
		//score[0] = 100;
	}

}


//block잡은 후에 alt누른 상태에서 방향키 위 아래 이동하면 줄 이동 가능.