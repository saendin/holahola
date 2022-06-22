package com.yedam.java.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

public class ProductsDAO extends DAO {
	// 싱글톤
	private static ProductsDAO productsDAO = null;

	private ProductsDAO() {
	}

	public static ProductsDAO getInstance() {
		if (productsDAO == null) {	//productsDAO가 null일때 겟인스턴스로 값 받아옴.
			productsDAO = new ProductsDAO();
		}
		return productsDAO;
	}

	// CRUD
	// 등록
	public void insert(Product product) {
		try {
			connect();

			// sql 구성
			// 쿼리통해서 값 통해서 넣으면 DEFAULT 구문이 돌지 않으므로 ?가 아닌 값을 직접 입력해줘야함
			String sql = "INSERT INTO products (product_id, product_name, product_price) VALUES (products_seq.nextval, ?, ?)";
					
//			"VALUES (product_sez.nextval, ? ?) 에 대입될 값 입력
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("제품 등록 완료");
			} else
				System.out.println("제품 수정 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 -1. 재고 수정
	public void updateStock(Product product) {
		try {
			connect();
			// sql 구성
			String sql = "UPDATE products SET product_stock = " + product.getProductStock() + " WHERE product_id = "
					+ product.getProductId();
			// 필드를 이용해서 만드는 형식이 stmt
			// 물을 표(prepareStatement)를 사용하지 않으면 바로 값을 DB로 넘겨줌
			stmt = con.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("제품 수정 완료");
			} else
				System.out.println("제품 수정 실패");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 -2. 이름, 가격만 수정하도록(재고 제외)
	public void updateInfo(Product product) {
		try {
			connect();
			String sql = "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	// 기본키를 사용하는것이 가장 바람직함 - 넘겨받는 값 제한해야 중복삭제발생 X
	public void delete(int productId) {
		try {
			connect();

			// sql 구성
			String sql = "DELETE FROM products WHERE product_id = " + productId; // 줄 나눠쓸거면 끝 공백 신경 써야함. -> 보기에만 줄이 바뀌는
																					// 것. ex) DELETE FROM product 뒤에 꼭
			stmt = con.createStatement();
		
			// 결과 뽑아내기
			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("제품 삭제 완료");
			} else
				System.out.println("제품 삭제 실패");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회
	// 반환값이 중요하기 때문에 return타입 신경쓰기
	// 매개변수의 조건이 2~3개 이상 된다면 VO class를 이용해서 하면 됨.
	public Product selectOne(String productName) {
		Product product = null;

		try {
			connect();

			String sql = "SELECT * FROM products WHERE product_name = '" + productName + "'"; // primary값이 아니라 중복 값 들어갈 수 있음.
																						// 세심하게 조건 주던가 조심해서 등록하던가
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			// if문 - 한개의 값 가지고 오기.
			// while에서도 한개만 가지고 오긴 하지만 대신 가장 최신걸로 덮어씀 - 쿼리상에서는 단건조회가 아니고, 자바에서 값을 제한해서 그렇게
			// 보여지는 것 뿐(최대한 자바에서 제어하려고 하지 말것.)
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
			}

			/*
			 * while(rs.next()) { product = new Product();
			 * product.setProductId(rs.getInt("product_id"));
			 * product.setProductName(rs.getString("product_name"));
			 * product.setProductPrice(rs.getInt("product_price"));
			 * product.setProductStock(rs.getInt("product_stock")); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}

	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			connect();

			String sql = "SELECT * FROM products ORDER BY product_id"; // 전체조회에서는 데이터가 많아질수록 순서가 엉망이되므로 정렬해주면 좋음.

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			// 데이터 몇개인지 모르니까 while문 사용
			while (rs.next()) {
				// list에 담아질 참조변수 먼저 선언
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				// list는 꼭 add 넣어주기! 먼저 작성해서 잊지 않도록 할 것.
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
