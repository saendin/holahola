package Question1;

/*
 * 2) StandardWeightInfo Ŭ������ �����Ѵ�.
		- Human Ŭ������ ����Ѵ�.
		- �޼ҵ�� ������ ���� �����Ѵ�.
		(1) public void getInformation() : �̸�, Ű, �����Կ� ǥ��ü���� ����ϴ� ���
		(2) public double getStandardWeight() : ǥ��ü���� ���ϴ� ���
		( * ǥ�� ü�� : (Height - 100) * 0.9 )
 */



public class StandardWeightInfo extends Human {

	StandardWeightInfo(String name, double height, double weight) {
		super(name, height, weight);
	}

	// �θ� Ŭ������ �� ������ �״�� �������̵��ؼ� ���ڴ�.
//	//(1) public void getInformation() : �̸�, Ű, �����Կ� ǥ��ü���� ����ϴ� ���
	@Override
	public void getInformation() {
		// super = �θ� Ŭ����(���� ����) �״�� ���.
//		//2�����
		// �θ�Ŭ�������� ������ �̸�, Ű, ������������ ǥ��ü�� ���� ���ٿ��� ���� ���(print() �޼ҵ�)
		super.getInformation();
		print();
	}

	// print �޼ҵ� ���� : ǥ��ü���� ��� (�ؿ��� �������� ǥ�ذ� ���ϴ� �޼ҵ� ���ϰ� ���)
	public void print() {
		System.out.println(", ǥ��ü�� " + standardWeight() + " �Դϴ�.");
	}

	// ǥ��ü���� �����ϴ� ���ο� �޼ҵ� ����
//	//(2) public double getStandardWeight() : ǥ��ü���� ���ϴ� ���
	// 2�� ��� - stdrdWght��
	// ǥ�� ü�߰� �������ִ� �޼ҵ� ����
	public double standardWeight() {
		double stdrdWght;

		stdrdWght = ((height - 100) * 0.9);

		return stdrdWght; // ������ stdrdWght�� �ҷ��;� �ϹǷ� ���ϰ� �ʿ�.
	}

}

/*
 * @Override public void getInformation() { // super = �θ� Ŭ����(���� ����) �״�� ���.
 * 
 * // //1����� ȣ�� // standardWeight(); // // public void standardWeight() { //�޼ҵ�
 * ��ü�� �ҷ��ðŶ� ���ϰ� ���ʿ�. // //1�� ��� - stdrdWght ����� �ٽ� �ѹ� �������ֱ� // double
 * stdrdWght; // // stdrdWght = ((height - 100) * 0.9 ); // //
 * System.out.printf("%s���� ���� %f, ������ %f, ǥ��ü�� %.1f �Դϴ�.", name, height, weight,
 * stdrdWght);
 * 
 */
