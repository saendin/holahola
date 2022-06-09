package Question2;

import java.util.Scanner;

public class RandomGame_ {
	private Keypad game;
	
	public RandomGame_() {
		//최초로 게임 실행
		setRandomGame();
		
		while (true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력 받고
			int menuNo = menuSelect();

			// 각각의 기능 실행
			if (menuNo == 1) {
				game.leftUpButton();

			} else if (menuNo == 2) {
				game.leftDownButton();
			} else if (menuNo == 3) {
				game.rightUpButton();
			} else if (menuNo == 4) {
				game.rightDownButton();
			} else if (menuNo == 5) {
				game.changeMode();
			} else if (menuNo == 0) {
				setRandomGame();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				printInputError();
			}
		}

	}
	//gameChange가 현재 게임과 다른 타입의 게임이 나오게 하려면 아에 다른 로직으로. 이거는 랜덤을 뽑아내는 것.
	private void setRandomGame() {
		int random = (int)(Math.random() * 2);
		switch(random) {
		case 0 :
			game = new RPGgame();
			break;
		case 1 :
			game = new ArcadeGame();
			break;
		}
		
	}
	private void menuPrint() {
		System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
	}

	private int menuSelect() {
		System.out.print("choice>>");
		return new Scanner(System.in).nextInt(); //한번만 쓰고 끝일 때는 이렇게 한번만 뉴 스캐너 호출해서 사용해도 무방.
	}
	
	private void exit() {
		System.out.println("EXIT");
	}
	
	private void printInputError() {
		System.out.println("메뉴를 잘못 입력하셨습니다.");
	}
}
