package com.rays.jdbc.bundle;

import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.app");
		
		System.out.println(rb.getString("driver"));
		
	}

}
