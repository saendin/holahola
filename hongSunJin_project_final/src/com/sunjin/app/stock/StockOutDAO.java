package com.sunjin.app.stock;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunjin.app.common.DAO;

public class StockOutDAO extends DAO {
	// 싱글톤 생성
	private static StockOutDAO dao = null;

	private StockOutDAO() {
	}

	public static StockOutDAO getInstance() {
		if (dao == null) {
			dao = new StockOutDAO();
		}
		return dao;
	}

	// 값이 중복 입력될 수 있으므로 조회만 가능하도록 구현
	
	// 출고값 입력
	public void insert(StockInfo info) {
		try {
			connect();

			String sql = "INSERT INTO stock_out (isn, amount) VALUES (?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, info.getIsn());
			pstmt.setInt(2, info.getAmount());

			int result = pstmt.executeUpdate();
			if (result > 0) {
			} else {
				System.out.println("문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 검색한 품번의 출고 횟수 조회
	public boolean selectedInfo(int isn) {
		boolean isSelected = false;
		try {
			connect();

			String sql = "SELECT COUNT(*) AS count FROM stock_out WHERE isn = " + isn;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				if (rs.getInt("count") > 0) {
					isSelected = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return isSelected;
	}

	// 검색한 품번의 누적 출고량 조회
	public int SelectAmount(int isn) {
		int amount = 0;
		try {
			connect();
			// 프로덕트 수량의 합계를 가져와라.(NULL값 대신 0 넣을것), 테잌아웃 굿즈로 부터, product_id가 00값인 것의
			String sql = "SELECT NVL(SUM(amount), 0) AS SUM FROM stock_out WHERE isn = " + isn;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			// 값을 하나만 받을거라 if 씀.
			// 다음행으로 넘어갈때 컬럼명이 sum인 컬럼의 값을 가져와라.
			if (rs.next()) {
				amount = rs.getInt("SUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return amount;
	}

	// 전체 출고내역
	public List<StockInfo> selectAll() {
		List<StockInfo> list = new ArrayList<>();

		try {
			connect();

			String sql = "SELECT o.stock_date, o.isn, p.product_name, o.amount FROM product p JOIN stock_out o"
					+ " ON p.isn = o.isn" + " ORDER BY o.stock_date DESC";

			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StockInfo info = new StockInfo();
				info.setStockDate(rs.getDate("stock_date"));
				info.setIsn(rs.getInt("isn"));
				info.setProductName(rs.getString("product_name"));
				info.setAmount(rs.getInt("amount"));

				list.add(info); // 리스트에 dealInfo값들 추가 ㄱ
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 해당 날짜에 출고된 상품 리스트 조회
	public List<StockInfo> selectAll(Date stockDate) {
		List<StockInfo> list = new ArrayList<>();

		try {
			connect();

			String sql = "SELECT o.stock_date, o.isn, p.isn, o.amount"
					+ " FROM products p JOIN stock_out o" + " ON p.isn = o.isn"
					+ " WHERE o.stock_date = ?" + " ORDER BY o.stock_date DESC";

			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, stockDate);
			rs = pstmt.executeQuery();

			int result = pstmt.executeUpdate();

			while (rs.next()) {
				// list에 담아질 참조변수 선언
				StockInfo info = new StockInfo();
				info.setStockDate(rs.getDate("stock_date"));
				info.setIsn(rs.getInt("isn"));
				info.setProductName(rs.getString("product_name"));
				info.setAmount(rs.getInt("amount"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 검색한 품번의 총 출고 내역 조회
	public List<StockInfo> selectAll(int isn) {
		List<StockInfo> list = new ArrayList<>();

		try {
			connect();

			String sql = "SELECT o.stock_date, o.isn, p.isn, o.amount"
					+ " FROM products p JOIN stock_out o" + " ON p.isn = o.isn"
					+ " WHERE o.isn = ?" + " ORDER BY o.isn";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, isn);
			rs = pstmt.executeQuery();

			int result = pstmt.executeUpdate();

			while (rs.next()) {
				// list에 담아질 참조변수 선언
				StockInfo info = new StockInfo();
				info.setStockDate(rs.getDate("stock_date"));
				info.setIsn(rs.getInt("isn"));
				info.setProductName(rs.getString("product_name"));
				info.setAmount(rs.getInt("amount"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 재고량은 따로 프로그램에서 처리.
	// 여기서는 그냥 출고량만 처리할 것.

}
