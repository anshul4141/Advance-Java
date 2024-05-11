package com.rays.user;

import java.text.SimpleDateFormat;

public class UserModelTest {

	public static void main(String[] args) throws Exception {

//		testAdd();
		testFindByPk();

	}

	private static void testFindByPk() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean = model.findByPk(6);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean.setFirstName("Pratik");
		bean.setLastName("Sharma");
		bean.setLoginId("pratik@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2001-04-02"));
		bean.setAddress("Ujjain");

		model.add(bean);

	}

}
