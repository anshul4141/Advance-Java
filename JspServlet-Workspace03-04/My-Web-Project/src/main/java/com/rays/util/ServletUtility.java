package com.rays.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtility {

	public static void forward(String page, HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getErrorMessage(HttpServletRequest request) {

		String errorMsg = (String) request.getAttribute("errorMsg");

		if (errorMsg != null) {
			return errorMsg;
		}
		return "";
	}

	public static void setErrorMessage(String msg, HttpServletRequest request) {
		request.setAttribute("errorMsg", msg);
	}

	public static String getSuccesMessage(HttpServletRequest request) {

		String succMsg = (String) request.getAttribute("succMsg");

		if (succMsg != null) {
			return succMsg;
		}
		return "";
	}

	public static void setSuccMessage(String msg, HttpServletRequest request) {
		request.setAttribute("succMsg", msg);
	}

}
