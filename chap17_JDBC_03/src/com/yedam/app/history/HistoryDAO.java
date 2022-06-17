package com.yedam.app.history;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO {

	//싱글톤 만들기
	private static HistoryDAO historyDAO = null;
	private HistoryDAO() {}
	public static HistoryDAO getInstance() { //외부에서 무조건 호출해야하니 꼭 public인지 확인할것. private하면 못 끌어다써서 오류남
		if(historyDAO == null) {
			historyDAO = new HistoryDAO();
		} return historyDAO;

	}

	//CRUD
	//등록
	public void insert(History history) {
		try {
			connect();
			
			String sql = "INSERT INTO product_history VALUES(?, ?, ?)";
			
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setInt(1,  history.getProductId()); // 제품 id 삽입
			ppstmt.setInt(2, history.getProductCategory()); // 제품 카테고리 삽입
			ppstmt.setInt(3,  history.getProductAmount()); // 제품 양 삽입
			
			int result = ppstmt.executeUpdate();
					
					if(result > 0) {
						System.out.println("제품 등록 완료");
					} else {
						System.out.println("제품 등록 실패");
					}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정 - 수량만
	//(수량만 수정 or 입고하거나 출고한 내역 자체를 수정 등 다양한 경우가 있으므로 생각해서 만들것.)
	public void update(History history) {
		try {
			
			connect();
			
			String sql = "UPDATE product_history SET product_amount = ? WHERE product_id = ?";
			ppstmt = conn.prepareStatement(sql);
			
			ppstmt.setInt(1, history.getProductAmount());
			ppstmt.setInt(2, history.getProductId());
			
			int result = ppstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int productId) {
		try {
			connect();
			
			String sql = "DELETE FROM product_histoy WHERE product_id =" + productId;
			
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setInt(1,  productId);
			
			int result = ppstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회 - 각 상품에 대한 재고만 조회
	//1. 제품이 입고일때만 제품별 총 양 조회 하기 = product_category = 1
	public int selectInAmount(int productId) {
		int result = 0;
		
		try {
			connect();
			
			String sql = "SELECT SUM(product_amount) AS SUM FROM product_history WHERE product_id = ? AND product_category = 1";
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setInt(1,  productId);
			
			rs = ppstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("SUM"); //product_amount은 별칭 SUM 쓰겠음(컬럼명, 별칭, 컴럼 순서별 숫자를 이용해서 가지고 오는 방식 가능)
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
	}
	
	//단건조회 - 각 상품에 대한 재고만 조회 (return타입 = 조회값 리턴)
	//2. 제품이 입고일때만 제품별 총 양 조회 하기
	//교수님께서 짜주신고
	public int selectOutAmount(int productId) {
		int result = 0;
		
		try {
			connect();
			//제품이 입고일때만 제품별 총 양 조회 하기 = product_category = 2
			String sql = "SELECT SUM(product_amount) AS SUM FROM product_history WHERE product_id = ? AND product_category = 2";
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setInt(1,  productId);
			
			rs = ppstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("SUM"); //product_amount은 별칭 SUM 쓰겠음(컬럼명, 별칭, 컴럼 순서별 숫자를 이용해서 가지고 오는 방식 가능)
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
	}
	
	//전체조회 - 전체 상품의 각 재고
	//Map으로 짜보기
	public Map selectAllAmount() {
		Map<Integer, Integer> list = new HashMap<>();
		try {
			connect();
			// 각제품에 따른 입고량과 출고량 들고오기
			//-품번이랑 제품 카테고리별 품번이랑 제품 카테고리, 제품 총량 가져와라 FROM 제품 히스토리에서
			String sql = "SELECT product_id, product_category, SUM(product_amount) AS Amount FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 입고와 출고에 따른 각각의 목록 들고오기
			//-입고량은 입고량대로(inList) 출고량은 출고량대로(outList) 분리하는 작업
			//-하나의 테이블에 있으면서 연달아있는 경우에 품번이랑 카테고리명만 알면 map쓰는게 정보 가져오는게 더 편함
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			
			while(rs.next()) {
				int category = rs.getInt("product_category");
				if(category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("Amount"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("Amount"));
				}
				
				//-출고가 되었다는건 입고가 된 상품이라는 기반하에 이뤄지는 거기 때문에 그걸 구성해줘야 함
				//-입고와 출고과 분리되어 있으니까 각각에서 내가 찾고자 하는 제품을 끄집어내와서 재고량 계산해주기
				Set<Integer> keySet = inList.keySet(); //리스트 한번 쭉 돌면서 
				for(int key : keySet) {
					int inAmount = inList.get(key); //입고
					Integer outAmount = outList.get(key);
					if(outAmount != null) {	//재고 수량이 있을 때만 출력하도록
						list.put(key, (inAmount - outAmount)); //출고 되었을 때 입고량 - 출고량 
					} else {
						list.put(key,  inAmount); //입고가 되었는데 출고가 되지 않았을 경우 입고량이 그대로 재고가 됨.
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
	}
	
	
}
