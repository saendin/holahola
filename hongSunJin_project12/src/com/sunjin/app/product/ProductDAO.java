package com.sunjin.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunjin.app.common.DAO;

public class ProductDAO extends DAO {
	// 싱글톤
	private static ProductDAO productDAO = null;

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		if (productDAO == null) { // productsDAO가 null일때 겟인스턴스로 값 받아옴.
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	// 상품 등록
	// 품번, 품명, 브랜드, 가격, 카테고리
	public void insert(Product product) {
		try {
			connect();

			String sql = "INSERT INTO product (isn, product_name, brand, price, p_category, stock)"
					+ " VALUES (product_seq.nextval, ?, ?, ? ,?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProductName().toLowerCase());
			pstmt.setString(2, product.getBrand().toLowerCase());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getCategory());
			pstmt.setInt(5, product.getStock());
			
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("제품 등록이 완료되었습니다!");
			} else
				System.out.println("문제가 발생했어요!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 가격만
	public void updateInfo(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET price = ? WHERE isn = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product.getPrice());
			pstmt.setInt(2, product.getIsn());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("가격이 변경되었습니다!");
			} else {
				System.out.println("문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//재고 업데이트
	public void updateStock(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET stock = " + product.getStock() + " WHERE isn = " + product.getIsn();
			stmt = con.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("완료되었습니다!");
			} else {
				System.out.println("문제가 발생했어요!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 삭제
	public void delete(int isn) {
		try {
			connect();

			String sql = "DELETE FROM product WHERE isn = " + isn;
			stmt = con.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("상품이 삭제되었습니다");
			} else
				System.out.println("문제가 발생했어요!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 브랜드로 조회
	public List<Product> findBrand(String brand) {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();
			String sql = "SELECT * FROM product WHERE LOWER(brand) = '" + brand + "' ORDER BY brand";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name").toLowerCase());
				product.setBrand(rs.getString("brand").toLowerCase());
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 상품명으로 조회
	public List<Product> findName(String productName) {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();

			String sql = "SELECT * FROM product WHERE LOWER(product_name) Like '%" + productName + "%' ORDER BY '" + productName + "'";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name").toLowerCase());
				product.setBrand(rs.getString("brand").toLowerCase());
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 상품 카테고리별 리스트 조회
	public List<Product> findCategory(int category) {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();

			String sql = "SELECT * FROM product WHERE p_category = " + category + " ORDER BY p_category";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 입력한 가격 범위로 카테고리 조회
	public List<Product> findPriceRange(int price1, int price2) {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();
			// price가 price1보다 작거나 같고 price2보다는 클 때
			String sql = "SELECT * FROM product WHERE price <= " + price2 + " AND price >=" + price1
					+ " ORDER BY product_name";

			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 대여 가능한 리스트만 조회
	public List<Product> inStock() {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();

			String sql = "SELECT * FROM product WHERE stock > 0 ";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 전체 리스트 조회
	public List<Product> showAllList() {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();

			String sql = "SELECT * FROM product";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 수정에서 쓸 isn으로 전체정보 조회
	public Product findIsn(int isn) {
		Product product = null;

		try {
			connect();
			String sql = "SELECT * FROM product WHERE isn = " + isn + " ORDER BY isn";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("p_category"));
				product.setStock(rs.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}
	
	public int SelectAmount(int isn) {
		int stock = 0;
		try {
			connect();
			String sql = "SELECT stock FROM product WHERE isn = " + isn;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				stock = rs.getInt("stock");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return stock;
	}

}
