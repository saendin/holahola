package chap06.src.com.yedam.java.ch0602;

//큰 개념의 인스턴스와 생성자 정의
		//1. 사용자 열거타입 우선순위로 올려놓음.(사용 하던 안하던)
		//2. 그리고 복사해서 동일한 형태로 복사해서 사용함. 그걸 직접 사용하는게 아님.(class는 극 소수의 상황이 아니면 사용하지 않음)
		//2-1. 이렇게 다양한 인스턴스를 생성할 수 있게 함.
		//3. 항상 new를 이용해서 만듦
		
public class Car {

		//Class의 full name은 Package + Class 네임 합친 것.
		//즉 같은 패키지 안에서의 동일한 이름의 클래스는 생성할 수 없지만, 패키지가 다르다면 삽가능
		String company = "현대자동차";
		String model = "그랜저";
		String color = "검정";
		int maxSpeed = 350;
		int speed;
		
		//***생성자 내에서 또 다른 생성자를 호출할 수 있고, 이 개념이 this임
		
		Car(String color){			//Car() {}	//기본 생성자
			//this.color = color; 	//this는 인스턴스 내부에서만 사용할 수 있는 method인데(내부의 값을 건드릴 수 있음)
									//그 인스턴스의 필드를 가리킴. 본 클래스의 필드는 생성자가 수정할 수 없음(=생성자는 필드를 건드릴 수 없음).
									//생성자 내부에서 this.을 쓰고 보조창을 보면 위에 정의했던 필드들이 보임.
			
			this("그랜저", color, 350);
			this.company = "기아";	//생성자 내에서 생성자를 호출할때는 반드시 순서가 중요함.
			}
		

		
		
		//타입이 똑같으면 문제가 생김. 이름을 똑같이 하는건 상관 없음.
		//매개변수의 타입, 숫자 등이 완전히 달라야 오버로딩 성립 가능. 오버로딩 = 재활용성
		Car(String model, String color) {
			//this.model = model;
			//this.color = color;
			this(model,color,350);	//여기서 this는 생성자를 뜻함. this.field/ this.method ->this만 붙여주면 생성자를 호출하는구나 하고 생각해주면 됨.
			//-> 동일한 형태의 생성자를 가진 인스턴스를 불러옴.
			//그래서 결국엔 밑의 Car에서 지정한 this 값들이 호출됨.
			}
			//이게 위의 값에 불러 들여감.
		Car(String model, String color, int maxSpeed) {
			this.model = model;
			this.color = color;
			this.maxSpeed = maxSpeed;
			}
}
