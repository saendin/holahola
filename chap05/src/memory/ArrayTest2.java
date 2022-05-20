package memory;

public class ArrayTest2 {

	public static void main(String[] args) {

		String[] arr = {"hello", "hi", "good"};
		
		//for문으로 String에 있는 값을 전부 출력하시오.
		for(int i=0; i<arr.length; i++) {
			// 0부터 돌려서 arr배열 값의 갯수와 같거나 커지면 반복 종료. 실행문을 끝낼 때 마다 횟수+1
			System.out.println(arr[i]);
			// 횟수를 반복할때마다의 배열값을 출력하라.
			System.out.println(arr[i].length());
			//배열 상수의 글자 수를 출력
	}
	}
}
