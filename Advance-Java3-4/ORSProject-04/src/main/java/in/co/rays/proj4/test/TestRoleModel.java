package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {

//		testAdd();
		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByName();
//		testSearch();

	}

	private static void testAdd() throws ApplicationException, DuplicateRecordException {

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

	private static void testUpdate() throws ApplicationException, DuplicateRecordException {

		RoleBean bean = new RoleBean();

		bean.setId(2);
		bean.setName("admin");
		bean.setDescription("student see only marksheet");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() throws ApplicationException {

		RoleBean bean = new RoleBean();

		bean.setId(5);

		model.delete(bean);
		System.out.println("role deleted successfully");

	}

	private static void testFindByPk() throws ApplicationException {

		RoleBean bean = new RoleBean();

		bean = model.findByPk(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("role not found");
		}

	}

	private static void testFindByName() throws ApplicationException {

		RoleBean bean = new RoleBean();

		bean = model.findByName("student");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("role not found");
		}

	}

	private static void testSearch() throws ApplicationException {

		RoleBean bean = new RoleBean();

		List<RoleBean> list = model.search(bean, 0, 0);

		Iterator<RoleBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}
}
