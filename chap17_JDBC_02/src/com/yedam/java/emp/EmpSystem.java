package com.yedam.java.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpSystem {
	private EmpDAO dao = EmpDAO.getInstance();
	private Scanner sc = new Scanner(System.in); // 입력받을 스캐너 생성

	public EmpSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();

			// 메뉴 입력
			int menuNo = selectMenu();

			// 각 기능별 실행 (각 메소드들이 어떤 기능에 대해 묻고있는지 코드 이름 명확히 하는 것이 좋음)
			if (menuNo == 1) {
				// 등록
				insertEmployee();
			} else if (menuNo == 2) {
				// 수정
				updateEmployee();
			} else if (menuNo == 3) {
				// 삭제
				deleteEmployee();
			} else if (menuNo == 4) {
				// 단건조회(사원 조회)
				selectEmployee();
			} else if (menuNo == 5) {
				// 전체조회
				selectAllEmployee();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				inputError();
			}
		}
	}
	//어느정도 구성해놓고 만들어야 놓치는 일이 없음.
	//주석으로 구성 짜놓고 하기. 메소드 만들어놓고 짜기 등 방법은 여러가지
	//간단한거부터 먼저 만들기
	
	//메뉴형식
	private void menuPrint() {
		System.out.println("===========================================");
		System.out.println("1.등록  2.수정  3.삭제  4.사원조회  5.전체조회  9.종료");
		System.out.println("===========================================");
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
	
	
	//사원 입력 메소드
	private void insertEmployee() {
		//사원정보 입력
		Employee emp = inputAll(); //employee타입으로 전달 받을 거임
		
		//입력 받은 것 DB에 전달
		dao.insert(emp); //insert로 정보 받아줌.
	}
	//업데이트 되는 정보 입력
	private void updateEmployee() {
		//수정하는 정보 입력
		Employee emp = inputUpdateInfo();
		//DB에 전달
		dao.update(emp);
	}
	
	
	//정보 삭제하기
	private void deleteEmployee() {
		//사원 번호 입력
		int employeeId = inputEmployeeId(); //넘겨받은 정보 지우면 됨
		
		//DB에 전달
		dao.delete(employeeId); //delete로 지우기
	}
	
	
	//사원 한명 조회 메소드
	private void selectEmployee() {
		//사원번호 입력
		int employeeId = inputEmployeeId();
				
		//DB검색
		Employee emp = dao.selectOne(employeeId);
		
		//결과 출력
		if(emp != null) {
			System.out.println(emp);
		}else {
			System.out.println("원하는 정보가 존재하지 않습니다."); //널 값일 때 원하는 정보가 없다라고 알려주기
		}
	}
	
	
	//사원 전체조회 메소드
	private void selectAllEmployee() {
		List<Employee> list = dao.selectAll(); //Employee의 list배열 값들 불러오기 -> 들어있는 임플로이 전체 값 로딩
		
		for(Employee emp : list) {	//내용이 있는것만 전부 출력하기
			System.out.println(emp);
		}
	}
	
	
	//사원 정보 입력받기 메소드
	private Employee inputAll() {
		Employee emp = new Employee(); //임플로이에서 불러온 정보를 사용하기 위해 새로운 객체 생성
		
		//set으로 정보 삽임 (형태변환 주의)
		System.out.println("사번>> ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		
		System.out.println("이름>> ");
		emp.setFirstName(sc.nextLine());
		
		System.out.println("성>> ");
		emp.setLastName(sc.nextLine());
		
		System.out.println("이메일>> ");
		emp.setEmail(sc.nextLine());
		
		System.out.println("전화번호>> ");
		emp.setPhoneNumber(sc.nextLine());
		
		System.out.println("입사일(YYYY-MM-DD)>> ");
		emp.setHireDate(Date.valueOf(sc.nextLine())); //정확한 데이트 타입(YYYY-MM-DD)으로 맞춰줘야됨. 스캐너는 그 기능이 없어소
		
		System.out.println("직급>> ");
		emp.setJobId(sc.nextLine());
		
		System.out.println("연봉>> ");
		emp.setSalary(Integer.parseInt(sc.nextLine()));
		
		System.out.println("상여>> ");
		emp.setCommissionPct(Double.parseDouble(sc.nextLine()));
		
		System.out.println("상사>> ");
		emp.setManagerId(Integer.parseInt(sc.nextLine()));
		
		System.out.println("부서>> ");
		emp.setDepartmentId(Integer.parseInt(sc.nextLine()));
		
		return emp;
	}
	
	
	//업데이트 하고자 하는 정보만 받기 메소드
	private Employee inputUpdateInfo() {
		Employee emp = new Employee();
		
		System.out.println("사번>> ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.println("연봉>> ");
		emp.setSalary(Integer.parseInt(sc.nextLine()));
		return emp;
	}
	
	
	//사번 받기 메소드
	private int inputEmployeeId() {
		System.out.println("사번>> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	
	
}