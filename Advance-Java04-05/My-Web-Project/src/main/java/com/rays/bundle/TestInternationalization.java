package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestInternationalization {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.message", new Locale("hi"));

		System.out.println(rb.getString("msg.hello"));

	}

}
