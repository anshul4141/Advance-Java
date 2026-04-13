package com.rays.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();

		for (int i = 0; i < cookies.length; i++) {

			Cookie c = cookies[i];

			String name = c.getName();
			String value = c.getValue();

			System.out.println("name => " + name);
			System.out.println("value => " + value);
		}
	}
}