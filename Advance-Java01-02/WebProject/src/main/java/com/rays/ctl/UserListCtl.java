package com.rays.ctl;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<UserBean> list = null;
		UserModel model = new UserModel();

		int pageNo = 1;
		int pageSize = 5;

		try {
			list = model.search(null, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		int pageNo = 1;
		int pageSize = 5;

		String op = request.getParameter("operation");
		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {

			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					bean.setId(Integer.parseInt(id));
					try {
						model.delete(bean);
						request.setAttribute("successMsg", "record deleted successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				request.setAttribute("errorMsg", "select at least one record to delete");
			}

		}

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

		List<UserBean> list = null;

		try {
			list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

}
