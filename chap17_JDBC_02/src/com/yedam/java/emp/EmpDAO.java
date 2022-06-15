package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDAO {
	// 가능한 싱글톤으로 만들기
	// 1. 교재 p.280의 싱글톤 코드는 호출되는 DAO가 사용 될 때도 있고 안될때도 있는데, 이건 호출되는 순간에 new연산자가 새로은
	// 객체를 생성해놓음. -> 메모리가 할당되어 있는 상태 유지.
	// -> 즉 데이터 양이 방대해질수록 그 테이블에 따른 DAO가 계속 생성 -> 많은 메모리 차지 그래서 (3.에서 계속)
	private static EmpDAO empDAO = null;

	private EmpDAO() {
	} // 2.empDAO가

	public static EmpDAO getInstance() { // 3. public static EmpDAO getInstance()를 생성했을때만
		if (empDAO == null) {
			empDAO = new EmpDAO(); // 4. (empDAO를)실행됨. = 새로운 객체를 생성 하도록 코드 짠 것.
		}
		return empDAO;
	}

	// Oracle 연결 정보
	String jdbc_driver; // 이 언더바들은 꼭 써야하는건 아니고 관례적으로 쓰는 것. jdbc_driver로 써도 됨.
	String oracle_url;
	String connectedId;
	String connectedPwd;

	// 각 메소드에서 공통적으로 사용하는 필드 존재
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		// 1. JDBC Driver 로딩하기
		dbConfig();
		try {
			Class.forName(jdbc_driver);
			// 2. DB 서버 접속하기 --가 하나의 메소드가 될 것
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	public void dbConfig() { // Properties라는 파일로 별도 관리
		String resource = "config/db.properties"; // config/db.properties 파일에 있는 정보 가져오겠다.
		Properties properties = new Properties(); // properties 객체 생성

		try {
			String filePath // filePath가 진짜 물리적 파일 위치를 가져옴. 그리고 FileInputStream으로 접근
					= ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath)); // properties가 읽어들이면 기본틀을 가진 값을 알아서 읽어냄.
															// 경로가 정확하지 않다면 ClassLoader.getSystemClassLoader()를 통해서 경로
															// 찾고 아니라면 new FileInputStream(filePath) <-이렇게 직접 넣어줘도 됨.
		} catch (IOException e) {
			e.printStackTrace(); // 오류가 있다면 어떤 오류인지 표시해주는 것
		}
		// 이 메소드로 오라클 정보 가져올 수 있음.
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");

	}

	// 4. 자원 해제하기 -- 별도의 메소드로 구성
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. CRUD 실행 -- 각각의 메소드로 구성
	// 전체조회
	// 각각의 기능에 따라 리턴되는 타입 적절히 써주기
	// 다양한 값이 나올거니까 list 형태로
	public List<Employee> selectAll() { // list<employee>값 가지는 selectAll 메소드 정의
		List<Employee> list = new ArrayList<>(); // 참조변수가 list인 employee정보들 담긴 새로운 객체 생성
		try {
			connect(); // DB와 연결

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees ORDER BY employee_id");
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id")); // rs.getInt("department_id")이 괄호 안에 있는 이름은 DB의 컬럼명과
																	// 같아야 함.(언더바 주의)

				list.add(emp); // add해서 list에 emp담아줌
								// add로 연결해주지 않으면 list에 안담김
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 끊어주고 리스트 반환
			disconnect(); // DB와 연결 끊어주기. 안해줘도 return이 있어 끊기긴 할테지만, 혹시 모르니까 해주는것. 혹시라도 만약에 디스커넥트가 되지 않으면
							// 여러 사용자 접속시에 무한 대기 루프가 걸릴 수 있음.
		}
		return list; // return은 반환해준다는 의미도 있지만 동시에 그 구문을 끝낸다는 것을 의미한다. 고로 disconnect를 return전에 넣어줘야
						// 작동하는 것이다.

	}

	// 단건조회
	public Employee selectOne(int employeeId) { // Employee클래스의 employeeID를 매개변수로 가지는 selectOne메소드 만들기
		Employee emp = null; // 정보가 없으면 null로 반환하시오.
		try {
			String sql = "SELECT * FROM employees WHERE employee_id =" + employeeId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) { // 반환되는 값이 하나여야 하므로 보통 If문 처리
				emp = new Employee(); // emp 값이 있을 때 객체 생성
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return emp;
	}

	// 등록
	public void insert(Employee emp) { // 매개변수로 employee 보호 객체를 받고 리턴값 없으므로 보이드
		try {
			connect();// db연결

			// sql에 다음의 값들 입력
			String sql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());// first_name
			pstmt.setString(3, emp.getLastName());// last_name
			pstmt.setString(4, emp.getEmail());// email
			pstmt.setString(5, emp.getPhoneNumber());// phoneNum
			pstmt.setDate(6, emp.getHireDate());// 생일
			pstmt.setString(7, emp.getJobId());// 직함
			pstmt.setDouble(8, emp.getSalary());// 연봉
			pstmt.setDouble(9, emp.getCommissionPct());// 커미션
			pstmt.setInt(10, emp.getManagerId());// 매니저아이디
			pstmt.setInt(11, emp.getDepartmentId());// 부서번호

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("등록이 완료되었습니다 ^ㅇ^");
			} else {
				System.out.println("등록이 되지않았읍니다 ㅜ ㅜ"); // 등록이 되었는지 명확히 알 수 있도록 sysout
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void update(Employee emp) {
		try {
		connect();//db연결
		String sql = "UPDATE employees SET salary = ? WEHRE employee_id = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(2,  emp.getEmployeeId());
		pstmt.setDouble(1, emp.getSalary());
		
		int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("등록이 완료되었습니다 ^ㅇ^");
				} else {
					System.out.println("등록이 되지않았읍니다 ㅜ ㅜ"); //등록이 되었는지 명확히 알 수 있도록 sysout
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 삭제
	public void delete(int employeeId) {
		try {
			connect();//db연결
			String sql = "DELETE FROM employees WEHRE employee_id =" + employeeId;
			pstmt = conn.prepareStatement(sql);

			int result = pstmt.executeUpdate();
					if(result > 0) {
						System.out.println("삭제 되었습니다 ^ㅇ^");
					} else {
						System.out.println("삭제에 실패했습니다 ㅜ ㅜ"); //등록이 되었는지 명확히 알 수 있도록 sysout
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
}