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

@WebFilter(urlPatterns = "*.do")
public class FrontCtl implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("in frontCtl doFilter method");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		//session.setMaxInactiveInterval(15);

		if (session.getAttribute("user") == null) {
			req.setAttribute("errorMsg", "your session is expired, please login again!");
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		} else {
			chain.doFilter(req, res); // call next config filter / controller in the chain
		}

	}

	@Override
	public void destroy() {

	}

}
