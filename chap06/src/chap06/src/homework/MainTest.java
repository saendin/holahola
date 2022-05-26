package chap06.src.homework;

import java.util.Scanner;
//"1.학생수 입력 2.학생점수 등록 3.학생점수 전체조회 4.학생정보분석 5.종료"
public class MainTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		GetScores getScores = new GetScores();
		
		while (run) {
			System.out.println("1.학생 수 입력 | 2.학생점수 등록 | 3.학생점수 전체조회 | 4.학생정보분석 | 5.종료 ");
			System.out.print("번호를 선택하세요> ");
			
			System.out.println();
			
			int select = Integer.parseInt(scan.nextLine());
			
			//학생 수 입력
			if (select == 1) {
				System.out.print("학생 수> ");
				int student = Integer.parseInt(scan.nextLine());
				getScores.setNum(student);
				
				System.out.println();
				
			//수에 따른 학생 점수 등록
			} else if (select == 2){
				System.out.println("학생 점수 등록> ");
				int score = Integer.parseInt(scan.nextLine());
				getScores.setScores(score);
			
				System.out.println();
				
			//점수 리스트 출력	
			} else if (select == 3) {
				getScores.scoresList();
				
				System.out.println();
				
			//학생 정보 분석
			} else if (select == 4) {
				getScores.Result();
				
			//프로그램 종료
			} else if (select == 5) {
				run = false;
				System.out.println("프로그램을 종료합니다.");
			}
		}
			
		System.out.println();
			
		
		
		
	}

}
