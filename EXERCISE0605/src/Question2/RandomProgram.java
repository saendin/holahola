package Question2;

import java.util.Scanner;

public class RandomProgram {
	/*
	 * Question 3] Question 2]�� �̿��Ͽ� �������� ���α׷��� �����϶�. 1) ���α׷��� ������ ��� 50% Ȯ���� �� ����
	 * ���� �� �ϳ��� ���õȴ�. ( RPGgame or ArcadeGame ) 2) ������ ���� �޴��� �����Ѵ�. << 1.LeftUP |
	 * 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT
	 * >> 3) �Ʒ��� ���� ��°���� �������� �����ڵ带 �����Ѵ�.
	 * 
	 */
// 1) ���α׷��� ������ ��� 50% Ȯ���� �� ���� ���� �� �ϳ��� ���õȴ�.
	
	//�������α׷��� ���� ¥����� �� �ؿ� �޼ҵ� �߰��� ���� �� �ҷ��ͼ� ������ ��.
	
	public static void main(String[] args) {

		boolean run = true;
		int menu = 0;

		Keypad rpg;
		Keypad arcade;

		int rand = (int) (Math.random() * 2) + 1;

		Scanner sc = new Scanner(System.in);

		while (run) {
//			1) ���α׷��� ������ ��� 50% Ȯ���� �� ���� ���� �� �ϳ��� ���õȴ�.( RPGgame or ArcadeGame )
			// �������� 1�� �� rpg���� ����
			if (rand == 1) {
				// rpg�� �����մϴ�. ��¹��� �ҷ�����
				rpg = new RPGgame();

				// �Ʒ��� ���� ����� �ݺ� ��� �ǵ��� �Ͻÿ�.
				while (run) {

					// �޴� ����Ʈ�ƿ� ���ְ�
					System.out.println(
							"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
					System.out.print("choice>>");
					menu = Integer.parseInt(sc.nextLine());

					// rpg���Ӹ�忡���� �޴� ���� �Է����ֱ�.
					if (menu == 1) {
						// �ؿ��� ������ ���� �ѹ��� �� �� �ִ� ��� ã�ƺ���
						rpg.leftUpButton();
					} else if (menu == 2) {
						rpg.leftDownButton();
					} else if (menu == 3) {
						rpg.rightUpButton();
					} else if (menu == 4) {
						rpg.rightDownButton();
					} else if (menu == 5) {
						rpg.changeMode(); // ��� ��ȯ
					} else if (menu == 0) {
						// arcade = new ArcadeGame();
						rand = 2;
						break;
					} else if (menu == 9) { // ������
						System.out.println("EXIT");
						break;
					}
				}
			} else if (rand == 2) {
//
				// arcade�� �����մϴ� ��¹��� �ҷ�����
				arcade = new ArcadeGame();

				// �Ʒ��� ���� ����� �ݺ� ��� �ǵ��� �Ͻÿ�.
				while (run) {

//				//�޴� ����Ʈ�ƿ� ���ְ�
					System.out.println(
							"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
					System.out.print("choice>>");
					menu = Integer.parseInt(sc.nextLine());

					// arcade���Ӹ�忡���� �޴� ���� �Է����ֱ�.
					if (menu == 1) {
						// �ؿ��� ������ ���� �ѹ��� �� �� �ִ� ��� ã�ƺ���
						arcade.leftUpButton();
					} else if (menu == 2) {
						arcade.leftDownButton();
					} else if (menu == 3) {
						arcade.rightUpButton();
					} else if (menu == 4) {
						arcade.rightDownButton();
					} else if (menu == 5) {
						arcade.changeMode(); // ��� ��ȯ
					} else if (menu == 0) {
						// rpg = new RPGgame();
						rand = 1;
						break;
					} else if (menu == 9) { // ������
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
