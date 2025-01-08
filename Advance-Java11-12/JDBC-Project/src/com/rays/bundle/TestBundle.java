package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("sp"));

		System.out.println(rb.getString("greeting"));
	}

}
