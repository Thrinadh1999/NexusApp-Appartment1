package com.pranavaeet.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pranavaeet.utils.TimeFormatter;
import com.pranavaeet.utils.Utils;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.email.api.ElasticEmail;
import com.pranavaeet.email.api.Email;
import com.pranavaeet.email.api.EmailFormatter;
import com.pranavaeet.common.LoginHelper;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.utils.KeyGenerator;

@Service
public class LoginHelper {

	final static Logger logger = LogManager.getLogger(LoginHelper.class);
	
	@Autowired
	ObjectDAO objectDAO;
	
	public String generateUsername(String type) {
		String username = type+"_"+Utils.generateRandomNumber(4);	
		int count = Integer.parseInt(objectDAO.singleResultSelect(SQL_QUERIES.usernameCount, new String[] {username}).get("count").toString());
		while(count > 0) {
			username = new String(generateUsername(type));
		}
		logger.info("Returning username: "+username);
		return username;
	}
	
	public boolean createUserLogin(String username, String name, String userRole){
		boolean loginCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUser,
				new String[] { username, encryptString(username), String.valueOf(1) });
		
		boolean userRoleCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUserRole,
				new String[] { username, userRole, TimeFormatter.getCurrentTimeStamp() });
		
		boolean userProfileCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUserProfile,
				new String[] { username, name, "", String.valueOf(1) });
		
		if(loginCreated && userRoleCreated && userProfileCreated)
			return true;
		return false;
	}
	
	public boolean createUserLogin(String username, String firstName, String lastName, String userRole){
		boolean loginCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUser,
				new String[] { username, encryptString(username), String.valueOf(1) });
		
		boolean userRoleCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUserRole,
				new String[] { username, userRole, TimeFormatter.getCurrentTimeStamp() });
		
		boolean userProfileCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUserProfile,
				new String[] { username, firstName, lastName, String.valueOf(1) });
		
		if(loginCreated && userRoleCreated && userProfileCreated)
			return true;
		return false;
	}
	
	public boolean createUserLoginWithEmail(String firstName, String lastName, String emailAddress, String userRole, String jobTitle){
		String username = emailAddress;
		String password = KeyGenerator.generatePassword(8);
		
		boolean loginCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUser,
				new String[] { username, encryptString(password), String.valueOf(1) });
		
		boolean userRoleCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUserRole,
				new String[] { username, userRole, TimeFormatter.getCurrentTimeStamp() });
		
		boolean userProfileCreated = objectDAO.addOrUpdate(SQL_QUERIES.createUserProfile,
				new String[] { username, firstName, lastName, emailAddress, null, null, String.valueOf(1), userRole});
		
		if(loginCreated && userRoleCreated && userProfileCreated) {
			Email email = createLoginEmail(firstName, lastName, emailAddress, password, jobTitle);
			ElasticEmail api = new ElasticEmail();
			try {
				api.sendEmail(email, "Pranava Job Portal", "jobportal@pranavalabs.com");
				return true;
			} catch (Exception e) {				
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public boolean updatePassword(String username, String password) {
		boolean passwordUpdated = objectDAO.addOrUpdate(SQL_QUERIES.updatePassword, new String[] {
				new String(encryptString(password)), username});		
		return passwordUpdated;
	}
	
	public boolean resetPassword(String username) {
		return updatePassword(username, username);
	}
	
	public boolean resetPasswordLink(String firstName, String lastName, String emailAddress) {
		String password = KeyGenerator.generatePassword(8);
		Email email = createPasswordResetEmail(firstName, lastName, emailAddress, password);
		ElasticEmail api = new ElasticEmail();
		try {
			api.sendEmail(email, "Pranava Job Portal", "jobportal@pranavalabs.com");
			return updatePassword(emailAddress, password);
		} catch (Exception e) {				
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Encrypts a given String using the BCrypt Password Encoder.
	 * 
	 * @param password - String containing plain text.
	 * @return Encrypted value of input as String.
	 */
	private String encryptString(String plainText) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encrypted = passwordEncoder.encode(plainText);
		return encrypted;
	}
	
	private Email createLoginEmail(String firstName, String lastName, String emailAddress, String password, String jobTitle) {
		String url = "https://jobs.pranavalabs.com/signin";
		String body = EmailFormatter.startHtml()+EmailFormatter.htmlStartingTextForUser(firstName+" "+lastName);
		body += "<tr><td><p>We have received your application for the role of <strong>"+jobTitle+"</strong> and a new jobs portal account has been created for you.<br/>"
			+ "Once you login to the portal, you will be able to access your job application and continue with the hiring process.</p>"
			+ "<p>Your login credentials are enclosed below. We strongly recommend you to change your password immediately after logging in.</p>"
			+ "<p><strong>Username:</strong> "+emailAddress+"<br/><strong>Password: </strong>"+password+"</p>"
			+ "<p><a style=\"padding:10px;border-radius: 10px;color: #fff;background: #26B99A;border: 1px solid #169F85;text-decoration: none;display:inline-block;\" href=\""+url+"\" target=\"_blank\">Go to Jobs Portal</a></p><p>If the above button does not work, copy the followng link and paste it in your browser's address bar: <br/> <span style=\"text-decoration:underline;color:dodgerblue;\">"+url+"</span></p><br/></td></tr>"
			+ EmailFormatter.footerTextUser()
			+ "</table>"+EmailFormatter.endHtml();
		
		Email email = new Email();
		email.setTo(emailAddress);
		email.setSubject("Welcome to Pranava EET Job Portal");
		email.setFromEmail("jobportal@pranavalabs.com");
		email.setFromName("Pranava Job Portal");
		email.setBody(body);
		return email;
	}
	
	private Email createPasswordResetEmail(String firstName, String lastName, String emailAddress, String password) {
		String url = "https://jobs.pranavalabs.com/signin";
		String body = EmailFormatter.startHtml()+EmailFormatter.htmlStartingTextForUser(firstName+" "+lastName);
		body += "<tr><td><p>We have received a password reset request for your jobs portal account at Pranava EET and we have generated a new password.<br/>"
			+ "Your new login credentials are enclosed below. We strongly recommend you to change your password immediately after logging in.</p>"
			+ "<p><strong>Username:</strong> "+emailAddress+"<br/><strong>Password: </strong>"+password+"</p>"
			+ "<p><a style=\"padding:10px;border-radius: 10px;color: #fff;background: #26B99A;border: 1px solid #169F85;text-decoration: none;display:inline-block;\" href=\""+url+"\" target=\"_blank\">Go to Jobs Portal</a></p><p>If the above button does not work, copy the followng link and paste it in your browser's address bar: <br/> <span style=\"text-decoration:underline;color:dodgerblue;\">"+url+"</span></p><br/></td></tr>"
			+ EmailFormatter.footerTextUser()
			+ "</table>"+EmailFormatter.endHtml();
		
		Email email = new Email();
		email.setTo(emailAddress);
		email.setSubject("Password Reset - Pranava EET Job Portal Account");
		email.setFromEmail("jobportal@pranavalabs.com");
		email.setFromName("Pranava Job Portal");
		email.setBody(body);
		return email;
	}
	
}
