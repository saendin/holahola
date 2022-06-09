package Question2;
/*
3) ArcadeGame Ŭ������ �����Ѵ�.
	- Keypad�� �����ϴ� Ŭ����.
	- ���� ��带 ������ ������ �ʵ带 ������ �����ڸ� �̿��Ͽ� ���� �ʱ�ȭ���� "ArcadeGame ����"�� ����Ѵ�.
	  ( ��, �Ű������� �̿����� ������ ������ ���� NORMAL_MODE �̴�. )
	- Keypad �������̽��� ���ǵ� �߻� �޼��带 ������ ���� �������̵��Ѵ�.
	(1) public abstract void leftUpButton() : "ĳ���Ͱ� �������� �̵��Ѵ�"�� ����Ѵ�.
	(2) public abstract void leftDownButton() : "ĳ���Ͱ� �������� �̵��Ѵ�"�� ����Ѵ�.
	(3) public abstract void rightUpButton()
		- NORMAL_MODE �ϰ�� : "ĳ���Ͱ� �Ϲ� ����"�� ����Ѵ�.
		- HARD_MODE �ϰ�� : "ĳ���Ͱ� ���� ����"�� ����Ѵ�.
	(4) public abstract void rightDownButton()
		- NORMAL_MODE �ϰ�� : "ĳ���Ͱ� HIT ����."�� ����Ѵ�.
		- HARD_MODE �ϰ�� : "ĳ���Ͱ� Double HIT ����."�� ����Ѵ�.
	(5) public abstract void changeMode() : ��带 �ٲٰ� ���� ��带 ����ϴ� ��� ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> 
 */
public class ArcadeGame implements Keypad {
	int mode = 0;

	// ������ - �����ڸ� �̿��Ͽ� ���� �ʱ�ȭ���� "RPGgame ����"�� ����Ѵ�.
	// ( ��, �Ű������� �̿����� ������ ������ ���� NORMAL_MODE �̴�.
	ArcadeGame() {
		mode = NORMAL_MODE;
		System.out.println("ArcadeGame ����");
	}
	@Override
	public void leftUpButton() {
		System.out.println("ĳ���Ͱ� �������� �̵��Ѵ�");
	}

	@Override
	public void leftDownButton() {
		System.out.println("ĳ���Ͱ� �������� �̵��Ѵ�");
	}

	@Override
	public void rightUpButton() {
		if (mode == 0) {
			System.out.println("ĳ���Ͱ� �Ϲ� ����");
		} else if (mode == 1) {
			System.out.println("ĳ���Ͱ� ���� ����");
		}		
	}

	@Override
	public void rightDownButton() {
		if (mode == 0) {
			System.out.println("ĳ���Ͱ� HIT ����");
		} else if (mode == 1) {
			System.out.println("ĳ���Ͱ� Double HIT ����");
		}		
	}

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
