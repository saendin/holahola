package Question1;

/*
 * 2) StandardWeightInfo 클래스를 정의한다.
		- Human 클래스를 상속한다.
		- 메소드는 다음과 같이 정의한다.
		(1) public void getInformation() : 이름, 키, 몸무게와 표준체중을 출력하는 기능
		(2) public double getStandardWeight() : 표준체중을 구하는 기능
		( * 표준 체중 : (Height - 100) * 0.9 )
 */



public class StandardWeightInfo extends Human {

	StandardWeightInfo(String name, double height, double weight) {
		super(name, height, weight);
	}

	// 부모 클래스의 겟 인포를 그대로 오버라이딩해서 쓰겠다.
//	//(1) public void getInformation() : 이름, 키, 몸무게와 표준체중을 출력하는 기능
	@Override
	public void getInformation() {
		// super = 부모 클래스(변형 없이) 그대로 상속.
//		//2번방법
		// 부모클래스에서 가져온 이름, 키, 몸무게정보에 표준체중 정보 덧붙여서 같이 출력(print() 메소드)
		super.getInformation();
		print();
	}

	// print 메소드 생성 : 표준체중을 출력 (밑에서 생성해준 표준값 구하는 메소드 리턴값 사용)
	public void print() {
		System.out.println(", 표준체중 " + standardWeight() + " 입니다.");
	}

	// 표준체중을 구현하는 새로운 메소드 생성
//	//(2) public double getStandardWeight() : 표준체중을 구하는 기능
	// 2번 방법 - stdrdWght만
	// 표준 체중값 리턴해주는 메소드 생성
	public double standardWeight() {
		double stdrdWght;

		stdrdWght = ((height - 100) * 0.9);

		return stdrdWght; // 위에서 stdrdWght만 불러와야 하므로 리턴값 필요.
	}

}

/*
 * @Override public void getInformation() { // super = 부모 클래스(변형 없이) 그대로 상속.
 * 
 * // //1번방법 호출 // standardWeight(); // // public void standardWeight() { //메소드
 * 자체를 불러올거라 리턴값 불필요. // //1번 방법 - stdrdWght 출력을 다시 한번 정의해주기 // double
 * stdrdWght; // // stdrdWght = ((height - 100) * 0.9 ); // //
 * System.out.printf("%s님의 신장 %f, 몸무게 %f, 표준체중 %.1f 입니다.", name, height, weight,
 * stdrdWght);
 * 
 */
