package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//doGet method handle HTTP GET request (HTTP GET request is a default request)
//doPost method handle HTTP POST request (When you submit request with parameter and form data when call HTTP POST request)

@WebServlet("/WelcomeCtl") // wild-card mapping of servlet to access servlet
public class WelcomeCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
		rd.forward(request, response); // forward method used to forward same request to it's own view

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
		rd.forward(request, response);

	}

}
