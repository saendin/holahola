package Question2;

public class Question {
/*
 * Question 2]
	1) Keypad �������̽��� �����Ѵ�.	//�������̽� : �׳� ������ ��. ��� ���� ����. ����� �θ�Ŭ������ ����� ����. �װ� ������
	- ������ ���� ��� �ʵ带 �����Ѵ�. 
	(1) public static final int NORMAL_MODE = 0;	//public(��Ű�� ȣȯ ����), static(��ü���� ��� �����ϵ��� ����ϰڴ�)
	(2) public static final int HARD_MODE = 1;	// �׳� �̷��� ����ҰŴ� ������ ���� ������.
	- ������ ���� �߻� �޼��带 �����Ѵ�.	// interface - implements

	(1) public abstract void leftUpButton() : ���ʿ��� ���� ��ư�� ������ �� �����ϴ� ���
	(2) public abstract void leftDownButton() : ���ʿ��� �Ʒ��� ��ư�� ������ �� �����ϴ� ���
	(3) public abstract void rightUpButton() : �����ʿ��� ���� ��ư�� ������ �� �����ϴ� ���
	(4) public abstract void rightDownButton() : �����ʿ��� �Ʒ��� ��ư�� ������ �� �����ϴ� ���
	(5) public abstract void changeMode() : ��带 �ٲٰ� ���� ��带 ����ϴ� ��� ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	


	2) RPGgame Ŭ������ �����Ѵ�.
	- Keypad�� �����ϴ� Ŭ����.
	- ���� ��带 ������ ������ �ʵ带 ������ �����ڸ� �̿��Ͽ� ���� �ʱ�ȭ���� "RPGgmae ����"�� ����Ѵ�.
	  ( ��, �Ű������� �̿����� ������ ������ ���� NORMAL_MODE �̴�. )
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
	(5) public abstract void changeMode() : ��带 �ٲٰ� ���� ��带 ����ϴ� ��� ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	
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
}
