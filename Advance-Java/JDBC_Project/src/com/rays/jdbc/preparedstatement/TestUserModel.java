package com.rays.jdbc.preparedstatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
		testUpdate();
//		testDelete();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("Ayan");
		bean.setLastName("Choudhary");
		bean.setLoginId("ayan@gmail.com");
		bean.setPassword("ayan123");
		bean.setDob(sdf.parse("2004-10-09"));

		model.add(bean);

	}

	public static void testUpdate() throws SQLException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("Ayan");
		bean.setLastName("Ahmed Choudhary");
		bean.setLoginId("ayan@gmail.com");
		bean.setPassword("ayan123");
		bean.setDob(sdf.parse("2004-10-09"));

		model.update(bean);

	}

	public static void testDelete() throws SQLException, ParseException {

		UserModel model = new UserModel();

		model.delete(8);

	}

}
