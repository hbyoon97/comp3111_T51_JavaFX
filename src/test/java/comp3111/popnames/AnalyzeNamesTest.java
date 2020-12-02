package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzeNamesTest {
	
//    @Test 
//    public void testGetRankNotFound() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	int i = a.getRank(2019, "XXX", "M");
//		assertEquals(i, -1);
//    }
//    
//    @Test 
//    public void testGetRankMale() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	int i = a.getRank(2019, "David", "M");
//    	assertTrue(i==27);
//    }
//    
//    @Test 
//    public void testGetRankFemale() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	int i = a.getRank(2019, "Desire", "F");
//    	assertTrue(i==2192);
//    }
//    	
//    @Test 
//    public void testGetNameMale() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 27, "M");
//    	assertTrue(name.equals("David"));
//    }
//    
//    @Test 
//    public void testGetNameFemale() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertTrue(name.equals("Desire"));
//    }
//
//    @Test 
//    // new added
//    public void testGetNameNotFound() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 27777, "F");
//    	assertTrue(name.equals("information on the name at the specified rank is not available"));
//    }
//    
//    @Test 
//    // new added
//    public void testGetSummary() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String summary = a.getSummary(2019);
//    	assertEquals(summary, "Summary (Year of 2019):\n" + 
//    			"Total Births = 3,445,321\n" + 
//    			"***Baby Girls = 1,665,373\n" + 
//    			"***Baby Boys = 1,779,948\n" + 
//    			"Total Number of Unique Names = 31,954\n" + 
//    			"***Unique Names (baby girls) = 17,905\n" + 
//    			"***Unique Names (baby boys) = 14,049\n");
//    }
    
    @Test
    //getNameCount()
    public void testGetNameCount() {
    	AnalyzeNames a = new AnalyzeNames();
    	int result = a.getNameCount("Tommy", "M", 1997);
    	assertEquals(result, 995);
    }
    
    @Test
    //getTotalBirths()
    public void testGetTotalBirths() {
    	AnalyzeNames a = new AnalyzeNames();
    	int result = a.getTotalBirths(1997, "F");
    	assertEquals(result, 1739806);
    }
    
    @Test
    //mostPopularYear()
    public void testMostPopularYear() {
    	AnalyzeNames a = new AnalyzeNames();
    	int result = a.mostPopularYear(1941, 1945, "John", "M");
    	assertEquals(result, 1945);
    }
    
    @Test
    //mostPopularYear()
    public void testMostPopularYear2() {
    	AnalyzeNames a = new AnalyzeNames();
    	int result = a.mostPopularYear(1968, 2019, "Ida", "M");
    	assertEquals(result, 0);
    }
    
}
