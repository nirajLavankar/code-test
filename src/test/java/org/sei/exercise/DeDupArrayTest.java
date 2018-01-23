package org.sei.exercise;

import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Niraj
 * Junit Test class to perform the testing of the functionality
 * 
 */
public class DeDupArrayTest {
	DeDup deDup = new DeDup();
	
	/**
	 * Verify the input provided is not null
	 */
	@Test
	public void verifyNotNullInputTest() {
		int[] input = deDup.getRandomIntegers();
		Assert.assertNotNull(input);
	}
	
	/**
	 *  Validate the number of input provided with the expected and actual length of an 
	 *  element within an array
	 */
	@Test
	public void validateInputTest() {
		int[] input = deDup.getRandomIntegers();
		int[] actual = { 1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
	            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
	            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
		Assert.assertEquals(input.length, actual.length);
	}
	
	/**
	 *  Case 1- Test that  after sorting the output array is not null.
	 *  Print the output non duplicate array as per the input order 
	 */
	@Test
	public void removeDupsWithOrderCase1Test(){
		int[] input = deDup.getRandomIntegers();
		Integer[] result = deDup.removeDupsWithOrderCase1(input);
		Assert.assertNotNull(result);
		deDup.printResult(result);
	}
	
	/**
	 *  Case 2- Test that  after sorting the output array is not null.
	 *  Print the output non duplicate array as per the input order 
	 */
	@Test
	public void removeDupsWithOrderCase2Test(){
		int[] input = deDup.getRandomIntegers();
		Set<Integer> result= deDup.removeDupsWithOrderCase2(input);
		Assert.assertNotNull(result);
		deDup.printResult(result);
	}
	
	/**
	 *  Case 3- Test that  after sorting the output array is not null.
	 *  Print the output non duplicate array as per the input order 
	 */
	@Test
	public void removeDupsWithOrderCase3Test(){
		int[] input = deDup.getRandomIntegers();
		Set<Integer> result= deDup.removeDupsWithOrderCase3(input);
		Assert.assertNotNull(result);
		deDup.printResult(result);
	}
	
	/**
	 *  Case 4- Test that  after sorting the output array is not null.
	 *  Print the output non duplicate array as per the input order 
	 */
	@Test
	public void removeDupsWithOrderCase4Test(){
		int[] input = deDup.getRandomIntegers();
		Set<Integer> result= deDup.removeDupsWithOrderCase4(input);
		Assert.assertNotNull(result);
	}
	
	/**
	 *  Case 5- Test that  after sorting the output array is not null.
	 *  Print the output non duplicate array. No input order is maintained with this use case.
	 */
	@Test
	public void removeDupsWithNonOrderTest(){
		int[] input = deDup.getRandomIntegers();
		Set<Integer> result= deDup.removeDupsNonOrder(input);
		Assert.assertNotNull(result);
	}
	
}
