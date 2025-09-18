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

		bean.setFirstName("Lucky");
		bean.setLastName("Tomar");
		bean.setLogin("lucky@gmail.com");
		bean.setPassword("lucky123");
		bean.setDob(sdf.parse("2005-01-18"));

		model.add(bean);

	}

}
