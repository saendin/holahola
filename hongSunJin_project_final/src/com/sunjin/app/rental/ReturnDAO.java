package com.sunjin.app.rental;

import java.sql.SQLException;

import com.sunjin.app.common.DAO;

public class ReturnDAO extends DAO{
	// 반납 = 재고로 입고
	private static ReturnDAO returnDAO = null;
	private ReturnDAO() {}
	
	public static ReturnDAO getInstance() {
		if (returnDAO == null) {
			returnDAO = new ReturnDAO();
		}
		return returnDAO;
	}
	// 반납(입고)는 렌탈(출고)한 수량 안에서만 진행된다.
	// 1 반납 - 품번과 수량만 받을 수 있도록
	public void insert(RentalInfo info) {
		try {
			connect();
			String sql = "INSERT INTO rental (isn, return_amount) VALUES (?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, info.getIsn());
			pstmt.setInt(2, info.getAmount());

			int result = pstmt.executeUpdate();
			if (result > 0) {
			} else {
				System.out.println("예기치 못한 문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 검색한 품번의 반납할 양 조회 - 반납 재고 isn으로 묶어서 합계 나타내기.
	public int SelectAmount(int isn) {
		int stock = 0;
		try {
			connect();

			String sql = "SELECT " + isn + " , SUM(NVL(return_amount,0)) AS SUM"
					+ " FROM rental"
					+ " WHERE isn = " + isn
					+ " GROUP BY " + isn;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				stock = rs.getInt("SUM");// SUM함수의 결과값을 변수에 담아서 반환할고 sum이라는 변수로 가져옴.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return stock;
	}
	
}
