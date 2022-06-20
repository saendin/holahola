package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
//DAO에 있는 DB의 정보를 사용해야하므로 DAO 상속
public class ProductDAO extends DAO {
	
	//싱글톤
	private static ProductDAO productDAO = null;
	//ProductDAO를 getInstance()해줬을 때만 리턴해주기
	private ProductDAO() {}
	public static ProductDAO getInstance() {
		if(productDAO == null) {
			productDAO = new ProductDAO();
		} return productDAO;
	}
	
	//CRUD
	//등록
	public void insert(Product product) {
		try {
			connect();
			
			//sql문 구성
			String sql = 
					"INSERT INTO products VALUES (product_seq.nextval, ?, ?)"; //시퀀스 넣어줄 때 : (아이디가 들어갈 자리) product_seq.nextval 시퀀스를 써주면 됨
					//INSERT INTO product(x) VALUES (?, ?, ?) 원래는 컬럼을 지정하려면 product뒤 ()안에 써줘야함
		
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setString(1, product.getProductName());
			ppstmt.setInt(2,  product.getProductPrice());
			
			//결과 뽑아내기
			int result = ppstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("등록 완료");
			} else {
				System.out.println("등록 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	//수정
	public void update(Product product) {
		try {
			connect();
			
			String sql = "UPDATE products SET product_price =? WHERE product_id = ?";
			ppstmt = conn.prepareStatement(sql);
			
			ppstmt.setInt(1, product.getProductPrice());
			ppstmt.setInt(2, product.getProductId());
			
			//결과 뽑아내기
			int result = ppstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//삭제 
	public void delete(int productId) {
		try {
			connect();
			//prepareStatement 쓸 때 보통 물음표 쓰고 (컬럼명이랑 타입 정확히 지정안해줘도 알아서 해주기때문에 편함)
			//stmt는 물음표 안쓰고 정확히 지정해줌. 아래 단건조회 참고
			String sql = "DELETE FROM products WHERE product_id =" + productId;
			ppstmt = conn.prepareStatement(sql);
//			ppstmt.setInt(1,  productId); --이거 없어도 돌아가나 테스트해보기
			
			int result = ppstmt.executeUpdate();
			
			//결과 뽑아내기
			if (result > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			System.out.println("삭제 완료");
		} finally {
			disconnect();
		}
		
		
		
	}
	
	//단건조회
	//무엇을 기준으로 조회해 올건지 생각해봐야함
	//ex)제품번호, 제품이름 등등
	//여기서는 제품번호와 제품이름을 사용하도록 한다.
	//productName을 매개변수로 가지는 셀렉트 원
	public Product selectOne(String productName) {
		Product product = null; //dept = null이다
		
		try {
			connect(); //연결부터
			String sql = "SELECT * FROM products WHERE product_name = ?"; //stmt는 물음표 안쓰고 정확히 지정해줌.
																		 //String타입은 + ProductName으로 받으면 못 읽어 들여서 prepareStatement쓰는게 편함
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setString(1,productName);
			rs = ppstmt.executeQuery();
			
			//반환되는 값은 하나이므로 if문으로 <- X
			while(rs.next()) {	
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return product;
	}
	//productId을 매개변수로 가지는 셀렉트 원
	public Product selectOne(int productId) {
		Product product = null; //dept = null이다
		
		try {
			connect(); //연결부터
			String sql = "SELECT * FROM products WHERE product_id =" + productId; //stmt는 물음표 안쓰고 정확히 지정해줌.
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//반환되는 값을 하나만 설정할때는 if문으로 사용. (원래는 이렇게 하지만 이렇게 쓰면 코드가 복잡해지므로 여기서는 while문을 써줌.)
			//while을 쓰면 가장 마지막으로 등록된 값으로 쿼리가 실행됨.
			while(rs.next()) {	
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return product;
	}
	
	
	//전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			connect();
			String sql = "SELECT * FROM products ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
						
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		} return list;
	}
	
	
	
	
}
