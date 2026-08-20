package com.rays.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtility {

	public static void forward(String view, HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher(view);
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getErrorMessage(String key, HttpServletRequest request) {

		String val = (String) request.getAttribute(key);

		if (val != null) {
			return val;
		}
		return "";
	}

}
