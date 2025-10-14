package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		int pageNo = 1;
		int pageSize = 5;

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("list", list);
			request.setAttribute("nextList", nextList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String op = request.getParameter("operation");

		int pageNo = 1;
		int pageSize = 5;

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {

			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
						request.setAttribute("successMsg", "record deleted successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				request.setAttribute("errorMsg", "select at least one record");
			}

		}

		if (op.equals("search")) {
			try {
				bean.setDob(sdf.parse(request.getParameter("dob")));
				bean.setFirstName(request.getParameter("firstName"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals("next")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageNo++;
		}

		if (op.equals("previous")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageNo--;
		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("list", list);
			request.setAttribute("nextList", nextList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

}
