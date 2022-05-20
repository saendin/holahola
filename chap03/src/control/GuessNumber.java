package control;

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rand = (int) (Math.random() * 10) + 1;
		; // 나중에 난수로 바꿀것임
		int num; // 유저가 입력하는 값
		int count = 1; // 시도횟수 : 입력할때마다 1씩 증가
		String result;
		System.out.println("입력값");
		// 반복
		do {
			count++;
			// 유저가 입력한 키보드 값을 입력 받아서 num에 저장
			System.out.println();
			num = Integer.parseInt(scan.nextLine());
			// 숫자만 들어올거면 num = scan.nextInt();써도 됨.
			// rand> num "크다" 출력
			if (rand > num) {
				result = "크당";
			}
			// rand < num "작다" 출력
			else if (rand < num) {
				result = "작당ㅠ";
			}
			// 랜덤 수를 맞혔을 때 게임 종료.
			else {
				System.out.print("\t맞당ㅋㅋ");
				break;
			}
			// count(시도 횟수)가 5회 이상이면 게임 종료.
			if (count >= 5)
				break;
			System.out.println(result);
			// 랜덤값이 넘버값과 같아지지 않는 이상 계속 반복
		} while (true);
		System.out.println("축하~합니다.");
	}
}