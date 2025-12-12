package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.ServletUtility;

@WebServlet(name = "UserListCtl", urlPatterns = { "/UserListCtl" })
public class UserListCtl extends BaseCtl {
	
	@Override
	protected void preload(HttpServletRequest request) {

		RoleModel model = new RoleModel();

		try {
			List roleList = model.list();
			request.setAttribute("roleList", roleList);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setRoleId(DataUtility.getLong(request.getParameter("roleId")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));

		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageNo = 1;
		int pageSize = 10;

		UserBean bean = (UserBean) populateBean(request);
		UserModel model = new UserModel();

		try {
			List<UserBean> list = model.search(bean, pageNo, pageSize);
			List<UserBean> next = model.search(bean, pageNo + 1, pageSize);

			if (list == null || list.isEmpty()) {
				ServletUtility.setErrorMessage("No record found", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.setBean(bean, request);
			request.setAttribute("nextListSize", next.size());

			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = null;
		List next = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = 10;

		UserBean bean = (UserBean) populateBean(request);
		UserModel model = new UserModel();

		String op = DataUtility.getString(request.getParameter("operation"));
		String[] ids = request.getParameterValues("ids");

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.USER_CTL, request, response);
				return;

			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					UserBean deletebean = new UserBean();
					for (String id : ids) {
						deletebean.setId(DataUtility.getInt(id));
						model.delete(deletebean);
						ServletUtility.setSuccessMessage("User deleted successfully", request);
					}
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}

			} else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
				return;

			} else if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
				return;
			}

			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.setBean(bean, request);
			request.setAttribute("nextListSize", next.size());

			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public String getView() {
		return ORSView.USER_LIST_VIEW;
	}
}