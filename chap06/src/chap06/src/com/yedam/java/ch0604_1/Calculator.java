package chap06.src.com.yedam.java.ch0604_1;

import java.util.Scanner;

public class Calculator {
	// 1. 갯수 입력
	// 2. 숫자 입력
	// 3. 더하기
	// 4. 빼기
	// 5. 곱하기
	// 6. 나누기
	int[] numList;
	int index;

	Scanner scan = new Scanner(System.in);

	Calculator() {
		index = -1; // 실제 배열의 크기보다 내가 입력한 값이 작을 수 있으니 index를 정의해줌.
					// 실제 가진 크기보다 1개가 작음.(= -1)
	}

	// 1. 갯수입력
	void setArraySize(int size) {
		numList = new int[size];
	}

	// 2. 숫자입력
	void setNum(int num) {
		if ((index+1) > numList.length) {
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더이상 입력할 수 없습니다.");
		}
	}

	// 3. 더하기
	void plus() {
		if (isExecuted()) {
			int sum = 0;
			for (int i = 0; i <= index; i++) {
				sum += numList[i];
			}
			System.out.println("모두 더한 결과 : " + sum);
		}
	}

	// 4. 빼기
	void substract() {
		if (isExecuted()) {
			int minus = numList[0];
			for (int i = 1; i <= index; i++) {
				minus -= numList[i];
			}
			System.out.println("모두 뺀 결과 : " + minus);
		}
	}

	// 5. 곱하기
	void multiply() {
		if (isExecuted()) {
			int multi = numList[0];
			for (int i = 1; i <= index; i++) {
				multi *= numList[i];
			}
			System.out.println("모두 곱한 결과 : " + multi);
		}
	}

	// 6. 나누기
	void divide() {
		if (isExecuted()) {
			double div = (double) numList[0];
			for (int i = 1; i <= index; i++) {
				div /= numList[i];
			}
			System.out.printf("모두 나눈 결과 : %.2f", div);
		}
	}

	// 0. 조건 체크
	boolean isExecuted() { // 배열의 크기만큼은 아니더라도 isExecuted가 2개 이상인가를 체크해줘야함.
							// 모든 연산은 최소 수가 두개는 되어야 하므로.
		if ((index + 1) >= 2) {
			return true;
		} else {
			System.out.println("숫자를 더 입력해주세요.");
			return false; // boolean은 return값을 true & false로 각각 줘야함
		}
	}

}
