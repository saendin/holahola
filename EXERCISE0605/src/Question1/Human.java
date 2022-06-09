package Question1;

/*
 * Question 1]
	1) Human 클래스를 정의한다.
		- 이름과 키, 몸무게를 필드로 가지며 생성자를 이용하여 값을 초기화한다.
		- 메소드는 다음과 같이 정의한다.
 */

//(1) public void getInformation() : 이름, 키와 몸무게를 출력하는 기능
public class Human {
	// 필드 - 이름과 키, 몸무게를 필드로 가진다.
	String name;
	double height; // 키, 몸무게는 소숫점까지 나와야하니까 더블 사용.
	double weight;

	// 생성자 - 생성자를 이용하여 값을 초기화한다.
	Human(String name, double height, double weight) { // 휴먼클래스에서 괄호 안의 변수들을 초기화 해 사용하겠다.
		this.name = name; 	// this로 선언해줌으로써 다른곳에서 인스턴스를 생성해(변형해서) 사용하겠다.
		this.height = height;
		this.weight = weight;	
	}

	// 메소드 - (1) public void getInformation() : 이름, 키와 몸무게를 출력하는 기능
	public void getInformation() {
		//출력이니까 sysout
		//신장이랑 몸무게 d넣고 exception 오류 제거 써서 구현해보기.
			System.out.printf("%s님의 신장 %.1f, 몸무게 %.1f", name, height, weight);
		}
	}

