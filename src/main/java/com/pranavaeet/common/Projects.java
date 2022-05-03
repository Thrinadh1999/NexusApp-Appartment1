package com.pranavaeet.common;

public class Projects {
	private String projectID;
	private String projectName;
	private String description;
	private String startDate;
	private String dueDate;
	private String client;
	private String clientDetails;
public Projects(){
		
	}


public String getProjectID() {
	return projectID;
}


public void setProjectID(String projectID) {
	this.projectID = projectID;
}


public String getProjectName() {
	return projectName;
}


public void setProjectName(String projectName) {
	this.projectName = projectName;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getStartDate() {
	return startDate;
}


public void setStartDate(String startDate) {
	this.startDate = startDate;
}


public String getDueDate() {
	return dueDate;
}


public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}


public String getClient() {
	return client;
}


public void setClient(String client) {
	this.client = client;
}


public String getClientDetails() {
	return clientDetails;
}


public void setClientDetails(String clientDetails) {
	this.clientDetails = clientDetails;
}


@Override
public String toString() {
	return "Projects [projectID=" + projectID + ", projectName=" + projectName + ", description=" + description
			+ ", startDate=" + startDate + ", dueDate=" + dueDate + ", client=" + client + ", clientDetails="
			+ clientDetails + "]";
}

}
