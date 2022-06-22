package com.yedam.app.books;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class BooksDAO extends DAO {

	// 싱글톤
	private static BooksDAO booksDAO = null;

	private BooksDAO() {
	}

	public static BooksDAO getInstance() {
		if (booksDAO == null) {
			booksDAO = new BooksDAO();
		}
		return booksDAO;
	}

	// CRUD
	// 1. 전체조회
	public List<Books> selectAll() {
		List<Books> list = new ArrayList<Books>();
		try {
			connect();
			String sql = "SELECT * FROM books";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Books books = new Books();
				books.setBookTitle(rs.getString("book_title"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setStory(rs.getString("story"));

				list.add(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
		return list;
	}

	// 2. 단건 조회 - 책 이름으로 조회
	public Books selectOne(String bookTitle) {
		Books books = null;

		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_title = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookTitle);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				books = new Books();
				books.setBookTitle(rs.getString("book_title"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setStory(rs.getString("story"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return books;
	}

	// 3. 내용 검색 - 내용의 일부가 들어가면 검색이 출력됨.
	public List<Books> selectStory(String str) {
		List<Books> list = new ArrayList<Books>();
		Books books = null;

		try {
			connect();
			String sql = "SELECT * FROM books WHERE story LIKE ?";
			pstmt = con.prepareStatement(sql);
			String story ="";
			story = "%||" + str + "||%";
			pstmt.setString(1, story);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				books = new Books();
				books.setBookTitle(rs.getString("book_title"));
				books.setBookWriter(rs.getString("book_writer"));
				books.setStory(rs.getString("story"));
				books.setStock(rs.getInt("stock"));
				
				list.add(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 4. 대여 여부 - books의 stock이 0 일때는 대여중 1일때는 대여가능 boolean = 1 true / 0 = false 
	public void update(boolean stock) {
		try {
//			Books stock = null;
			
			connect();

			String sql = "UPDATE books SET stock = " + stock;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			// 결과 뽑아내기
			if (rs.getBoolean("stock")) {
				System.out.println("대여가능");
			} else {
				System.out.println("대여중");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 7. 책 등록
	public void insert(Books books) {
		try {
			connect();

			String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, books.getBookTitle());
			pstmt.setString(2, books.getBookWriter());
			pstmt.setString(3, books.getStory());
			pstmt.setInt(3, books.getStock());

			// 결과 뽑아내기
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("책 등록이 완료되었습니다.");
			} else {
				System.out.println("책 등록에 실패하였습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
