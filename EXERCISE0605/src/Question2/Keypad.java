package Question2;
/*
1) Keypad �������̽��� �����Ѵ�.
- ������ ���� ��� �ʵ带 �����Ѵ�. 
(1) public static final int NORMAL_MODE = 0;	//public(��Ű�� ȣȯ ����), static(��ü���� ��� �����ϵ��� ����ϰڴ�)
(2) public static final int HARD_MODE = 1;	// �׳� �̷��� ����ҰŴ� ������ ���� ������.

- ������ ���� �߻� �޼��带 �����Ѵ�.	// interface - implements
(1) public abstract void leftUpButton() : ���ʿ��� ���� ��ư�� ������ �� �����ϴ� ���
(2) public abstract void leftDownButton() : ���ʿ��� �Ʒ��� ��ư�� ������ �� �����ϴ� ���
(3) public abstract void rightUpButton() : �����ʿ��� ���� ��ư�� ������ �� �����ϴ� ���
(4) public abstract void rightDownButton() : �����ʿ��� �Ʒ��� ��ư�� ������ �� �����ϴ� ���
(5) public abstract void changeMode() : ��带 �ٲٰ� ���� ��带 ����ϴ� ��� ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
*/
//�������̽� : �׳� ������ ��. ��� ���� ����. ����� �θ�Ŭ������ ����� ����. �װ� ������

public interface Keypad {
	//�ʵ� - ������ ���� ��� �ʵ带 �����Ѵ�. 
	public static final int NORMAL_MODE = 0;	//public(��Ű�� ȣȯ ����), static(��ü���� ��� �����ϵ��� ����ϰڴ�)
	public static final int HARD_MODE = 1;		// �׳� �̷��� ����ҰŴ� ������ ���� ������.
	
	
	//�޼ҵ� - ������ ���� �߻� �޼��带 �����Ѵ�.
	public abstract void leftUpButton(); 	// : ���ʿ��� ���� ��ư�� ������ �� �����ϴ� ���
	public abstract void leftDownButton(); 	// : ���ʿ��� �Ʒ��� ��ư�� ������ �� �����ϴ� ���
	public abstract void rightUpButton(); 	// : �����ʿ��� ���� ��ư�� ������ �� �����ϴ� ���
	public abstract void rightDownButton(); // : �����ʿ��� �Ʒ��� ��ư�� ������ �� �����ϴ� ���
	public abstract void changeMode(); 		// : ��带 �ٲٰ� ���� ��带 ����ϴ� ��� ( ���� ���, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)

	
}
