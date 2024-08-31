package com.rays.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	public void add(UserBean bean) throws Exception {

		Class.forName(rb.getString("driver"));

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));

			PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");

			UserBean existBean = findByLoginId(bean.getLoginId());

			conn.setAutoCommit(false);

			if (existBean == null) {

				pstmt.setInt(1, bean.getId());
				pstmt.setString(2, bean.getFirstName());
				pstmt.setString(3, bean.getLastName());
				pstmt.setString(4, bean.getLoginId());
				pstmt.setString(5, bean.getPassword());
				pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
				pstmt.setString(7, bean.getPhoneNo());
				pstmt.setString(8, bean.getAddress());
				pstmt.setString(9, bean.getGender());

				int i = pstmt.executeUpdate();

				conn.commit();

				System.out.println("data inserted successfully.. " + i);
			} else {
				System.out.println("loginId already exist");
			}

		} catch (Exception e) {

			conn.rollback();
			e.printStackTrace();

		}

	}

	public void delete(UserBean bean) throws Exception {

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data deleted successfully.. " + i);

	}

	public void update(UserBean bean) throws Exception {

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement(
				"update user set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ?, phoneNo = ?, address = ?, gender = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getPhoneNo());
		pstmt.setString(7, bean.getAddress());
		pstmt.setString(8, bean.getGender());
		pstmt.setInt(9, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data update successfully... " + i);

	}

	public UserBean searchAll() throws Exception {

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("select * from user");

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setPhoneNo(rs.getString(7));
			bean.setAddress(rs.getString(8));
			bean.setGender(rs.getString(8));

		}

		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {

		System.out.println("data = " + loginId + " " + password);

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("select * from user where loginId = ? and password = ?");

		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setPhoneNo(rs.getString(7));
			bean.setAddress(rs.getString(8));
			bean.setGender(rs.getString(8));

		}

		return bean;

	}

	public UserBean findByLoginId(String loginId) throws Exception {

		System.out.println("data = " + loginId);

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("select * from user where loginId = ?");

		pstmt.setString(1, loginId);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setPhoneNo(rs.getString(7));
			bean.setAddress(rs.getString(8));
			bean.setGender(rs.getString(8));

		}

		return bean;

	}

	public List search(UserBean bean) throws Exception {

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "'");
			}

			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "'");
			}

		}
		System.out.println(sql.toString());

		PreparedStatement ptmt = conn.prepareStatement(sql.toString());
		ResultSet rs = ptmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setPhoneNo(rs.getString(7));
			bean.setAddress(rs.getString(8));
			bean.setGender(rs.getString(8));
			list.add(bean);
		}
		return list;

	}

}
