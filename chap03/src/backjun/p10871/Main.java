package backjun.p10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 스캐너로 입력값을 받아들여라
		Scanner scan = new Scanner(System.in);
		
		// n, x, num은 정수값임
		int n, x, num;
		int i=1;
		
		//n와 x에 대한 정수값을 입력 받는다
		n = scan.nextInt();
		x = scan.nextInt();
		
		
		// i값이 n값보다 작거나 같을때까지 반복
		do {
			//num값에 대한 정수값을 입력 받는다.
			num = scan.nextInt();
			//num값이 x값보다 작다면 num 을 출력하시오.
			if(num < x) {
				System.out.print(num+" ");
			}
			//반복문이 한번 씩 끝날 때 마다 i++을  하시오.
			i++;
		} while(i<=n);
	}
		
}
