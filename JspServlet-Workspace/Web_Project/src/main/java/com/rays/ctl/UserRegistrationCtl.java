package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("UserRegistrationView.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setFirstName(firstName.trim());
			bean.setLastName(lastName.trim());
			bean.setLoginId(login.trim());
			bean.setPassword(password.trim());
			bean.setDob(sdf.parse(dob.trim()));
			model.add(bean);

			request.setAttribute("successMsg", "user registration successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "loginId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("UserRegistrationView.jsp", request, response);

	}

}
