package com.pranavaeet.common;


public class Tasks {
	private String taskId;
	private String taskName;
	private String taskDescription;
	private String status;
	private String points;
	private String createdTime;
	private String priority;
	private String employeeId;
	private String projectId;
	

	public Tasks() {
		
	}
	
	

	public String getTaskId() {
		return taskId;
	}



	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getTaskDescription() {
		return taskDescription;
	}



	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getPoints() {
		return points;
	}



	public void setPoints(String points) {
		this.points = points;
	}



	public String getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}





	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



	public String getProjectId() {
		return projectId;
	}



	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}



	@Override
	public String toString() {
		return "Tasks [taskId=" + taskId + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", status=" + status + ", points=" + points + ", createdTime=" + createdTime + ", priority="
				+ priority +  ", employeeId=" + employeeId + "]";
	}



	

}