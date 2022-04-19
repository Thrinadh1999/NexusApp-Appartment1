package com.pranavaeet.common;

public class Feature {

	private String id;
	private String featureName;
	private String featureUrl;
	private String featureIcon;
	private String userRole;
	private String priority;
	
	public Feature() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureUrl() {
		return featureUrl;
	}

	public void setFeatureUrl(String featureUrl) {
		this.featureUrl = featureUrl;
	}

	public String getFeatureIcon() {
		return featureIcon;
	}

	public void setFeatureIcon(String featureIcon) {
		this.featureIcon = featureIcon;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Feature [id=" + id + ", featureName=" + featureName + ", featureUrl=" + featureUrl + ", featureIcon="
				+ featureIcon + ", userRole=" + userRole + ", priority=" + priority + "]";
	}
	
}
