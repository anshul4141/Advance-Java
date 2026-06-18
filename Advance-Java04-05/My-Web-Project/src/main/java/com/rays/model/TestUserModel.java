package com.rays.model;

import java.util.Iterator;
import java.util.List;

import com.rays.bean.UserBean;

public class TestUserModel {

	public static void main(String[] args) {
		testSearch();
	}

	private static void testSearch() {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("Ma");
		List<UserBean> list = model.search(bean, 1, 2);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}

	}

}
