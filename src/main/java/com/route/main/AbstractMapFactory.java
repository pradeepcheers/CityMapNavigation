package com.route.main;

/**
 * 
 * @author Pradeep Sadashivamurthy
 *
 */
public class AbstractMapFactory {
	
	/**
	 * @see com.route.main.MapFactory
	 */
	public  MapFactory getMapFactory() {
		return new MapFactory();
	}

}
