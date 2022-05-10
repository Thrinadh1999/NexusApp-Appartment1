package com.pranavaeet.constants;

public class SQL_QUERIES {

	private SQL_QUERIES() {}
	
public static final String addUserLoginTime = "INSERT INTO user_login_activity (username, loginTime, ipAddress, location, browser) VALUES (?, ?, ?, ?, ?)";
	
	public static final String getUserFeatures = "SELECT * FROM app_features WHERE userRole IN (SELECT user_role FROM user_roles WHERE username=?) ORDER BY priority";

	public static final String createUserProfile = "INSERT INTO user_profile (username, firstname, lastname, email,mobile, address1, city, state, country, zipcode, gender, status, userRole, imageFilePath, imageFileType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?)";
	public static final String getUserProfile = "SELECT * FROM user_profile WHERE username=?";
	public static final String getusersProfileList= "SELECT * FROM user_profile";
	public static final String updateUserProfile = "UPDATE user_profile SET firstname=?, lastname=?, email=?, mobile=?, gender=?, dateOfBirth=?, imageFilePath=?, imageFilePath=? WHERE username=?";

	public static final String getUserAddress = "SELECT * FROM user_address WHERE username=?";
	public static final String addUserAddress = "INSERT INTO user_address (username, address1, address2, city, state, country, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String updateUserAddress = "UPDATE user_profile SET address1=?, address2=?, city=?, state=?, country=?, zipcode=? WHERE username=?";
	
	public static final String updateUserPicture = "UPDATE user_profile SET imageFilePath=?, imageFileType=? WHERE username=?";
	
	public static final String updatePassword = "UPDATE users SET password=? WHERE username=?";
	public static final String usernameExists = "SELECT COUNT(*) FROM users WHERE username=?";
    public static final String usernameCount = "SELECT COUNT(*) AS count FROM users WHERE username=?";
    public static final String createUser = "INSERT INTO users (username, password, status) VALUES (?, ?, 1)";
	public static final String checkUsernameExists = "SELECT username FROM users WHERE username=?";
	public static final String updateUser = "UPDATE users SET username=?,password=?,status=? WHERE username=?";

	

	public static final String addUserActivity = "INSERT INTO user_activity (username, timestamp, activity) VALUES (?, ?, ?)";
	public static final String getUserActivityList = "SELECT * FROM user_activity WHERE username=? ORDER BY id DESC";
	
	public static final String getStateList = "SELECT * FROM state_lkp";
	public static final String getStateCount = "SELECT COUNT(*) as stateCount FROM state_lkp";
	
	public static final String getCountryList = "SELECT * FROM country_lkp";
	public static final String getCountryCount = "SELECT COUNT(*) as CountryCount FROM country_lkp ";
	
	public static final String getUserRolesList = "SELECT * FROM user_roles_lkp WHERE user_role NOT IN ('ROLE_SUPERADMIN', 'ROLE_ADMIN')";
	public static final String getUserRoles = "SELECT id, user_role as userRole,display_name as dispName FROM `user_roles_lkp` where id != 1; ";
	public static final String createUserRole = "INSERT INTO user_roles (username, user_role, created_time) VALUES (?, ?, NOW())";
	
	public static final String getDepartments = "SELECT * FROM department";
	public static final String addDepartment = "INSERT INTO department (name,description,code) VALUES(?,?,?)";
	public static final String getDepartmentById = "SELECT * from department d WHERE d.departmentId =?";
	public static final String editDep = "SELECT * from department WHERE departmentId = ?";
	public static final String updateDep = "UPDATE department d SET d.name = ?, d.description = ?, d.code = ? WHERE d.departmentId = ?";
	
	public static final String getEmployeeCount = "SELECT COUNT(*) as empCount FROM employee";
	public static final String getEmployee= "SELECT* FROM employee";
	public static final String addEmployee = "INSERT INTO employee (firstName,lastName,address,mobile,joinDate,departmentId,role) VALUES(?,?,?,?,?,?,?)";
	public static final String getEmployeeList = "SELECT e.*,up.email FROM employee e RIGHT JOIN user_profile up ON e.mobile=up.mobile WHERE e.id IS NOT NULL";
	public static final String getEmpBYDepId = "SELECT * FROM employee WHERE departmentId=2";
	
	public static final String getProjects = "SELECT * FROM projects";
	public static final String addProjects = "INSERT INTO projects (projectName, description, startDate, dueDate, client, clientDetails) VALUES(?, ?, ?, ?, ?, ?)";
    public static final String updateProjects = "UPDATE projects SET projects.projectName=?, projects.description=?, projects.startDate=?, projects.dueDate=?, projects.client=?, projects.clientDetails=? Where projects.projectID = ?";
	public static final String getProjectCount = "SELECT COUNT(*) as proList FROM projects";
	public static final String editProjects = "SELECT * FROM projects WHERE projectID = ?";
	public static final String getProjectsById = "SELECT * FROM projects WHERE projects.projectID =?";
	
	public static final String getTasks = "SELECT * FROM tasks";
	public static final String addTasks = "INSERT INTO tasks (taskName, taskDescription,  points, createdTime, priority,status, employeeId, projectId ) VALUES(?, ?, ?, NOW(), ?, 'Pending',?, ?)";
	public static final String updateTasks = "UPDATE tasks SET  tasks.status = ? WHERE taskId=?";
	public static final String getTasksCount = "SELECT COUNT(*) as taskCount FROM tasks";
	public static final String editTasks = "SELECT tasks.status FROM tasks WHERE taskId = ?";
	
	public static final String getCategories = "SELECT * FROM categories";
	public static final String addCategories = "INSERT INTO categories (categoryName, description,type, createdTime) VALUES(?, ?, ?, NOW())";
	public static final String editCategories = "SELECT categories.categoryName, categories.description, categories.type, categories.createdTime FROM categories WHERE categoryId =?";
	
	public static final String getTransactions = "SELECT * FROM transactions";
	public static final String addTransactions ="INSERT INTO transactions (transactionBy, transactionDateTime, transDescription, transactionCategories, transactionType, amount) VALUES(?,NOW(),?,?,?,?)";
		
			
}