package Question2;

import java.util.Scanner;

public class RandomProgram {
	/*
	 * Question 3] Question 2]을 이용하여 랜덤게임 프로그램을 구현하라. 1) 프로그램을 실행할 경우 50% 확률로 두 개의
	 * 게임 중 하나가 셋팅된다. ( RPGgame or ArcadeGame ) 2) 다음과 같이 메뉴를 구성한다. << 1.LeftUP |
	 * 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT
	 * >> 3) 아래와 같이 출력결과가 나오도록 실행코드를 구현한다.
	 * 
	 */
// 1) 프로그램을 실행할 경우 50% 확률로 두 개의 게임 중 하나가 셋팅된다.
	
	//메인프로그램을 새로 짜줘야지 그 밑에 메소드 추가를 했을 때 불러와서 실행이 됨.
	
	public static void main(String[] args) {

		boolean run = true;
		int menu = 0;

		Keypad rpg;
		Keypad arcade;

		int rand = (int) (Math.random() * 2) + 1;

		Scanner sc = new Scanner(System.in);

		while (run) {
//			1) 프로그램을 실행할 경우 50% 확률로 두 개의 게임 중 하나가 셋팅된다.( RPGgame or ArcadeGame )
			// 랜덤값이 1일 때 rpg게임 실행
			if (rand == 1) {
				// rpg를 실행합니다. 출력문구 불러오고
				rpg = new RPGgame();

				// 아래와 같은 양식이 반복 출력 되도록 하시오.
				while (run) {

					// 메뉴 프린트아웃 해주고
					System.out.println(
							"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
					System.out.print("choice>>");
					menu = Integer.parseInt(sc.nextLine());

					// rpg게임모드에서의 메뉴 조건 입력해주기.
					if (menu == 1) {
						// 밑에서 변수를 통해 한번에 할 수 있는 방법 찾아보기
						rpg.leftUpButton();
					} else if (menu == 2) {
						rpg.leftDownButton();
					} else if (menu == 3) {
						rpg.rightUpButton();
					} else if (menu == 4) {
						rpg.rightDownButton();
					} else if (menu == 5) {
						rpg.changeMode(); // 모드 변환
					} else if (menu == 0) {
						// arcade = new ArcadeGame();
						rand = 2;
						break;
					} else if (menu == 9) { // 나가기
						System.out.println("EXIT");
						break;
					}
				}
			} else if (rand == 2) {
//
				// arcade를 실행합니다 출력문구 불러오고
				arcade = new ArcadeGame();

				// 아래와 같은 양식이 반복 출력 되도록 하시오.
				while (run) {

//				//메뉴 프린트아웃 해주고
					System.out.println(
							"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
					System.out.print("choice>>");
					menu = Integer.parseInt(sc.nextLine());

					// arcade게임모드에서의 메뉴 조건 입력해주기.
					if (menu == 1) {
						// 밑에서 변수를 통해 한번에 할 수 있는 방법 찾아보기
						arcade.leftUpButton();
					} else if (menu == 2) {
						arcade.leftDownButton();
					} else if (menu == 3) {
						arcade.rightUpButton();
					} else if (menu == 4) {
						arcade.rightDownButton();
					} else if (menu == 5) {
						arcade.changeMode(); // 모드 변환
					} else if (menu == 0) {
						// rpg = new RPGgame();
						rand = 1;
						break;
					} else if (menu == 9) { // 나가기
						System.out.println("EXIT");
						break;
					}
				}
			}
			if (menu == 9) {
				break;
			}
		}
	}
}
