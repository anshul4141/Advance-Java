package com.rays.test;

import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("user"));
		System.out.println(rb.getString("password"));

	}

}
