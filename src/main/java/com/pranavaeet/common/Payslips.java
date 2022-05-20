package com.pranavaeet.common;

public class Payslips {
	private String id;
	private String employeeId	;
	private String employeeName;
	private String employeeaddress;
	private String mobile ;
	private String departmentName;
	private String role;
	private String month;
	private String pay;
	
	public Payslips(){

}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeaddress() {
		return employeeaddress;
	}

	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Payslips [id=" + id + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", employeeaddress=" + employeeaddress + ", mobile=" + mobile + ", departmentName=" + departmentName
				+ ", role=" + role + ", month=" + month + ", pay=" + pay + "]";
	}
}