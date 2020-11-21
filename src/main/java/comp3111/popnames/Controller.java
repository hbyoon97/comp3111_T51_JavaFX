/**
 * Building on the sample skeleton for 'ui.fxml' COntroller Class generated by SceneBuilder 
 */
package comp3111.popnames;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Controller {
	
	@FXML
	private TabPane tabPane;

    @FXML
    private Tab tabTaskZero;

    @FXML
    private TextField textfieldNameF;

    @FXML
    private TextField textfieldYear;

    @FXML
    private Button buttonRankM;

    @FXML
    private TextField textfieldNameM;

    @FXML
    private Button buttonRankF;

    @FXML
    private Button buttonTopM;

    @FXML
    private Button buttonTopF;

    @FXML
    private Button buttonSummary;
    
    @FXML
    private Tab tabReport1;

    @FXML
    private ToggleGroup T1;

    @FXML
    private Tab tabReport2;

    @FXML
    private ToggleGroup T11;

    @FXML
    private Tab tabReport3;

    @FXML
    private ToggleGroup T111;

    @FXML
    private Tab tabApp1;

    @FXML
    private Tab tabApp2;

    @FXML
    private Tab tabApp3;

    @FXML
    private TextField textfieldTask2;   
    
    @FXML
    private RadioButton rbTask2_male;
    
    @FXML
    private RadioButton rbTask2_female;
    
    @FXML
    private TextField periodTask2_1;
    
    @FXML
    private TextField periodTask2_2;
    
    @FXML
    private TextArea textAreaConsole; 

    /**
     *  Task Zero
     *  To be triggered by the "Summary" button on the Task Zero Tab 
     *  
     */
    @FXML
    void doSummary() {
    	int year = Integer.parseInt(textfieldYear.getText());
    	String oReport = AnalyzeNames.getSummary(year);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rank (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRankF() {
    	String oReport = "";
    	String iNameF = textfieldNameF.getText();
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	int oRank = AnalyzeNames.getRank(iYear, iNameF, "F");
    	if (oRank == -1)
    		oReport = String.format("The name %s (female) has not been ranked in the year %d.\n", iNameF, iYear);
    	else
    		oReport = String.format("Rank of %s (female) in year %d is #%d.\n", iNameF, iYear, oRank);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rank (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRankM() {
    	String oReport = "";
    	String iNameM = textfieldNameM.getText();
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	int oRank = AnalyzeNames.getRank(iYear, iNameM, "M");
    	if (oRank == -1)
    		oReport = String.format("The name %s (male) has not been ranked in the year %d.\n", iNameM, iYear);
    	else
    		oReport = String.format("Rank of %s (male) in year %d is #%d.\n", iNameM, iYear, oRank);
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopF() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopM() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
    	textAreaConsole.setText(oReport);
    }
    
    /**
     *  Task Two
     *  To be triggered by the REPORT button on the Task Zero Tab
     *  
     */
    @FXML
    void doTask2() {
    	String oReport = "";
    	int numCount = 0;
    	Boolean invalid = false;
    	String rbValue[] = {"M"};
    	
    	//retrieve text field
    	String name = textfieldTask2.getText();
    	
    	//handle null input 
    	if(textfieldTask2.getText().trim().equals("") || textfieldTask2.getText().trim().isEmpty()) {
    		oReport = "Name field cannot be blank";
    		invalid = true;
    	}
    	
    	//retrieve radio button value
    	rbTask2_male.setToggleGroup(T11);
    	rbTask2_male.setUserData("M");
    	rbTask2_female.setToggleGroup(T11);
    	rbTask2_female.setUserData("F");
    	
    	RadioButton selectedRadioButton = (RadioButton) T11.getSelectedToggle();
    	rbValue[0] = selectedRadioButton.getText();
    	
    	//update rbValue to M and F
    	if(rbValue[0].equals("Male")) rbValue[0] = "M";
    	else rbValue[0] = "F";
    	
    	//update variable gender for oReport
    	String gender = "";
    	if(rbValue[0].equals("M")) gender = "male";
    	else gender = "female";
    	
    	//retrieve period fields
    	int period1 = Integer.parseInt(periodTask2_2.getText());
    	int period2 = Integer.parseInt(periodTask2_1.getText());
    	
    	//handle invalid input period
    	if((period1 > period2 || period1 < 1880 || period2 > 2019) && !invalid) {
    		oReport = "Please input valid period (1880 - 2019)";	
    		invalid = true;
    	}
    	
    	//getCount
    	if(!invalid) numCount = AnalyzeNames.getNameCount(name, rbValue[0], period2);
    
    	//get totalBirth for specified
    	int totalBirth = 0;
    	if(!invalid) totalBirth = AnalyzeNames.getTotalBirths(period2, rbValue[0]);
    	if(totalBirth == 0 && !invalid) {
    		oReport = String.format("There was no %s born in %d!", gender, period2);
    	}
    	
    	
    	int arrayIndexFix = 1;
    	if(period2-period1+2 > 1) arrayIndexFix = period2-period1+2;
    	String table[][] = new String[arrayIndexFix][4];
    	if(!invalid) {
        	table[0][0] = " Year";
        	table[0][1] = " Rank";
        	table[0][2] = " Count";
        	table[0][3] = " Percentage";
        	for(int row = 1; row<period2-period1+2; row++) {
        			table[row][0] = Integer.toString(period1-1+row);
        			table[row][1] = Integer.toString(AnalyzeNames.getRank(period1-1+row, name, rbValue[0]));
        			table[row][2] = Integer.toString(AnalyzeNames.getNameCount(name, rbValue[0], period1-1+row));
        			table[row][3] = String.format("%2f", (double) AnalyzeNames.getNameCount(name, rbValue[0], period1-1+row) * 100 / 
        					AnalyzeNames.getTotalBirths(period1-1+row, rbValue[0]));
        	}
    	}
    	
    	//print table
    	if(!invalid) {
    		oReport += String.format("Year\t\t\t\t\t");
        	oReport += String.format("Rank\t\t\t\t\t");
        	oReport += String.format("Count\t\t\t\t\t");
        	oReport += String.format("Percentage\t\t\t\t\t");
        	oReport += String.format("\n");

        	for(int row = 1; row<period2-period1+2; row++) {
        		for(int col = 0; col<4; col++) {
    				String tabSpace = "\t\t\t\t\t";
    				if(col == 2 && table[row][col].length() != 5) tabSpace+="\t";
    				oReport += table[row][col]+tabSpace;
        		}
        		oReport += String.format("\n");
        	}	
        	oReport += String.format("\n");
    	}
    	
    	//valid oReport
    	if(!invalid) {
    		int popular_year = AnalyzeNames.mostPopularYear(period1, period2, name, rbValue[0]);
        	int popularYearNamesBirth = AnalyzeNames.getNameCount(name, rbValue[0], popular_year);
        	int popularYearTotalBirth = AnalyzeNames.getTotalBirths(popular_year, rbValue[0]);
    		if(AnalyzeNames.getRank(period2, name, rbValue[0]) == -1) oReport += String.format("The name %s (%s) has not been ranked in the year %d. ", name, rbValue[0], period2);
    		else {
    			oReport += String.format("In the year %d the number of birth with name %s is %d, ", period2, name, numCount);
    			oReport += "which represents " + String.format("%.5f", (double)(numCount * 100)/totalBirth) 
				+ " percent of total " + gender + " births in " + period2 +". ";
    		}
    		if(popularYearNamesBirth != 0) {
    			oReport += String.format("The year when the name %s was most popular is %d. ", name, popular_year);
        		oReport += String.format("In that year, the number of births is %d, "
        				+ "which represents a %s percent of the total %s birth in %d"
        				 ,popularYearNamesBirth, String.format("%.5f", (double)(popularYearNamesBirth * 100)/popularYearTotalBirth), gender, popular_year);
    		}
    	}
    	textAreaConsole.setText(oReport);
    }
}

