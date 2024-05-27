package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		System.out.println("id ====>" + id);

		if (id != null) {

			try {
				bean = model.findByPk(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

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
			bean.setDob(sdf.parse(dob));
			bean.setFirstName(fname);
			bean.setLastName(lname);
			bean.setLoginId(loginId);
			bean.setPassword(pwd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bean.setAddress(address);

		if (op.equals("save")) {

			try {
				model.add(bean);
				request.setAttribute("msg", "user added successfully");
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (op.equals("update")) {
			String id = request.getParameter("id");
			bean.setId(Integer.parseInt(id));

			try {
				model.update(bean);
				request.setAttribute("msg", "user Updated successfully");
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);

	}
}
