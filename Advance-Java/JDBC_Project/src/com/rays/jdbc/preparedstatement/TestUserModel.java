package com.rays.jdbc.preparedstatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {

	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {
		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setId(10);
		bean.setFirstName("Ayan");
		bean.setLastName("Choudhary");
		bean.setLoginId("ayan123@gmail.com");
		bean.setPassword("ayan123");
		bean.setDob(sdf.parse("2004-10-09"));

		model.add(bean);

	}

	public static void testUpdate() throws SQLException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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

		model.delete(8);

	}

	public static void testFindByPk() throws SQLException {

		UserBean bean = new UserBean();

		bean = model.findByPk(10);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		} else {
			throw new RuntimeException("record not found");
		}

	}

}
