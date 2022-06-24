package com.pranavaeet.constants;

public class SQL_QUERIES {

	private SQL_QUERIES() {}
	//webApplication queries
	
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
	public static final String sumOfTransactionsRec = "SELECT sum(transactions.amount) AS totalRcp FROM transactions WHERE transactionType ='Receipt'"; 	
	public static final String countOfTarnsRec = "SELECT COUNT(transactions.amount) AS noOfRec FROM transactions WHERE transactionType ='Receipt'";
	public static final String sumOfTransPaym = "SELECT SUM(transactions.amount) AS totalExp FROM transactions WHERE transactionType ='Payment'";
	public static final String countOfTransPaym = "SELECT COUNT(transactions.amount) AS noOfPaym FROM transactions WHERE transactionType ='Payment'";
	
	public static final String getOpeningBalance = "SELECT balances.openingBalance AS bal from balances";
	
	public static final String intrestSum = "SELECT SUM(transactions.amount) AS totalInterest FROM transactions WHERE transactions.transactionCategories ='Interest'";
	public static final String expSum = "SELECT SUM(transactions.amount) AS totalExpenses FROM transactions WHERE transactions.transactionCategories ='Expences'";
	public static final String salSum = "SELECT SUM(transactions.amount) AS totalSal FROM transactions WHERE transactions.transactionCategories ='Salaries'";
	public static final String projSum = "SELECT SUM(transactions.amount) AS totalProjAmt FROM transactions WHERE transactions.transactionCategories ='Projects'";
	public static final String FurnSum = "SELECT SUM(transactions.amount) AS totalFurAmt FROM transactions WHERE transactions.transactionCategories ='Furniture'";
	public static final String MedicalSum = "SELECT SUM(transactions.amount) AS totalMedicalAmt FROM transactions WHERE transactions.transactionCategories ='Medical Expences'";
	public static final String RentSum = "SELECT SUM(transactions.amount) AS totalRentAmt FROM transactions WHERE transactions.transactionCategories ='Rent'";
	public static final String MaintenanceSum = "SELECT SUM(transactions.amount) AS totalMaintenanceAmt FROM transactions WHERE transactions.transactionCategories ='Maintenance'";
	public static final String ElectricSum = "SELECT SUM(transactions.amount) AS totalElectricBillAmt FROM transactions WHERE transactions.transactionCategories ='Electric Bill'";
	public static final String SystemAccessoriesSum = "SELECT SUM(transactions.amount) AS systemAccessoriesAmt FROM transactions WHERE transactions.transactionCategories ='New Equipments Or Accessories'";
	public static final String SharesSum = "SELECT SUM(transactions.amount) AS sharesAmt FROM transactions WHERE transactions.transactionCategories ='Shares'";
	public static final String Bonus = "SELECT SUM(transactions.amount) AS bonusAmt FROM transactions WHERE transactions.transactionCategories ='Bonus'";
	
	public static final String getTransCatgPay = "SELECT transactions.transactionCategories AS tranCatg, SUM(transactions.amount) AS tAmntPay FROM transactions WHERE transactions.transactionType = 'Payment' GROUP BY transactions.transactionCategories";
	public static final String getTransCatgRec = "SELECT transactions.transactionCategories AS tranCat, SUM(transactions.amount) AS tAmntR FROM transactions WHERE transactions.transactionType = 'Receipt' GROUP BY transactions.transactionCategories";
	public static final String getPaymByDate = "SELECT t.transactionCategories as cat,sum(t.amount) AS totalPaymt FROM transactions t WHERE t.transactionDateTime BETWEEN ? AND ? AND t.transactionType ='Payment' GROUP By t.transactionCategories"; 
	public static final String getRecByDate = "SELECT t.transactionCategories as cat,sum(t.amount) AS totalRecp FROM transactions t WHERE t.transactionDateTime BETWEEN ? AND ? AND t.transactionType ='Receipt' GROUP By t.transactionCategories";
	public static final String getTranPayBeforeDt = "SELECT SUM(t.amount) AS tP FROM transactions t WHERE t.transactionDateTime<=? AND t.transactionType = 'Payment'";
	public static final String getTranRecBeforeDt = "SELECT SUM(t.amount) AS tR FROM transactions t WHERE t.transactionDAteTime<=? AND t.transactionType = 'Receipt'";
	
	
	public static final String getInvoices = "SELECT * FROM invoices";
	public static final String getInvoicesItems = "SELECT * FROM invoiceItems WHERE invoiceItems.invoiceID = ?";
	public static final String getInvoicesList = "SELECT * FROM invoices i RIGHT JOIN invoiceItems ON i.invoiceId = invoiceItems.invoiceID";
	public static final String addInvoices = "INSERT INTO invoices (invoiceNo,client, clientAdress, toName, issueDate, invoiceBy, createdTime) VALUES(?, ?, ?, ?, NOW(), ?, NOW())";
	public static final String addInvoicesItems = "INSERT INTO invoiceItems (invoiceID, itemName, description, quantity,itemPrice) VALUES(?, ?, ?, ?, ?)";
	public static final String getInvoiceById = "SELECT * from invoices where invoices.invoiceId=?";
	public static final String sumItemPriceById = "SELECT SUM(((18/100)*(invoiceItems.quantity * invoiceItems.itemPrice))+(invoiceItems.quantity * invoiceItems.itemPrice))AS invoiceAmt FROM invoiceItems WHERE invoiceItems.invoiceID=?"; 
	public static final String sumInvSubTotal="SELECT SUM(invoiceItems.quantity * invoiceItems.itemPrice) AS InvSubTotal  FROM invoiceItems WHERE invoiceItems.invoiceID=?";
	public static final String taxAnmt = "SELECT SUM((18/100)*(invoiceItems.quantity * invoiceItems.itemPrice)) AS taxAmount FROM invoiceItems WHERE invoiceItems.invoiceID=?";
	public static final String totalItemPrice = "SELECT (invoiceItems.quantity * invoiceItems.itemPrice) AS TotalPrice FROM invoiceItems WHERE invoiceItems.invoiceID=? GROUP BY invoiceItems.id";
	public static final String getPaySlip = "SELECT * FROM payslips";
	public static final String addPayslips = "INSERT INTO payslips (employeeName, month, pay) VALUES(?, ?, ?)";
	public static final String getEmpPaySlipsByName = "SELECT * FROM payslips WHERE employeeName=?"; 
	public static final String getEmployeePayslipById = "SELECT * FROM payslips where payslips.id=?";
	public static final String getDepNameForSelectedEmp ="SELECT * FROM department RIGHT JOIN employee ON department.departmentId = employee.departmentId WHERE employee.id=? GROUP BY employee.firstName+ +employee.lastName";	
	
	//nexus_app queries
	//nexusUsers
	public static final String addNexususers = "INSERT INTO nexus_users (username,fullname, phonenumber, email) VALUES (?, ?, ?, ?)";
	public static final String getNexususersList= "SELECT * FROM nexus_users";
	public static final String validateLogin="SELECT DISTINCT IF(u.phonenumber = ? ,'VALID', 'INVALID')AS 'STATUS' FROM nexus_users u WHERE u.username  = ?";
	//nexusAppartments
	public static final String addNexusapartments = "INSERT INTO nexus_apartments (name, mobilenumber, relationship, floor, flatno) VALUES (?, ?, ?, ?, ?)";
	public static final String getNexusapartmentsList= "SELECT * FROM nexus_apartments";
	//nexus User Profiles
	public static final String addNexususerprofiles = "INSERT INTO nexus_user_profiles (firstname,lastname,role,mobilenumber,email,image,venturename,block,flatno,gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String getNexususerprofileList= "SELECT * FROM nexus_user_profiles";
	//nexus Notices
	public static final String addNexusnotices = "INSERT INTO nexus_notices (title,description,startdate,enddate,createdby) VALUES (?, ?, ?, ?, ?)";
	public static final String getNexusnoticesList= "SELECT * FROM nexus_notices";
	//nexus Visitors
	public static final String addNexusvisitors = "INSERT INTO nexus_visitors (fullname,contactnumber,typeofvisitor,flatno,expectedtime,image,intime,indate,outtime,outdate,elapsedtime) VALUES (?, ?, ?, ?, ?, ?, now(), CURDATE(), ?, ?, ?)";
	public static final String getNexusvisitorsList= "SELECT * FROM nexus_visitors";
	public static final String updateVisListbyId = "UPDATE nexus_visitors SET outtime=?,outdate=? WHERE nexus_visitors.id=?";
	//end of nexus app queries
	
	
	
	//Nexus Application Admin
	
	public static final String getAppartmentDetails="SELECT * FROM appartment_nexusapp";
	public static final String addAppartmentDetails="INSERT INTO appartment_nexusapp (appartmentName, appartmentOwner,number, appartmenStatus, description, blockId, floorId) VALUES(?, ?, ?, ?, ?, ?, ?)";
	//public static final String addAppartmentDetails1="I"
	
	public static final String getBlockDetails="SELECT * FROM block_nexusapp";
	public static final String addBlockDetails="INSERT INTO block_nexusapp (blockName, ventureId,no_of_floors,no_of_appartments) VALUES(?, ?, ?, ?)";
	public static final String getBlockDetailsByBlockName="SELECT * FROM block_nexusapp WHERE block_nexusapp.blockName=?";
	
	public static final String getCustomerDetails="SELECT * FROM customers_nexusapp";
	public static final String addCustomerDetails="INSERT INTO customers_nexusapp (customerName, customerMobile, customerAddress, customerPincode, customerRole, ventureName) VALUES(?, ?, ?, ?, ?, ?)";
	
	public static final String getFloorDetails="SELECT * FROM floor_nexusapp";
	public static final String addFloorDetails="INSERT INTO floor_nexusapp (floorNumber, blockName,no_of_appartments) VALUES(?,?,?)";
	
	public static final String getMonthlyMaintainanceDetails="SELECT * FROM monthly_maintainance_nexusapp";
	public static final String addMonthlyMaintainanceDetails="INSERT INTO monthly_maintainance_nexusapp (createdBy, amount, createdDate, status, description) VALUES(?, ?, ?, ?, ?)";
	
	public static final String getNexusUsersDetails="SELECT * FROM users_nexusapp";
	public static final String addNexusUsersDetails="INSERT INTO users_nexusapp (userName, userFullName, userRole, userMobile, userEmail, userAddress, city, state, country, zipcode, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String getNexusUsersByRole="SELECT * FROM users_nexusapp WHERE users_nexusapp.userRole='SA'";
	public static final String countNexusUsersNumber="SELECT COUNT(*) AS 'Status' FROM users_nexusapp WHERE users_nexusapp.userMobile=?";
	public static final String getUserListbyrole="SELECT * FROM users_nexusapp WHERE users_nexusapp.userRole='OW'";
	public static final String getUserListByNumber="SELECT * FROM users_nexusapp WHERE users_nexusapp.userMobile=?";
	
	public static final String getVentureDetails="SELECT * FROM venture_nexusapp";
	public static final String addVentureDetails="INSERT INTO venture_nexusapp (ventureName, ventureAddress, description,no_of_blocks) VALUES( ?, ?, ?,?)";
	
	public static final String getVisitorNexusDetails="SELECT * FROM visitors_nexusapp";
	public static final String addVisitorNexusDetails="INSERT INTO visitors_nexusapp (typeOfVisitor, appartmentName, blockName, name, mobile, inTime, inDate, outTime, outDate,elapsedTime,expectedTime,imagePath) VALUES(?, ?, ?, ?, ?, CURTIME(), CURDATE(),?,?,?,?,?)";
	
	public static final String getPaymentsDetails="SELECT * FROM monthly_payments_nexusapp";
	
	public static final String getStateAppList="SELECT * FROM state_lokp";
	public static final String getCountryAppList="SELECT * FROM country_lokp";
	public static final String getRoleList="SELECT * FROM user_role_Lookup_nexusapp";
	public static final String addOtpToMobileNo="INSERT INTO otp_nexusapp (number, otp) VALUES(?, ?)";
	public static final String getCountOfNumber ="SELECT COUNT(*)AS 'count' FROM otp_nexusapp WHERE number=? AND otp=?; "; 
	public static final String updateOtp= "UPDATE otp_nexusapp SET otp=? WHERE number=?";
	public static final String otpValidation="SELECT DISTINCT IF(otp_nexusapp.otp = ? ,'VALID', 'INVALID')AS 'STATUS' FROM otp_nexusapp";
	public static final String getVisType="SELECT * FROM visitorsType_lkp_nexusapp";
	public static final String getRoleForNumber="SELECT users_nexusapp.userRole FROM users_nexusapp WHERE users_nexusapp.userMobile=?";
	public static final String joinBlock_Floor="SELECT * FROM block_nexusapp RIGHT JOIN floor_nexusapp ON block_nexusapp.blockName=floor_nexusapp.blockName GROUP BY block_nexusapp.blockName";
	
}



