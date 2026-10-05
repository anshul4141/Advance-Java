package com.rays.jdbc.preparedstatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
		testSearch();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(22);
		bean.setFirstName("Naman");
		bean.setLastName("sharma");
		bean.setLoginId("naman@gmail.com");
		bean.setPassword("pass");
		bean.setDob(sdf.parse("2002-02-02"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(22);
		bean.setFirstName("Harshit");
		bean.setLastName("yadav");
		bean.setLoginId("harshit@gmail.com");
		bean.setPassword("pass");
		bean.setDob(sdf.parse("2002-02-02"));

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(22);

	}

	public static void testFindByPk() throws SQLException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(200);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

	}

	public static void testSearch() throws SQLException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

//		bean.setFirstName("r");

		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println("-------------");
		}

	}

}
