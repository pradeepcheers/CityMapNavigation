package com.route.main;

import com.route.map.CityMap;
import com.route.map.Map;
import com.route.map.exception.InvalidInputException;

/**
 * Factory for maps creation
 * @author Pradeep Sadashivamurthy
 *
 */
public class MapFactory extends AbstractMapFactory {
	/**
	 * Factory method for getting maps
	 * @param map input
	 * @return a type of map
	 * @throws InvalidInputException
	 */
	public Map getMap (String map) throws InvalidInputException {
		return new CityMap(map);
	}
}
