package com.pranavaeet.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectDAOImpl implements ObjectDAO {

	final static Logger logger = LogManager.getLogger(ObjectDAOImpl.class);
	private JdbcTemplate jdbcTemplate;

	public ObjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addOrUpdate(String query, String[] args) {
		logger.info("Executing Query: " + query+" with params: "+Arrays.toString(args));
		int result = jdbcTemplate.update(query, (Object[]) args);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Object singleResultSelect(String query, String[] args, Class<?> objectClass) {
		logger.info("Executing Query: " + query+" with params: "+Arrays.toString(args));
		Map<String, Object> returnMap = jdbcTemplate.queryForMap(query, (Object[]) args);
		return createObject(returnMap, objectClass);
	}

	@Override
	public Map<String, Object> singleResultSelect(String query, String[] args) {
		logger.info("Executing Query: " + query+" with params: "+Arrays.toString(args));
		Map<String, Object> returnMap = jdbcTemplate.queryForMap(query, (Object[]) args);
		return returnMap;
	}

	@Override
	public List<?> multipleResultSelect(String query, String[] args, Class<?> objectClass) {
		logger.info("Executing Query: " + query+" with params: "+Arrays.toString(args));
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(query, (Object[]) args);
		List<Object> returnList = new LinkedList<Object>();
		for (Map<String, Object> map : queryResult) {
			returnList.add(createObject(map, objectClass));
		}
		return returnList;
	}

	@Override
	public List<Map<String, Object>> multipleResultSelect(String query, String[] args) {
		logger.info("Executing Query: " + query+" with params: "+Arrays.toString(args));
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(query, (Object[]) args);
		return queryResult;
	}

	@Override
	public int insertAndGetResult(String query, String resultColumn, String[] inputParams) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, new String[] {resultColumn});
				for(int i=0; i<inputParams.length; i++) {
					ps.setString(i+1, inputParams[i]);
				}
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	private Object createObject(Map<String, Object> map, Class<?> objectClass) {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(map, objectClass);
	}

}
