package Question1;

/*
 * 3) ObesityInfo Ŭ������ �����Ѵ�.
		- StandardWeightInfo Ŭ������ ����Ѵ�.
		- �޼ҵ�� ������ ���� �����Ѵ�.
		(1) public void getInformation() : �̸�, Ű, �����Կ� �񸸵��� ����ϴ� ���
		(2) public double getObesity() : �񸸵��� ���ϴ� ���
		( * �񸸵� : (Weight - ǥ�� ü��)/ǥ��ü�� * 100 )
 */
public class ObesityInfo extends StandardWeightInfo {
	// ObesityInfo�� StandardWeightInfo�� ���� ��ӹ���

	ObesityInfo(String name, double height, double weight) {
		super(name, height, weight);
	}
//	(1) public void getInformation() : �̸�, Ű, �����Կ� �񸸵��� ����ϴ� ���
	//����ϴ� StnadardWeightInfo�� getInformation. ��,
	//public void getInformation() {
	//(super.getInformation();
	//print();) ->�� ���� ����Ұ��̹Ƿ� �������̵����ֱ�.
	
	@Override
	public void getInformation() {
		super.getInformation();	//�ٵ� ���� �θ��� ����(-> super.)
	}
	
	//print�޼ҵ� �������̵��ؼ�
	//StandardWeightInfo�� print() = System.out.println(", ǥ��ü�� " + standardWeight() + " �Դϴ�.");
	//�� �Ʒ��� �񸸵� ��°����� �����.
	//���θ� Ŭ������ Human�� �� ���� ���� : �ڹٿ��� ���߻���� �Ұ����ϱ� ����.
	//����� �θ��� �͸� ���� �� ����. ���� �޼ҵ���ϰ�� �򰥸� �� �ֱ� ����.
	@Override
	public void print() {
		System.out.println(", " + getObesity() + " �Դϴ�.");

	}

	// (2) public double getObesity() : �񸸵��� ���ϴ� ���
	public String getObesity() {

		double obesity;
		String result;

		obesity = ((weight - standardWeight()) / standardWeight() * 100);

		if (obesity <= 18.5) {
			result = "��ü��";
		} else if (18.5 < obesity && obesity < 23.8) {
			result = "����";
			;
		} else if (23.0 <= obesity && obesity < 25.0) {
			result = "��ü��";
		} else if (25.0 <= obesity) {
			result = "��";
		} else {
			result = "BMI ���� ����";
		}

		return result;
	}

}
