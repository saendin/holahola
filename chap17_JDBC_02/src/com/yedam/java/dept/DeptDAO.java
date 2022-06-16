package com.yedam.java.dept;

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

public class DeptDAO {
	private static DeptDAO deptDAO = null;

//싱글톤으로 만들기
	private DeptDAO() {
	}

//DeptDAO를 getInstance()해줬을 때만 리턴해주기
	public static DeptDAO getInstance() {
		if (deptDAO == null) { // deptDAO가 null일때 deptDAO 실행
			deptDAO = new DeptDAO(); // deptDAO 실행하기위해 새로운 객체 생성
		}
		return deptDAO; // null값이 아니면 deptDAO를 리턴하라
	}

//Oracle 연결 정보 미리 필드로 선언
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;

//각 메소드에서 공통적으로 사용할 필드 선언
	Connection connect;
	Statement stmt;
	PreparedStatement ppstmt;
	ResultSet rs;

	public void connect() {
		// 1. JDBC DRIVER 로딩
		dbConfing();
		try {
			Class.forName(jdbc_driver);
			connect = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("데이터를 연동하지 못했습니다.");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	// 2. DB서버 접속
	public void dbConfing() {
		// config/db.properties 파일에 있는 정보 가져오겠음
		String resource = "config/db.properties";
		// properties 객체 생성
		Properties properties = new Properties();

		try {
			// 실제로 존재하는 파일의 물리적 위치 가져오기. String filePath
			// 경로의 경로의 경로를 타고 가져옴. "." = ~에서
			String filePath = ClassLoader.getSystemClassLoader().getSystemResource(resource).getPath();

			properties.load(new FileInputStream(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 이 메소드로 오라클 정보 가져옴.
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");
	}

	// 4. 연동 해제하기 (필드에서 선언해줬던 것들)
	public void disconnect() {
		try {
			if (rs != null)
				rs.close(); // resultSet이 not null일 때 resultSet 종료
			if (stmt != null)
				stmt.close(); // statement가 not null일 때 statement 종료
			if (ppstmt != null)
				ppstmt.close();
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Department에 담긴 값들 selectAll에 담기
	public List<Department> selectAll() {
		List<Department> list = new ArrayList();
		try {
			connect(); // 연결부터 해주고

			// 정보 연동해서 담기
			stmt = connect.createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments ORDER BY department_id");
			while (rs.next()) {
				Department dept = new Department();

				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));

				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//단건 조회
	// Department클래스의 departmentId를 매개변수로 가지는 selectOne메소드
	public Department selectOne(int departmentId) {
		Department dept = null; //dept = null이다
		
		try {
			connect(); //연결부터
			String sql = "SELECT * FROM departments WHERE department_id =" + departmentId;
			stmt = connect.createStatement();
			rs = stmt.executeQuery(sql);
			//반환되는 값은 하나이므로 if문으로
			if(rs.next()) {	
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return dept;
	}
	
	//등록
	public void insert(Department dept) {
		try {
			connect();
			
			//sql에 다음 값 입력
			String sql = "INSERT INTO departments VALUES (?, ?, ?, ?)";
			ppstmt = connect.prepareStatement(sql);
			
			ppstmt.setInt(1, dept.getDepartmentId());
			ppstmt.setString(2, dept.getDepartmentName());
			ppstmt.setInt(3, dept.getManagerId());
			ppstmt.setInt(4, dept.getLocationId());
			
			int result = ppstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("등록 완료^ㅇ^");
			} else {
				System.out.println("등록 실패ㅜㅜ"); 
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//수정
	public void update(Department dept) {
		try {
			connect();
			
			String sql = "UPDATE departments SET location_id = ? WHERE department_id = ?";
			ppstmt = connect.prepareStatement(sql);
			
			ppstmt.setInt(1, dept.getLocationId());
			ppstmt.setInt(2, dept.getDepartmentId());
			
			int result = ppstmt.executeUpdate();
				if(result >0) {
					System.out.println("수정 완료^ㅇ^");
				} else {
					System.out.println("수정 실패ㅜㅜ"); 
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departments WHERE department_id =" + departmentId;
			ppstmt = connect.prepareStatement(sql);
			
			int result = ppstmt.executeUpdate();
				if(result >0) {
					System.out.println("삭제 완료^ㅇ^");
				} else {
					System.out.println("삭제 실패ㅜㅜ"); 
				}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
}
