package com.pranavaeet.Nexus.common;

public class UsersNexus {
	
	private String id;
	private String username;
	private String fullname;
	private String phonenumber;
	private String email;

 public UsersNexus() {
 }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "UsersNexus [id=" + id + ", username=" + username + ", fullname=" + fullname + ", phonenumber=" + phonenumber
			+ ", email=" + email + "]";
}
 
 
 }