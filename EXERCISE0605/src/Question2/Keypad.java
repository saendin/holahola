package Question2;
/*
1) Keypad 인터페이스를 정의한다.
- 다음과 같이 상수 필드를 정의한다. 
(1) public static final int NORMAL_MODE = 0;	//public(패키지 호환 가능), static(전체에서 사용 가능하도록 허용하겠다)
(2) public static final int HARD_MODE = 1;	// 그냥 이렇게 사용할거다 정도의 설명만 가질뿐.

- 다음과 같이 추상 메서드를 정의한다.	// interface - implements
(1) public abstract void leftUpButton() : 왼쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
(2) public abstract void leftDownButton() : 왼쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
(3) public abstract void rightUpButton() : 오른쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
(4) public abstract void rightDownButton() : 오른쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
(5) public abstract void changeMode() : 모드를 바꾸고 현재 모드를 출력하는 기능 ( 예를 들어, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
*/
//인터페이스 : 그냥 설명서일 뿐. 기능 전혀 없음. 상속은 부모클래스가 기능이 있음. 그게 차이점

public interface Keypad {
	//필드 - 다음과 같이 상수 필드를 정의한다. 
	public static final int NORMAL_MODE = 0;	//public(패키지 호환 가능), static(전체에서 사용 가능하도록 허용하겠다)
	public static final int HARD_MODE = 1;		// 그냥 이렇게 사용할거다 정도의 설명만 가질뿐.
	
	
	//메소드 - 다음과 같이 추상 메서드를 정의한다.
	public abstract void leftUpButton(); 	// : 왼쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void leftDownButton(); 	// : 왼쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void rightUpButton(); 	// : 오른쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void rightDownButton(); // : 오른쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void changeMode(); 		// : 모드를 바꾸고 현재 모드를 출력하는 기능 ( 예를 들어, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)

	
}
