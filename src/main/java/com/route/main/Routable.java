/**
 * 
 */
package com.route.main;

import com.route.map.exception.InvalidInputException;

/**
 * Routable Interface check if journey possible
 * @author Pradeep Sadashivamurthy
 *
 */
public interface Routable {
	/**
	 * 
	 * @param startLocation
	 * @param destinationLocation
	 * @return  if journey is possible or not
	 * @throws InvalidInputException
	 */
	public boolean isJourneyPossible(String startLocation, String destinationLocation) throws InvalidInputException;

}
