package com.route.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;

import com.route.map.constants.ConstantValues;
import com.route.map.exception.InvalidInputException;

/**
 * Represents a CityMap, takes map as input.
 * @author Pradeep Sadashivamurthy
 * @version 1.0
 * @see com.route.main.MapFactory 
 */
public class CityMap extends Map {
	
	
	/**
	 * @param mapInput - roadsAndLocations - A String specification of the 
	 * connections of roads and locations. A comma-separated list
	 * of roads between locations defined as 
	 * [startLocation]-[endLocation] e.g.
	 * 
	 * "a-b,b-a"     represents two locations, where travel 
	 *               is possible in both directions
	 * "a-b,b-c,c-a" represents a triangular one-way road travelling 
	 *               from a, through b and c, and finally back to a
     */
	public CityMap(String mapInput) throws InvalidInputException {
		super(mapInput); //call to super constructor
		String node, sLocation, dLocation = null;
		Matcher matcher = this.getMatcher(this.getMap());
		
		//Iterate over all edges in the input
		while (matcher.find()) {
			node = matcher.group ();
			sLocation = node.substring(0,node.indexOf(ConstantValues.TextValues.HYPHEN));
			dLocation = node.substring(node.indexOf(ConstantValues.TextValues.HYPHEN)+1);
			
			//Add source location to hashmap
			if(!hashMap.containsKey(sLocation)) {				
				hashMap.put(sLocation, new HashSet <String> ());
			} 
			
			//Add destination location to hashmap
			if(!hashMap.containsKey(dLocation)) {
				hashMap.put(dLocation, new HashSet <String> ());
			}
			
			//Add edge to hashmap
			if (!sLocation.equalsIgnoreCase(dLocation)) {
				hashMap.get(sLocation).add(dLocation);
			}
		}
	}
	
	/**
	 * 
	 * Determine whether a journey from the startLocation to the
     * destinationLocation can be made, based on the available roads
     * 
     * Implemented using Breadth first search algorithm
     * 
	 * @param startLocation 
	 * @param destinationLocation
	 * @return boolean value, states if journey is possible or not
	 */
	public boolean isJourneyPossible(String startLocation, String destinationLocation) throws InvalidInputException {
		String value;
		boolean flag = false;
		HashSet<String> nodes;
		
		//Verify input parameters for for null values
		verifyEmptyInput(startLocation);
		verifyEmptyInput(destinationLocation);
		
		//As per the assumption map and search inputs are case insensitive
		startLocation = this.truncateSpacesLowerCase(startLocation);
		destinationLocation = this.truncateSpacesLowerCase(destinationLocation);
		
		//Checks if source and destination locations are in the input map
		verifySearchInput(startLocation,destinationLocation);  
		
		//Queue to store and check map nodes
		Queue<String> que = new ConcurrentLinkedQueue<String>();
		
		//Used to keep track of already visited nodes to prevent infinite looping in isJourneyPossible
		List<String> visited = new ArrayList<String>(); 
		
		//Enqueue start location
		que.offer(startLocation);
		
		//Mark as visited
		visited.add(startLocation);
		
		//Loop over until queue is empty
		while(!que.isEmpty()){
			
			//Dequeue and gets adjacency list from hashmap
			value = que.poll();
			nodes = hashMap.get(value);
			
			//If dequeued value or its adjacency list contains destination return true and exit loop
			if(nodes.contains(destinationLocation) || value.equalsIgnoreCase(destinationLocation)){
				flag = true;
				break;
			//If not loop over add adjacency list nodes to queue and mark as visited	
			} else {
				for(String node:nodes){
					if(!visited.contains(node)){
						que.offer(node);
						visited.add(node);
					}
				}
			}
		}
		return flag;
	}
	
}