package com.rays.prepareStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		// testUpdate();
		testSearchAll();

	}

	private static void testSearchAll() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.searchAll();

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());

		} else {
			System.out.println("data not found");
		}

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("Krishna");
		bean.setLastName("Yadav");
		bean.setLoginId("shyam@gmail.com");
		bean.setPassword("shyam@123");
		bean.setDob(sdf.parse("2003-03-11"));
		bean.setPhoneNo("8758632548");
		bean.setAddress("Bhopal");
		bean.setGender("Male");

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(2);

		model.delete(bean);

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
