package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;

@WebServlet("/UserCtl")
public class UserCtl extends BaseCtl {

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
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "firstName is required");
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "firstName contains only alphabates");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "lastName is required");
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "lastName contains only alphabates");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("login"))) {
			request.setAttribute("login", "login is required");
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("login"))) {
			request.setAttribute("login", "invalid login format");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", "password is required");
			pass = false;
		} else if (!DataValidator.isPasswordLength(request.getParameter("password"))) {
			request.setAttribute("password", "password lenght min 8 or max 12");
			pass = false;
		} else if (!DataValidator.isPassword(request.getParameter("password"))) {
			request.setAttribute("password", "password must in xyz format");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", "confirmPassword is required");
			pass = false;
		} else if (!(request.getParameter("confirmPassword").equals(request.getParameter("password")))) {
			request.setAttribute("confirmPassword", "password and confirmPassword must be equal");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", "dob is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", "gender is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "mobileNo is required");
			pass = false;
		} else if (!DataValidator.isPhoneNo(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "invalid mobileNo format");
			pass = false;
		} else if (!DataValidator.isPhoneLength(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "phoneNo contain only 10 digit");
			pass = false;
		}

		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		bean.setRoleId(DataUtility.getLong(request.getParameter("roleId")));

		return bean;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		UserModel model = new UserModel();

		if (OP_SAVE.equals(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);
			try {
				if (bean.getId() > 0) {
					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("user updated successfully", request);
				} else {
					model.add(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("user added successfully", request);
				}
			} catch (ApplicationException | DuplicateRecordException e) {
				ServletUtility.setErrorMessage("user already exist", request);
				e.printStackTrace();
			}
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	public String getView() {
		return ORSView.USER_VIEW;
	}

}
