package com.pranavaeet.constants;

public class SQL_QUERIES {

	private SQL_QUERIES() {}
	
public static final String addUserLoginTime = "INSERT INTO user_login_activity (username, loginTime, ipAddress, location, browser) VALUES (?, ?, ?, ?, ?)";
	
	public static final String getUserFeatures = "SELECT * FROM app_features WHERE userRole IN (SELECT user_role FROM user_roles WHERE username=?) ORDER BY priority";

	public static final String createUserProfile = "INSERT INTO user_profile (username, firstname, lastname, email, mobile, gender, status, userRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String getUserProfile = "SELECT * FROM user_profile WHERE username=?";
	public static final String getusersProfileList= "SELECT * FROM user_profile";
	
	public static final String updateUserProfile = "UPDATE user_profile SET firstname=?, lastname=?, email=?, mobile=?, gender=?, dateOfBirth=? WHERE username=?";

	public static final String getUserAddress = "SELECT * FROM user_address WHERE username=?";
	
	public static final String addUserAddress = "INSERT INTO user_address (username, address1, address2, city, state, country, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String updateUserAddress = "UPDATE user_profile SET address1=?, address2=?, city=?, state=?, country=?, zipcode=? WHERE username=?";
	
	public static final String updateUserPicture = "UPDATE user_profile SET imageFilePath=?, imageFileType=? WHERE username=?";
	
	public static final String updatePassword = "UPDATE users SET password=? WHERE username=?";
	public static final String usernameExists = "SELECT COUNT(*) FROM users WHERE username=?";
    public static final String usernameCount = "SELECT COUNT(*) AS count FROM users WHERE username=?";
    public static final String createUser = "INSERT INTO users (username, password, status) VALUES (?, ?, ?)";
	public static final String checkUsernameExists = "SELECT username FROM users WHERE username=?";

	

	public static final String addUserActivity = "INSERT INTO user_activity (username, timestamp, activity) VALUES (?, ?, ?)";
	public static final String getUserActivityList = "SELECT * FROM user_activity WHERE username=? ORDER BY id DESC";
	
	public static final String getStateList = "SELECT * FROM state_lkp";
	public static final String getStateCount = "SELECT COUNT(*) as stateCount FROM state_lkp";
	
	public static final String getCountryList = "SELECT * FROM country_lkp";
	public static final String getCountryCount = "SELECT COUNT(*) as CountryCount FROM country_lkp ";
	
	public static final String getUserRolesList = "SELECT * FROM user_roles_lkp WHERE user_role NOT IN ('ROLE_SUPERADMIN', 'ROLE_ADMIN')";
	public static final String getUserRoles = "SELECT id, user_role as userRole,display_name as dispName FROM `user_roles_lkp` where id != 1; ";
	public static final String createUserRole = "INSERT INTO user_roles (username, user_role, created_time) VALUES (?, ?, ?)";
	
	public static final String getDepartments = "SELECT * FROM department";
	public static final String addDepartment = "INSERT INTO department (name,description,code) VALUES(?,?,?)";
	public static final String getEmployeeCount = "SELECT COUNT(*) as empCount FROM employee";
	public static final String addEmployee = "INSERT INTO employee (firstName,lastName,address,moblie,joinDate,role) VALUES(?,?,?,?,?,?,?)";
	public static final String getEmployeeList = "SELECT * FROM employee";
	

	

	
}
