package com.pranavaeet.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.pranavaeet.constants.ROLE_CONSTANTS;
import com.pranavaeet.constants.URL_CONSTANTS;

public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 
	final static Logger logger = LogManager.getLogger();
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private JdbcTemplate jdbcTemplate;
	
	public SuccessHandler(DataSource dataSource) {
    	setJdbcTemplate(new JdbcTemplate(dataSource));
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
 
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
		
        String targetUrl = determineTargetUrl(authentication,request);
        if (response.isCommitted()) {
           logger.error("Can't redirect");
            return;
        }
        request.getSession().setMaxInactiveInterval(15*60);        
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    /*
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to user role.
     */
	protected String determineTargetUrl(Authentication authentication,HttpServletRequest request) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
 
        List<String> roles = new ArrayList<String>();
 
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
 
        if(roles.contains(ROLE_CONSTANTS.SUPER_ADMIN)
        		|| roles.contains(ROLE_CONSTANTS.ADMIN)
        		|| roles.contains(ROLE_CONSTANTS.USER)) {
        	return URL_CONSTANTS.HOME_PAGE;
        }
		return URL_CONSTANTS.ERROR_403;
	}
	
	public String determineTargetUrl(HttpServletRequest request) {
		if(request.isUserInRole(ROLE_CONSTANTS.ADMIN)) {
        	return URL_CONSTANTS.MY_PROFILE;
        }
		return URL_CONSTANTS.SIGNIN;
	}
 
}