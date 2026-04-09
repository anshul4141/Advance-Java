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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		int pageNo = 1;
		int pageSize = 10;

		try {
			List<UserBean> list = model.search(bean, pageNo, pageSize);
			List<UserBean> nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("nextList", nextList);
			request.setAttribute("pageNo", pageNo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		int pageNo = 1;
		int pageSize = 10;

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
				request.setAttribute("erorrMsg", "select at least one record");
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

		if (op.equals("search")) {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
		}

		try {
			List<UserBean> list = model.search(bean, pageNo, pageSize);
			List<UserBean> nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("nextList", nextList);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

}
