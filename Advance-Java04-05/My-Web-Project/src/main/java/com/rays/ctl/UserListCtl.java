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

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		int pageNo = 1;
		int pageSize = 5;

		if (op != null && op.equals("search")) {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
		}

		if (op != null && op.equals("delete")) {
			String[] ids = request.getParameterValues("ids");
			if(ids != null && ids.length > 0) {
				for(String id : ids) {
					model.delete(Integer.parseInt(id));
					request.setAttribute("successMsg", "record deleted successfully");
				}
			} else {
				request.setAttribute("errorMsg", "select at least one record to delete..!");
			}
		}

		List<UserBean> list = model.search(bean, pageNo, pageSize);

		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

}
