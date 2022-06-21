package com.yedam.java.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

public class TakeOutGoodsDAO extends DAO {

	private static TakeOutGoodsDAO dao = null;

	private TakeOutGoodsDAO() {
	}

	public static TakeOutGoodsDAO getInstance() {
		if (dao == null) {
			dao = new TakeOutGoodsDAO();
		}
		return dao;
	}
	
	//CRUD
	//1. 등록
	//값이 중복 입력될 수 있으므로 조회만 가능하도록 구현
	
	public void insert(DealInfo info) {
		try {
			connect();
			
			String sql = "INSERT INTO take_out_goods (product_id, product_amount) VALUES (?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("출고 등록 완료");
			} else {
				System.out.println("출고 등록 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	// 2.단건조회
	// 2-1 (단건) 출고내역 유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connect();
			
			String sql = "SELECT COUNT(*) AS count FROM take_out_goods WHERE product_id = " + productId;
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				if(rs.getInt("count") > 0) {
					isSelected = true;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		} return isSelected;
	}
	
	// 2-2 (단건) 출고 수량
	public int SelectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			//프로덕트 수량의 합계를 가져와라.(NULL값 대신 0 넣을것), 테잌아웃 굿즈로 부터, product_id가 00값인 것의
			String sql = "SELECT NVL(SUM(product_amonut, 0) AS sum FROM take_out_goods WHERE product_id = " + productId;
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			//값을 하나만 받을거라 if 씀.
			//다음행으로 넘어갈때 컬럼명이 sum인 컬럼의 값을 가져와라.
			if(rs.next()) {
				amount = rs.getInt("sum");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		} return amount;
	}
	
	// 3. 전체조회
	
	// 3-1 (전체) 현재까지 입고된
		public List<DealInfo> selectAll(){
			List<DealInfo> list = new ArrayList<>();
			
			try {
				connect();
				
				String sql = "SELECT t.deal_date, t.product_id, p.product_id, t.product_amount"
						+ " FROM product p JOIN take_out_goods t"
						+ " ON p.product_id = t.product_id"
						+ " ORDER BY t.deal_date";
		
				stmt = con.createStatement();
				
				int result = stmt.executeUpdate(sql);
				
				while(rs.next()) {
					//list에 담아질 참조변수 선언
					DealInfo dealInfo = new DealInfo();
					dealInfo.setDealDate(rs.getDate("deal_date"));
					dealInfo.setProductId(rs.getInt("product_id"));
					dealInfo.setProductName(rs.getString("product_name"));
					dealInfo.setProductAmount(rs.getInt("product_amount"));
				
				list.add(dealInfo); //리스트에 dealInfo값들 추가 ㄱ
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			} return list;
		}
		
		
	// 3-2 (전체) 해당 날짜에 입고된 내역
	public List<DealInfo> selectAll(Date dealDate) {
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT t.deal_date, t.product_id, p.product_id, t.product_amount"
					+ " FROM product p JOIN take_out_goods t"
					+ " ON p.product_id = t.product_id"
					+ " WHERE deal_date = ?"
					+ " ORDER BY t.deal_date";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, dealDate);
			rs = pstmt.executeQuery();
			
			int result = pstmt.executeUpdate();
			
			while(rs.next()) {
				//list에 담아질 참조변수 선언
				DealInfo dealInfo = new DealInfo();
				dealInfo.setDealDate(rs.getDate("deal_date"));
				dealInfo.setProductId(rs.getInt("product_id"));
				dealInfo.setProductName(rs.getString("product_name"));
				dealInfo.setProductAmount(rs.getInt("product_amount"));
				
				list.add(dealInfo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return list;
	}
	
	// 3-3 (전체) 해당 제품의 입고된 내역
	public List<DealInfo> selectAll(int productId) {
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT t.deal_date, t.product_id, p.product_id, t.product_amount"
					+ " FROM product p JOIN take_out_goods t"
					+ " ON p.product_id = t.product_id"
					+ " WHERE product_id = ?"
					+ " ORDER BY t.deal_date";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			int result = pstmt.executeUpdate();
			
			while(rs.next()) {
				//list에 담아질 참조변수 선언
				DealInfo dealInfo = new DealInfo();
				dealInfo.setDealDate(rs.getDate("deal_date"));
				dealInfo.setProductId(rs.getInt("product_id"));
				dealInfo.setProductName(rs.getString("product_name"));
				dealInfo.setProductAmount(rs.getInt("product_amount"));
				
				list.add(dealInfo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return list;
	}
	
	
	//재고량은 따로 프로그램에서 처리.
	//여기서는 그냥 출고량만 처리할 것.

}