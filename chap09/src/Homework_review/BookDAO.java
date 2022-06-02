package Homework_review;

public class BookDAO implements Access {
	// With teacher

	//BookDAO=
	//book repo
	// 저장소

	 //싱글톤
	
	  private static BookDAO instance = new BookDAO();
	  private BookDAO() {
	  		init();
	  }
	  
	  public static BookDAO getInstance() {
	  		return instance;
	  }
	  
	 // 실제 사용할 필드 및 메소드
	  private Book[] dataList;	//->저장공간 마련
	  private int listIndex;
	  
	  
	  private void init() {
	} {		 //초기화 해서 반복적으로 사용할 수 있게 init생성
	  		dataList = new Book[100];
	  		listIndex = -1;
	  }
	 
	 
	 // *INSERT구문 ( 새로운 것을 생성하는 구문)
	  @Override
	  public void insert(Book book) {
	  		dataList[++listIndex] = book;
	  }
	  
	  
	 //*UPDATE구문 (있던 데이터를 업데이트(교체)하는 형태)
	  @Override
	  public void update(Book book) {
	  		for(int i=0; i<=listIndex; i++) {
	  			if(dataList[i].getIsbn() == book.getIsbn()) {
	  				dataList[i] = book;
	  			}
	  		}
	  }
	 
	  @Override
	  public void delete(int isbn) {	//매소드의 이름 = 메소드의 기능
	 		for(int i=0; i<=listIndex; i++) {
				if(dataList[i].getIsbn() == isbn) {
	  				dataList[i] = null;		//delete에서 null값을 주며 중간중간 데이터를 비워주면 한번씩 비워서 공간을 당겨줘야함.
	  			}
	  		}
	  		cleanDataList();	
	  							 
	  }
	  
	  	//반드시 있어야 하는 기능만 그 매소드 안에 코딩하는게 맞지만. 반드시 일어나야 하는건 내부. 
	 	// cleanDataList같이 기능은해야하지만 필수적 기능은 아니라면 그 구문을 벗어난 곳에 적어줌.
	 
	  private void cleanDataList() {
	  		//기존 필드 -> 임시변수로 값 복사
	  		Book[] tempList = dataList; //tempList라는 변수를 줘서 데이터리스트를 그대로 복사
	  		int tempIndex = listIndex;	//tempIndex라는 변수를 줘서 리스트 갯수를 그대로 복사
			//기존 필드 초기화
	  		init();
	  
	 		//임시 변소 -> 기존필드로 값을 옮김
	  		for(int i=0; i<=tempIndex; i++) {
	  			if(tempList[i] != null) {	//null이 아닐 때 데이터를 옮겨감
	 				dataList[++listIndex] = tempList[i];
	  			}
	  		}
	  }
	  
	  
	  @Override
	  public Book[] selectAll() {
	  Book[] list = new Book[listIndex+1];		
	  
	  for(int i=0; i<=listIndex; i++) { 		//실제로 있는 값까지만 복사해야되니까 listIndex씀.
	  			list[i] = dataList[i];
	  		}
	 		return list;
	  }
	  
	  
	  @Override
	  public Book selectOne(int isbn) {
		  	Book book = null;
		  	int index = 0;
	  		for(int i=0; i<=listIndex; i++) {
	  			if(dataList[i].getIsbn() ==isbn) {
	  				book = dataList[i];
	  				//index = i; //인덱스 크기를 임의로 복사해서
	  				break;
	  			}
	  		}
	  		//return dataList[index]; //
	  		return book;
	  }
 }

