package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
//		testfinByLogin();
//		testfinByPk();
//		testAuthenticate();
		testSearch();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);
		bean.setFirstName("Suraj");
		bean.setLastName("Sahu");
		bean.setLogin("suraj@gmail.com");
		bean.setPassword("suraj123");
		bean.setDob(sdf.parse("2006-11-07"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);
		bean.setFirstName("Suman");
		bean.setLastName("Sahu");
		bean.setLogin("suraj@gmail.com");
		bean.setPassword("suraj123");
		bean.setDob(sdf.parse("2006-11-07"));

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);

		model.delete(bean);

	}

	public static void testfinByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("ram123@gmail.com");

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	public static void testfinByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(7);

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	public static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("ram@gmail.com", "ram123");

		if (bean == null) {
			System.out.println("invalid login and password");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List list = model.search();
		
		Iterator<UserBean> it = list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println("--------------");
		}

	}

}
