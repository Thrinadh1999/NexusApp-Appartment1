package com.pranavaeet.config;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import com.pranavaeet.constants.URL_CONSTANTS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SuccessHandler successHandler;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource) 
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username,password,status from users where username=?")
			.authoritiesByUsernameQuery("select username,user_role from user_roles where username=?"); 
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		
		http.authorizeRequests()
			
		    .antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERUSER')")
		    .antMatchers("/super/**").access("hasAnyRole('ROLE_SUPERADMIN')")
		    .and()
				.formLogin().loginPage(URL_CONSTANTS.LOGIN).successHandler(successHandler)					
					.usernameParameter("home_username").passwordParameter("home_password")
		    .and()
				.formLogin().loginPage(URL_CONSTANTS.LOGIN).failureUrl(URL_CONSTANTS.LOGIN_ERROR)
					.usernameParameter("home_username").passwordParameter("home_password")			
			.and()
				.logout().logoutSuccessUrl(URL_CONSTANTS.LOGOUT)
				.invalidateHttpSession(true)
			.and()
				.exceptionHandling().accessDeniedPage(URL_CONSTANTS.ERROR_403)
			.and()
				.csrf() ;  
		http.authorizeRequests()
		.antMatchers("/app/**").permitAll()
		.and().csrf().disable();
		
		http
		.sessionManagement()
			.maximumSessions(3)
			.expiredUrl(URL_CONSTANTS.SESSION_EXPIRED)			
		.and()
			.sessionAuthenticationErrorUrl(URL_CONSTANTS.ERROR_403) ;
				
		http
		   .headers()
		   .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
		
	}
	
	

}