package com.rays.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontCtl", urlPatterns = "*.do")
public class FrontCtl implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		HttpSession session = request.getSession();

		// session.setMaxInactiveInterval(30);

		if (session.getAttribute("user") == null) {
			request.setAttribute("erorrMsg", "your session has been expired please login again..!");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("chain.doFilter method chali");
			chain.doFilter(request, response); // call next filter or controller in the chain
		}

	}

	@Override
	public void destroy() {
	}

}
