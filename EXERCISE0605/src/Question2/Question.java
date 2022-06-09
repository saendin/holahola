package Question2;

public class Question {
/*
 * Question 2]
	1) Keypad 인터페이스를 정의한다.	//인터페이스 : 그냥 설명서일 뿐. 기능 전혀 없음. 상속은 부모클래스가 기능이 있음. 그게 차이점
	- 다음과 같이 상수 필드를 정의한다. 
	(1) public static final int NORMAL_MODE = 0;	//public(패키지 호환 가능), static(전체에서 사용 가능하도록 허용하겠다)
	(2) public static final int HARD_MODE = 1;	// 그냥 이렇게 사용할거다 정도의 설명만 가질뿐.
	- 다음과 같이 추상 메서드를 정의한다.	// interface - implements

	(1) public abstract void leftUpButton() : 왼쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	(2) public abstract void leftDownButton() : 왼쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	(3) public abstract void rightUpButton() : 오른쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	(4) public abstract void rightDownButton() : 오른쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	(5) public abstract void changeMode() : 모드를 바꾸고 현재 모드를 출력하는 기능 ( 예를 들어, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	


	2) RPGgame 클래스를 정의한다.
	- Keypad를 구현하는 클래스.
	- 현재 모드를 값으로 가지는 필드를 가지며 생성자를 이용하여 값을 초기화한후 "RPGgmae 실행"을 출력한다.
	  ( 단, 매개변수를 이용하지 않으며 최초의 값은 NORMAL_MODE 이다. )
	//
	int mod;
	RPG() {			// 빈 ()가 매개변수가 따로 없다는 뜻. 즉 같은 이름으로 다른 매개변수가 들어가는 생성자를 여러개 생성 가능하단 뜻.
		mod = 0;}
	//

	- Keypad 인터페이스에 정의된 추상 메서드를 다음과 같이 오버라이딩한다.



	(1) public abstract void leftUpButton() : "캐릭터가 위쪽으로 이동한다"를 출력한다.
	(2) public abstract void leftDownButton() : "캐릭터가 아래쪽으로 이동한다"를 출력한다.
	(3) public abstract void rightUpButton()
		- NORMAL_MODE 일경우 : "캐릭터가 한칸단위로 점프한다."를 출력한다.
		- HARD_MODE 일경우 : "캐릭터가 두칸단위로 점프한다."를 출력한다.
	(4) public abstract void rightDownButton()
		- NORMAL_MODE 일경우 : "캐릭터가 일반 공격."를 출력한다.
		- HARD_MODE 일경우 : "캐릭터가 HIT 공격."를 출력한다.
	(5) public abstract void changeMode() : 모드를 바꾸고 현재 모드를 출력하는 기능 ( 예를 들어, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	
	3) ArcadeGame 클래스를 정의한다.
	- Keypad를 구현하는 클래스.
	- 현재 모드를 값으로 가지는 필드를 가지며 생성자를 이용하여 값을 초기화한후 "ArcadeGame 실행"을 출력한다.
	  ( 단, 매개변수를 이용하지 않으며 최초의 값은 NORMAL_MODE 이다. )
	- Keypad 인터페이스에 정의된 추상 메서드를 다음과 같이 오버라이딩한다.
	(1) public abstract void leftUpButton() : "캐릭터가 앞쪽으로 이동한다"를 출력한다.
	(2) public abstract void leftDownButton() : "캐릭터가 뒤쪽으로 이동한다"를 출력한다.
	(3) public abstract void rightUpButton()
		- NORMAL_MODE 일경우 : "캐릭터가 일반 공격"를 출력한다.
		- HARD_MODE 일경우 : "캐릭터가 연속 공격"를 출력한다.
	(4) public abstract void rightDownButton()
		- NORMAL_MODE 일경우 : "캐릭터가 HIT 공격."를 출력한다.
		- HARD_MODE 일경우 : "캐릭터가 Double HIT 공격."를 출력한다.
	(5) public abstract void changeMode() : 모드를 바꾸고 현재 모드를 출력하는 기능 ( 예를 들어, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	
	4)  아래와 같은 출력결과가 나오도록 실행코드를 구현한다.
	- 출력결과
		RPGgame 실행
		캐릭터가 위쪽으로 이동한다.
		캐릭터가 한칸단위로 점프한다.
		현재 모드 : HARD_MODE
		캐릭터가 두칸단위로 점프한다.
		캐릭터가 HIT 공격.
		캐릭터가 아래쪽으로 이동한다.
		현재 모드 : NORMAL_MODE
		캐릭터가 일반 공격.
		======================
		ArcadeGame 실행
		캐릭터가 앞쪽으로 이동한다.
		캐릭터가 일반 공격
		캐릭터가 뒤쪽으로 이동한다.
		현재 모드 : HARD_MODE
		캐릭터가 연속 공격.
		캐릭터가 앞쪽으로 이동한다.
		캐릭터가 Double HIT 공격.
			
 */
}
