package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();
//		testUpdate();
//		testDelete();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(23);
		bean.setFirstName("Naman");
		bean.setLastName("yadav");
		bean.setLoginId("naman@gmail.com");
		bean.setPassword("pass");
		bean.setDob(sdf.parse("2002-02-02"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(22);
		bean.setFirstName("Harshit");
		bean.setLastName("yadav");
		bean.setLoginId("harshit@gmail.com");
		bean.setPassword("pass");
		bean.setDob(sdf.parse("2002-02-02"));

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(22);

	}

}
