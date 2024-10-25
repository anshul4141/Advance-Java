package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();
		// testDelete();
		// testUpdate();
		// testSearch();
		// testAuthenticate();
		// testFindById();

	}

	private static void testFindById() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.findById(6);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getAddress());
			System.out.println(bean.getDob());

		} else {
			System.out.println("user not found");
		}

	}

	private static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.authenticate("ram123@gmail.com", "pass123");

		if (bean != null) {
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		// bean.setFirstName("Ram");
		// bean.setLastName("Gupta");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getAddress());
			System.out.println(bean.getDob());
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

		model.delete(4);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setFirstName("pawan");
		bean.setLastName("Sharma");
		bean.setLoginId("pawan@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("Bhopal");
		bean.setDob(sdf.parse("2003-02-02"));

		model.add(bean);

	}

}
