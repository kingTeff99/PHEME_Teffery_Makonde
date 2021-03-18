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
 * @author Teffery MAKONDE
 * @version 1.0
 * 
 */
public class AnalyticsSymptoms {

	public static void main(String[] args) {
		/**
		 * SortedMap that will contains disease and their occurencies <DiseaseName,OccurenciesCOunt>
		 */
		 Map<String, Integer> getSymptomMap = new TreeMap<>();
		 
		 	/**
		 	 * Open the file that contains disease list
		 	 */
	        try (BufferedReader br = new BufferedReader(new FileReader(new File("filepath")))) 
	        {
	            String currentSymptoms;
	            /**
	             * Read each line of the opened file
	             */
	            while ((currentSymptoms = br.readLine()) != null) 
	            {
	            	 /**
	            	  * Does the current symptoms is already in our disease map ?
	            	  */
	                 Integer count = getSymptomMap.get(currentSymptoms);

	                 if(count == null) 
	                 { 
	                    getSymptomMap.put(currentSymptoms, 1);
	                 }
	                 else 
	                 { 
	                     getSymptomMap.put(currentSymptoms, count + 1);
	                 }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
            File file = new File("results.out");// name file in output
            /**
             * Write into the file named "results.out" from the map
             */
	        try (BufferedWriter br1 = new BufferedWriter(new FileWriter(file)))
	        {
	        	for(Map.Entry<String, Integer> currentEntry : getSymptomMap.entrySet()) {
	        		br1.write(" Disease : " + currentEntry.getKey() + " = " + currentEntry.getValue());
	        		br1.newLine();
	        	}	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}


