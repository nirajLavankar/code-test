package org.sei.exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Niraj
 * 
 * Class is responsible to parse the input array element and remove the
 * duplicate element from it by maintaining the insertion order. 3
 * different approach are provided for single solution
 *
 */
public class DeDup {
	public static final Logger logger = Logger.getLogger(DeDup.class);
	public static final String COMMA = ",";

	/**
	 * Member variable initialized with values
	 */
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * This method will return the input array hold using the member variable
	 * 
	 * @return int[]
	 */
	public int[] getRandomIntegers() {
		return randomIntegers;
	}

	/**
	 * Main method responsible to load the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DeDup deDup = new DeDup();
		int inputValue[] = deDup.getRandomIntegers();
		
		// Case 1
		Integer[] case1OutVal = deDup.removeDupsWithOrderCase1(inputValue);
		deDup.printResult(case1OutVal);
		
		
		//Case 2
		Set<Integer> case2OutValSet = deDup.removeDupsWithOrderCase2(inputValue);
		deDup.printResult(case2OutValSet);
		
		// Case 3
		deDup.removeDupsWithOrderCase3(inputValue);
		
		// Case 4
		deDup.removeDupsWithOrderCase4(inputValue);
		
		// Case 5 Non Order
		deDup.removeDupsNonOrder(inputValue);
	}

	/**
	 * 
	 * This approach to remove the duplicate element from an array is basically
	 * linear search Entire Array is sequentially searched with one against the
	 * other element In order to maintain the insertion sequence, I have to
	 * create new copy of an array which will hold the non duplicate elements.
	 * To create new reference array with the reference copy, I had to make use
	 * of of System.Arraycopy- This itself is heavy operation. Complexity O(n^2)
	 * 
	 * @param inputVal
	 * @return
	 */
	protected Integer[] removeDupsWithOrderCase1(int[] inputVal) {
		logger.info("Removing deuplicate from the input array value using linear search starts ");
		int counter = 0;
		Integer[] referanceCopy = new Integer[inputVal.length];
		for (int i = 0; i < inputVal.length; i++) {
			boolean isPresent = false;
			for (int j = 0; j < referanceCopy.length; j++) {
				if (referanceCopy[j] != null && referanceCopy[j] == inputVal[i]) {
					isPresent = true;
				}
			}
			if (!isPresent) {
				referanceCopy[counter] = inputVal[i];
				counter++;
			}
		}
		Integer[] outputVal = new Integer[counter];
		System.arraycopy(referanceCopy, 0, outputVal, 0, counter);
		logger.info("Removing deuplicate from input array value using linear search ends...");
		return outputVal;
	}
	
	/**
	 * Set does not allow duplicate element. The best way is to insert the
	 * element into LinkedHashSet. LinkedHashSet preserves the insertion order.
	 * This is one of the efficient approach as the complexity is O(n).
	 * 
	 * @param inputArray
	 * @return
	 */
	protected Set<Integer> removeDupsWithOrderCase2(int[] inputArray) {
		logger.info("Removing deuplicate from the input array value using collection api starts ");
		Set<Integer> outputSet = new LinkedHashSet<Integer>();
		for (Integer intVal : inputArray) {
			outputSet.add(intVal);
		}
		logger.info("Removing deuplicate from the input array value using collection api ends...");
		return outputSet;
	}

	/**
	 * Set does not allow duplicate element. The best way is to insert the
	 * element into LinkedHashSet. LinkedHashSet preserves the insertion order.
	 * This is one of the efficient approach as the complexity is O(n). I have
	 * used one of the important feature of Java8 for functional programming as
	 * Lambda expression an Streams API. Java 8 has come up with Streams API
	 * which will provide parallel processing over the collection
	 * 
	 * @param inputArray
	 * @return
	 */
	protected Set<Integer> removeDupsWithOrderCase3(int[] inputArray) {
		logger.info("Removing deuplicate from the input array value using java 8 streams api starts ");
		Set<Integer> outputSet = new LinkedHashSet<Integer>();
		for (Integer intVal : inputArray) {
			outputSet.add(intVal);
		}
		System.out.print("Output## ");
		outputSet.stream().forEach(outVal -> System.out.print(outVal + " "));
		logger.info("\nRemoving deuplicate from the input array value using java 8 streams api  ends...");
		return outputSet;
	}

	/**
	 * Used Java8 API to convert the primitive int array to Collection type
	 * List. Java 8 has come up with Streams API and functional programming
	 * using Lambda expression.
	 * 
	 * @param inputArray
	 * @return
	 */
	protected Set<Integer> removeDupsWithOrderCase4(int[] inputArray) {
		logger.info("Removing deuplicate from the input array value using java8 starts ");
		List<Integer> inList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
		Set<Integer> outputResultSet = inList.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		logger.info("Removing deuplicate from the input array value using java8 ends...");
		return outputResultSet;
	}
	
	/**
	 * Set does not allow duplicate element. The best way is to insert the
	 * element into LinkedHashSet. LinkedHashSet preserves the insertion order.
	 * This is one of the efficient approach but order is not maintained due to
	 * parallel processing.
	 * 
	 * @param inputArray
	 * @return
	 */
	protected Set<Integer> removeDupsNonOrder(int[] inputArray) {
		logger.info(
				"Removing deuplicate from the input array value using java 8 parallel streams without order starts ");
		Set<Integer> outputSet = new LinkedHashSet<Integer>();
		for (Integer intVal : inputArray) {
			outputSet.add(intVal);
		}
		System.out.print("Output## ");
		outputSet.parallelStream().forEach(outVal -> System.out.print(outVal + " "));
		logger.info(
				"\nRemoving deuplicate from the input array value using java 8 parallel streams without order ends...");
		return outputSet;
	}

	/**
	 * This function is resposible to print the output result as per the asked
	 * format
	 * 
	 * @param object
	 */
	public void printResult(Object object) {
		String toPrintVal = "";
		if (object instanceof Integer[]) {
			Integer[] input = (Integer[]) object;
			for (Integer outVal : input) {
				toPrintVal = toPrintVal + outVal + COMMA;
			}
		} else if (object instanceof Set) {
			Set<Integer> inputSet = (Set<Integer>) object;
			for (Integer outVal : inputSet) {
				toPrintVal = toPrintVal + outVal + COMMA;
			}
		}
		if (StringUtils.isNotBlank(toPrintVal)) {
			toPrintVal = toPrintVal.substring(0, toPrintVal.lastIndexOf(COMMA));
		}
		logger.info(" Output## " + toPrintVal + "\n");
	}

}
