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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		HttpSession session = request.getSession();

		if (op != null) {

			session.invalidate();
			request.setAttribute("msg", "User Logout Successfully");

		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		HttpSession session = request.getSession();

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		if (op.equals("SignIn")) {

			try {
				bean = model.authenticate(loginId, password);

				if (bean != null) {

					session.setAttribute("user", bean);

					RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("err", "Invalid loginId or Password");
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
