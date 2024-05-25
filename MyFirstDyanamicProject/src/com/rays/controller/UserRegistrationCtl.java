package com.rays.controller;

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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("UserRegistrationView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String loginId = request.getParameter("email");
		String pwd = request.getParameter("password");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");

		try {
			bean.setFirstName(fname);
			bean.setLastName(lname);
			bean.setLoginId(loginId);
			bean.setPassword(pwd);
			bean.setDob(sdf.parse(dob));
			bean.setAddress(address);
			model.add(bean);
			request.setAttribute("msg", "User Register Successfully");
		} catch (Exception e) {
			request.setAttribute("msg", "Data Not Inserted");
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(request, response);

	}

}
