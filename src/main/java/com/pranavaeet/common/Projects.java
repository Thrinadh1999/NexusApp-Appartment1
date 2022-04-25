package com.pranavaeet.common;

public class Projects {
	private String projectId;
	private String projectName;
	private String description;
	private String beginDate;
	private String endDate;
public Projects(){
		
	}
public String getProjectId() {
	return projectId;
}
public void setProjectID(String projectId) {
	this.projectId = projectId;
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
public String getBeginDate() {
	return beginDate;
}
public void setBeginDate(String beginDate) {
	this.beginDate = beginDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
@Override
public String toString() {
	return "Products [projectID=" + projectId + ", projectName=" + projectName + ", description=" + description + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
}
}
