package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// request.getParameter("") method use to get data from view
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(login);
		System.out.println(password);
		System.out.println(dob);

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		try {
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLogin(login);
			bean.setPassword(password);
			bean.setDob(sdf.parse(dob));

			model.add(bean);

		} catch (Exception e) {

		}

		RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(request, response);

	}

}