package in.co.rays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;

public abstract class BaseCtl extends HttpServlet {

	// const buttons
	public static final String OP_SAVE = "Save";
	public static final String OP_UPDATE = "Update";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_RESET = "Reset";
	public static final String OP_LOG_OUT = "Logout";

	public static final String MSG_SUCCESS = "success";

	public static final String MSG_ERROR = "error";

	// for input validation
	protected boolean validate(HttpServletRequest request) {
		return true;
	}

	// for pre-load data
	protected void preload(HttpServletRequest request) {
	}

	// for get data from view and set into bean then return bean
	protected BaseBean populateBean(HttpServletRequest request) {
		return null;
	}

	// set createdBy, modifiedBy and createdDateTime, modifiedDateTime
	protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {
		return null;
	}

	// Generic work flow
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	// return view of same controller
	public abstract String getView();

}
