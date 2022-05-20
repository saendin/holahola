package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhileTest1 {
	public static void main(String[] args) throws FileNotFoundException {
		// while1();
		// for1();
		// for2();
		// gugudan1();
		//findMin();
		//findMax();
		findMaxMin();
	}
	
	
	
	//최댓, 최솟값 구하기
	public static void findMaxMin() throws FileNotFoundException {
		//파일에서 입력 받을거임
		Scanner scan = new Scanner(new File("score.txt"));
		int max = scan.nextInt();
		int min = max;
		// 10번 반복
		for(int i=0; i<9; i++) {	//이미 변수부터 입력값을 한번 줬으므로 총 10번 반복하는거
			//파일에서 숫자를 읽어들임
			int num = scan.nextInt();
			// 파일에서 작은 수 보다 작으면 출력
			if (num > max) {
				max=num;
			}
			//파일에서 큰 수 보다 크면 출력
			if (num < min) {
				min=num;
			}
		}
		System.out.printf("최댓값= %d 최솟값= %d", max, min);
	}
	//최댓값
	public static void findMax() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));	// 스캐너로 숫자를 입력.
		int max = 0; 	// int max = scan.nextInt(); 일때는
		
		for (int i=0; i<9; i++) {		// 이미 입력된 값에서 시작하는것이므로 i를 하나 빼줌. (원래 10. 1빼서 9)
			int num = scan.nextInt();
			if (num > max) {
				max = num;		//큰 수 보다 크면 출력
			}
		}
		System.out.println("최댓값= " + max);	// 최댓값= 맥스를 출력

	}
	
	// 최솟값
	public static void findMin() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int min = 100;// 스캐너 - 숫자를 입력

		for (int i = 0; i<=10; i++) {		// 포문 - 10번 반복 (i=첫 시작값)
			//파일에서 숫자를 읽어들임
			int num = scan.nextInt();
			//작은수 보다 작으면 출력
			if (num < min) {
				min = num;
			}
		}
		System.out.println("최솟값= " + min);	// 최솟값= 민을 출력
	}

	// 바뀌는 i에 따라 5단 출력 = i는 1~9까지의 수이며 반복 할 때 마다 1씩 늘어난다.
	// 5단은 *5이므로 변하는 수 i에 대한 5단 곱셈을 출력하기 위해서는 5 * %d(i)
	public static void gugudan1() {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d= %d\n", dan, i, dan * i); // 5*2=10
		}
	}

	// 10~1 출력
	public static void for2() {
		for (int i = 10; i >= 1; i--) {
			System.out.println(i + "\t반복");
		}
	}

	// 1부터 10까지 반복 : for
	public static void for1() {
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i + "\t반복");
		}
	}

	// 1부터 10까지 반복
	public static void while1() {
		int count = 1;
		do {
			System.out.println(count);
			count++;
		} while (count <= 10);
	}
}