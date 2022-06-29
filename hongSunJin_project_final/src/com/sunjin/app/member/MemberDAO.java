package com.sunjin.app.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunjin.app.common.DAO;
import com.sunjin.app.rental.RentalInfo;

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
					login.setName(rs.getString("name"));
					login.setEmail(rs.getString("email"));
					login.setPhone(rs.getInt("phone"));
					login.setRole(rs.getInt("role"));

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
			pstmt.setString(1, member.getId()); // primary key
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getPhone());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println();
				System.out.println(
						"=============================================================================================");
				System.out.println("                                   회원가입이 완료되었습니다 !");
				System.out.println("                " + member.getId() + " 님 ! 럭셔리 모먼트와 함께하게 된 것을 진심으로 환영합니다 !");
				System.out.println();
			} else
				System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 전화번호
	public void updateInfoP(Member member) {
		try {
			connect();
			String sql = "UPDATE members SET phone = ? WHERE id = '" + member.getId() + "'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, member.getPhone());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println();
			} else {
				System.out.println("문제가 발생했어요! T T");
			}
		} catch (SQLException e) {
			System.out.println("문제가 발생했어요! T T");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 회원아이디
	public Member findId(String id) {
		Member member = null;
		try {
			connect();

			String sql = "SELECT * FROM members WHERE id = '" + id + "'";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getInt("phone"));
				member.setRole(rs.getInt("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}
	
	// 렌트한 회원 아이디 조회
	public RentalInfo findRent(String id) {
		RentalInfo info = null;
		try {
			connect();

			String sql = "SELECT id, isn, rental_amount, rent_time, rent_time+5 AS RETURN FROM rental WHERE id = '" + id + "' ORDER BY id";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				info = new RentalInfo();
				info.setId(rs.getString("id"));
				info.setIsn(rs.getInt("isn"));
				info.setAmount(rs.getInt("rental_amount"));
				info.setRentalDate(rs.getDate("rent_time"));
				info.setReturnDate(rs.getDate("RETURN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return info;
	}
	
	// 멤버 전체조회
	public List<Member> selectAll() {
		List<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM members ORDER BY id";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getInt("phone"));
				member.setRole(rs.getInt("role"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
		return list;
	}

	// 회원탈퇴/ 삭제
	public void delete(String id) {
		try {
			connect();

			String sql = "DELETE FROM members WHERE id = '" + id + "'";
			stmt = con.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result > 0) {
			} else
				System.out.println("문제가 발생했어요!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
