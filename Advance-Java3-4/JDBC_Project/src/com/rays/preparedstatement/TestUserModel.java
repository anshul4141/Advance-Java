package com.rays.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) {

		try {
//			testAdd();
//			testDelete();
			testUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testAdd() throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		UserModel model = new UserModel();
	
		model.add(8, "Kashif", "Ansari", "kashif@gmail.com", "pass123", sdf.parse("2002-01-01"));

	}
	
	public static void testDelete() throws Exception {
		
		UserModel model = new UserModel();
		
		model.delete(8);
		
	}
	
	public static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		UserModel model = new UserModel();
	
		model.update(8, "Kashif", "Ansari", "kashif@gmail.com", "pass123", sdf.parse("2006-12-06"));

	}

}
