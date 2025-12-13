package in.co.rays.proj4.util;

import java.util.Calendar;
import java.util.Date;

public class DataValidator {

	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	public static boolean isInteger(String val) {

		if (isNotNull(val)) {
			try {
				Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isLong(String val) {
		if (isNotNull(val)) {
			try {
				Long.parseLong(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isEmail(String val) {

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(val)) {
			try {
				return val.matches(emailreg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isName(String val) {

		String namereg = "^[^-\\s][\\p{L} .'-]+$";

		if (isNotNull(val)) {
			try {
				return val.matches(namereg);
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isRollNo(String val) {

		String rollreg = "[a-zA-Z]{2}[0-9]{3}";

		if (isNotNull(val)) {
			try {
				return val.matches(rollreg);
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isPassword(String val) {

		String passreg = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,12}";

		if (isNotNull(val)) {
			try {
				return val.matches(passreg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isPasswordLength(String val) {

		if (isNotNull(val) && val.length() >= 8 && val.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPhoneNo(String val) {

		String phonereg = "^[6-9][0-9]{9}$";

		if (isNotNull(val)) {
			try {
				return val.matches(phonereg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isPhoneLength(String val) {

		if (isNotNull(val) && val.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isDate(String val) {

		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}

	public static boolean isSunday(String val) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(DataUtility.getDate(val));
		int i = cal.get(Calendar.DAY_OF_WEEK);

		if (i == Calendar.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		// Test isNull and isNotNull
		System.out.println("isNull Test:");
		System.out.println("Empty String: " + isNull(""));
		System.out.println("Null String: " + isNull(null));
		System.out.println("Non-null String: " + isNotNull("Hello"));

		// Test isInteger
		System.out.println("\nisInteger Test:");
		System.out.println("Valid Integer String: '123' -> " + isInteger("123"));
		System.out.println("Invalid Integer String: 'abc' -> " + isInteger("abc"));
		System.out.println("Null String: -> " + isInteger(null));

		// Test isLong
		System.out.println("\nisLong Test:");
		System.out.println("Valid Long String: '1234567890' -> " + isLong("1234567890"));
		System.out.println("Invalid Long String: 'abc' -> " + isLong("abc"));

		// Test isEmail
		System.out.println("\nisEmail Test:");
		System.out.println("Valid Email: 'test@example.com' -> " + isEmail("test@example.com"));
		System.out.println("Invalid Email: 'test@.com' -> " + isEmail("test@.com"));

		// Test isName
		System.out.println("\nisName Test:");
		System.out.println("Valid Name: 'John Doe' -> " + isName("John Doe"));
		System.out.println("Invalid Name: '123John' -> " + isName("123John"));

		// Test isRollNo
		System.out.println("\nisRollNo Test:");
		System.out.println("Valid RollNo: 'AB123' -> " + isRollNo("AB123"));
		System.out.println("Invalid RollNo: 'A1234' -> " + isRollNo("A1234"));

		// Test isPassword
		System.out.println("\nisPassword Test:");
		System.out.println("Valid Password: 'Passw0rd@123' -> " + isPassword("Passw0rd@123"));
		System.out.println("Invalid Password: 'pass123' -> " + isPassword("pass123"));

		// Test isPasswordLength
		System.out.println("\nisPasswordLength Test:");
		System.out.println("Valid Password Length: 'Passw0rd' -> " + isPasswordLength("Passw0rd"));
		System.out.println("Invalid Password Length: 'pass' -> " + isPasswordLength("pass"));

		// Test isPhoneNo
		System.out.println("\nisPhoneNo Test:");
		System.out.println("Valid PhoneNo: '9876543210' -> " + isPhoneNo("9876543210"));
		System.out.println("Invalid PhoneNo: '1234567890' -> " + isPhoneNo("1234567890"));

		// Test isPhoneLength
		System.out.println("\nisPhoneLength Test:");
		System.out.println("Valid Phone Length: '9876543210' -> " + isPhoneLength("9876543210"));
		System.out.println("Invalid Phone Length: '98765' -> " + isPhoneLength("98765"));

		// Test isDate
		System.out.println("\nisDate Test:");
		System.out.println("Valid Date: '01-01-2025' -> " + isDate("2025-01-01"));
		System.out.println("Invalid Date: '10/15/2024' -> " + isDate("10/15/2024"));

		// Test isSunday
		System.out.println("\nisSunday Test:");
		System.out.println("Date on Sunday: '10/13/2024' -> " + isSunday("10/13/2024"));
		System.out.println("Date not on Sunday: '10/15/2024' -> " + isSunday("10/15/2024"));
	}
}
