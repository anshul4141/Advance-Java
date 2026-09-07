package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByLogin();
		testSearch();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Chinmay");
		bean.setLastName("Khede");
		bean.setLoginId("chinmay@gmail.com");
		bean.setPassword("chinmay123");
		bean.setDob(sdf.parse("2002-10-23"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(17);
		bean.setFirstName("Chinmay");
		bean.setLastName("Khede");
		bean.setLoginId("chinmay@gmail.com");
		bean.setPassword("chinmay123");
		bean.setDob(sdf.parse("2002-10-23"));

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(17);

	}

	public static void testFindByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(20);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getPassword());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getDob());
		} else {
			System.out.println("user not found");
		}

	}

	public static void testFindByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("chinmayghj@gmail.com");
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getPassword());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getDob());

	}

	public static void testSearch() {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getPassword());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getDob());
			System.out.println("-----------------");
		}

	}

}
