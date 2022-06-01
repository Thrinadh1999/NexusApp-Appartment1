package com.pranavaeet.common;

public class NexusUserProfiles {
	
	private String id;
	private String role;
	private String firstname;
	private String lastname;
	private String mobilenumber;
	private String email;
	private String venturename;
	private String block;
	private String flatno;
	private String gender;
	private String image;
	
	public NexusUserProfiles(){
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVenturename() {
		return venturename;
	}

	public void setVenturename(String venturename) {
		this.venturename = venturename;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}
	

	public String getFlatno() {
		return flatno;
	}

	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "NexusUserProfiles [id=" + id + ", role=" + role + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobilenumber=" + mobilenumber + ", email=" + email + ", venturename=" + venturename + ", block="
				+ block + ", flatno=" + flatno + ", gender=" + gender + ", image=" + image + "]";
	}

	
	
}
