package com.pranavaeet.common;

public class Categories {
	private String categoryId;
	private String categoryName;
	private String description;
	private String type;
	private String createdTime;
public Categories(){
		
	}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCreatedTime() {
	return createdTime;
}
public void setCreatedTime(String createdTime) {
	this.createdTime = createdTime;
}
@Override
public String toString() {
	return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
			+ ", type=" + type + ", createdTime=" + createdTime + "]";
}

}
