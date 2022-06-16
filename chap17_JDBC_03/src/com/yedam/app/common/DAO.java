package com.yedam.app.common;
//common = 공통으로 사용할 DAO 패키지
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


//두 DAO를 연결하고 끊는 것만 할것. 상속이 일어나므로 필드를 전부 protected로 바꿔줄것
public class DAO { 
	// Oracle 연결 정보
	//오직 DAO 클래스에서만 건드리게 할것이므로 private로 막기(자식에서 수정 못하도록)
		private String jdbc_driver;
		private String oracle_url;
		private String connectedId;
		private String connectedPwd;

		// 각 메소드에서 공통적으로 사용하는 필드 존재
		protected Connection conn;
		protected Statement stmt;
		protected PreparedStatement ppstmt;
		protected ResultSet rs;

		public void connect() {
			// 1. JDBC Driver 로딩하기
			dbConfig();
			try {
				Class.forName(jdbc_driver);
			// 2. DB 서버 접속하기 --가 하나의 메소드가 될 것
				conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
			} catch (ClassNotFoundException e) {
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
				if (ppstmt != null)
					ppstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
}
