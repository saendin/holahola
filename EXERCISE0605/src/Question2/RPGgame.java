package Question2;
/*
2) RPGgame 클래스를 정의한다.
- Keypad를 구현하는 클래스.
c
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
*/

//- Keypad를 구현하는 클래스.
public class RPGgame implements Keypad {
	// 필드 - 현재 모드를 값으로 가지는 필드를 가지며
	int mode = 0;

	// 생성자 - 생성자를 이용하여 값을 초기화한후 "RPGgame 실행"을 출력한다.
	// ( 단, 매개변수를 이용하지 않으며 최초의 값은 NORMAL_MODE 이다.
	RPGgame() {
		mode = NORMAL_MODE;
		System.out.println("RPGgame 실행");
	}

	// Keypad 인터페이스에 정의된 추상 메서드를 다음과 같이 오버라이딩한다.
	// : "캐릭터가 위쪽으로 이동한다"를 출력한다.
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다");
	}

	// : "캐릭터가 아래쪽으로 이동한다"를 출력한다.
	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다");
	}

	
	// - NORMAL_MODE 일경우 : "캐릭터가 한칸단위로 점프한다."를 출력한다.
	// - HARD_MODE 일경우 : "캐릭터가 두칸단위로 점프한다."를 출력한다.
	@Override
	public void rightUpButton() {
		if (mode == 0) {
			System.out.println("캐릭터가 한칸단위로 점프한다");
		} else if (mode == 1) {
			System.out.println("캐릭터가 두칸 단위로 점프한다");
		}

	}

	// - NORMAL_MODE 일경우 : "캐릭터가 일반 공격."를 출력한다.
	// - HARD_MODE 일경우 : "캐릭터가 HIT 공격."를 출력한다.
	@Override
	public void rightDownButton() {
		if (mode == 0) {
			System.out.println("캐릭터가 일반 공격");
		} else if (mode == 1) {
			System.out.println("캐릭터가 HIT 공격");
		}
	}

	// 모드를 바꾸고 현재 모드를 출력하는 기능
	// ( 예를 들어, NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	@Override
	public void changeMode() {
		if (mode == 0) {
			mode = 1;
			System.out.println("현재 모드 : HARD_MODE");
		} else if (mode == 1) {
			mode = 0;
			System.out.println("현재 모드 : NORMAL_MODE");
		}
	}
}
