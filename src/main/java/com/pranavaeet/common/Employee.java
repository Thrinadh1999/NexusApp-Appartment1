package com.pranavaeet.common;

public class Employee<departmentName> {
	private String id;
	private String empUnique;
	private String firstName;
	private String lastName;
	private String address;
	private String mobile;
	private String city;
	private String zipCode;
	private String joinDate;
	private String relieveDate;
	private String departmentId;
	private String role;
	private String stateName;
	private String countryId;
	private String email;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empUnique=" + empUnique + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", mobile=" + mobile + ", joinDate=" + joinDate + ", relieveDate="
				+ relieveDate + ", departmentId=" + departmentId + ", role=" + role + ", getId()=" + getId()
				+ ", getEmpUnique()=" + getEmpUnique() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAddress()=" + getAddress() + ", getMobile()=" + getMobile() + ", getJoinDate()="
				+ getJoinDate() + ", getRelieveDate()=" + getRelieveDate() + ", getDepartmentId()=" + getDepartmentId()
				+ ", getRole()=" + getRole() + ", stateName=" + stateName + ", countryId=" + countryId + ", email=" + email + "]";
	}

}
