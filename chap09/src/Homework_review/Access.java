package Homework_review;

public interface Access {
	
//	VO 클래스 - DB에 접속할때 만드는 가장 기본적인 interface
//	(하나의 디비를 쓰다가 교체할 수도 있기 때문에 인터페이스를 만들어서 접근함)

	 //등록
	 void insert(Book book);
	 
	 //수정
	 void update(Book book);
	 
	 //삭제
	 void delete(int isbn);
	 
	 //전체조회
	 Book[] selectAll();	//DB는 데이터를 삽입하고 반환받는 역할밖에 못함.
	 
	 //단건조회
	 Book selectOne(int isbn);
	
}
