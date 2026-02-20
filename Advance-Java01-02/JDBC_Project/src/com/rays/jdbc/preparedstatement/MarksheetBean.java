package com.rays.jdbc.preparedstatement;

public class MarksheetBean {

	private int id;
	private String rollNo;
	private String name;
	private int phy;
	private int chm;
	private int maths;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		this.phy = phy;
	}

	public int getChm() {
		return chm;
	}

	public void setChm(int chm) {
		this.chm = chm;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

}
