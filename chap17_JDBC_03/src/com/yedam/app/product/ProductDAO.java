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
					"INSERT INTO product VALUES (product_seq.nextval, ?, ?)"; //아이디가 들어갈 자리에 product_seq.nextval 시퀀스를 넣어줘야함
					//INSERT INTO product(x) VALUES (?, ?, ?) 원래는 컬럼을 지정하려면 product뒤 ()안에 써줘야함
		
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setString(1, product.getProductName());
			ppstmt.setInt(2,  product.getProductPrice());
			
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
			
			String sql = "UPDATE product SET product_price =? WHERE product_id = ?";
			ppstmt = conn.prepareStatement(sql);
			
			ppstmt.setInt(1, product.getProductPrice());
			ppstmt.setInt(2, product.getProductId());
			
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
			
			String sql = "DELETE FROM product WHERE product_id =" + productId;
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setInt(1,  productId);
			
			int result = ppstmt.executeUpdate();
			
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
	
	public Product selectOne(int productId) {
		Product product = null; //dept = null이다
		
		try {
			connect(); //연결부터
			String sql = "SELECT * FROM product WHERE product_id =" + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//반환되는 값은 하나이므로 if문으로
			if(rs.next()) {	
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
			String sql = "SELECT * FROM product ORDER BY product_id";
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
