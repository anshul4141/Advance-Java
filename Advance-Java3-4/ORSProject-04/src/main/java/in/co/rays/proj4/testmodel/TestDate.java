package in.co.rays.proj4.testmodel;

import java.sql.Timestamp;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) {
		
		Date d = new Date();
		
		System.out.println(d);
		System.out.println(d.getTime());
		
		Timestamp ts =  new Timestamp(d.getTime());
		
	}

}
