package Question2;

/*
 4)  아래와 같은 출력결과가 나오도록 실행코드를 구현한다.
	- 출력결과
		RPGgame 실행
		캐릭터가 위쪽으로 이동한다.
		캐릭터가 한칸단위로 점프한다.
		현재 모드 : HARD_MODE
		캐릭터가 두칸단위로 점프한다.
		캐릭터가 HIT 공격.
		캐릭터가 아래쪽으로 이동한다.
		현재 모드 : NORMAL_MODE
		캐릭터가 일반 공격.
		======================
		ArcadeGame 실행
		캐릭터가 앞쪽으로 이동한다.
		캐릭터가 일반 공격
		캐릭터가 뒤쪽으로 이동한다.
		현재 모드 : HARD_MODE
		캐릭터가 연속 공격.
		캐릭터가 앞쪽으로 이동한다.
		캐릭터가 Double HIT 공격.
 */
public class MainTest {

	public static void main(String[] args) {
		// Keypad 변수명을 gameType으로 하겠다.
		Keypad rpg;
		Keypad arcade;
		
		// 뉴 연산자로 초기화 해주는 동시에 실행됨.
		rpg = new RPGgame(); 	// RPGgame 실행
		
		
		rpg.leftUpButton();	// Keypad에서 leftUpButton 메소드를 불러옴.
		rpg.rightUpButton();
		
		rpg.changeMode();	// 해주면 모드가 바뀜.
		
		rpg.rightUpButton();	// 바뀐 모드로 적용
		rpg.rightDownButton();
		rpg.leftDownButton();
		
		rpg.changeMode();
		
		rpg.rightDownButton();
		
		System.out.println("=======================");
		
		arcade = new ArcadeGame(); //ArcadeGame 실행
		
		
		arcade.leftDownButton();
		arcade.rightUpButton();
		arcade.leftUpButton();
		
		arcade.changeMode();
		
		arcade.rightUpButton();
		arcade.leftDownButton();
		arcade.rightDownButton();
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//0,1중에서 랜덤으로 뽑아서 모드 지정해주기
//		int rand = (int) (Math.random() * 2) + 1;
//		Keypad keypad;
//		
//		keypad = new ArcadeGame();
//		
//			if( rand == 0 ) {
		
//			}
//			else if (rand == 1) {

//			}
//	}



//Scanner sc = new Scanner(System.in);
//int mode;
//
//mode = Integer.parseInt(sc.nextLine());
//
//if (mode == 0) {
//	RPGgame rpgGame = new RPGgame();
//}
