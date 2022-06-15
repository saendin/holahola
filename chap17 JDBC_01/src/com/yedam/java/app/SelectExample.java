package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {
	//JDBC DB 연동하기
	public static void main(String[] args) throws Exception {
		//1. JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		//2. DB 서버에 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//getConnection()을 사용해주기 위해 디비에 대한 정보설정 (경로, 아이디, 패스워드)
		String id = "hr";
		String pwd = "hr";
		Connection con = DriverManager.getConnection(url,id,pwd); //직접적으로 변수 선언하지 않고 DriverManager 활용 -> getConnection()이용해 디비랑 연결 됨.
		
		
		//3. Statement of PreparedStatement 객체 생성하기
		//작동할  Statement of PreparedStatement를 만들어 낼 것
		
		//new연산자 기반이 아닌 동작하는 Connection을 이용해서 Statement만들기
		Statement stmt = con.createStatement(); //import java.sql.Statement;
		
		
		//4. Query 구성
//		String sql = "SELECT * FROM employees WHERE last_name = 'King'"; //동작시킬 SQL문 그대로 써주면 됨.(세미콜론은 안씀에 주의!)
		String sql = "SELECT * FROM employees WHERE salary>6000";
		
		//5. Query 실행
		ResultSet rs = stmt.executeQuery(sql);//DB에서 처리한 결과 값 받기 (SELECT문은 ResultSet으로 결과 값 받음)
											  //stmt.executeQuery(sql) -> 실행하고자 하는 sql문을 executeQuery에 넣어줌.
											  //간단한거 써줄때만 stmt써주고 insert같이 복잡한고 할때는 쓰기 어려움.
		
		
		
		//6. 그에 따른 결과 값 출력
//		while(rs.next()) {	//총 크기를 알 수 없어서 while문 돌림
//			String name = rs.getString("first_name") + " " + rs.getString("last_name");	//행 안의 데이터 가져올 때 "get+반환하는 타입" 을 씀.("")안에는 컬럼명 그대로 써줘야 함.
//			System.out.println(name);
//		}
		
		
		while(rs.next()) {	//총 크기를 알 수 없어서 while문 돌림
			int salary = rs.getInt("salary");	//행 안의 데이터 가져올 때 "get+반환하는 타입" 을 씀.("")안에는 컬럼명 그대로 써줘야 함.
			System.out.println(salary);
		}
		
		//7. 사용했던 자원 해제하기.
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
