package Question1;

/*
 * Question 1]
	1) Human Ŭ������ �����Ѵ�.
		- �̸��� Ű, �����Ը� �ʵ�� ������ �����ڸ� �̿��Ͽ� ���� �ʱ�ȭ�Ѵ�.
		- �޼ҵ�� ������ ���� �����Ѵ�.
 */

//(1) public void getInformation() : �̸�, Ű�� �����Ը� ����ϴ� ���
public class Human {
	// �ʵ� - �̸��� Ű, �����Ը� �ʵ�� ������.
	String name;
	double height; // Ű, �����Դ� �Ҽ������� ���;��ϴϱ� ���� ���.
	double weight;

	// ������ - �����ڸ� �̿��Ͽ� ���� �ʱ�ȭ�Ѵ�.
	Human(String name, double height, double weight) { // �޸�Ŭ�������� ��ȣ ���� �������� �ʱ�ȭ �� ����ϰڴ�.
		this.name = name; 	// this�� �����������ν� �ٸ������� �ν��Ͻ��� ������(�����ؼ�) ����ϰڴ�.
		this.height = height;
		this.weight = weight;	
	}

	// �޼ҵ� - (1) public void getInformation() : �̸�, Ű�� �����Ը� ����ϴ� ���
	public void getInformation() {
		//����̴ϱ� sysout
		//�����̶� ������ d�ְ� exception ���� ���� �Ἥ �����غ���.
			System.out.printf("%s���� ���� %.1f, ������ %.1f", name, height, weight);
		}
	}

