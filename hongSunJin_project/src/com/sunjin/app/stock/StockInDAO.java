package com.sunjin.app.stock;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunjin.app.common.DAO;

public class StockInDAO extends DAO {
	// 싱글톤
	private static StockInDAO dao = null;

	private StockInDAO() {
	}

	public static StockInDAO getInstance() {
		if (dao == null) {
			dao = new StockInDAO();
		}
		return dao;
	}

	// 1 재고 등록 - 품번과 수량만 받을 수 있도록
	public void insert(StockInfo info) {
		try {
			connect();
			String sql = "INSERT INTO stock_in (isn, stock) VALUES (?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, info.getIsn());
			pstmt.setInt(2, info.getStock());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("입고 완료");
			} else {
				System.out.println("문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 검색한 품번의 입고 횟수 조회
	public boolean selectedInfo(int isn) {
		boolean isSelected = false; // 항상 false로 하고 필요할 때만 초기화 할 수 있게끔 만들기
		try {
			connect();

			String sql = "SELECT COUNT(*) AS COUNT입고횟수 FROM stock_in WHERE isn = " + isn;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// count가 0보다 클 경우만 isSelected 수행
				if (rs.getInt("COUNT") > 0) {
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

	// 검색한 품번의 누적 재고량 조회
	public int SelectedAmount(int isn) {
		int stock = 0;
		try {
			connect();

			String sql = "SELECT NVL(SUM(stock),0) AS SUM FROM stock_in WHERE isn = " + isn;

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

	// 총 재고 리스트 조회
	public List<StockInfo> selectAll() {
		List<StockInfo> list = new ArrayList<>();

		try {
			connect();
			//입고날짜, 품번, 상품이름, 재고를 입고날짜로 정렬
			String sql = "SELECT i.stock_date, i.isn, p.product_name, i.stock FROM product p JOIN in_stock i"
					+ " ON p.isn = i.isn" + " ORDER BY isn";

			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StockInfo info = new StockInfo();
				info.setStockDate(rs.getDate("stock_date"));
				info.setIsn(rs.getInt("isn"));
				info.setProductName(rs.getString("product_name"));
				info.setStock(rs.getInt("stock"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 해당 날짜에 입고된 상품 리스트 조회 / stock_in_date : 입고날짜
	public List<StockInfo> selectAll(Date stockDate) {
		List<StockInfo> list = new ArrayList<>();

		try {
			connect();

			String sql = "SELECT i.stock_date, i.isn, p.product_name, i.stock" + " FROM product p JOIN in_stock i"
					+ " ON p.isn = i.isn" + " WHERE stock_date = ?" + " ORDER BY stock_date";

			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, stockDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// list에 담아질 참조변수 선언
				StockInfo info = new StockInfo();
				info.setStockDate(rs.getDate("stock_date"));
				info.setIsn(rs.getInt("isn"));
				info.setProductName(rs.getString("product_name"));
				info.setStock(rs.getInt("stock"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 입력한 품번의 입고 리스트 조회
	public List<StockInfo> selectAll(int isn) {
		List<StockInfo> list = new ArrayList<>();

		try {
			connect();

			String sql = "SELECT i.stock_date, i.isn, p.product_name, i.stock" + " FROM product p JOIN in_stock i"
					+ " ON p.isn = i.isn" + " WHERE isn = ?" + " ORDER BY isn";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, isn);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, isn);
				rs = pstmt.executeQuery();

				StockInfo info = new StockInfo();
				info.setStockDate(rs.getDate("stock_date"));
				info.setIsn(rs.getInt("isn"));
				info.setProductName(rs.getString("product_name"));
				info.setStock(rs.getInt("stock"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
