package comp3111.popnames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.csv.*;
import edu.duke.*;
import java.util.*;

public class AnalyzeNames {

	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}

	public static String getSummary(int year) {
		String oReport = "";
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int totalNames = 0;
		int uniqueBoys = 0;
		int uniqueGirls = 0;

		oReport = String.format("Summary (Year of %d):\n", year);
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			totalNames += 1;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				uniqueBoys++;
			} else {
				totalGirls += numBorn;
				uniqueGirls++;
			}
		}

		oReport += String.format("Total Births = %,d\n", totalBirths);
		oReport += String.format("***Baby Girls = %,d\n", totalGirls);
		oReport += String.format("***Baby Boys = %,d\n", totalBoys);

		oReport += String.format("Total Number of Unique Names = %,d\n", totalNames);
		oReport += String.format("***Unique Names (baby girls) = %,d\n", uniqueGirls);
		oReport += String.format("***Unique Names (baby boys) = %,d\n", uniqueBoys);

		return oReport;
	}

	public static int getRank(int year, String name, String gender) {
		boolean found = false;
		int oRank = 0;
		int rank = 1;
		for (CSVRecord rec : getFileParser(year)) {
			// Increment rank if gender matches param
			if (rec.get(1).equals(gender)) {
				// Return rank if name matches param
				if (rec.get(0).equals(name)) {
					found = true;
					oRank = rank;
					break;
				}
				rank++;
			}
		}
		if (found)
			return oRank;
		else
			return -1;
	}

	public static String getName(int year, int rank, String gender) {
		boolean found = false;
		String oName = "";
		int currentRank = 0;

		// For every name entry in the CSV file
		for (CSVRecord rec : getFileParser(year)) {
			// Get its rank if gender matches param
			if (rec.get(1).equals(gender)) {
				// Get the name whose rank matches param
				currentRank++;
				if (currentRank == rank) {
					found = true;
					oName = rec.get(0);
					break;
				}
			}
		}
		if (found)
			return oName;
		else
			return "information on the name at the specified rank is not available";
	}

	public static ArrayList<Object> getTask3(int fromYear, int toYear, String gender) {
		Map<String, Integer> ranking = new HashMap<String, Integer>();
		Map<String, Integer> fromRanking = new HashMap<String, Integer>();
		Map<String, Integer> toRanking = new HashMap<String, Integer>();
		int fromYearRankingCounter = 1;
		int toYearRankingCounter = 1;

		for (CSVRecord rec : getFileParser(fromYear)) {
			if (rec.get(1).equals(gender)) {
				fromRanking.put(rec.get(0), fromYearRankingCounter);
				fromYearRankingCounter++;
			}
		}

		for (CSVRecord rec : getFileParser(toYear)) {
			if (rec.get(1).equals(gender)) {
				toRanking.put(rec.get(0), toYearRankingCounter);
				toYearRankingCounter++;
			}
		}

		for (var toRk : toRanking.entrySet()) {
			Integer frRk = fromRanking.get(toRk.getKey());
			if (frRk != null) {
				// exist in both from and to year
				ranking.put(toRk.getKey(), toRk.getValue() - frRk);
			}
		}

		String riseName = minUsingIteration(ranking);
		String fallName = maxUsingIteration(ranking);
		ArrayList<Object> ret = new ArrayList<>();
		ret.add(riseName);
		ret.add(fromRanking.get(riseName));
		ret.add(toRanking.get(riseName));
		ret.add(fallName);
		ret.add(fromRanking.get(fallName));
		ret.add(toRanking.get(fallName));

		return ret;
	}


	public static <K, V extends Comparable<V>> K maxUsingIteration(Map<K, V> map) {
		Map.Entry<K, V> maxEntry = null;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		return maxEntry.getKey();
	}

	public static <K, V extends Comparable<V>> K minUsingIteration(Map<K, V> map) {
		Map.Entry<K, V> minEntry = null;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
				minEntry = entry;
			}
		}
		return minEntry.getKey();
	}

	// Function to calculate the most frequent word in the array.
	public static String FrequentWordname(String array[]) {
		// Insert all unique strings and update count if a string is not unique.
		Map<String, Integer> hshmap = new HashMap<String, Integer>();
		for (String str : array) {
			if (hshmap.keySet().contains(str)) // if already exists then update count.
				hshmap.put(str, hshmap.get(str) + 1);
			else
				hshmap.put(str, 1); // else insert it in the map.
		}
		// Traverse the map for the maximum value.
		String maxStr = "";
		int maxVal = 0;
		for (Map.Entry<String, Integer> entry : hshmap.entrySet()) {
			String key = entry.getKey();
			Integer count = entry.getValue();
			if (count > maxVal) {
				maxVal = count;
				maxStr = key;
			}
			// Condition for the tie.
			else if (count == maxVal) {
				if (key.length() < maxStr.length())
					maxStr = key;
			}
		}
		return maxStr;

	}

	public static int FrequentWordnum(String array[]) {
		// Insert all unique strings and update count if a string is not unique.
		Map<String, Integer> hshmap = new HashMap<String, Integer>();
		for (String str : array) {
			if (hshmap.keySet().contains(str)) // if already exists then update count.
				hshmap.put(str, hshmap.get(str) + 1);
			else
				hshmap.put(str, 1); // else insert it in the map.
		}
		// Traverse the map for the maximum value.
		String maxStr = "";
		int maxVal = 0;
		for (Map.Entry<String, Integer> entry : hshmap.entrySet()) {
			String key = entry.getKey();
			Integer count = entry.getValue();
			if (count > maxVal) {
				maxVal = count;
				maxStr = key;
			}
			// Condition for the tie.
			else if (count == maxVal) {
				if (key.length() < maxStr.length())
					maxStr = key;
			}
		}
		return maxVal;
	}
	
	 public static int getNameCount(String name, String gender, int year) {
		 int count = 0;
		 for (CSVRecord rec : getFileParser(year)) {
			 if(rec.get(0).equals(name) && rec.get(1).equals(gender)) {
				count = Integer.parseInt(rec.get(2)); 
			 } 
		 }
		 return count;
	 }
	 
	 public static int getTotalBirths(int year, String gender) {
		 int totalBirth = 0;
		 for (CSVRecord rec : getFileParser(year)) {
			 if(rec.get(1).equals(gender)) {
				int numBorn = Integer.parseInt(rec.get(2));
				totalBirth += numBorn;
			 }
		 }
		 return totalBirth;
	 }
	 
	 public static int mostPopularYear(int period1, int period2, String name, String gender) {
		 int popular_year = 0;
		 int maxRank = 10000;
		 double thisPercent;
		 double maxPercent = 0.0;
		 for(int i = period1; i<=period2; i++) {
			 int iRank = getRank(i, name, gender);
			 thisPercent = (double) getNameCount(name, gender, i) * 100 / getTotalBirths(i, gender);
			 if(iRank < maxRank && iRank != -1) {
				 maxPercent = thisPercent;
				 maxRank = iRank;
				 popular_year = i;
				 continue;
			 }
			 if(iRank <= maxRank && thisPercent > maxPercent && iRank != -1) {
				 maxPercent = thisPercent;
				 maxRank = iRank;
				 popular_year = i;
			 }
		 }
		 return popular_year;
	 }
}