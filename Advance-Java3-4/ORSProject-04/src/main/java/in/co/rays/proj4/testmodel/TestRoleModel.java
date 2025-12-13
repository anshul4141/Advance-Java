package in.co.rays.proj4.testmodel;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.UserModel;

public class TestRoleModel {
	
	public static void main(String[] args) {
		
		testAdd();
		
	}
	
	public static void testAdd() {
		
			RoleBean bean = new RoleBean();
			bean.setName("hr");
			bean.setDescription("hr");
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			
			RoleModel model = new RoleModel();
			
			try {
				model.add(bean);
				System.out.println("Role Added Successfully");
			} catch (ApplicationException e) {
				e.printStackTrace();
			}	
	}

}
