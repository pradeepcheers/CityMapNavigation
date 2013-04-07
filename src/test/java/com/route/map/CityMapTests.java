package com.route.map;
import static org.junit.Assert.assertEquals;

import com.route.main.AbstractMapFactory;
import com.route.map.exception.InvalidInputException;

/**
 * 
 * @author Pradeep Sadashivamurthy
 * @version 1.0
 *               
 */
public class CityMapTests {
	
	// Factory invocation no fail expected
	@org.junit.Test
	public void testFactoryTrueCaseCheck() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",true,route.isJourneyPossible("mk5", "mk20"));
	}
	
	@org.junit.Test
	public void testFactoryTrueValue1() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",true,route.isJourneyPossible("MK5", "MK20"));
	}
	
	@org.junit.Test
	public void testFactoryTrueValue2() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("a-a,a-b,b-c,c-d");
		assertEquals("Result",true,route.isJourneyPossible("b", "b"));
	}
	
	@org.junit.Test
	public void testFactoryTrueValue3() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",true,route.isJourneyPossible("MK5", "MK25"));
	}
	
	@org.junit.Test
	public void testFactoryTrueValue4() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",false,route.isJourneyPossible("MK25", "MK5"));
	}
	
	@org.junit.Test
	public void testFactoryTrueValue5() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("a-b,b-c,c-d,a-n,a-m,m-d");
		assertEquals("Result",true,route.isJourneyPossible("a", "d"));
	}
	
	@org.junit.Test
	public void testFactoryTrueValue6() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible("ab", "ef"));
	}
	
	@org.junit.Test
	public void testSameValues() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",true,route.isJourneyPossible("ab", "ab"));	
	}
	
	@org.junit.Test
	public void testSameValues1() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",true,route.isJourneyPossible("ef", "ef"));	
	}
	
	// Factory invocation no fail expected
		
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryNull1() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible(null, "ab"));	
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryNull2() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible("ab", null));	
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryNull3() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible(null, null));	
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryEmptyString1() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",true,route.isJourneyPossible("", ""));
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryEmptyString2() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",true,route.isJourneyPossible("MK5", ""));
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryEmptyString() throws InvalidInputException {
		Map route = new AbstractMapFactory().getMapFactory().getMap("MK5-MK10,MK10-MK15,MK15-MK20,MK20-MK25");
		assertEquals("Result",true,route.isJourneyPossible("", "MK5"));
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryFalseValue1() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible("01", "ef"));	
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryFalseValue2() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible("ab", "01"));	
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testFactoryFalseValue3() throws Exception{
		Map route = new AbstractMapFactory().getMapFactory().getMap("ab-bc,bc-ab,cd-ab, de-ef");
		assertEquals("Result",false,route.isJourneyPossible("01", "09"));	
	}
	
	// Direct invocation fail expected
	@org.junit.Test (expected=InvalidInputException.class)
	public void testNullValue() throws Exception{
		new CityMap(null).getMap();	
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testInvalidInputExceptionEmptyString() throws Exception{
		new CityMap("").getMap();
	}
	
	@org.junit.Test (expected=InvalidInputException.class)
	public void testInvalidInputExceptionDiffPattern() throws Exception{
		new CityMap("a").getMap();
	}
	
	
	// Direct invocation no fail expected
	@org.junit.Test 
	public void testInvalidInputExceptionSameNodeCase() throws Exception{
		assertEquals("Result","a-a", new CityMap("a-a").getMap());
	}
	
	@org.junit.Test 
	public void testInvalidInputExceptionSameNode() throws Exception{
		assertEquals("Result","a-a", new CityMap("a-A").getMap());
	}
	
	@org.junit.Test 
	public void testInvalidInputExceptionSameNodesCase() throws Exception{
		assertEquals("Result","a-a,b-b,c-c",new CityMap("a-a,b-b,c-c").getMap());
	}
	
	@org.junit.Test 
	public void testInvalidInputExceptionSameNodes() throws Exception{
		assertEquals("Result","a-d,b-b,c-c", new CityMap("a-d,b-B,c-C").getMap());
	}
	
	@org.junit.Test
	public void testNormalInput() throws InvalidInputException{
		assertEquals("Result","a-b,b-c,c-a",new CityMap("a-b,b-c,c-a").getMap ());
	}
	
	@org.junit.Test
	public void testNormalInputOneValue() throws InvalidInputException{
		assertEquals("Result","a-b",new CityMap("a-b").getMap ());
	}
	
	@org.junit.Test
	public void testNormalInputSpace() throws InvalidInputException{
		assertEquals("Result","a-b,b-c,c-a",new CityMap("a-b , b-c , c-a").getMap());
	}
	
	@org.junit.Test
	public void testNormalInputNumber() throws InvalidInputException{
		assertEquals("Result","a-9,b-c,1-a", new CityMap("a-9,b-c,1-a").getMap());
	}
	
	@org.junit.Test
	public void testNormalInputDoubleLetters() throws InvalidInputException{
		assertEquals("Result","a-bb,b-c",new CityMap("a-bb,b-c").getMap());
	}
	
	@org.junit.Test
	public void testNormalInputMultipleLetters() throws InvalidInputException{
		assertEquals("Result","aa-bbbb,bbbb-ccccc",new CityMap("aa-bbbb,bbbb-ccccc").getMap());
	}
}
