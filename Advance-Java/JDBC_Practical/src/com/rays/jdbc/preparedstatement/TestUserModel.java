package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		testAdd();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(4);
		bean.setFirstName("Suraj");
		bean.setLastName("Sahu");
		bean.setLogin("suraj@gmail.com");
		bean.setPassword("suraj123");
		bean.setDob(sdf.parse("2006-11-07"));

		model.add(bean);

	}

}
