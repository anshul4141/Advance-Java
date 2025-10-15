package com.rays.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataValidator {

	public static boolean signUpValidation(HttpServletRequest request) {

		boolean isValid = true;

		System.out.println("firstName: " + request.getParameter("firstName"));

		if (request.getParameter("firstName") == "") {
			request.setAttribute("firstName", "firstName is required");
			System.out.println("firstName is required");
			isValid = false;
		}
		if (request.getParameter("lastName") == "") {
			request.setAttribute("lastName", "lastName is required");
			System.out.println("lastName is required");
			isValid = false;
		}
		if (request.getParameter("login") == "") {
			request.setAttribute("login", "login is required");
			System.out.println("login is required");
			isValid = false;
		} else if (!request.getParameter("login").endsWith("@gmail.com")) {
			request.setAttribute("login", "invalid login format");
			isValid = false;
		}
		if (request.getParameter("password") == "") {
			request.setAttribute("password", "password is required");
			System.out.println("password is required");
			isValid = false;
		} else if (!(request.getParameter("password").length() >= 8
				|| request.getParameter("password").length() <= 12)) {
			request.setAttribute("password", "Your password must be between 8 and 12 characters long.");
			System.out.println("password is required");
			isValid = false;
		}
		if (request.getParameter("dob") == "") {
			request.setAttribute("dob", "dob is required");
			System.out.println("dob is required");
			isValid = false;
		} else if (!(request.getParameter("dob") == "")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date dob = sdf.parse(request.getParameter("dob"));
				Date now = new Date();
				int age = now.getYear() - dob.getYear();
				if (!(age >= 18 && age <= 60)) {
					request.setAttribute("dob", "you are not eligible for this web site");
					isValid = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return isValid;

	}

}
