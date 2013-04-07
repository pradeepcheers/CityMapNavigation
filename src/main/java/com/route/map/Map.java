package com.route.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.route.main.Routable;
import com.route.map.constants.ConstantValues;
import com.route.map.exception.InvalidInputException;

/**
 * @author Pradeep Sadashivamurthy
 * @version 1.0
 * Super class of CityMap, performs input validations like input map pattern etc      
 */
public abstract class Map implements Routable {
	
	private String map = null;
	HashMap <String, HashSet<String>> hashMap = new HashMap <String, HashSet<String>> (); //Used to store input map
	
	/**
	 * Constructor validtes input and sets the input value to the instance variable
	 * @param mapInput
	 * @throws InvalidInputException
	 */
	protected Map (String mapInput) throws InvalidInputException {
		super ();
		verifyEmptyInput(mapInput);
		this.setMap(verifyMapInput(truncateSpacesLowerCase(mapInput)));	
	}
	
	/**
	 * Verify the input map match to the correct map pattern "([a-zA-Z0-9]+)-([a-zA-Z0-9]+)(,([a-zA-Z0-9]+)-([a-zA-Z0-9]+))*"
	 * @param mapInput
	 * @return mapInput
	 * @throws InvalidInputException
	 */
	private String verifyMapInput (String mapInput) throws InvalidInputException {
		//Exception thrown if map input doesn't match regular expression pattern
		if (!mapInput.matches (ConstantValues.RegularExpressionValues.REGULAR_EXPRESSION)) {
			throw new InvalidInputException (ConstantValues.ExceptionMessages.INVALID_INPUT);
		} else {
			return mapInput;
		}
	}
	
	/**
	 * Returns the java.util.regex.Matcher that will match the given input against this pattern "([a-zA-Z0-9]+)-([a-zA-Z0-9]+)"
	 * @param mapInput
	 * @return Matcher
	 */
	protected Matcher getMatcher(String mapInput) {
		Pattern pattern = null;
		try {
			//Verifies the input pattern with the regular expression pattern
			pattern = Pattern.compile(ConstantValues.RegularExpressionValues.PATTERN_EXPRESSION);
		} catch (PatternSyntaxException patternSyntaxException) {
			throw new PatternSyntaxException(ConstantValues.ExceptionMessages.PATTERN_SYTAX_ERROR, ConstantValues.RegularExpressionValues.PATTERN_EXPRESSION, -1);
		}
		//returns Matcher object for the input
		return pattern.matcher(mapInput);
	}
	
	/**
	 * Throws InvalidInputException if the input is null or empty
	 * @param startLocation
	 * @param destinationLocation
	 * @throws InvalidInputException
	 */
	protected void verifyEmptyInput (String input) throws InvalidInputException {
		
		//Throws InvalidInputException if map input or source or destination nodes are null or empty
		if(input == null || input.equals(ConstantValues.TextValues.EMPTY_STRING))
			throw new InvalidInputException(ConstantValues.ExceptionMessages.INVALID_JOURNEY_INPUT);		
	}
	
	/**
	 * Throws InvalidInputException if the node doesn't found in the input map
	 * @param startLocation
	 * @param destinationLocation
	 * @throws InvalidInputException
	 */
	protected void verifySearchInput (String startLocation, String destinationLocation) throws InvalidInputException {
		
		//Throws InvalidInputException if source and destination nodes are not found in the input map
		if(!hashMap.containsKey(startLocation) || !hashMap.containsKey(destinationLocation))
			throw new InvalidInputException(ConstantValues.ExceptionMessages.LOCATION_NOT_FOUND);	
	}
	
	/**
	 * Truncates white spaces from the input
	 * @param mapInput
	 * @return mapInput
	 */
	protected String truncateSpacesLowerCase (String mapInput) {
		//returns input by removing white spaces as per the assumption and converts input to lower case
		return mapInput.replaceAll(ConstantValues.TextValues.SPACE, ConstantValues.TextValues.EMPTY_STRING).toLowerCase();
	}
	/**
	 * Getter Method
	 * @return map
	 */
	public String getMap() {
		return map;
	}

	/**
	 * Setter Method
	 * @param map
	 */
	public void setMap(String map) {
		this.map = map;
	}
	

}
