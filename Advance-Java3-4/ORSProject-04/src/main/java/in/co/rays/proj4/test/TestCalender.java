package in.co.rays.proj4.test;

import java.util.Calendar;
import java.util.Date;

public class TestCalender {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date());

		cal.add(Calendar.DATE, -10);
		
		System.out.println(cal.getTime());

	}

}
