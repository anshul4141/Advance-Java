package com.rays.util;

import javax.servlet.http.HttpServletRequest;

public class InputValidatorUtility {

	public static boolean loginValidator(HttpServletRequest request) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean pass = true;

		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "loginId is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		} 
//		else if (password.length() < 8 || password.length() > 12) {
//			pass = false;
//			request.setAttribute("password", "password lenght shuld be > 8 or == 12");
//		}

		return pass;

	}

}
