package com.sunjin.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	// Oracle DB 정보
	private String jdbcDriver;
	private String oracleUrl;
	private String connectedId;
	private String connectedPwd;

	// 공통적으로 사용되는 필드
	protected Connection con;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	// 생성자
	public DAO() {
		dbConfig();
	}

	// 1. DB에 접속하는 메소드
	public void connect() {
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver의 로딩에 실패하였습니다.");
		} catch (SQLException e) {
			System.out.println("DB 접속에 실패했습니다.");
		}
	}

	// 2. DB 정보를 가져오기
	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath
					= ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		// 오라클 정보 가져오기
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");
	}

	// 2. DB 해제
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
