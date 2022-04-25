package com.pranavaeet.common;

public class Employee {
	private String id;
	private String empUnique;
	private String firstName;
	private String lastName;
	private String address;
	private String mobile;
	private String joinDate;
	private String relieveDate;
	private String departmentId;
	private String role;
	
	public Employee() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpUnique() {
		return empUnique;
	}

	public void setEmpUnique(String empUnique) {
		this.empUnique = empUnique;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getRelieveDate() {
		return relieveDate;
	}

	public void setRelieveDate(String relieveDate) {
		this.relieveDate = relieveDate;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empUnique=" + empUnique + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", mobile=" + mobile + ", joinDate=" + joinDate + ", relieveDate="
				+ relieveDate + ", departmentId=" + departmentId + ", role=" + role + ", getId()=" + getId()
				+ ", getEmpUnique()=" + getEmpUnique() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAddress()=" + getAddress() + ", getMobile()=" + getMobile() + ", getJoinDate()="
				+ getJoinDate() + ", getRelieveDate()=" + getRelieveDate() + ", getDepartmentId()=" + getDepartmentId()
				+ ", getRole()=" + getRole() + "]";
	}

	
}
