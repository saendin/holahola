package com.sunjin.app.rental;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunjin.app.common.DAO;

public class RentalDAO extends DAO {
	// 품번 존재 확인
	// 존재 -> 재고 확인
	// 재고 -> int 재고 담고
	// int변수에 담은것 -1(set) -> update구문써서 DB에도 연동되도록
	// 대여/ 반납 기록

	// 렌탈(출고)는 남아있는 수량 안에서만 가능하다.
	private static RentalDAO rentalDAO = null;

	private RentalDAO() {
	}

	public static RentalDAO getInstance() {
		if (rentalDAO == null) {
			rentalDAO = new RentalDAO();
		}
		return rentalDAO;
	}

	// 렌탈값 입력
	public void insert(RentalInfo info) {
		try {
			connect();

			String sql = "INSERT INTO rental (id, isn, rental_amount) VALUES (?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			pstmt.setInt(2, info.getIsn());
			pstmt.setInt(3, info.getAmount());

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

	// 재고 확인 (검색한 품번의 재고 확인 = product stock에서)
	public int SelectedAmount(int isn) {
		int stock = 0;
		try {
			connect();
			String sql = "SELECT isn, SUM(NVL(rental_amount,0)) AS SUM"
					+ " FROM rental"
					+ " WHERE isn = " + isn 
					+ " GROUP BY isn";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				stock = rs.getInt("SUM");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return stock;
	}
	
	// 렌트한 회원 아이디 조회
	public RentalInfo findRent(String id) {
		RentalInfo member = null;
		try {
			connect();

			String sql = "SELECT id, isn, rental_amount, rent_time, rent_time+5 FROM rental ORDER BY id";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				RentalInfo info = new RentalInfo();
				info.setId(rs.getString("id"));
				info.setIsn(rs.getInt("isn"));
				info.setAmount(rs.getInt("rental_amount"));
//				info.setAmount(rs.getString("return_amount"));
				info.setRentalDate(rs.getDate("rent_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}
	
	//rental 테이블 안의 isn 조회
	public RentalInfo findIsn(int isn) {
		RentalInfo rental = null;
		try {
			connect();
			String sql = "SELECT * FROM rental WHERE isn = " + isn;
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				rental = new RentalInfo();
				rental.setId(rs.getString("id"));
				rental.setIsn(rs.getInt("isn"));
				rental.setAmount(rs.getInt("rental_amount"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return rental;
	}
	
//	public List<RentalInfo> selectList(String id) {
//		List<RentalInfo> list = new ArrayList<>();
//		try {
//			connect();
//			String sql = "SELECT id, isn, rental_amount, rent_time, rent_time+5 FROM rental ORDER BY id";
//			stmt = con.createStatement();
//
//			rs = stmt.executeQuery(sql);
//
//			if (rs.next()) {
//				RentalInfo info = new RentalInfo();
//				info.setId(rs.getString("id"));
//				info.setIsn(rs.getInt("isn"));
//				info.setAmount(rs.getInt("rental_amount"));
////				info.setAmount(rs.getString("return_amount"));
//				info.setRentalDate(rs.getDate("rent_time"));
//				list.add(info);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list;
//	}

	// 전체 렌탈(출고) 내역
//	public List<RentalInfo> selectAll() {
//		List<RentalInfo> list = new ArrayList<>();
//
//		try {
//			connect();
//
//			String sql = "SELECT o.stock_date, o.isn, p.product_name, o.amount FROM product p JOIN stock_out o"
//					+ " ON p.isn = o.isn" + " ORDER BY o.isn";
//
//			stmt = con.createStatement();
//
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				StockInfo info = new StockInfo();
//				info.setStockDate(rs.getDate("stock_date"));
//				info.setIsn(rs.getInt("isn"));
//				info.setProductName(rs.getString("product_name"));
//				info.setAmount(rs.getInt("amount"));
//
//				list.add(info); //
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list;
//	}

}
