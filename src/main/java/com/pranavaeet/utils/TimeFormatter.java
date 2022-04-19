package com.pranavaeet.utils;

import java.sql.Date;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.time.temporal.ChronoUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeFormatter {

	final static Logger logger = LogManager.getLogger(TimeFormatter.class);
	private static final String timeZone = "Asia/Kolkata";
	
	private static final DateTimeFormatter displayDateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
	private static final DateTimeFormatter excelDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final DateTimeFormatter internationalDateFormatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
	private static final DateTimeFormatter internationalDateFormatter2 = DateTimeFormatter.ofPattern("d/MM/yyyy");
	private static final DateTimeFormatter internationalDateFormatter3 = DateTimeFormatter.ofPattern("dd/M/yyyy");
	private static final DateTimeFormatter internationalDateFormatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter usDateFormatter1 = DateTimeFormatter.ofPattern("M/d/yyyy");
	private static final DateTimeFormatter usDateFormatter2 = DateTimeFormatter.ofPattern("M/dd/yyyy");
	private static final DateTimeFormatter usDateFormatter3 = DateTimeFormatter.ofPattern("MM/d/yyyy");
	private static final DateTimeFormatter usDateFormatter4 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private static final DateTimeFormatter sqlDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter idTimestampFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");
	private static final DateTimeFormatter sqlTimestampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final DateTimeFormatter displayTimestampFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static final DateTimeFormatter slotTimeFormatter1 = DateTimeFormatter.ofPattern("hh:mm a");
	private static final DateTimeFormatter slotTimeFormatter2 = DateTimeFormatter.ofPattern("h:mm a");
	private static final DateTimeFormatter slotTimeFormatter3 = DateTimeFormatter.ofPattern("HH:mm");
	
	public TimeFormatter(){
		
	}
	
	//*************************** Parsers Begin ********************************
	
	/**
	 * Returns current local date object.
	 * @return LocalDate object
	 */
	public static LocalDate getCurrentLocalDate(){
		return LocalDate.now(ZoneId.of(timeZone));
	}
	
	/**
	 * Returns current local date-time object.
	 * @return LocalDateTime object
	 */
	public static LocalDateTime getCurrentLocalDateTime(){
		return LocalDateTime.now(ZoneId.of(timeZone));
	}
	
	/**
	 * Returns current time stamp as a  string in HH:mm:ss format.
	 * @return
	 */
	public static String getCurrentTime(){		
		return getCurrentLocalDateTime().format(displayTimestampFormatter);
	}
	
	/**
	 * Returns current time stamp as a  string in yyMMddHHmmssSSS format.
	 * @return
	 */
	public static String getCurrentTimeStampForId(){		
		return getCurrentLocalDateTime().format(idTimestampFormatter);
	}
	
	/**
	 * Returns current time stamp as a  string in yyyy-MM-dd HH:mm:ss format.
	 * @return
	 */
	public static String getCurrentTimeStamp(){		
		return getCurrentLocalDateTime().format(sqlTimestampFormatter);
	}
	
	/**
	 * Returns current date string in MMM dd, yyyy format.
	 * @return
	 */
	public static String getCurrentDateInUSFormat(){		
		return getCurrentLocalDate().format(usDateFormatter4);
	}
	public static String getCurrentDateInSqlStringFormat(){		
		return getCurrentLocalDate().format(sqlDateFormatter);
	}
	
	/**
	 * Returns current date string in MMM dd, yyyy format.
	 * @return
	 */
	public static String getCurrentDate(){		
		return getCurrentLocalDate().format(displayDateFormatter);
	}

	/**
	 * Returns current date as a SQL date object.
	 * @return
	 */
	public static Date getCurrentSQLDate(){		
		return Date.valueOf(getCurrentLocalDate());
	}
	
	/**
	 * Returns current date in SQL format as a plain string.
	 * @return
	 */
	public static String getCurrentSQLDateString(){		
		return getCurrentLocalDate().format(sqlDateFormatter);
	}	
	
	/**
	 * Returns current date in MM/DD/YYYY format as a plain string.
	 * @return
	 */
	public static String getCurrentUSDateString(){		
		return getCurrentLocalDate().format(usDateFormatter4);
	}

	/**
	 * Returns all dates of a given week as a key,value pair.
	 * @return
	 */
	public static Map<String,Date> getWeekDates(Date weekDate) throws ParseException {
		Map<String, Date> weekDates = new LinkedHashMap<String, Date>();		
		LocalDate ld = weekDate.toLocalDate();
		LocalDate mondayDate = null;
		if(ld.getDayOfWeek().equals(DayOfWeek.MONDAY))
			mondayDate = ld;
		else
			mondayDate = ld.with(TemporalAdjusters.previous( DayOfWeek.MONDAY ));
		weekDates.put("Monday", Date.valueOf(mondayDate));
		weekDates.put("Tuesday", Date.valueOf(mondayDate.plusDays(1)));
		weekDates.put("Wednesday", Date.valueOf(mondayDate.plusDays(2)));
		weekDates.put("Thursday", Date.valueOf(mondayDate.plusDays(3)));
		weekDates.put("Friday", Date.valueOf(mondayDate.plusDays(4)));
		weekDates.put("Saturday", Date.valueOf(mondayDate.plusDays(5)));
		weekDates.put("Sunday", Date.valueOf(mondayDate.plusDays(6)));		
		return weekDates;
	}
	
	public static Map<String,String> getWeekDatesForDisplay(Date weekDate) throws ParseException {
		Map<String, String> weekDates = new LinkedHashMap<String, String>();		
		LocalDate ld = weekDate.toLocalDate();
		LocalDate mondayDate = null;
		if(ld.getDayOfWeek().equals(DayOfWeek.MONDAY))
			mondayDate = ld;
		else
			mondayDate = ld.with(TemporalAdjusters.previous( DayOfWeek.MONDAY ));
		weekDates.put("Monday", mondayDate.format(displayDateFormatter));
		weekDates.put("Tuesday", mondayDate.plusDays(1).format(displayDateFormatter));
		weekDates.put("Wednesday", mondayDate.plusDays(2).format(displayDateFormatter));
		weekDates.put("Thursday", mondayDate.plusDays(3).format(displayDateFormatter));
		weekDates.put("Friday", mondayDate.plusDays(4).format(displayDateFormatter));
		weekDates.put("Saturday", mondayDate.plusDays(5).format(displayDateFormatter));
		weekDates.put("Sunday", mondayDate.plusDays(6).format(displayDateFormatter));		
		return weekDates;
	}
	
	public static Map<Integer,String> getDailyTimeSlots() throws ParseException {
		Map<Integer, String> slotMap = new LinkedHashMap<Integer, String>();		
		LocalDateTime startTime = LocalDateTime.now().withHour(0).withMinute(0);
		slotMap.put(1, startTime.format(slotTimeFormatter3));
		int i=2;
		LocalDateTime endTime= startTime.plusMinutes(30);
		String startValue = startTime.format(slotTimeFormatter3);
		String endValue = endTime.format(slotTimeFormatter3);
		while(!startValue.equals(endValue)) {
			slotMap.put(i, endTime.format(slotTimeFormatter3));
			i++;
			endTime= endTime.plusMinutes(30);
			endValue = endTime.format(slotTimeFormatter3);
		}
		return slotMap;
	}
	
	/**
	 * Returns the list of all dates between a given start date and end date.
	 * All dates are of String type and should be in yyyy-MM-dd format.
	 * 
	 * @param startDate Start date of the desired date range.
	 * @param endDate End date of the desired date range.
	 * @return List of SQL date Strings between the start date and end date.
	 */
	public static List<String> getDatesWithinRange(String startDate, String endDate) {
		List<String> dateRange = new ArrayList<String>();				
		try{
			LocalDate currentDate = Date.valueOf(startDate).toLocalDate();
			LocalDate end = Date.valueOf(endDate).toLocalDate();
			while(currentDate.isBefore(end)){
				dateRange.add(currentDate.format(sqlDateFormatter));
				currentDate = currentDate.plusDays(1);
			}
			dateRange.add(end.format(sqlDateFormatter));		
		}catch(Exception e){
			logger.error(e.getMessage());
		}		
		return dateRange;
	}
	
	/**
	 * Returns the Monday date of the week for the given date.
	 * 
	 * @param date SQL date string in yyyy-MM-dd format.
	 * @return SQL Date String in yyyy-MM-dd format.
	 * @throws ParseException
	 */
	public static String getCurrentWeekMondayDate(String date) throws ParseException {		
		LocalDate ld = Date.valueOf(date).toLocalDate();
		LocalDate mondayDate = null;
		if(ld.getDayOfWeek().equals(DayOfWeek.MONDAY))
			mondayDate = ld;
		else
			mondayDate = ld.with(TemporalAdjusters.previous( DayOfWeek.MONDAY ));		
		return String.valueOf(mondayDate);
	}
	
	//*************************** Parsers End ********************************
	
	//*************************** Converters Begin ********************************
	
	/**
	 * Converts a Timestamp String from MMM dd, yyyy HH:mm:ss format to yyyy-MM-dd format.
	 * 
	 * @param date Timestamp String in MMM dd, yyyy HH:mm:ss format that needs to be converted.
	 * @return Converted Date String in yyyy-MM-dd format.
	 * @throws ParseException
	 */
	public static String getCurrentDatefromTime(String time) throws ParseException{		
		LocalDate ld = LocalDate.parse(time, displayTimestampFormatter); 
		return ld.format(sqlDateFormatter);
	}
	
	public static String getFormatDatefromTime(String time) throws ParseException{		
		LocalDate ld = LocalDate.parse(time, sqlTimestampFormatter); 
		return ld.format(sqlDateFormatter);
	}
	
	/**
	 * Converts a String to a SQL Date object.
	 * 
	 * @param date Date String in yyyy-MM-dd format.
	 * @return SQL Date object.
	 * @throws ParseException
	 */
	public static Date convertStringToSQLDate(String date){		
       try{
    	   if(null == date)
    		   return null;
    	   LocalDate ld = LocalDate.parse(date, sqlDateFormatter); 
           return Date.valueOf(ld);
       }catch(Exception e){
    	   return Date.valueOf(getCurrentLocalDate());
       }				
	}	

	/**
	 * Converts a Date String from MMM dd, yyyy format to yyyy-MM-dd format.
	 * 
	 * @param date Date String in MMM dd, yyyy format that needs to be converted.
	 * @return Converted Date String in yyyy-MM-dd format.
	 * @throws ParseException
	 */
	public static String convertRegularDatetoSqlDateString(String date) throws ParseException {
		LocalDate ld = LocalDate.parse(date, displayDateFormatter); 
		return ld.format(sqlDateFormatter);		
	}
	
	/**
	 * Converts a Date String from any format to yyyy-MM-dd format.
	 * 
	 * @param date Date String in any format that needs to be converted.
	 * @return Converted Date String in yyyy-MM-dd format.
	 * @throws ParseException
	 */
	public static String convertDatetoSqlDateString(String date) throws ParseException {
		LocalDate ld = null;
		try{
			ld = LocalDate.parse(date, displayDateFormatter);
		}catch(Exception e){
			try{
				ld = parseUSDate(date);
			}catch(Exception ex){
				try{
					ld = LocalDate.parse(date, excelDateFormatter);
				}catch(Exception exp){
					try{
						ld = parseInternationalDate(date);
					}catch(Exception exc){
						//Can't help any more. Tried all possible formats.
						logger.error("Unparseable date format: "+date);
					}
				}
			}
		}		 
		return ld.format(sqlDateFormatter);		
	}
	
	/**
	 * Converts a SQL date object to a more readable format. Used for displaying in UI.
	 * 
	 * @param date Date object in yyyy-MM-dd format that needs to be converted.
	 * @return Converted Date String in MMM dd, yyyy format.
	 * @throws ParseException
	 */
	public static String convertSQLToRegularDate(Date date) throws ParseException {		
		LocalDate ld = LocalDate.parse(date.toString(), sqlDateFormatter); 
		return ld.format(displayDateFormatter);		
	}
	
	/**
	 * Converts a SQL date string to a more readable format. Used for displaying in UI.
	 * 
	 * @param sqlDate Date String in yyyy-MM-dd format that needs to be converted.
	 * @return Converted Date String in MMM dd, yyyy format.
	 * @throws ParseException
	 */
	public static String convertSQLToRegularDate(String sqlDate) throws ParseException {
		LocalDate ld = LocalDate.parse(sqlDate, sqlDateFormatter); 
		return ld.format(displayDateFormatter);		
	}
	
	/**
	 * Converts a SQL date string to U.S. date format. Used for displaying in UI.
	 * 
	 * @param sqlDate Date String in yyyy-MM-dd format that needs to be converted.
	 * @return Converted Date String in MM/dd/yyyy format.
	 */
	public static String convertSQLToUSDate(String sqlDate) {
		try{
			LocalDate ld = LocalDate.parse(sqlDate, sqlDateFormatter); 
			return ld.format(usDateFormatter4);	
		}catch(Exception e){
			return sqlDate;
		}			
	}
	/**
	 * Converts a SQL date string to U.S. date format. Used for displaying in UI.
	 * 
	 * @param sqlDate Date String in dd-MM-yyyy format that needs to be converted.
	 * @return Converted Date String in MM/dd/yyyy format.
	 */
	public static String convertDateInUSFormat(String date){		
		return getCurrentLocalDate().format(usDateFormatter4);
	}
	
	/**
	 * Returns the number of days between the given start date and end date.
	 * 
	 * @param startDate Date String in yyyy-MM-dd format
	 * @param endDate Date String in yyyy-MM-dd format
	 * @return Integer value of the number of days. Includes the start and end dates as well.
	 */
	public static int calculateDayCount(String startDate, String endDate){
		LocalDate start = Date.valueOf(startDate).toLocalDate();
		LocalDate end = Date.valueOf(endDate).toLocalDate();
		long days = start.until(end, ChronoUnit.DAYS)+1;
		return (int) days;
	}
	
	/**
	 * Unformats timestamp string from MMM dd, yyyy HH:mm:ss to a SQL Date object.
	 * @return a SQL date object
	 */
	public static Date unFormatTimestamp(String timestamp) throws ParseException{		
		LocalDate ld = LocalDate.parse(timestamp, displayTimestampFormatter); 
		return Date.valueOf(ld.format(sqlDateFormatter));
	}
	
	/**
	 * Unformats timestamp string from yyyy-MM-dd HH:mm:ss to a SQL Date object.
	 * @return a SQL date object
	 */
	public static Date unFormatSQLTimestamp(String timestamp) throws ParseException{		
		LocalDate ld = LocalDate.parse(timestamp, sqlTimestampFormatter); 
		return Date.valueOf(ld.format(sqlDateFormatter));
	}
	
	/**
	 * Unformats timestamp string from yyyy-MM-dd HH:mm:ss to a SQL Date object.
	 * @return a SQL date object
	 */
	public static String unFormatSQLTimestampAsString(String timestamp){		
		try{
			LocalDate ld = LocalDate.parse(timestamp, sqlTimestampFormatter); 
			return ld.format(sqlDateFormatter);
		}catch(Exception e){
			return timestamp;
		}		
	}
	
	/**
	 * Calculates the time difference in minutes between given timestamps.
	 * Difference is calculated from reference time to target time.
	 * 
	 * @param referenceTimestamp Timestamp string in yyyy-MM-dd HH:mm:ss format.
	 * @param targetTimestamp Timestamp string in yyyy-MM-dd HH:mm:ss format.
	 * @return Time difference in minutes.
	 */
	public static int calculateTimeDifferenceInMinutes(String referenceTimestamp, String targetTimestamp){
		int returnTime = 0;
		try{
			LocalDateTime ld1 = LocalDateTime.parse(referenceTimestamp, sqlTimestampFormatter); 
			LocalDateTime ld2 = LocalDateTime.parse(targetTimestamp, sqlTimestampFormatter);
			returnTime = (int) ChronoUnit.MINUTES.between(ld1,ld2);			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return returnTime;
	}
	
	//*************************** Converters End ********************************
	
	//*************************** Validators Begin ********************************
	
	/**
	 * Verifies if the date given is in SQL date format.
	 * 
	 * @param date Date string
	 * @return true if the date is in a valid format; false otherwise
	 */
	public static boolean isDateFormatValidSQL(String date){
		try{
			LocalDate ld = LocalDate.parse(date, sqlDateFormatter); 
			ld.format(sqlDateFormatter);
			return true;
		}catch(Exception e){
			logger.error(e.getMessage()+" for date: "+date);
		}		
		return false;
	}
	
	public static boolean isDateBeforeCurrentDate(String date) {
		LocalDate ld = getCurrentLocalDate();
		LocalDate lt = LocalDate.parse(date, usDateFormatter4);
        if(lt.isBefore(ld)) {
        	return true;
        }
		return false;
	}
	
	
	public static boolean isDateBeforeCurrentSqlStringDate(String date) {
		LocalDate ld = getCurrentLocalDate();
		LocalDate lt = LocalDate.parse(date, sqlDateFormatter);
        if(lt.isBefore(ld)) {
        	return true;
        }
		return false;
	}
	
	public static boolean isTimeBeforeCurrentTime(String time) {
		LocalTime ld = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        try {
        	LocalTime lt = LocalTime.parse(time, slotTimeFormatter1);
            if(lt.isBefore(ld)) {
            	return true;
            }
        }catch(Exception e) {
        	LocalTime lt = LocalTime.parse(time, slotTimeFormatter2);
            if(lt.isBefore(ld)) {
            	return true;
            }
        }
		return false;
	}
	
	public static boolean isDateWithinRange(String referenceDate, String startDate, String endDate) {				
		try{
			LocalDate currentDate = Date.valueOf(referenceDate).toLocalDate();
			LocalDate start = Date.valueOf(startDate).toLocalDate();
			LocalDate end = Date.valueOf(endDate).toLocalDate();
			if(currentDate.equals(start) || currentDate.equals(end))
				return true;
			if((currentDate.isBefore(end)) && (currentDate.isAfter(start)))
				return true;			
		}catch(Exception e){
			logger.error(e.getMessage());
		}		
		return false;
	}
	
	public static boolean isDateWithinCurrentMonth(String referenceDate) {				
		try{
			LocalDate compareDate = Date.valueOf(referenceDate).toLocalDate();
			LocalDate currentDate = getCurrentLocalDate();
			if(compareDate.getMonth().equals(currentDate.getMonth()))
				return true;						
		}catch(Exception e){
			logger.error(e.getMessage());
		}		
		return false;
	}
	
	public static boolean isDateWithinCurrentYear(String referenceDate) {				
		try{
			LocalDate compareDate = Date.valueOf(referenceDate).toLocalDate();
			LocalDate currentDate = getCurrentLocalDate();
			if(compareDate.getYear() == currentDate.getYear())
				return true;						
		}catch(Exception e){
			logger.error(e.getMessage());
		}		
		return false;
	}
	
	//*************************** Validators End ********************************
	
	private static LocalDate parseUSDate(String date) throws ParseException{
		LocalDate ld = null;
		try{
			ld = LocalDate.parse(date, usDateFormatter1);
		}catch(Exception e1){
			try{
				ld = LocalDate.parse(date, usDateFormatter2);
			}catch(Exception e2){
				try{
					ld = LocalDate.parse(date, usDateFormatter3);
				}catch(Exception e3){
					ld = LocalDate.parse(date, usDateFormatter4);					
				}
			}
		}
		return ld;
	}
	
	private static LocalDate parseInternationalDate(String date) throws ParseException{
		LocalDate ld = null;
		try{
			ld = LocalDate.parse(date, internationalDateFormatter1);
		}catch(Exception e1){
			try{
				ld = LocalDate.parse(date, internationalDateFormatter2);
			}catch(Exception e2){
				try{
					ld = LocalDate.parse(date, internationalDateFormatter3);
				}catch(Exception e3){
					ld = LocalDate.parse(date, internationalDateFormatter4);					
				}
			}
		}
		return ld;
	}
	
}
