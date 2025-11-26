package in.co.rays.proj4.model;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;

public class TestRoleModel {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) throws ApplicationException {

		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByName();
//		testSearch();

	}

	private static void testAdd() throws ApplicationException {

		RoleBean bean = new RoleBean();

		bean.setName("admin");
		bean.setDescription("admin");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		long pk = model.add(bean);

		System.out.println("data added successfully at id: " + pk);

	}

	private static void testUpdate() {

	}

	private static void testDelete() {

	}

	private static void testFindByPk() {

	}

	private static void testFindByName() {

	}

	private static void testSearch() {

	}

}
