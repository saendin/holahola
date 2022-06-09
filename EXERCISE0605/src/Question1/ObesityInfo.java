package Question1;

/*
 * 3) ObesityInfo 클래스를 정의한다.
		- StandardWeightInfo 클래스를 상속한다.
		- 메소드는 다음과 같이 정의한다.
		(1) public void getInformation() : 이름, 키, 몸무게와 비만도를 출력하는 기능
		(2) public double getObesity() : 비만도를 구하는 기능
		( * 비만도 : (Weight - 표준 체중)/표준체중 * 100 )
 */
public class ObesityInfo extends StandardWeightInfo {
	// ObesityInfo는 StandardWeightInfo의 것을 상속받음

	ObesityInfo(String name, double height, double weight) {
		super(name, height, weight);
	}
//	(1) public void getInformation() : 이름, 키, 몸무게와 비만도를 출력하는 기능
	//상속하는 StnadardWeightInfo의 getInformation. 즉,
	//public void getInformation() {
	//(super.getInformation();
	//print();) ->를 고대로 사용할것이므로 오버라이딩해주기.
	
	@Override
	public void getInformation() {
		super.getInformation();	//근데 이제 부모의 것인(-> super.)
	}
	
	//print메소드 오버라이딩해서
	//StandardWeightInfo의 print() = System.out.println(", 표준체중 " + standardWeight() + " 입니다.");
	//를 아래의 비만도 출력값으로 덮어쓰기.
	//조부모 클래스인 Human쓸 수 없는 이유 : 자바에선 다중상속이 불가능하기 때문.
	//상속은 부모의 것만 받을 수 있음. 같은 메소드명일경우 헷갈릴 수 있기 때문.
	@Override
	public void print() {
		System.out.println(", " + getObesity() + " 입니다.");

	}

	// (2) public double getObesity() : 비만도를 구하는 기능
	public String getObesity() {

		double obesity;
		String result;

		obesity = ((weight - standardWeight()) / standardWeight() * 100);

		if (obesity <= 18.5) {
			result = "저체중";
		} else if (18.5 < obesity && obesity < 23.8) {
			result = "정상";
			;
		} else if (23.0 <= obesity && obesity < 25.0) {
			result = "과체중";
		} else if (25.0 <= obesity) {
			result = "비만";
		} else {
			result = "BMI 측정 오류";
		}

		return result;
	}

}
