package com.pranavaeet.Nexus.common;

public class FlatDetailsNexus {
	private String id;
	private String name;
	private String mobilenumber;
	private String relationship;
	private String floor;
	private String flatno;
	
public FlatDetailsNexus(){
		
	}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}

public String getRelationship() {
	return relationship;
}

public void setRelationship(String relationship) {
	this.relationship = relationship;
}

public String getFloor() {
	return floor;
}

public void setFloor(String floor) {
	this.floor = floor;
}

public String getFlatno() {
	return flatno;
}

public void setFlatno(String flatno) {
	this.flatno = flatno;
}

@Override
public String toString() {
	return "FlatDetailsNexus [id=" + id + ", name=" + name + ", mobilenumber=" + mobilenumber + ", relationship="
			+ relationship + ", floor=" + floor + ", flatno=" + flatno + "]";
}

}