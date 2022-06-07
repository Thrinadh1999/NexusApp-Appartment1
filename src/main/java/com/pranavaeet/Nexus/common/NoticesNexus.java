package com.pranavaeet.Nexus.common;

public class NoticesNexus {
	private String id;
	private String title;
	private String description;
	private String startdate;
	private String enddate;
	private String createdby;
	
public NoticesNexus(){
		
	}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getStartdate() {
	return startdate;
}

public void setStartdate(String startdate) {
	this.startdate = startdate;
}

public String getEnddate() {
	return enddate;
}

public void setEnddate(String enddate) {
	this.enddate = enddate;
}

public String getCreatedby() {
	return createdby;
}

public void setCreatedby(String createdby) {
	this.createdby = createdby;
}

@Override
public String toString() {
	return "NoticesNexus [id=" + id + ", title=" + title + ", description=" + description + ", startdate=" + startdate
			+ ", enddate=" + enddate + ", createdby=" + createdby + "]";
}

}

