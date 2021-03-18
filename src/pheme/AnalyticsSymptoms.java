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
		 * Read file and count the symptoms occurencies in a map
		 */
		Map<String, Integer> diseaseOccurMap = getDiseaseMapFromFile(new File("symptoms.txt"));
		
		writeDiseaseMapToFile(new File("results.out"), diseaseOccurMap);

	}
           
	static Map<String, Integer> getDiseaseMapFromFile(File sourceFile) {
		/**
		 * SortedMap that will contains disease and their occurencies
		 */
		 Map<String, Integer> diseaseOccurenciesMap = new TreeMap<>();
		 	/**
		 	 * Open the file that contains disease list
		 	 */
	        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) 
	        {
	            String currentSymptom;
	            /**
	             * Read each line of the opened file
	             */
	            while ((currentSymptom = br.readLine()) != null) 
	            {
	            	 /**
	            	  * Does the current symptoms is already in our disease map ?
	            	  */
	                 Integer count = diseaseOccurenciesMap.get(currentSymptom);

	                 if(count == null) 
	                	 count = 0;
	                
	                 diseaseOccurenciesMap.put(currentSymptom, count + 1);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return diseaseOccurenciesMap;
	}
	
	static File writeDiseaseMapToFile(File Output, Map<String, Integer> diseaseOccurenciesMap) {
         /**
          * Write into the file named "results.out" from the map
          */
	        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(Output)))
	        {
	        	for(Map.Entry<String, Integer> currentEntry : diseaseOccurenciesMap.entrySet()) {
	        		bw1.write(" Disease : " + currentEntry.getKey() + " = " + currentEntry.getValue());
	        		bw1.newLine();
	        	}	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return Output;
	}
}


