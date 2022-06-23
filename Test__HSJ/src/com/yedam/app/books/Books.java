package com.yedam.app.books;

//VO 클래스
public class Books {
   // 필드
   private String bookTitle;// 책제목
   private String bookWriter;// 저자
   private String story;// 내용
   private int stock;// 재고1

   // getter setter
   public String getBookTitle() {
      return bookTitle;
   }

   public void setBookTitle(String bookTitle) {
      this.bookTitle = bookTitle;
   }

   public String getBookWriter() {
      return bookWriter;
   }

   public void setBookWriter(String bookWriter) {
      this.bookWriter = bookWriter;
   }

   public String getStory() {
      return story;
   }

   public void setStory(String story) {
      this.story = story;
   }

   public int getStock() {
      return stock;
   }

   public void setStock(int stock) {
      this.stock = stock;

   }
   @Override
   public String toString() {
      String str = "";
      if(stock == 1) {
         str = "대여가능";
      } else {
         str = "대여중";
      } return "책제목 : " + bookTitle + ", 저자명 : " + bookWriter + ", 내용 : " + story + ", 대여여부 : " + str;
   }
}
//   @Override
//   public String toString() {
//
//      String book = "책제목 : " + bookTitle + ", 저자명 : " + bookWriter + ", 내용 : " + story + ", 대여여부 : ";
//      
//       if (stock == 0) {
//         book += "대여가능";
//      } else {
//         book += "대여중";
//         
//      } return book; //str로 새로 생성해서
//   }