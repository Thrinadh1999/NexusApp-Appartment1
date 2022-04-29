package com.pranavaeet.common;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
	private String departmentName;
	private String role;
	private String stateName;
	private String countryId;
	private String email;
	private String gender;
	private CommonsMultipartFile imageUpload;	
	private String imageFilePath;
	private String imageFileType;

	

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
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

	public CommonsMultipartFile getImageUpload() {
		return imageUpload;
	}

	public void setImageUpload(CommonsMultipartFile imageUpload) {
		this.imageUpload = imageUpload;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileType() {
		return imageFileType;
	}

	public void setImageFileType(String imageFileType) {
		this.imageFileType = imageFileType;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empUnique=" + empUnique + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", mobile=" + mobile + ", city=" + city + ", zipCode=" + zipCode
				+ ", joinDate=" + joinDate + ", relieveDate=" + relieveDate + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", role=" + role + ", stateName=" + stateName + ", countryId="
				+ countryId + ", email=" + email + ", gender=" + gender + ", imageUpload=" + imageUpload
				+ ", imageFilePath=" + imageFilePath + ", imageFileType=" + imageFileType + "]";
	}	
}