package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormCtl")
public class FormCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("FormView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do post method...............");

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		System.out.println(firstName);
		System.out.println(lastName);

		RequestDispatcher rd = req.getRequestDispatcher("FormView.jsp");
		rd.forward(req, resp);
	}

}
