package com.rays.bundle;

import java.util.ResourceBundle;

public class TestResourceBundle {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

		String url = rb.getString("url");
		String driver = rb.getString("driver");
		System.out.println("url=" + url + "\n" + "driver=" + driver);

	}

}
