package com.pranavaeet.common;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UserProfile {

	private String id;
	private String userRole;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String gender;
	private String dateOfBirth;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String status;
	private CommonsMultipartFile imageUpload;	
	private String imageFilePath;
	private String imageFileType;
	private byte[] imageFileContent;
	
	public UserProfile() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public byte[] getImageFileContent() {
		return imageFileContent;
	}

	public void setImageFileContent(byte[] imageFileContent) {
		this.imageFileContent = imageFileContent;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipcode=" + zipcode + ", status=" + status + ", imageUpload="
				+ imageUpload + ", imageFilePath=" + imageFilePath + ", imageFileType=" + imageFileType
				+ ", imageFileContent=" + Arrays.toString(imageFileContent) + "]";
	}


}
