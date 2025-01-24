package com.rays.controller;

import java.io.IOException;
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

		int pageNo = 1;
		int pageSize = 5;

		try {
			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
		} catch (Exception e) {
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String op = request.getParameter("operation");
		System.out.println("op = " + op);

		int pageNo = 1;
		int pageSize = 5;

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {

			if (ids != null && ids.length > 0) {

				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
					}

				}

			} else {
				System.out.println("select at least one record");
			}

		}

		try {

			if (op.equals("search")) {
				bean.setFirstName(request.getParameter("firstName"));
				bean.setLastName(request.getParameter("lastName"));
			}

			if (op.equals("next")) {

				pageNo = Integer.parseInt(request.getParameter("pageNo"));

				pageNo++;

			}

			if (op.equals("previous")) {

				pageNo = Integer.parseInt(request.getParameter("pageNo"));

				pageNo--;

			}

			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
		} catch (Exception e) {
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

}
