package com.rays.ctl;

import java.io.IOException;

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
		
		System.out.println("op == " + op);
		
		if(op != null) {
			HttpSession session = request.getSession();
			session.invalidate(); // session destroy
		}
		
		response.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {
			bean = model.authenticate(login, password);
			session.setAttribute("user", bean);
			response.sendRedirect("WelcomeCtl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
