package com.rays.prepareStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("Shyam");
		bean.setLastName("Yadav");
		bean.setLoginId("shyam@gmail.com");
		bean.setPassword("shyam@123");
		bean.setDob(sdf.parse("2003-03-11"));
		bean.setPhoneNo("8758632548");
		bean.setAddress("Bhopal");
		bean.setGender("Male");

		model.add(bean);

	}

}
