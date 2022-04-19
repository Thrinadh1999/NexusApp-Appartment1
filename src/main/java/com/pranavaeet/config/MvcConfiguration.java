package com.pranavaeet.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.common.ObjectDAOImpl;
import com.pranavaeet.utils.GoogleCloudStorage;
import com.pranavaeet.utils.TimeFormatter;

@Configuration
@ComponentScan(basePackages = "com.pranavaeet.*")
@EnableWebMvc
@Import({ SecurityConfig.class })

public class MvcConfiguration implements WebMvcConfigurer {

	String dbDriver = Variables.dbDriver;
	String dbUrl = Variables.dbUrl;	
	String dbUsername = Variables.dbUsername;
	String dbPassword = Variables.dbPassword;
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {		
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		dataSource.setDriverClassName(dbDriver);	
		dataSource.setUrl(dbUrl); 
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword); 	  
		return dataSource;
	}
	
	@Bean
	public SuccessHandler getTestURLAuthenticationSuccessHandler() {
		return new SuccessHandler(getDataSource());
	}
	
	@Bean
	public TimeFormatter getTimeFormatter(){
		return new TimeFormatter();
	}
	
	@Bean
	public GoogleCloudStorage getGoogleCloudStorage(){
		return new GoogleCloudStorage();
	}
	
	@Bean
	public ObjectDAO getObjectDAO(DataSource dataSource) {
		return new ObjectDAOImpl(getDataSource());
	}


}