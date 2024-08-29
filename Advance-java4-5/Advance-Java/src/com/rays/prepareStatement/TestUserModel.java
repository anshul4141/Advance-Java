package com.rays.prepareStatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		// testUpdate();
		// testSearchAll();
		// testAuthenticate();
		// testFindByLoginId();
		testSearch();

	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		//bean.setFirstName("Ram");
		//bean.setLastName("Yadav");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getGender());
			System.out.println(bean.getAddress());

		}

	}

	private static void testFindByLoginId() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.findByLoginId("ram123@gmail.com");

		if (bean != null) {
			System.out.println("loginId already exists");
		} else {
			System.out.println("loginId is not available");
		}

	}

	private static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.authenticate("ram@gmail.com", "pass123");

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getGender());
			System.out.println(bean.getAddress());

		} else {
			System.out.println("invalid loginId or password");
		}

	}

	private static void testSearchAll() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.searchAll();

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());

		} else {
			System.out.println("data not found");
		}

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("Krishna");
		bean.setLastName("Yadav");
		bean.setLoginId("shyam@gmail.com");
		bean.setPassword("shyam@123");
		bean.setDob(sdf.parse("2003-03-11"));
		bean.setPhoneNo("8758632548");
		bean.setAddress("Bhopal");
		bean.setGender("Male");

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(2);

		model.delete(bean);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(3);
		bean.setFirstName("Shyam");
		bean.setLastName("Yadav");
		bean.setLoginId("shyam123@gmail.com");
		bean.setPassword("shyam@123");
		bean.setDob(sdf.parse("2003-03-11"));
		bean.setPhoneNo("8758632548");
		bean.setAddress("Bhopal");
		bean.setGender("Male");

		model.add(bean);

	}

}
