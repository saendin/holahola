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

			String sql = "INSERT INTO product (isn, product_name, brand, price, category)"
					+ " VALUES (products_seq.nextval, ?, ?, ? ,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getBrand());
			pstmt.setInt(4, product.getPrice());
			pstmt.setInt(5, product.getCategory());

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
			String sql = "UPDATE product SET product_price = ? WHERE isn = ?";
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

	// 삭제
	public void delete(int isn) {
		try {
			connect();

			String sql = "DELETE FROM products WHERE isn = " + isn; 
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
	public Product findBand(String brand) {
		Product product = null;

		try {
			connect();
			String sql = "SELECT * FROM product WHERE brand = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "brand");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("category"));
				product.setStock(rs.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}

	// 상품명 일부가 들어가면 그 리스트 조회
	public List<Product> findBrand(String productName) {
		List<Product> list = new ArrayList<>();
		Product product = null;

		try {
			connect();

			String sql = "SELECT * FROM books WHERE product_name Like '%" + productName + "%'";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("category"));
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

			String sql = "SELECT * FROM books WHERE category = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "brand");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("category"));
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
			String sql = "SELECT * FROM product WHERE price <= " + price1 + " AND price >" + price2;

			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setIsn(rs.getInt("isn"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setCategory(rs.getInt("category"));
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
	
	//대여 가능한 리스트만 조회
	public List<Product> canDoRental() {
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
				product.setCategory(rs.getInt("category"));
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

}
