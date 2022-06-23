package com.yedam.app.books;

import java.util.List;
import java.util.Scanner;

public class Management {
   private Scanner sc = new Scanner(System.in);
   private BooksDAO dao = BooksDAO.getInstance();

   public Management() {
      while (true) {
         // 메뉴 출력
         menuPrint();

         // 메뉴 입력
         int menuNo = selectMenu();

         // 각 기능별 실행 (각 메소드들이 어떤 기능에 대해 묻고있는지 코드 이름 명확히 하는 것이 좋음)
         if (menuNo == 1) {
            // 1.전체초회
            selectAllBooks();
         } else if (menuNo == 2) {
            // 2.단건조회
            selectOne();
         } else if (menuNo == 3) {
            // 3.내용검색
            selectStory();
         } else if (menuNo == 4) {
            // 4.대여가능여부
            selectDoRental();
         } else if (menuNo == 5) {
            // 5.책대여
            rentalBook();
         } else if (menuNo == 6) {
            // 6.책반납
            returnBook();
         } else if (menuNo == 7) {
            // 7.책등록
            insertBook();
         } else if (menuNo == 9) {
            exit();
            break;
         } else {
            inputError();
         }
      }
   }

   private void menuPrint() {
      System.out.println("===============================================================================");
      System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책 대여 | 6.책 반납 | 7.책 등록 | 9.종료");
      System.out.println("===============================================================================");
   }

   private int selectMenu() {
      int menu = 0;
      try {
         System.out.print("메뉴선택>");
         menu = Integer.parseInt(sc.nextLine());

      } catch (NumberFormatException e) { // 메뉴에 숫자가 아닌값을 입력하면 NumberFormatException로 catch문 아래의 것이 뜰고임. -> 다시 try문의
                                 // 입력받는 곳으로 돌아가게끔 만들 것
         System.out.println("숫자 형식으로 입력해주세요.");
      }
      return menu;
   }

   // 종료
   private void exit() {
      System.out.println("프로그램을 종료합니다.");
   }

   // 잘못된 숫자 입력
   private void inputError() {
      System.out.println("메뉴에 맞게 입력해주세요.");
   }

   // 1.전체조회
   private void selectAllBooks() {
      List<Books> list = dao.selectAll();

      for (Books books : list) {
         System.out.println(books);
      }
   }

   // 2.단건조회
   private void selectOne() {
      // 책 제목 검색
      String bookTitle = inputBookTitle();

      // DB 검색
      Books books = dao.selectOne(bookTitle);

      // 결과 출력
      if (books != null) {
         System.out.println(books);
      } else {
         System.out.println("검색 결과가 없습니다!");
      }

   }

   // -2 책 제목 검색
   private String inputBookTitle() {
      System.out.print("책제목>");
      return sc.nextLine();
   }

   // 3.내용검색
   private void selectStory() {
      // 책 내용 검색
      String bookStory = inputBookStory();

      // DB검색
      List<Books> list = dao.selectStory(bookStory);

      for (Books books : list) {

         // 결과 출력
         if (books != null) {
            System.out.println(books);
         } else {
            System.out.println("검색 결과가 없습니다.");
         }
      }
   }

   private String inputBookStory() {
      System.out.println("책내용>");
      return sc.nextLine();
   }

   // 대여가능여부
   private void selectDoRental() {
      // DB검색
      List<Books> list = dao.selectDoRental();

      for (Books books : list) {

         // 결과 출력
         if (books != null) {
            System.out.println(books);
         } else {
            System.out.println("검색 결과가 없습니다.");
         }
      }

   }

   // 책 대여
   private void rentalBook() {
      // 책 제목 검색
      String bookTitle = inputBookTitle();

      // dao에서 북렌탈 메소드 불러오깅
      dao.bookRental(bookTitle);
   }

   // 책 반납
   private void returnBook() {
      // 책 제목 검색
      String bookTitle = inputBookTitle();

      // dao에서 북리턴 메소드 불러오기
      dao.bookReturn(bookTitle);
   }

   private void insertBook() {
      // 책정보 입력
      Books book = inputAll();

      // 입력받은것 DB에 전달
      dao.insert(book);
   }

   private Books inputAll() {
      Books book = new Books();

      System.out.println("책제목>");
      book.setBookTitle(sc.nextLine());

      System.out.println("저자명");
      book.setBookWriter(sc.nextLine());

      System.out.println("내용>");
      book.setStory(sc.nextLine());

      return book;
   }

}