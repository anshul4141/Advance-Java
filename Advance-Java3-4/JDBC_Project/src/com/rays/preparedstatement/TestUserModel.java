package com.rays.preparedstatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) {

		try {
//			testAdd();
//			testDelete();
//			testUpdate();
			testFindByPk();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("Chintu");
		bean.setLastName("Chokshe");
		bean.setLogin("chintu@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2003-01-01"));

		model.add(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(8);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("Chintu");
		bean.setLastName("Chokshe");
		bean.setLogin("chintu@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2003-01-01"));

		model.update(bean);

	}

	public static void testFindByPk() throws SQLException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(10);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		} else {
			System.out.println("user not found");
		}

	}

}
