package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(3);
		bean.setFirstName("Kamal");
		bean.setLastName("Sharma");
		bean.setLoginId("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("Bhopal");
		bean.setDob(sdf.parse("2003-02-02"));

		model.add(bean);

	}

}
