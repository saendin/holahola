package Question2;

/*
 4)  �Ʒ��� ���� ��°���� �������� �����ڵ带 �����Ѵ�.
	- ��°��
		RPGgame ����
		ĳ���Ͱ� �������� �̵��Ѵ�.
		ĳ���Ͱ� ��ĭ������ �����Ѵ�.
		���� ��� : HARD_MODE
		ĳ���Ͱ� ��ĭ������ �����Ѵ�.
		ĳ���Ͱ� HIT ����.
		ĳ���Ͱ� �Ʒ������� �̵��Ѵ�.
		���� ��� : NORMAL_MODE
		ĳ���Ͱ� �Ϲ� ����.
		======================
		ArcadeGame ����
		ĳ���Ͱ� �������� �̵��Ѵ�.
		ĳ���Ͱ� �Ϲ� ����
		ĳ���Ͱ� �������� �̵��Ѵ�.
		���� ��� : HARD_MODE
		ĳ���Ͱ� ���� ����.
		ĳ���Ͱ� �������� �̵��Ѵ�.
		ĳ���Ͱ� Double HIT ����.
 */
public class MainTest {

	public static void main(String[] args) {
		// Keypad �������� gameType���� �ϰڴ�.
		Keypad rpg;
		Keypad arcade;
		
		// �� �����ڷ� �ʱ�ȭ ���ִ� ���ÿ� �����.
		rpg = new RPGgame(); 	// RPGgame ����
		
		
		rpg.leftUpButton();	// Keypad���� leftUpButton �޼ҵ带 �ҷ���.
		rpg.rightUpButton();
		
		rpg.changeMode();	// ���ָ� ��尡 �ٲ�.
		
		rpg.rightUpButton();	// �ٲ� ���� ����
		rpg.rightDownButton();
		rpg.leftDownButton();
		
		rpg.changeMode();
		
		rpg.rightDownButton();
		
		System.out.println("=======================");
		
		arcade = new ArcadeGame(); //ArcadeGame ����
		
		
		arcade.leftDownButton();
		arcade.rightUpButton();
		arcade.leftUpButton();
		
		arcade.changeMode();
		
		arcade.rightUpButton();
		arcade.leftDownButton();
		arcade.rightDownButton();
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//0,1�߿��� �������� �̾Ƽ� ��� �������ֱ�
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
