package com.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class HiPropertiesTest {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("hi"));

		System.out.println(rb.getString("greeting"));

	}

}
