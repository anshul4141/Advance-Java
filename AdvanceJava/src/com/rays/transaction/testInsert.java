package com.rays.transaction;

import java.sql.Connection;
import java.sql.Statement;

import com.rays.util.JDBCDataSource;

public class testInsert {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			Statement stmt = conn.createStatement();

			conn.setAutoCommit(false);

			int i = stmt.executeUpdate(
					"insert into users values(7, 'niraj', 'chopra', 'niraj@gmail.com', 'pass@123', '2002-12-13', 'Indore')");

			i = stmt.executeUpdate(
					"insert into users values(8, 'Avnish', 'Upadhyay', 'avnish@gmail.com', 'pass@123', '2002-12-13', 'Indore')");

			i = stmt.executeUpdate(
					"insert into users values(7, 'aniruddh', 'meena', 'meena@gmail.com', 'pass@123', '2002-12-13', 'Indore')");

			conn.commit();
			System.out.println("data inserted");

		} catch (Exception e) {

			conn.rollback();

			System.out.println("data not inserted");

			System.out.println(e.getMessage());

		} finally {

		}

	}

}
