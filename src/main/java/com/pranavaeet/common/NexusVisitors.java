package com.pranavaeet.common;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class NexusVisitors {
	
	private String id;
	private String fullname;
	private String contactnumber;
	private String typeofvisitor;
	private String flatno;
	private String expectedtime;
	private String intime;
	private String indate;
	private String outtime;
	private String outdate;
	private String elapsedtime;
	private CommonsMultipartFile imageNexusUpload;
	private String image;


	public NexusVisitors(){
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getContactnumber() {
		return contactnumber;
	}


	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}


	public String getTypeofvisitor() {
		return typeofvisitor;
	}


	public void setTypeofvisitor(String typeofvisitor) {
		this.typeofvisitor = typeofvisitor;
	}


	public String getFlatno() {
		return flatno;
	}


	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}


	public String getExpectedtime() {
		return expectedtime;
	}


	public void setExpectedtime(String expectedtime) {
		this.expectedtime = expectedtime;
	}


	public String getIntime() {
		return intime;
	}


	public void setIntime(String intime) {
		this.intime = intime;
	}


	public String getIndate() {
		return indate;
	}


	public void setIndate(String indate) {
		this.indate = indate;
	}


	public String getOuttime() {
		return outtime;
	}


	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}


	public String getOutdate() {
		return outdate;
	}


	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}


	public String getElapsedtime() {
		return elapsedtime;
	}


	public void setElapsedtime(String elapsedtime) {
		this.elapsedtime = elapsedtime;
	}
	


	public CommonsMultipartFile getImageNexusUpload() {
		return imageNexusUpload;
	}


	public void setImageNexusUpload(CommonsMultipartFile imageNexusUpload) {
		this.imageNexusUpload = imageNexusUpload;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "NexusVisitors [id=" + id + ", fullname=" + fullname + ", contactnumber=" + contactnumber
				+ ", typeofvisitor=" + typeofvisitor + ", flatno=" + flatno + ", expectedtime=" + expectedtime
				+ ", intime=" + intime + ", indate=" + indate + ", outtime=" + outtime + ", outdate=" + outdate
				+ ", elapsedtime=" + elapsedtime + ", imageNexusUpload=" + imageNexusUpload + ", image=" + image + "]";
	}


	
	
}	
