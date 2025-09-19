package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();
//		testDelete();
//		testUpdate();
//		testFindByLogin();

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
		
		if(existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");
		}
		
	}

}
