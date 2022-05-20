package memory;

public class ExceptionTest {

	public static void main(String[] args) {

		int[] a = new int[5];
		System.out.println(a[0]);
		//
		int[] b = null; //null은 참조값이 없다는 뜻이므로 nullpointer에러 남. -> if(b != null) {로 해주면 에러 안남.
		System.out.println(b[0]);
		
		
	}

}
