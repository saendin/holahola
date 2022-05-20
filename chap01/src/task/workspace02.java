package task;

import java.util.Scanner;

public class workspace02 {

	
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	// 스캐너를 통해 입력값을 받으시오.
	
	String name, id, tel;
	//name, id, tel이라는 변수를 String으로 정의하시오
	
	System.out.print("[필수정보입력]");
	//[필수정보입력]을 출력하시오.

	
	System.out.println();
	
	
	System.out.print("1.이름:");
	// 1. 이름: 을 출력하시오.
	name = scanner.nextLine();
	// 입력된 id값을 스캐너로 받아내시오.
	
	System.out.print("2. 주민번호:");
	id = scanner.nextLine();
	//위와 동일
	
	
	System.out.print("3. 전화번호:");
	tel = scanner.nextLine();
	//위와 동일
	
	System.out.println();
	
	
	System.out.println("[입력한 내용]");
	System.out.println(name);
	System.out.println(id);
	System.out.println(tel);
	// 위의 내용을 각각 출력함~!
	
}
}
