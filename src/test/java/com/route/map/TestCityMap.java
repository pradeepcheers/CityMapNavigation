package com.route.map;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * @author Pradeep Sadashivamurthy
 * @version 1.0
 * @see com.route.map.CityMapTests
 * Calls jUnit test class              
 */
public class TestCityMap {
	
	/**
	 * Initiates jUnit tests
	 */
	public static void main (String [] args) {
		Result result = JUnitCore.runClasses(CityMapTests.class);
		for(Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
	}

}
