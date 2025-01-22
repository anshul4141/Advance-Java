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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		System.out.println("op = " + op);

		HttpSession session = req.getSession();

		if (op != null) {
			
			// no 1 to destroy session invalidate()
			session.invalidate();
			req.setAttribute("msg", "user logout successfully");
		}

		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String op = req.getParameter("operation");
		System.out.println("op == " + op);

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();

		if (op.equals("SignIn")) {

			try {
				bean = model.authenticate(loginId, password);

				if (bean != null) {

					System.out.println("User Login Successfully");
					session.setAttribute("user", bean);
					RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
					rd.forward(req, resp);

				} else {

					System.out.println("invalid loginId or password");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
