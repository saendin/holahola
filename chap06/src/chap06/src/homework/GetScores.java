package chap06.src.homework;

import java.util.Scanner;

/* 문제1) 등록기능 구현
 *    - "1.학생수 입력 2.학생점수 등록 3.학생점수 전체조회 4.학생정보분석 5.종료"
 *	  - 입력받은 학생 수에 등록할 수 있는 학생점수 수가 정해지도록 구현하세요.
 *    - 아래를 참조해서 각 학생의 점수를 입력하세요.
 *         1) 점수 : 100점
 *         2) 점수 : 73점
 *         3) 점수 : 92점
 *         4) 점수 : 65점
 *         5) 점수 : 86점
 * 문제2) 전체조회 구현
 *    - 저장된 점수를 입력 순으로 모두 출력하세요.
 * 문제3) 분석기능 구현
 *    - 점수 중 각 최고점과 최저점에 도달하는 점수를 출력하세요.
 *    - 점수 중 최고점과 최저점을 제외한 점수에 해당하는 점수들에 대한 평균점수(소수점 이하 두자리)를 구해 출력하세요.
 *           printf(%.2f)
 *   		-> 최고점과 최저점 먼저 구하기
 *    		-> 최고점과 최저점 제외한 나머지 점수들의 평균 구하기
 */
public class GetScores {

	// 필드
	int[] scores;
	int index;
	int min;
	int max;
	int avg;
	int sum = 0;

	// 생성자
	GetScores() {
		index = -1;
	}

	// 메소드
	// 1. 학생 수 입력받기(for 배열 초기화)
	// void = 단순한 수 출력
	// 외부에서 학생 몇 명 입력받을지 넘겨받음.
	void setNum(int student) {
		// 점수는 학생 수 만큼 생성
		this.scores = new int[student];
	}

	// 2. 점수 등록(입력)
	void setScores(int score) {
		this.scores[++index] = score;
		// index값이 -1에서 시작하니까 ++해서 0부터 시작하도록 세팅
	}

	// 3. 학생 점수 전체 조회
	// 단순 배열 선언
	void scoresList() {
		// i는 무조건 0부터 시작하고 점수의 갯수가 i보다 커지면 종료한다
		// = 점수 갯수만큼 반복->출력 점수[]> [] 점
		for (int i = 0; i <= index; i++) {
			System.out.println("점수[" + i + "]>" + scores[i] + " 점");
		}
	}

	// 4. 분석기능
	// 4-1. 최고점 구하기
	int getMaxScore() {
		int max = scores[0]; // max는 scores[]의 0값부터 시작
		for (int i = 1; i <= index; i++) { // 점수의 갯수만큼 반복
			int overnum = scores[index]; // temp의 값은 점수값 중 하나와 같다.(+조건을 위한 큰 그림)
			if (max < overnum) { // 언제일때? -> max보다 크면, temp=max다
				max = overnum;
			}
		}
		return max; // max 값을 반환하시오

	}

	// 4-2. 최저점 구하기
	int getMinScore() {
		int min = scores[0];
		for (int i = 1; i <= index; i++) {
			int minornum = scores[i];
			if (min > minornum) {
				min = minornum;
			}
		}
		return min; // min 값을 반환하시오

	}

	// 4-3. 평균점수
	// 최고점과 최저점을 제외, 나머지 점수들의 평균점수를 구하기
	// 최저점<나머지점수<최고점 = 나머지점수가 최저점보다 크고 최고점보다 작을때 합산해서 나누기.
	// 나머지 점수 = 전체 - min - max = 전체 수 -2
	// (소수점 이하 두자리까지만 표시)
	double getAvgScore() {
		min = getMinScore();
		max = getMaxScore();
		for (int i = 0; i <= index; i++) {
			// 누적 식 : sum = sum + scores[ ]
			sum += scores[i];
		}

		// if (min < score && score < max) {
		// avg = (sum - max - min) / (index-1);
		// }

		avg = (sum - max - min) / (index - 1);
		return avg;
	}

	// 4-4. 분석
	void Result() {
		System.out.println("최고 점수 : " + getMaxScore());
		System.out.println("최저 점수 : " + getMinScore());
		System.out.printf("평균 점수 : %.2f\n", getAvgScore());
	}
}
