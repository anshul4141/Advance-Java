package com.rays.jdbc.preparedstatement;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testAuthencticate();
//		testFindByPk();
		testSearch();

	}

	private static void testSearch() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List<UserBean> list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	private static void testFindByPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(3);

		if (bean != null) {
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testAuthencticate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("harshit@gmail.com", "harshit123");

		if (bean != null) {
			System.out.println("user login kar sakta hai...");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
		} else {
			System.out.println("invalid login or password");
		}

	}

	private static void testDelete() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(6);

		UserModel model = new UserModel();

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();

		bean.setId(3);
		bean.setFirstName("Harshita");
		bean.setLastName("Panchal");
		bean.setLogin("harshit@gmail.com");
		bean.setPassword("harshit123");
		bean.setDob(new Date());

		UserModel model = new UserModel();
		model.update(bean);

	}

	public static void testAdd() throws Exception {
		UserBean bean = new UserBean();

		bean.setId(4);
		bean.setFirstName("abc");
		bean.setLastName("abc");
		bean.setLogin("abc@gmail.com");
		bean.setPassword("abc123");
		bean.setDob(new Date());

		UserModel model = new UserModel();

		int id = model.add(bean);

		System.out.println("record inserted at id: " + id);
	}

}
