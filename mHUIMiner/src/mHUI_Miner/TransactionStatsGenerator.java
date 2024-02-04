package mHUI_Miner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This class reads a transaction database and calculates statistics
 * about this transactions database, then it prints the statistics to the console.
 * <br/><br/>
 * It is modified from the stats generator in SPMF library
 * 
* @author Philippe Fournier-Viger, Alex Peng
 */

public class TransactionStatsGenerator {
	/**
	 * This method generates statistics for a transaction database (a file)
	 * @param path the path to the file
	 * @param fileName the name of the csv file to be created
	 * @throws IOException  exception if there is a problem while reading the file.
	 */
	public void getStats(String path, String fileName) throws IOException {

		// we initialize some variables that we will use to generate the statistics
		int minItem = Integer.MAX_VALUE; // the largest id for items in the database
		int maxItem = 0; // the largest id for items in the database
		//Set<Integer> items = new java.util.HashSet<Integer>();  // the set of all items
		List<Integer> sizes = new ArrayList<Integer>(); // the lengths of each transactions
		int dataSetSize = 0;

		
		// this map is used to store the number of times that each item
		// appear in the database.
		// the key is an item
		// the value is the number of items that the item appears
		HashMap<Integer, Integer> mapItemSupport = new HashMap<Integer, Integer>();
			
		BufferedReader myInput = null;
		String thisLine;
		try {
			myInput = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
			// for each line (transaction) until the end of file
			while ((thisLine = myInput.readLine()) != null) {
				// if the line is a comment, is empty or is a kind of metadata
				if (thisLine.isEmpty() == true || thisLine.charAt(0) == '#' || thisLine.charAt(0) == '%'
						|| thisLine.charAt(0) == '@') {
					continue;
				}

				// split the transaction into individual items
				String[] transaction = thisLine.split(" ");
				
				// add the size of this transaction to the list of sizes
				sizes.add(transaction.length);
				dataSetSize += 1;

				for (int i = 0; i < transaction.length; i++) {
					Integer item = Integer.parseInt(transaction[i]);
					//update maxItem and minItem
					if(item > maxItem) {
						maxItem = item; 
					}
					if(item < minItem) {
						minItem = item; 
					}
					// If the item is not in the map already, we set count to 0
					Integer count = mapItemSupport.get(item);
					if (count == null) {
						count = 0;
					}
					mapItemSupport.put(item, count+1);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myInput != null) {
				myInput.close();
			}
		}


		///////////////////////////////////
		System.out.println("============  TRANSACTION DATABASE STATS ==========");
		System.out.println("Number of transactions : " + dataSetSize);
		
		// put support of items into a list
		List<Integer> listSupportOfItems = new ArrayList<Integer>(mapItemSupport.values());
		
		// we print the statistics
		System.out.println("File " + path);
		System.out.println("Number of distinct items: " + mapItemSupport.size());
		System.out.println("Smallest item id: " + minItem);
		System.out.println("Largest item id: " + maxItem);
		System.out.println("Average number of items per transaction: "
				+ calculateMean(sizes) + " standard deviation: "
				+ calculateStdDeviation(sizes) + " variance: "
				+ calculateVariance(sizes));
		System.out.println("Average item support in the database: "
				+ calculateMean(listSupportOfItems) + " standard deviation: "
				+ calculateStdDeviation(listSupportOfItems) + " variance: "
				+ calculateVariance(listSupportOfItems)
				+ " min value: " + calculateMinValue(listSupportOfItems)
				+ " max value: " + calculateMaxValue(listSupportOfItems)
				);
		
		Collections.sort(listSupportOfItems);
		writeCSV(fileName, listSupportOfItems);
		
	}
	

	private static void writeCSV(String fileName, List<Integer> listSupportOfItems){
	    //Delimiter used in CSV file
		int belowAverSupport = 0;
		int aboveAverSupport = 0;
	    final String COMMA_DELIMITER = ",";
	    FileWriter fileWriter = null; 
	    double averSupport = calculateMean(listSupportOfItems);
	    try{
	    	fileWriter = new FileWriter(fileName);
//	    	for(int i = 0; i<listSupportOfItems.size();i++){
//	    		if(listSupportOfItems.get(i)<averSupport){
//	    			belowAverSupport += 1;
//	    		}else{
//	    			aboveAverSupport += 1;
//	    		}
//	    		fileWriter.append(Integer.toString(listSupportOfItems.get(i)));
//	    		fileWriter.append(COMMA_DELIMITER);
//	    	}
	    	for(int i = 0; i<5267001;i+=1000){
	    		if(listSupportOfItems.get(i)<averSupport){
	    			belowAverSupport += 1;
	    		}else{
	    			aboveAverSupport += 1;
	    		}
	    		fileWriter.append(Integer.toString(listSupportOfItems.get(i)));
	    		fileWriter.append(COMMA_DELIMITER);
	    	}
			System.out.println("Number of items whose support values are below average: " + belowAverSupport);
			System.out.println("Number of items whose support values are above average: " + aboveAverSupport);

	    	
	    }catch(Exception e){
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();

	    }finally{
	    	try{
	    		fileWriter.flush();
	    		fileWriter.close();
	    	}catch(IOException e){
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();

	    	}
	    }
	    
	    
	}


	/**
	 * This method calculates the mean of a list of integers
	 * @param list the list of integers
	 * @return the mean 
	 */
	private static double calculateMean(List<Integer> list) {
		double sum = 0;
		for (Integer val : list) {
			sum += val;
		}
		return sum / list.size();
	}

	/**
	 * This method calculates the standard deviation of a list of integers
	 * @param list the list of integers
	 * @return the standard deviation
	 */
	private static double calculateStdDeviation(List<Integer> list) {
		double deviation = 0;
		double mean = calculateMean(list);
		for (Integer val : list) {
			deviation += Math.pow(mean - val, 2);
		}
		return Math.sqrt(deviation / list.size());
	}

	/**
	 * This method calculates the mean of a list of doubles
	 * @param list the list of doubles
	 * @return the mean
	 */
	private static double calculateMeanD(List<Double> list) {
		double sum = 0;
		for (Double val : list) {
			sum += val;
		}
		return sum / list.size();
	}

	/**
	 * This method calculates the standard deviation of a list of doubles
	 * @param list the list of doubles
	 * @return the standard deviation
	 */
	private static double calculateStdDeviationD(List<Double> list) {
		double deviation = 0;
		double mean = calculateMeanD(list);
		for (Double val : list) {
			deviation += Math.pow(mean - val, 2);
		}
		return Math.sqrt(deviation / list.size());
	}

	/**
	 * This method calculates the variance of a list of integers
	 * @param list the list of integers
	 * @return the variance 
	 */
	private static double calculateVariance(List<Integer> list) {
		double deviation = 0;
		double mean = calculateMean(list);
		for (Integer val : list) {
			deviation += Math.pow(mean - val, 2);
		}
		return Math.pow(Math.sqrt(deviation / list.size()), 2);
	}

	/**
	 * This method returns the smallest integer from a list of integers
	 * @param list the list of integers
	 * @return the smallest integer 
	 */
	private static int calculateMinValue(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (Integer val : list) {
			if (val < min) {
				min = val;
			}
		}
		return min;
	}

	/**
	 * This method returns the largest integer from a list of integers
	 * @param list the list of integers
	 * @return the largest integer 
	 */
	private static int calculateMaxValue(List<Integer> list) {
		int max = 0;
		for (Integer val : list) {
			if (val >= max) {
				max = val;
			}
		}
		return max;
	}
	

}
