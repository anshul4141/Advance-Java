package com.rays.ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		try {
			List<UserBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("UserListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String op = request.getParameter("operation");
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
				request.setAttribute("errorMsg", "select at least one record to delete");
			}
		}

		if (op.equals("search")) {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
		}

		try {
			List<UserBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("UserListView.jsp", request, response);

	}

}
