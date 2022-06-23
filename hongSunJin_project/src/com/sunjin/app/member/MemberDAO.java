package com.sunjin.app.member;

import java.sql.SQLException;

import com.sunjin.app.common.DAO;


public class MemberDAO extends DAO {
	private static MemberDAO dao = null;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	// CRUD
	// 로그인 여부
	// 권한
	public Member selectOne(Member member) {
		Member login = null;
		try {
			connect();
			// 아이디와 비밀번호 두개 넘어가지만 셀렉트는 아이디만 먼저
			// 로그인 실패시 아이디 nor 비밀번호 알기 위해서
			String sql = "SELECT * FROM member WHERE id = '" + member.getId() + "'" ;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			//select절로 아이디 존재여부 확인 되었을 때
			if (rs.next()) {	
				//아이디 검색 = 비밀번호도 일치하는지 확인
				if (rs.getString("pwd").equals(member.getPwd())) {
					
					//-> 로그인 성공 -> 검색된 정보 반환
					login = new Member();
					login.setId(rs.getString("id"));
					login.setPwd(rs.getString("pwd"));
					login.setRole(rs.getInt("role"));
					
				} else {
					System.out.println("비밀번호를 확인해주세요!");
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return login;
	}
}
