package com.rays.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontCtl", urlPatterns = { "*.do" })
public class FrontCtl implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();

		// session.setMaxInactiveInterval(20);

		if (session.getAttribute("user") == null) {

			request.setAttribute("msg", "Your session is expired.. please login again");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);

		} else {
			chain.doFilter(request, response);
		}

	}

}
