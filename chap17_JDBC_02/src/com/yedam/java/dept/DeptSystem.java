package com.yedam.java.dept;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp.Employee;

public class DeptSystem {
	private DeptDAO dao = DeptDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public DeptSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();

			// 메뉴 입력
			int menuNo = selectMenu();

			// 각 기능별 실행 (각 메소드들이 어떤 기능에 대해 묻고있는지 코드 이름 명확히 하는 것이 좋음)
			if (menuNo == 1) {
				// 등록
				insertDepartment();
			} else if (menuNo == 2) {
				// 수정
				updateDepartment();
			} else if (menuNo == 3) {
				// 삭제
				deleteDepartment();
			} else if (menuNo == 4) {
				// 단건조회(사원 조회)
				selectDepartment();
			} else if (menuNo == 5) {
				// 전체조회
				selectAllDepartment();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				inputError();
			}
		}
	}
	
	//메뉴형식
		private void menuPrint() {
			System.out.println("============================================");
			System.out.println("1.등록  2.수정  3.삭제  4.부서조회  5.전체조회  9.종료");
			System.out.println("============================================");
		}
		//메뉴선택
		private int selectMenu() {
			int menu = 0;
			try {
				menu = Integer.parseInt(sc.nextLine()); 
				
			}catch(NumberFormatException e) {	// 메뉴에 숫자가 아닌값을 입력하면 NumberFormatException로 catch문 아래의 것이 뜰고임. -> 다시 try문의 입력받는 곳으로 돌아가게끔 만들 것
				System.out.println("숫자를 입력해주십쇼");
			}
			return menu;
		}
		//종료시 문구 출력
		private void exit() {
			System.out.println("프로그램을 종료합니다.");
		}
		//잘못된 숫자 입력했을 때
		private void inputError() {
			System.out.println("메뉴에 맞게 입력해주십셔");
		}
		
		
		//브서 입력 메소드
		private void insertDepartment() {
			//사원정보 입력
			Department dept = inputAll(); //employee타입으로 전달 받을 거임
			
			//입력 받은 것 DB에 전달
			dao.insert(dept); //insert로 정보 받아줌.
		}
		//업데이트 되는 정보 입력
		private void updateDepartment() {
			//수정하는 정보 입력
			Department dept = inputUpdateInfo();
			//DB에 전달
			dao.update(dept);
		}
		
		//정보 삭제하기
		private void deleteDepartment() {
			//사원 번호 입력
			int departmentId = inputDepartmentId(); //넘겨받은 정보 지우면 됨
			
			//DB에 전달
			dao.delete(departmentId); //delete로 지우기
		}
		
		
		//사원 한명 조회 메소드
		private void selectDepartment() {
			//사원번호 입력
			int departmentId = inputDepartmentId();
					
			//DB검색
			Department dept = dao.selectOne(departmentId);
			
			//결과 출력
			if(dept != null) {
				System.out.println(dept);
			}else {
				System.out.println("원하는 정보가 존재하지 않습니다."); //널 값일 때 원하는 정보가 없다라고 알려주기
			}
		}
		
		//사원 전체조회 메소드
		private void selectAllDepartment() {
			List<Department> list = dao.selectAll(); //Employee의 list배열 값들 불러오기 -> 들어있는 임플로이 전체 값 로딩
			
			for(Department dept : list) {	//내용이 있는것만 전부 출력하기
				System.out.println(dept);
			}
		}
		
		//부서 정보 입력받기 메소드
		private Department inputAll() {
			Department dept = new Department(); //임플로이에서 불러온 정보를 사용하기 위해 새로운 객체 생성
			
			//set으로 정보 삽임 (형태변환 주의)
			System.out.println("부서번호>> ");
			dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
			
			System.out.println("부서이름>> ");
			dept.setDepartmentName(sc.nextLine());
			
			System.out.println("매니저번호>> ");
			dept.setManagerId(Integer.parseInt(sc.nextLine()));
			
			System.out.println("위치정보>> ");
			dept.setLocationId(Integer.parseInt(sc.nextLine()));
			
			return dept;
		}
		
		//업데이트 하고자 하는 정보만 받기 메소드
		private Department inputUpdateInfo() {
			Department dept = new Department();
			
			System.out.println("부서번호>> ");
			dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
			System.out.println("위치>> ");
			dept.setLocationId(Integer.parseInt(sc.nextLine()));
			return dept;
		}
		
		
		//사번 받기 메소드
		private int inputDepartmentId() {
			System.out.println("부서번호>> ");
			return Integer.parseInt(sc.nextLine());
		}
	
	
	
}
