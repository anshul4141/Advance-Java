package com.rays.user;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		testSearch();

	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		List list = model.search();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();
			System.out.println(bean.getId() + " " + bean.getFirstName() + " " + bean.getLastName());

		}

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(29);

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(29);
		bean.setFirstName("Tarun");
		bean.setLastName("Verma");
		bean.setLoginId("Tarun@gmail.com");
		bean.setPassword("tarun123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2000-02-02"));

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setFirstName("abc");
		bean.setLastName("abc");
		bean.setLoginId("abc@gmail.com");
		bean.setPassword("abc123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2000-02-02"));

		model.add(bean);

	}

}
