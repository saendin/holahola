package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// SQL employees에 INSERT UPDATE DELETE SELECT 구문 JDBC로 ,,
public class SQLExample {

	public static void main(String[] args) throws Exception {
		//1. JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB 서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
			
		Connection con = DriverManager.getConnection(url,id,pwd);
		
		//3. CRUD 실행
		/*******************INSERT********************/
		//-1. Statement or PrepareStatement 객체 생성하기 //교수님은 PrepareStatement 자주 씀. "?"를 변수처럼 쓸 수 있음.
		String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)"; //employees에 값 삽입 (컬럼 수 만금 변수 ? 넣어줌.)
		PreparedStatement pstmt = con.prepareStatement(insert);
		
		//-2. SQL 구성 후 실행
		pstmt.setInt(1, 1000); 	//prepareStatement가 제공하는 메소드 -> set+Int(타입) 
							   	//set으로 값 넣어주면 prepareStatement가 알아서 물음표 자리에 값을 구성해줌.
								//1이 물음표 자리 = 즉 첫번째 물음표, 1000이 거기에 들어갈 값. 즉 첫번째 물음표 자리에 1000값을 넣을 것임.
		pstmt.setString(2, "Sun Jin");//first_name
		pstmt.setString(3, "Hong");//last_name
		pstmt.setString(4, "saend00@naver.com");//email
		pstmt.setString(5, "82.10.1234.5678");//phoneNum
		pstmt.setString(6, "22/06/15");//생일
		pstmt.setString(7, "SA_REP");//직함
		pstmt.setInt(8, 6000);
		pstmt.setDouble(9, 0.99);
		pstmt.setInt(10, 100);
		pstmt.setInt(11, 80);//위에 써준 ?의 갯수만큼 set메소드를 써줘야함. BUT Set메소드 순서는 상관 없음.
		
		//-3. 결과 출력
		int result = pstmt.executeUpdate(); //값 자체가 변경되는 Insert, Update, Delete는 executeUpdate()를 씀
		
		System.out.println("insert 결과 : " + result);
		
		/*******************UPDATE********************/
		//-1. Statement or PrepareStatement 객체 생성하기
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?"; //테이블이랑 컬럼명에는 ? 못씀. 인지 못함주의
																					//물음표는 내가 여기에 값을 넣겠다를 표시해주는 역할
//		temp = "UPDATE" + tables + "SET" + coulumn + "="; 이런식도 가능 
		pstmt = con.prepareStatement(update);
		
		//-2. SQL 구성 후 실행
		pstmt.setInt(2, 1000); //Set 메소드느 순서 상관 없어서
		pstmt.setString(1, "Shin"); //"UPDATE employees SET last_name = ? WHERE employee_id = ?"의 구문에 따라 순서대로 (번호, 값)을 넣어줌
		
		//-3. 결과 출력
		result = pstmt.executeUpdate();
		
		System.out.println("update 결과 : " + result);
		
		/*******************SELECT********************/
		//-1. Statement or PrepareStatement 객체 생성하기
		String select = "SELECT * FROM employees ORDER BY employee_id";
		pstmt = con.prepareStatement(select);
		
		//-2. SQL 구성 후 실행
		ResultSet rs = pstmt.executeQuery();
		
		
		//-3. 결과 출력
		while(rs.next()) {
			String info = rs.getInt("employee_id") + " : " + rs.getString("last_name") + " " + rs.getString("first_name");
			System.out.println(info);
		}
		
		/*******************DELETE********************/
		//-1. Statement or PrepareStatement 객체 생성하기
		String delete = "DELETE FROM employees WHERE employee_id = ?"; //WHERE절 꼭 넣어서 우리가 넣어준 값만 삭제할것,,
		pstmt = con.prepareStatement(delete);
		
		//-2. SQL 구성 후 실행
		pstmt.setInt(1, 1000);
		
		//-3. 결과 출력
		result = pstmt.executeUpdate();
		
		System.out.println("delete 결과 : " + result);
		
		
		//4. 자원 해제하기
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}

}
