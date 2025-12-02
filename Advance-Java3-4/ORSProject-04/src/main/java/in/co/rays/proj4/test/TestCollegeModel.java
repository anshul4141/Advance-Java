package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;

public class TestCollegeModel {
	
	public static CollegeModel model = new CollegeModel();
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
		
	}

	private static void testAdd() throws Exception {
		
		CollegeBean bean = new CollegeBean();
		
		bean.setName("DAVV");
		bean.setAddress("Madhumilan Squre, Indore");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhoneNo("7778885525");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		model.add(bean);
		
		
	}

}
