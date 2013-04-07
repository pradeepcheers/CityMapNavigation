package com.route.map;

import java.io.IOException;
import java.util.Scanner;

import com.route.main.AbstractMapFactory;
import com.route.main.Routable;
import com.route.map.exception.InvalidInputException;

/**
 * 
 * @author Pradeep Sadashivamurthy
 *
 */
public class CityMapJarTest {

	private static Scanner userInput;

	/**
	 * @param args
	 * @throws InvalidInputException
	 */
	public static void main(String[] args) throws InvalidInputException, IOException {
		String sourceLocation, destinatinLocation, reTest;
		boolean test=false;
		userInput = new Scanner(System.in);
		System.out.println("Enter input map [Eg: a-b,b-c,c-d,d-a]: ");
		Routable route = new AbstractMapFactory().getMapFactory().getMap(userInput.next());
		do {
		System.out.println("Please enter source location and destination location to check if journey possible:");
		System.out.println("Enter source location: ");
		sourceLocation = userInput.next();
		System.out.println("Enter destination location: ");
		destinatinLocation = userInput.next();
		try {
			test = route.isJourneyPossible(sourceLocation, destinatinLocation);
			if (test) {
				System.out.println("\n Journey Possible \n");
			} else {
				System.out.println("\n Journey Not Possible \n");
			}
		} catch(InvalidInputException iie){
			System.out.println(iie.getMessage());
		}
		
		System.out.println("Do you want to check for another Journey? (y/n)");
		reTest = userInput.next();
		} while(reTest.equalsIgnoreCase("Y") || reTest.equalsIgnoreCase("YES"));
	}

}
