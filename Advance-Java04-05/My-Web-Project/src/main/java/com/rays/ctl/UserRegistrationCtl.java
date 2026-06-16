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

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		try {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
			bean.setLoginId(request.getParameter("loginId"));
			bean.setPassword(request.getParameter("password"));
			bean.setDob(sdf.parse(request.getParameter("dob")));

			model.add(bean);
			request.setAttribute("successMsg", "user saved successfully");
			request.setAttribute("bean", bean);
			System.out.println("user saved successfully");
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			System.out.println("somthing wrong in saved user");
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(request, response);

	}

}
