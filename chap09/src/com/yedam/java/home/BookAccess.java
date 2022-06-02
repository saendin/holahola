package com.yedam.java.home;
//저장소 역할을 할 클래스를 사용하기 위해 만드는것
public interface BookAccess {
//책 정보 저장소(Crud)
//등록
	public void insert(Book book);
//수정
	public void update(Book book);
//삭제
	public void delete(int isbn);
//전체조회
	public Book[] selectAll();
//단건조회
	public Book selectOne(int bookIsbn);
}
