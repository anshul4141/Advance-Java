package com.rays.jdbc.preparedstatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
		testDelete();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();

		model.add(8, "Abhay", "Malve", "mave@gmail.com", "pass123", sdf.parse("2002-04-09"));

	}

	public static void testUpdate() throws SQLException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();

		model.update(8, "Abhay", "Malve", "mave@gmail.com", "abhay123", sdf.parse("2002-04-09"));

	}

	public static void testDelete() throws SQLException, ParseException {

		UserModel model = new UserModel();

		model.delete(8);

	}

}
