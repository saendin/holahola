package com.yedam.java.dept;
//VO class만들기. 내가 접근하고자 하는 테이블의 한 행에 대응되는 모든 값을 가진다.
public class Department {
	//필드
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
	// Source에서 Generate toString해주기
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}

	// getter, setter 생성
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	

}
