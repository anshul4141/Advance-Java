package com.rays.jdbc.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestMultiLanguage {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.app", new Locale("sp")); // app_sp
		
		String greeting = rb.getString("greeting");
		
		System.out.println(greeting);
		
	}

}
