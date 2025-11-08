package com.rays.controller;

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
			session.invalidate(); // session destroy
			request.setAttribute("successMsg", "user logout successfully");
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			bean = model.authenticate(login, password);
			if (bean != null) {
				System.out.println("user login successfully");
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");

			} else {
				System.out.println("invalid login or password");
				request.setAttribute("errorMsg", "invalid login or password");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
		}

	}

}
