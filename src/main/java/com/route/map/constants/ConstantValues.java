package com.route.map.constants;

/**
 * @author Pradeep Sadashivamurthy
 * @version 1.0  
 *
 */
public class ConstantValues {
	
	/**
	 * Text Constants
	 */
	public static class TextValues 
	{
		public final static String SPACE = " ";
		public final static String EMPTY_STRING = "";
		public final static char HYPHEN = '-';
	}
	
	/**
	 * Regular Expression Values
	 */
	public static class RegularExpressionValues 
	{
		public final static String REGULAR_EXPRESSION = "([a-zA-Z0-9]+)-([a-zA-Z0-9]+)(,([a-zA-Z0-9]+)-([a-zA-Z0-9]+))*";
		public final static String PATTERN_EXPRESSION = "([a-zA-Z0-9]+)-([a-zA-Z0-9]+)";
	}
	
	/**
	 * Exception Messages
	 */
	public static class ExceptionMessages
	{
		public final static String INVALID_INPUT = "Map input is not valid";
		public final static String PATTERN_SYTAX_ERROR = "Expression's syntax is invalid";
		public final static String INVALID_SEARCH_LOCATION = "Journey location not found in the map provided";
		public final static String INVALID_JOURNEY_INPUT = "Source and Destination locations can't be null";
		public final static String LOCATION_NOT_FOUND = "Source or destination location not found in the map";
	}
	
}
