package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		// testUpdate();
		testSearch();

	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();

		List list = model.search();

		Iterator it = list.iterator();

		UserBean bean = new UserBean();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
		}

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(3);
		bean.setFirstName("Tarun");
		bean.setLastName("Sharma");
		bean.setLoginId("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("Bhopal");
		bean.setDob(sdf.parse("2003-02-02"));

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(3);

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
