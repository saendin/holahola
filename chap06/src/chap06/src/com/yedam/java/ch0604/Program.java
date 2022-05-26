package chap06.src.com.yedam.java.ch0604;

import java.util.Scanner;
//클래스 하나 만들어서 가진 기능이 뭔지 쭉 적어보기.
// 점수값을 저장하는 필드가 필요함.
// 1. 학생 수 입력
// 2. 점수 입력
// 3. 점수 리스트 출력
// 4. 분석 - 최고점수, 평균점수
// 5. 종료

public class Program {

	Scanner scanner = new Scanner(System.in);
	
	// 필드
	int[] scores;
	int index;
	
	// 생성자
	Program() {
		index = -1;
		
	}
	// 메소드
	// 1. 학생 수(for 배열 초기화)
	//void = 단순한 수 출력
	void setStudentNum (int student) {
		//외부에서 학생 몇 명 입력받을지 넘겨받음. 굳이 숫자가 아니어도 충분
		scores = new int[student];
	}
	
	// 2. 점수 입력
	void setStudentScore(int score) {	
		scores[++index] = score; 
		//단순히 이렇게만 적으면 score의 값이 몇개나 들어와 있는지 알 수 없음
		//-> int index;줌 ( index값을 초기화 = index -1값 주고 ++해서 0부터 시작되도록.)
		
	}
	// 3. 점수 리스트 출력(단순한 배열 선언)
	void printScores() {
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "]>" + scores[i]);
		}
	}
	// 4-1. 최고점수
		//최고점수. 점수들 중 가장 높은점수. 입력된 값 중 
	int getMaxScore() {
		int max = scores[0];	//max는 score 0값부터 시작
		for (int i=1; i<scores.length; i++) {	// 점수 갯수만큼 반복
			int temp = scores[i];	//temp값은 점수값과 같은데, 점수값 중 하나와 같다.
			if(max < temp) {	//그 점수값 구하는 법.
								// 만약에 temp가 max보다 크다면
				max = temp; 	// 그 값이 max가 됨.
			}
		}
		return max;				//=break; = 그 값이 곧 맥스값~
	}
			


// 4-2. 평균점수
	double getAvgScore() {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {//누적. 제일 많이 씀.		
			sum += scores[i];				//sum = sum + scores{i];
		}
		return (double)sum / scores.length; //변수만 반환시키는게 아니고 연산식도 가능~
											//sum, scores.length 둘 다 int값임. -> double로 강제형전환 필요
	}

// 4-3. 분석
	 void printResult() {
		 System.out.println("최고 점수 : " + getMaxScore());
		 System.out.println("평균 점수 : " + getAvgScore());
	 }
}