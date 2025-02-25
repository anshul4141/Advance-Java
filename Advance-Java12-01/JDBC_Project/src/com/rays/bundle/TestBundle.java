package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

		String url = rb.getString("url");
		String driver = rb.getString("driver");
		String username = rb.getString("username");
		String password = rb.getString("password");

		System.out.println(url);
		System.out.println(driver);
		System.out.println(username);
		System.out.println(password);

		System.out.println("-----------------");

		rb = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("hi"));

		System.out.println(rb.getString("greeting"));
	}

}
