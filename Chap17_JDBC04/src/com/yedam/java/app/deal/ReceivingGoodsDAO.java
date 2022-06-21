package com.yedam.java.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

public class ReceivingGoodsDAO extends DAO {
	// 싱글톤
	private static ReceivingGoodsDAO dao = null;

	private ReceivingGoodsDAO() {
	}

	public static ReceivingGoodsDAO getInstance() {
		if (dao == null) {
			dao = new ReceivingGoodsDAO();
		}
		return dao;
	}

	// CRUD
	// 1.등록
	// 기본키가 아니라 중복 입력될 수 있음. 이럴경우 수정, 삭제가 거의 불가능하다 보여짐. -> 그래서 여기선 만들지 않을 것ㅇㅇ. 조회만.
	// 만들라면 primary key역할 넣어줘야함.
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO receiving_goods (product_id, product_amount) VALUES (?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("입고 등록 완료");
			} else {
				System.out.println("입고 "
						+ "등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 2.단건조회
	// 2-1 (단건) 입고내역 유무 - 원래는 보 클래스 외의 것도 충분히 가능
	public boolean selectInfo(int productId) {
		boolean isSelected = false; // 항상 false로 하고 필요할 때만 초기화 할 수 있게끔 만들기
		try {
			connect();

			String sql = "SELECT COUNT(*) AS count FROM receiving_goods WHERE product_id = " + productId;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) { /// 쓰면 값 없더라도 0이 옴(-> 반드시 0은 반환됨) 그래서 조건 지정해줘야함
				if (rs.getInt("count") > 0) { // count가 0보다 클 경우에만 isSelected 돌아가도록.
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

	// 2-2 (단건) 입고 수량
	public int SelectAmount(int productId) {
		int amount = 0;
		try {
			connect();

			String sql = "SELECT NVL(SUM(product_amount),0) AS sum FROM receiving_goods WHERE product_id = " + productId;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				amount = rs.getInt("sum");// SUM함수의 결과값을 변수에 담아서 반환할고 sum이라는 변수로 가져옴.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return amount;
	}

	// 3. 전체조회
	// 3-1 (전체) 현재까지 입고된
	public List<DealInfo> selectAll(){
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount" //SELECT해와라
			+ " FROM product p JOIN receiving_goods r" //프로덕트랑 리시빙굿즈 조인해서
			+ " ON p.product_id = r.product_id"
			+ " ORDER BY r.deal_date";//프로덕트의 프로덕트 아이디랑 리시빙프로덕트 아이디 컬럼이랑 같다. 그리고 거래 날짜로 정렬하셈
	
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
	public List<DealInfo> selectAll(Date dealDate){
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount" //SELECT해와라
					+ " FROM product p JOIN receiving_goods r" //프로덕트랑 리시빙굿즈 조인해서
					+ " ON p.product_id = r.product_id"//프로덕트의 프로덕트 아이디랑 리시빙프로덕트 아이디 컬럼이랑 같다.
					+ " WHERE deal_date = ?" // 거래날짜가 ? 일 때
					+ " ORDER BY r.deal_date"; // 그리고 거래 날짜로 정렬하셈
			
	
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
			
			list.add(dealInfo); //리스트에 dealInfo값들 추가 ㄱ
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return list;
	}


	// 3-3 (전체) 해당 제품의 입고된 내역
	public List<DealInfo> selectAll(int productId){
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount" //SELECT해와라
			+ " FROM product p JOIN receiving_goods r" //프로덕트랑 리시빙굿즈 조인해서
			+ " ON p.product_id = r.product_id"//프로덕트의 프로덕트 아이디랑 리시빙프로덕트 아이디 컬럼이랑 같다.
			+ " WHERE product_id = ?"
			+ " ORDER BY r.deal_date"; // 그리고 거래 날짜로 정렬하셈
	
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
	
			
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

	
}
