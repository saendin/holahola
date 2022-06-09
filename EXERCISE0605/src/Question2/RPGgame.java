package Question2;
/*
2) RPGgame Ŭ������ �����Ѵ�.
- Keypad�� �����ϴ� Ŭ����.
c
//
int mod;
RPG() {			// �� ()�� �Ű������� ���� ���ٴ� ��. �� ���� �̸����� �ٸ� �Ű������� ���� �����ڸ� ������ ���� �����ϴ� ��.
	mod = 0;}
//

- Keypad �������̽��� ���ǵ� �߻� �޼��带 ������ ���� �������̵��Ѵ�.

(1) public abstract void leftUpButton() : "ĳ���Ͱ� �������� �̵��Ѵ�"�� ����Ѵ�.
(2) public abstract void leftDownButton() : "ĳ���Ͱ� �Ʒ������� �̵��Ѵ�"�� ����Ѵ�.
(3) public abstract void rightUpButton()
	- NORMAL_MODE �ϰ�� : "ĳ���Ͱ� ��ĭ������ �����Ѵ�."�� ����Ѵ�.
	- HARD_MODE �ϰ�� : "ĳ���Ͱ� ��ĭ������ �����Ѵ�."�� ����Ѵ�.
(4) public abstract void rightDownButton()
	- NORMAL_MODE �ϰ�� : "ĳ���Ͱ� �Ϲ� ����."�� ����Ѵ�.
	- HARD_MODE �ϰ�� : "ĳ���Ͱ� HIT ����."�� ����Ѵ�.
(5) public abstract void changeMode() : ��带 �ٲٰ� ���� ��带 ����ϴ� ��� ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
*/

//- Keypad�� �����ϴ� Ŭ����.
public class RPGgame implements Keypad {
	// �ʵ� - ���� ��带 ������ ������ �ʵ带 ������
	int mode = 0;

	// ������ - �����ڸ� �̿��Ͽ� ���� �ʱ�ȭ���� "RPGgame ����"�� ����Ѵ�.
	// ( ��, �Ű������� �̿����� ������ ������ ���� NORMAL_MODE �̴�.
	RPGgame() {
		mode = NORMAL_MODE;
		System.out.println("RPGgame ����");
	}

	// Keypad �������̽��� ���ǵ� �߻� �޼��带 ������ ���� �������̵��Ѵ�.
	// : "ĳ���Ͱ� �������� �̵��Ѵ�"�� ����Ѵ�.
	@Override
	public void leftUpButton() {
		System.out.println("ĳ���Ͱ� �������� �̵��Ѵ�");
	}

	// : "ĳ���Ͱ� �Ʒ������� �̵��Ѵ�"�� ����Ѵ�.
	@Override
	public void leftDownButton() {
		System.out.println("ĳ���Ͱ� �Ʒ������� �̵��Ѵ�");
	}

	
	// - NORMAL_MODE �ϰ�� : "ĳ���Ͱ� ��ĭ������ �����Ѵ�."�� ����Ѵ�.
	// - HARD_MODE �ϰ�� : "ĳ���Ͱ� ��ĭ������ �����Ѵ�."�� ����Ѵ�.
	@Override
	public void rightUpButton() {
		if (mode == 0) {
			System.out.println("ĳ���Ͱ� ��ĭ������ �����Ѵ�");
		} else if (mode == 1) {
			System.out.println("ĳ���Ͱ� ��ĭ ������ �����Ѵ�");
		}

	}

	// - NORMAL_MODE �ϰ�� : "ĳ���Ͱ� �Ϲ� ����."�� ����Ѵ�.
	// - HARD_MODE �ϰ�� : "ĳ���Ͱ� HIT ����."�� ����Ѵ�.
	@Override
	public void rightDownButton() {
		if (mode == 0) {
			System.out.println("ĳ���Ͱ� �Ϲ� ����");
		} else if (mode == 1) {
			System.out.println("ĳ���Ͱ� HIT ����");
		}
	}

	// ��带 �ٲٰ� ���� ��带 ����ϴ� ���
	// ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	@Override
	public void changeMode() {
		if (mode == 0) {
			mode = 1;
			System.out.println("���� ��� : HARD_MODE");
		} else if (mode == 1) {
			mode = 0;
			System.out.println("���� ��� : NORMAL_MODE");
		}
	}
}
