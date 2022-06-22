package com.yedam.app.members;

import java.sql.SQLException;

import com.yedam.java.app.common.DAO;

public class MembersDAO extends DAO {
	// 싱글톤
	private static MembersDAO dao = null;

	private MembersDAO() {
	}

	public static MembersDAO getInstance() {
		if (dao == null) {
			dao = new MembersDAO();
		}
		return dao;
	}

	// CRUD
	// 로그인 여부
	// 권한
	public Member selectOne(Member member) {
		Member loginInfo = null;
		try {
			connect();
			// 아이디와 비밀번호 두개 넘어가지만 셀렉트는 아이디만 먼저 할고
			// (아이디때문에 로그인 안되는건지 비번때문에 로그인 안되는 건지 확인하기 위해서)
			String sql = "SELECT * FROM members WHERE member_id = '" + member.getMemberId() + "'" ;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	//select절로 아이디 존재여부 확인됨.
				//아이디 검색 이퀄즈로 비밀번호도 일치하는지 확인함.
				if (rs.getString("member_password").equals(member.getMemberPassword())) {
					//비밀번호 일치
					//-> 로그인 성공 -> 검색된 정보 반환하기 위해 인스턴스 만들고 게터세터 집어넣은 것
					loginInfo = new Member();
					loginInfo.setMemberId(rs.getString("member_id"));
					loginInfo.setMemberPassword(rs.getString("member_password"));
					loginInfo.setMemberRole(rs.getInt("member_role"));
					
//					-> 이렇게 안하고 위의 방법으로 할 것member.setMemberRole(rs.getInt("member_role"));
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return loginInfo;
	}
}
