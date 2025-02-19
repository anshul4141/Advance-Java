package com.rays.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		// testSearch();
		testFindByPk();

	}

	private static void testFindByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(3);

		if (bean == null) {
			System.out.println("record not found");
		} else {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getGender());
			System.out.println("\t" + bean.getDob());
		}
	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getGender());
			System.out.println("\t" + bean.getDob());
		}

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(2);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("Aman");
		bean.setLastName("Sharma");
		bean.setLoginId("aman@gmail.com");
		bean.setPassword("aman123");
		bean.setAddress("bhopal");
		bean.setGender("male");
		bean.setDob(sdf.parse("2001-02-02"));

		UserModel model = new UserModel();

		model.add(bean);

	}

}
