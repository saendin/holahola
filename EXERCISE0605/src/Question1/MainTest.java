package Question1;
/*4) �Ʒ��� ���� ��°���� �������� �����ڵ带 �����ϴ�.
- ��°��
	ȫ�浿���� ���� 168, ������ 45, ǥ��ü�� 61.2 �Դϴ�.
	�ڵ��̴��� ���� 168, ������ 90, ���Դϴ�.
- ����
	������ Human Ŭ���� Ÿ������ �����Ͽ� �ϳ��� ����Ѵ�.
*/

public class MainTest {

	public static void main(String[] args) {
//		 Human human;	//int num; = ������ ����? ����?
//		 human = new StandardWeightInfo("ȫ�浿", 168, 45); = �ʱ�ȭ ����
		 Human human = new StandardWeightInfo("ȫ�浿", 168, 45);	//ȫ�浿�� ������ �־ ���� �����ϰڴ�.
		 human.getInformation();
		 
		 //���� �θ�Ŭ���� Human���� ������ ������ human�� �ٽ� �� �� ����(=�ణ ����� �ʳ�)
		 human = new ObesityInfo("�ڵ���", 168, 90);
		 human.getInformation();
	}
	
	
}
