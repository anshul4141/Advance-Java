package com.rays.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstSession")
public class FirstSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// session is not create when i pass false in getSession method but session is
		// already created it continue the session
		HttpSession session = req.getSession(false);

		if (session != null) {

			System.out.println("First Session = " + session.getId());

		} else {

			System.out.println("Session is null");

		}

	}

}
