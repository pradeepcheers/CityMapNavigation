package com.route.map.exception;
/**
 * Exception type for invalid input
 * @author Pradeep Sadashivamurthy
 *
 */
public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 7318172766513989545L;

	/**
	 * @param s
	 * @see java.lang.Exception
	 */
	public InvalidInputException(String s) {
		super(s);
	}

}
