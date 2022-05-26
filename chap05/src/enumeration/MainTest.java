package enumeration;

import java.util.Calendar;

public class MainTest {
//열거타입. 이런것도 있다는거 알아두기~
	public static void main(String[] args) {
		Week today = null;
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
		case 1:	 //Week값이 1이면 우리가 지정한 SUNDAY의 값이 today에 들어감.
			today = Week.SUNDAY;
			break;
		case 2:	 //Week값이 2이면 우리가 지정한 MONDAY의 값이 today에 들어감.
			today = Week.MONDAY;
			break;
		case 3:	 //Week값이 3이면 우리가 지정한 TUESDAY의 값이 today에 들어감.
			today = Week.TUESDAY;
			break;
		case 4:	 //Week값이 4이면 우리가 지정한 WEDNESDAY의 값이 today에 들어감.
			today = Week.WEDNESDAY;
			break;
		case 5:	 //Week값이 5이면 우리가 지정한 THURSDAY의 값이 today에 들어감.
			today = Week.THURSDAY;
			break;
		case 6:	 //Week값이 6이면 우리가 지정한 FRIDAY의 값이 today에 들어감.
			today = Week.FRIDAY;
			break;
		case 7:	 //Week값이 7이면 우리가 지정한 SATURDAY의 값이 today에 들어감.
			today = Week.SATURDAY;
			break;
		}
		System.out.println("오늘 요일 : " + today);
	}

}
