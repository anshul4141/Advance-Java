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

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String id = request.getParameter("id");

		if (id != null) {
			try {
				bean = model.findById(Integer.parseInt(id));
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String op = request.getParameter("operation");

		System.out.println("op === " + op);

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String phoneNo = request.getParameter("phoneNo");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");

		try {
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassword(password);
			bean.setDob(sdf.parse(dob));
			bean.setPhoneNo(phoneNo);
			bean.setAddress(address);
			bean.setGender(gender);

			if (op.equals("add")) {
				model.add(bean);
				request.setAttribute("smsg", "User Added successfully..");
			} else if (op.equals("update")) {
				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				request.setAttribute("smsg", "User Updated successfully..");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");

		rd.forward(request, response);
	}

}
