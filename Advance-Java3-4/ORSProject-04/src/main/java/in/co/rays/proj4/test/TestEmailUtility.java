package in.co.rays.proj4.test;

import java.util.HashMap;

import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.util.EmailBuilder;
import in.co.rays.proj4.util.EmailMessage;
import in.co.rays.proj4.util.EmailUtility;

public class TestEmailUtility {

	public static void main(String[] args) {

		try {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("login", "chetan50682@gmail.com");
			map.put("password", "pass123");

			String message = EmailBuilder.getUserRegistrationMessage(map);

			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setTo("chetan50682@gmail.com");
			emailMessage.setSubject("Registration is successful for ORS Project");
			emailMessage.setMessage(message);
			emailMessage.setMessageType(EmailMessage.HTML_MSG);

			EmailUtility.sendMail(emailMessage);

			System.out.println("Email sent successfully.");

		} catch (ApplicationException ex) {
			ex.printStackTrace();
			System.err.println("Failed to send email: " + ex.getMessage());
		}

	}

}
