# Spring MVC Template
This project shall be used as a starting template for all projects based on Java and Spring MVC framework.

## Features:
1. In-built Error Pages for 400, 403, 404, and 500 error codes.
2. Wrapper for JDBC DAO layer.
3. Login functionality with Spring Security.
4. User role based menu options.
5. Profile page for every user with profile picture support.
6. Unique username creation and role assignment.
7. Bootstrap 3 support.
8. Fontawesome v5.13.1 for icons.
9. In-built templates for Regular pages and Iframe pages.

## Template Notes
UI template based on BS3 template from colorlib-gentelella: https://github.com/ColorlibHQ/gentelella
Refer to the template for integration of other supported third party plugins.

## Project Initialization 
1. Change Project name in "pom.xml"
2. Change database name in "init-db.sql" and run the script. This will create the initial database.
3. Change the database credentials and database name in "app-config.properties"
4. Change Application name in "log4j2.properties"
5. Change Title in "TopNavigationBar.jsp"

## Coding Guidelines:
1. Follow camelCase for all method names and variables. 
2. Do not use "_" when creating variables in any *.java files.
3. In POST method, all the required information should be obtained from @ModelAttribute variable.
4. request.getParameter("") should be used in GET or PUT methods. Avoid this in POST methods.
5. When pushing your code to GitHub, please remove all "System.out" statements. Use logger.info statements wherever required.
6. When pushing your code to GitHub, please remove all commented code. This is mandatory for all *.java files. In JSP files, try to the extent possible.
7. URL names that are displayed in the browser should be in the format: "xxxx-xxxx". 
8. All URLs which do not appear in the browser (i.e. all URLs related to user actions) should follow camelCase. 
9. All JSP Files should follow PascalCase. No Exceptions.
10. Remove all unused methods and imports in all java files, especially controllers. Make sure there are no warnings when pushing code to server.
11. All URLs in the application should be mentioned in URL_CONSTANTS.java
12. All JSP files in the application should be mentioned in VIEW_CONSTANTS.java
13. All SQL Queries used in the application should be mentioned in SQL_QUERIES.java
14. URLs, JSP names, and SQL Queries should not be mentioned directly anywhere in the application. They should be declared in the appropriate constants files and then referenced wherever required.
15. Use only ObjectDAO interface to execute SQL Queries. No other DAO layers should be created.
16. Controller method names should match the URL associated with them.
 

