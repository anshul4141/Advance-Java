package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate(); // to destroy session
			request.setAttribute("successMsg", "user logout successfully");
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.authenticate(request.getParameter("loginId"), request.getParameter("password"));

		HttpSession session = request.getSession();

		if (bean != null) {
			session.setAttribute("user", bean);
			response.sendRedirect("WelcomeCtl");
		} else {
			request.setAttribute("errorMsg", "invalid login or password");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		}

	}

}
