package pheme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsSymptoms is the class represents all symptoms contains
 * in Symptoms.txt file.
 * 
 * Displays 
 * 
 * @author Teffery MAKONDE
 * @version 1.0
 * 
 */
public class AnalyticsSymptoms {

	public static void main(String[] args) {
		/**
		 * A map contains for key symptoms as string and 
		 * value as integer the number of times when symptoms appears.
		 * 
		 * @see getSymptoms
		 * 
		 */
		 Map<String, Integer> getSymptoms = new TreeMap<>();
		 
		 	/**
		 	 * 
		 	 * @exception print error if the file does not exist
		 	 * or is not available when BufferedRead reads.
		 	 * 
		 	 * @param br
		 	 */
	        try (BufferedReader br = new BufferedReader(new FileReader(new File("/Users/kingteff/Desktop/training/symptoms.txt")))) 
	        {
	        	/**
	        	 * 
	        	 * @param currentSymptoms
	        	 * 
	        	 */
	            String currentSymptoms;

	            while ((currentSymptoms = br.readLine()) != null) 
	            {
	            	 /**
	            	  * 
	            	  * @see count, 
	            	  */
	                 Integer count = getSymptoms.get(currentSymptoms);

	                 if(count == null) 
	                 { 
	                    getSymptoms.put(currentSymptoms, 1);
	                 }
	                 else 
	                 { 
	                     getSymptoms.put(currentSymptoms, count + 1);
	                 }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
            File file = new File("results.out");// name file in output
            /**
             * 
             * @param file, contains 
             * 
             * @param br1
             */
	        try (BufferedWriter br1 = new BufferedWriter(new FileWriter(file)))
	        {
	        	/**
	        	 * 
	        	 * @see currentEntry,
	        	 * 
	        	 */
	        	for(Map.Entry<String, Integer> currentEntry : getSymptoms.entrySet()) {
	        		br1.write(" Disease : " + currentEntry.getKey() + " = " + currentEntry.getValue());
	        		br1.newLine();
	        	}	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}


