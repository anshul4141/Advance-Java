package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.bean.UserBean;

public class UserModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	// <----- nextPk() ------>
	public int nextPk() throws Exception {

		int pk = 0;

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			pk = rs.getInt(1);

		return pk + 1;
	}

	// <----- add method ----->
	public void add(UserBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, username, password);

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();

			System.out.println(i + " row affected(records inserted...)");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			conn.rollback();
		}

	}

	// <----- update method ----->
	public void update(UserBean bean) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstName = ?, lastName = ?, login = ?, password = ?, dob = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(records updated...)");

		conn.close();
		pstmt.close();

	}

	// <----- delete method ----->
	public void delete(UserBean bean) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(records deleted...)");

		conn.close();
		pstmt.close();

	}

	// <----- findByLogin method ----->
	public UserBean findByLogin(String login) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}

		conn.close();
		pstmt.close();
		return bean;

	}

	// <----- findByPk method ----->
	public UserBean findByPk(int pk) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

		pstmt.setInt(1, pk);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}

		conn.close();
		pstmt.close();
		return bean;
	}

	// <----- findByLogin method ----->
	public UserBean authenticate(String login, String pwd) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ? and password = ?");

		pstmt.setString(1, login);
		pstmt.setString(2, pwd);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}

		conn.close();
		pstmt.close();
		return bean;

	}

	// <----- search ------>
	public List search(UserBean bean) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "%'");
			}
		}

		System.out.println("sql ===> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);
		}

		conn.close();
		pstmt.close();
		return list;

	}

}
