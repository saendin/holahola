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
      List<Books> list = new ArrayList<>();
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
            books.setStock(rs.getInt("stock"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return books;
   }

   // 3. 내용 검색 - 내용의 일부가 들어가면 검색이 출력됨.
   public List<Books> selectStory(String story) {
      List<Books> list = new ArrayList<>();
      Books books = null;

      try {
         connect();
//         String sql = "SELECT * FROM books WHERE story LIKE ?";
//         pstmt = con.prepareStatement(sql);
//         String story;
//         story = "'%||" + str + "||%'";
//         pstmt.setString(1, story);

         String sql = "SELECT * FROM books WHERE story Like '%" + story + "%'";
         stmt = con.createStatement();

         rs = stmt.executeQuery(sql);

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

   // 4. 대여 가능 여부 - books의 stock이 0 일때는 대여중 1일때는 대여가능 boolean = 1 true / 0 = false
   public List<Books> selectDoRental() {
      List<Books> list = new ArrayList<>();
      Books books = null;

      try {
         connect();

         String sql = "SELECT * FROM books WHERE stock = ? ";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, 1);
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

   // 5. 책 대여
   public void bookRental(String bookTitle) {
      try {
         connect();

         String sql = "UPDATE books SET stock = ? WHERE book_title = ?";
         pstmt = con.prepareStatement(sql);

         pstmt.setInt(1, 0);
         pstmt.setString(2, bookTitle);

         int result = pstmt.executeUpdate();

         if (result > 0) { // 검증코드 작성
            System.out.println("대여 완료");
         } else {
            System.out.println("대여 실패");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
   }

   // 6. 책 반납
   public void bookReturn(String bookTitle) {
      try {
         connect();

         String sql = "UPDATE books SET stock = ? WHERE book_title = ?";
         pstmt = con.prepareStatement(sql);

         pstmt.setInt(1, 0);
         pstmt.setString(2, bookTitle);

         int result = pstmt.executeUpdate();

         if (result > 0) { // 검증코드 작성
            System.out.println("대여 완료");
         } else {
            System.out.println("대여 실패");
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

         String sql = "INSERT INTO books (book_title, book_writer, story) VALUES (?, ?, ?)"; // VALUES앞에 쓸 컬럼명만
                                                                        // (컬럼명)해서 넣어줘야함

         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, books.getBookTitle());
         pstmt.setString(2, books.getBookWriter());
         pstmt.setString(3, books.getStory());

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