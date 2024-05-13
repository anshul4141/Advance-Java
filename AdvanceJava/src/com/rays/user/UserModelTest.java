package com.rays.user;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserModelTest {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testFindByPk();
//		testFindByLoginId();
//		testAuth();

		testSearch();

	}

	private static void testSearch() throws Exception {

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		List list = new ArrayList();

//		bean.setFirstName("M");
//		bean.setDob(new java.sql.Date().getTime());

		list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.println(bean.getFirstName());

		}

	}

	private static void testAuth() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean = model.authenticate("anshul@gmail.com", "pass@123");

		if (bean != null) {

			System.out.println("user login successfully");
			System.out.println(bean.getFirstName());

		} else {
			System.out.println("invalid loginId or password");
		}

	}

	private static void testFindByLoginId() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean = model.findByLoginId("anshul123@gmail.com");

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());

		} else {
			System.out.println("login id not found");
		}

	}

	private static void testFindByPk() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean = model.findByPk(6);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean.setFirstName("Manoj");
		bean.setLastName("Sharma");
		bean.setLoginId("manoj@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2001-04-02"));
		bean.setAddress("Ujjain");

		model.add(bean);

	}

}
