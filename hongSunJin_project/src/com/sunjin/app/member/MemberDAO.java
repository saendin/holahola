package com.sunjin.app.member;

import java.sql.SQLException;

import com.sunjin.app.common.DAO;
import com.sunjin.app.product.Product;

public class MemberDAO extends DAO {
	private static MemberDAO dao = null;

	private MemberDAO() {
	}

	// 싱글톤 생성
	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	// CRUD
	// 로그인 성공여부
	public Member selectRole(Member member) {
		Member login = null;
		try {
			connect();
			// 아이디와 비밀번호 두개 넘어가지만 셀렉트는 아이디만 먼저
			// 로그인 실패시 아이디 nor 비밀번호 알기 위해서
			String sql = "SELECT * FROM members where id = '" + member.getId() + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// select절로 아이디 존재여부 확인 되었을 때
			if (rs.next()) {
				// 아이디 검색 = 비밀번호도 일치하는지 확인
				if (rs.getString("pwd").equals(member.getPwd())) {

					// -> 로그인 성공 -> 검색된 정보 반환
					login = new Member();
					login.setId(rs.getString("id"));
					login.setPwd(rs.getString("pwd"));
					login.setRole(rs.getInt("role"));

				} else {
					System.out.println("비밀번호를 확인해주세요!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return login;
	}

	// 회원가입
	public void insert(Member member) {
		try {
			connect();

			String sql = "INSERT INTO members (id, pwd, name, email, phone)" + " VALUES (?, ?, ? ,?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getPhone());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원 등록이 완료되었습니다!");
			} else
				System.out.println("회원 가입에 문제가 생겼어요!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 전화번호
	public Member updateInfoP(String id) {
		Member member = new Member();
		try {
			connect();
			String sql = "UPDATE members SET phone = ? WHERE id = " + id;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, member.getPhone());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("전화번호가 변경되었습니다!");
			} else {
				System.out.println("문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return member;
	}
	// 수정 - 이메일
	public void updateInfoE(Member member) {
		try {
			connect();
			String sql = "UPDATE members SET email = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("이메일이 변경되었습니다!");
			} else {
				System.out.println("문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 회원탈퇴
	public void delete(int id) {
		try {
			connect();

			String sql = "DELETE FROM members WHERE id = " + id;
			stmt = con.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("상품이 삭제되었습니다");
			} else
				System.out.println("문제가 발생했어요!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
