package memory;

public class MainTest {

	public static void main(String[] args) {
		int sum = 0;
		if (args != null) {						// args가 null이 맞는지 for문으로 알아보기.
			for(int i=0; i<args.length; i++) {
				sum += Integer.parseInt(args[i]);
				
			}
		}
		System.out.println("합계=" + sum);
	}

}
