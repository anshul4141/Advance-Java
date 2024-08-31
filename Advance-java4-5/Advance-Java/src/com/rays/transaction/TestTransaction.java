package com.rays.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

		Class.forName(rb.getString("driver"));

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));

			Statement stmt = conn.createStatement();

			// step 1
			conn.setAutoCommit(false);

			int i = stmt.executeUpdate(
					"insert into user values(4,'user1','user1','user1@gmail.com','user123','2001-02-02','89858784589','indore','male')");

			i = stmt.executeUpdate(
					"insert into user values(4,'user1','user1','user1@gmail.com','user123','2001-02-02','89858784589','indore','male')");

			i = stmt.executeUpdate(
					"insert into user values(6,'user1','user1','user1@gmail.com','user123','2001-02-02','89858784589','indore','male')");

			// step 2
			conn.commit();

			System.out.println("data inserted successfully " + i);

		} catch (Exception e) {

			// step 3
			conn.rollback();
			e.printStackTrace();

		}

	}

}
