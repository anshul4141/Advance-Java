package com.rays.jdbc.preparedstatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		testGetMeritList();

	}

	private static void testGetMeritList() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		List<MarksheetBean> list = model.getMeritList();

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getPhy());
			System.out.println(bean.getChm());
			System.out.println(bean.getMaths());
			int total = bean.getPhy() + bean.getChm() + bean.getMaths();
			double percentage = ((total) / 3);
			System.out.println(total);
			System.out.println(percentage);
		}

	}

}
