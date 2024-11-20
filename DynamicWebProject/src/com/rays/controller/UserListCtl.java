package com.rays.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		try {
			List list = model.search(bean, 0, 0);
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String op = request.getParameter("operation");

		System.out.println("op = " + op);

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {

			for (String id : ids) {

				try {
					model.delete(Integer.parseInt(id));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		try {

			if (op.equals("search")) {

				bean.setFirstName(request.getParameter("firstName"));
				bean.setLastName(request.getParameter("lastName"));

				if (request.getParameter("dob") != "") {

					bean.setDob(sdf.parse(request.getParameter("dob")));

				}

			}

			List list = model.search(bean, 0, 0);
			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

}
