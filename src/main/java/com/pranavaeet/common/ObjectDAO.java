package com.pranavaeet.common;

import java.util.List;
import java.util.Map;

public interface ObjectDAO {

	/**
	 * This method is used to execute INSERT, UPDATE, and DELETE queries on the
	 * database.
	 * 
	 * @param query - The SQL Query that needs to be executed on the database.
	 * @param args  - Parameters that need to be sent as part of the SQL Query.
	 * @return true if the query is executed successfully; false otherwise
	 */
	public boolean addOrUpdate(String query, String[] args);

	/**
	 * This method is used to execute SELECT queries which are expected to result a
	 * single result from the database.
	 * 
	 * @param query       - The SQL Query that needs to be executed on the database.
	 * @param args        - Parameters that need to be sent as part of the SQL
	 *                    Query. Can be null.
	 * @param objectClass - The type of the object that needs to be created.
	 * @return An object of the given class with relevant information from the
	 *         database.
	 */
	public Object singleResultSelect(String query, String[] args, Class<?> objectClass);

	/**
	 * This method is used to execute SELECT queries which are expected to result a
	 * single result from the database.
	 * 
	 * @param query - The SQL Query that needs to be executed on the database.
	 * @param args  - Parameters that need to be sent as part of the SQL Query. Can
	 *              be null.
	 * @return A Map representation of relevant information from the database.
	 */
	public Map<String, Object> singleResultSelect(String query, String[] args);

	/**
	 * This method is used to execute SELECT queries which are expected to result
	 * multiple result from the database.
	 * 
	 * @param query       - The SQL Query that needs to be executed on the database.
	 * @param args        - Parameters that need to be sent as part of the SQL
	 *                    Query. Can be null.
	 * @param objectClass
	 * @return A List of objects of the given class with relevant information from
	 *         the database.
	 */
	public List<?> multipleResultSelect(String query, String[] args, Class<?> objectClass);

	/**
	 * This method is used to execute SELECT queries which are expected to result
	 * multiple result from the database.
	 * 
	 * @param query - The SQL Query that needs to be executed on the database.
	 * @param args  - Parameters that need to be sent as part of the SQL Query. Can
	 *              be null.
	 * @return A List of Map objects with relevant information from the database.
	 */
	public List<Map<String, Object>> multipleResultSelect(String query, String[] args);

	/**
	 * This method is used to execute an INSERT statement and get the resulting auto-generated ID in the database table.
	 * 
	 * @param query - The SQL Query that needs to be executed on the database.
	 * @param resultColumn - Name of the column in database table which will contain the auto-generated ID.
	 * @param inputParams - Parameters that need to be sent as part of the SQL Query. Can be null.
	 * @return Integer value of the auto-generated ID of the given column in the database.
	 */
	public int insertAndGetResult(String query, String resultColumn, String[] inputParams);


}
