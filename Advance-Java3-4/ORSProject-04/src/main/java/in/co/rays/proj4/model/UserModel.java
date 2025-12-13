package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.exception.RecordNotFoundException;
import in.co.rays.proj4.util.EmailBuilder;
import in.co.rays.proj4.util.EmailMessage;
import in.co.rays.proj4.util.EmailUtility;
import in.co.rays.proj4.util.JDBCDataSource;

/**
 * UserModel handles all database operations related to User entity such as
 * add, update, delete, find, authenticate, etc.
 *
 * This class uses JDBC for interaction with the database and supports
 * operations like registration, password change, and password recovery.
 * 
 * @author Sawan Panwar
 * @version 1.0
 */
public class UserModel {

	/**
	 * Returns the next primary key for User table.
	 *
	 * @return next primary key
	 * @throws DatabaseException if any database error occurs
	 */
	public Integer nextPk() throws DatabaseException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	/**
	 * Adds a new User to the database.
	 *
	 * @param bean the UserBean containing user details
	 * @return primary key of the newly added user
	 * @throws ApplicationException     if an application-level exception occurs
	 * @throws DuplicateRecordException if the login ID already exists
	 */
	public long add(UserBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		UserBean existbean = findByLogin(bean.getLogin());

		if (existbean != null) {
			throw new DuplicateRecordException("Login Id already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setString(9, bean.getGender());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	
	/**
	 * Updates an existing user in the database.
	 *
	 * @param bean the UserBean containing updated user details
	 * @throws DuplicateRecordException if the login ID already exists for another user
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public void update(UserBean bean) throws DuplicateRecordException, ApplicationException {

		Connection conn = null;

		UserBean beanExist = findByLogin(bean.getLogin());

		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("Login Id is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set first_name = ?, last_name = ?, login = ?, password = ?, dob = ?, mobile_no = ?, role_id = ?, gender = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setLong(7, bean.getRoleId());
			pstmt.setString(8, bean.getGender());
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating User ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	/**
	 * Deletes a user from the database.
	 *
	 * @param bean the UserBean containing user ID to be deleted
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public void delete(UserBean bean) throws ApplicationException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	/**
	 * Finds a user by primary key.
	 *
	 * @param pk the primary key of the user
	 * @return UserBean if found, otherwise null
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public UserBean findByPk(long pk) throws ApplicationException {

		UserBean bean = null;
		Connection conn = null;

		StringBuffer sql = new StringBuffer("select * from st_user where id = ?");

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getString(7));
				bean.setRoleId(rs.getLong(8));
				bean.setGender(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	/**
	 * Finds a user by login ID.
	 *
	 * @param login the login ID of the user
	 * @return UserBean if found, otherwise null
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public UserBean findByLogin(String login) throws ApplicationException {

		StringBuffer sql = new StringBuffer("select * from st_user where login = ?");

		UserBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getString(7));
				bean.setRoleId(rs.getLong(8));
				bean.setGender(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in getting User by login");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	/**
	 * Authenticates a user using login and password.
	 *
	 * @param login the login ID
	 * @param password the password
	 * @return UserBean if credentials are correct, otherwise null
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public UserBean authenticate(String login, String password) throws ApplicationException {

		UserBean bean = null;
		Connection conn = null;

		StringBuffer sql = new StringBuffer("select * from st_user where login = ? and password = ?");

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getString(7));
				bean.setRoleId(rs.getLong(8));
				bean.setGender(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in get roles");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	/**
	 * Searches users based on criteria and pagination.
	 *
	 * @param bean the UserBean containing search criteria
	 * @param pageNo the page number
	 * @param pageSize the number of records per page
	 * @return list of matching users
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public List<UserBean> search(UserBean bean, int pageNo, int pageSize) throws ApplicationException {

		Connection conn = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and last_name like '" + bean.getLastName() + "%'");
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" and login like '" + bean.getLogin() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" and password like '" + bean.getPassword() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getDate() > 0) {
				sql.append(" and dob = " + bean.getDob());
			}
			if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
				sql.append(" and mobile_no = " + bean.getMobileNo());
			}
			if (bean.getRoleId() > 0) {
				sql.append(" and role_id = " + bean.getRoleId());
			}
			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" and gender like '" + bean.getGender() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getString(7));
				bean.setRoleId(rs.getLong(8));
				bean.setGender(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
				list.add(bean);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in search user");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

	/**
	 * Changes the password of a user.
	 *
	 * @param id the user ID
	 * @param oldPassword the current password
	 * @param newPassword the new password
	 * @return true if password changed successfully, false otherwise
	 * @throws RecordNotFoundException if old password is invalid
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public boolean changePassword(Long id, String oldPassword, String newPassword)
			throws RecordNotFoundException, ApplicationException {

		boolean flag = false;

		UserBean beanExist = findByPk(id);

		if (beanExist != null && beanExist.getPassword().equals(oldPassword)) {
			beanExist.setPassword(newPassword);
			try {
				update(beanExist);
				flag = true;
			} catch (DuplicateRecordException e) {
				throw new ApplicationException("Login Id already exist");
			}
		} else {
			throw new RecordNotFoundException("Old Password is Invalid");
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", beanExist.getLogin());
		map.put("password", beanExist.getPassword());
		map.put("firstName", beanExist.getFirstName());
		map.put("lastName", beanExist.getLastName());

		String message = EmailBuilder.getChangePasswordMessage(map);

		EmailMessage msg = new EmailMessage();
		msg.setTo(beanExist.getLogin());
		msg.setSubject("ORSProject-04 Password has been changed Successfully.");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		return flag;
	}

	/**
	 * Sends a password to the user's email for password recovery.
	 *
	 * @param login the login ID (email)
	 * @return true if email sent successfully
	 * @throws RecordNotFoundException if login ID does not exist
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public boolean forgetPassword(String login) throws RecordNotFoundException, ApplicationException {

		UserBean userData = findByLogin(login);
		boolean flag = false;

		if (userData == null) {
			throw new RecordNotFoundException("Email ID does not exists..!!");
		}

		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("login", userData.getLogin());
			map.put("password", userData.getPassword());
			map.put("firstName", userData.getFirstName());
			map.put("lastName", userData.getLastName());

			String message = EmailBuilder.getForgetPasswordMessage(map);

			EmailMessage msg = new EmailMessage();
			msg.setTo(login);
			msg.setSubject("ORSProject-04 Password Reset");
			msg.setMessage(message);
			msg.setMessageType(EmailMessage.HTML_MSG);

			EmailUtility.sendMail(msg);
			flag = true;
		} catch (Exception e) {
			throw new ApplicationException("Please check your internet connection..!!");
		}
		return flag;
	}

	/**
	 * Registers a new user and sends confirmation email.
	 *
	 * @param bean the UserBean containing user details
	 * @return primary key of the newly registered user
	 * @throws DuplicateRecordException if login ID already exists
	 * @throws ApplicationException if an application-level exception occurs
	 */
	public long registerUser(UserBean bean) throws DuplicateRecordException, ApplicationException {

		long pk = add(bean);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", bean.getLogin());
		map.put("password", bean.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);

		EmailMessage msg = new EmailMessage();

		msg.setTo(bean.getLogin());
		msg.setSubject("Registration is successful for ORSProject-04");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		return pk;
	}
}