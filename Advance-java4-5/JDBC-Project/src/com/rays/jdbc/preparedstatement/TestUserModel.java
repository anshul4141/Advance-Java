package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testDelete();
//		testUpdate();
//		testFindByLogin();
//		changePassword();
		testSearch();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setFirstName("Lucky");
		bean.setLastName("Tomar");
		bean.setLogin("lucky@gmail.com");
		bean.setPassword("lucky123");
		bean.setDob(sdf.parse("2005-01-18"));

		model.add(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(3);

		model.delete(bean);

	}

	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(1);
		bean.setFirstName("Lucky");
		bean.setLastName("Tomar");
		bean.setLogin("lucky123@gmail.com");
		bean.setPassword("lucky123");
		bean.setDob(sdf.parse("2005-01-18"));

		model.update(bean);
	}

	public static void testFindByLogin() throws Exception {

		UserModel model = new UserModel();

		UserBean existsBean = model.findByLogin("lucky@gmail.com");

		if (existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");
		}

	}

	public static void changePassword() throws Exception {

		UserModel model = new UserModel();

		model.changePassword("shyam@2021", "shyam@2021", "shyam@gmail.com");

	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();
		bean.setFirstName("L");
		bean.setLastName("Sharma");

		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}

	}

}
