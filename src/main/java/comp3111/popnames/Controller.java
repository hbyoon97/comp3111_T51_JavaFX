/**
 * Building on the sample skeleton for 'ui.fxml' COntroller Class generated by SceneBuilder 
 */
package comp3111.popnames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {

	@FXML
	private Tab tabTaskZero;
	
	@FXML
	private TabPane tabPane;

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
	private RadioButton task3female;

	@FXML
	private RadioButton task3male;

	@FXML
	private Tab tabApp1;

	@FXML
	private Tab tabApp2;

	@FXML
	private Tab tabApp3;

	@FXML
	private TextArea textAreaConsole;

	@FXML
	private NumberTextField task3fromYear;

	@FXML
	private NumberTextField task3toYear;

	@FXML
	private NumberTextField task3topN;
	
	@FXML
	private Button doTask3;
	
	@FXML
	private Button buttonReport;

	@FXML
	private NumberTextField textfieldtopN;

	@FXML
	private NumberTextField textfieldy1;

	@FXML
	private NumberTextField textfieldy2;

	@FXML
	private RadioButton male;

	@FXML
	private RadioButton female;
    
    @FXML
    private RadioButton rbTask2_male;
    
    @FXML
    private RadioButton rbTask2_female;
    
    @FXML
    private TextField periodTask2_1;
    
    @FXML
    private TextField periodTask2_2;
    
    @FXML
    private TextField task5Name;
    
    @FXML
    private TextField task5YOB;
    
    @FXML
    private RadioButton rbTask5_male;
    
    @FXML
    private RadioButton rbTask5_mate_male;
    
    @FXML
    private RadioButton rbTask5_female;
    
    @FXML
    private RadioButton rbTask5_mate_female;
    
    @FXML
    private RadioButton rbTask5_younger;
    
    @FXML
    private RadioButton rbTask5_older;
    
    @FXML
    private ToggleGroup TG5_1;
    
    @FXML
    private ToggleGroup TG5_2;
    
    @FXML
    private ToggleGroup TG5_3;
    
    @FXML
    private TextField textfieldTask2;
    
    @FXML
	  private TextField textfieldMomName;
    
    @FXML
   	private TextField textfieldDadName;
    
    @FXML
   	private NumberTextField textfieldDadYOB;
    
    @FXML
   	private NumberTextField textfieldMomYOB;

	  @FXML
	  private NumberTextField textfieldVinYear;
	  
    @FXML
    private TextField task6userName;

    @FXML
    private ToggleGroup T61;

    @FXML
    private NumberTextField task6userYob;

    @FXML
    private TextField task6mateName;

    @FXML
    private ToggleGroup T62;

    @FXML
    private ChoiceBox<?> task6pref;
	    
	@FXML
	private RadioButton task6UserMale;
	
	@FXML
	private RadioButton task6UserFemale;
	
	@FXML
	private RadioButton task6MateMale;
	
	@FXML
	private RadioButton task6MateFemale;
	
	@FXML
	private Button doTask6;

	@FXML
	private void initialize() {
		T111 = new ToggleGroup();
		task3female.setToggleGroup(T111);
		task3male.setToggleGroup(T111);		
	}

	/**
	 * Task Zero To be triggered by the "Summary" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doSummary() {
		int year = Integer.parseInt(textfieldYear.getText());
		String oReport = AnalyzeNames.getSummary(year);
		textAreaConsole.setText(oReport);
	}


	/**
	 * Task Zero To be triggered by the "Rank (female)" button on the Task Zero Tab
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
	 * Task Zero To be triggered by the "Rank (male)" button on the Task Zero Tab
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
	 * Task Zero To be triggered by the "Top 5 (female)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doTopF() {
		String oReport = "";
		final int topN = 5;
		int iYear = Integer.parseInt(textfieldYear.getText());
		oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
		for (int i = 1; i <= topN; i++)
			oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Top 5 (male)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doTopM() {
		String oReport = "";
		final int topN = 5;
		int iYear = Integer.parseInt(textfieldYear.getText());
		oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
		for (int i = 1; i <= topN; i++)
			oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
		textAreaConsole.setText(oReport);
	}
	

	/**
	 * 
	 * Generate a pop-up window in response to the queries on identifying the names 
	 * that have maintained a high level of popularity within Top N over a given period.
	 * 
	 * The pop-up window displays a summary of the results and also detailed result 
	 * illustrated with a table.
	 * 
	 * @author Peter Chau Chun Wang
	 */
	@FXML
	public void doTask3() {
		int fromYear;
		int toYear;
		int topN;
		String gender;
		
		if(task3fromYear.getText() == null || task3fromYear.getText().isEmpty()) {
			showAlert("The period cannot be empty.");
			return;
		} else 
			fromYear = task3fromYear.getValue();
		
		if(task3toYear.getText() == null || task3toYear.getText().isEmpty()) {
			showAlert("The period cannot be empty.");
			return;
		} else 
			toYear = task3toYear.getValue();
		
		if(task3topN.getText() == null || task3topN.getText().isEmpty()) {
			showAlert("The level of popularity cannot be empty.");
			return;
		} else 
			topN = task3topN.getValue();
			
		if (fromYear < 1880) {
			showAlert("The period should not be earlier than 1880.");
			return;
		}
		if (toYear > 2019) {
			showAlert("The period should not be later than 2019.");
			return;
		}
		if (fromYear > toYear) {  // 1941 > 1945 
			showAlert("The period is not valid.");
			return;
		}
		if (topN <= 0) {
			showAlert("The popularity should not be zero or negative.");
			return;
		}
		gender = ((RadioButton) T111.getSelectedToggle()).getText().equals("Female") ? "F" : "M";
		
		Map<String, int[]> ret = AnalyzeNames.getTask3(fromYear, toYear, gender, topN);
		
		String summary = String.format("%d names are found to be maintained at a high level of popularity "
				+ "within Top %d over the period from year %d to year %d.",
				ret.size(), topN, fromYear, toYear);
//		textAreaConsole.setText(summary);


		Stage task3Stage = new Stage();
		task3Stage.setWidth(600);
		task3Stage.setHeight(500);
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);

		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		textArea.setText(summary);
		textArea.setMaxHeight(50);

		GridPane grid = new GridPane();
		grid.setMinHeight(200);
		grid.setMaxWidth(600);
		grid.setAlignment(Pos.CENTER);
		grid.setGridLinesVisible(true);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(25);
		col1.setHalignment(HPos.CENTER);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(25);
		col2.setHalignment(HPos.CENTER);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(25);
		col3.setHalignment(HPos.CENTER);
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setPercentWidth(25);
		col4.setHalignment(HPos.CENTER);
		grid.getColumnConstraints().addAll(col1, col2, col3, col4);

		Label name = new Label("Name");
		grid.add(name, 0, 0);

		Label lrk = new Label("Lowest Rank");
		Label lrkyr = new Label("[in year]");
		VBox lrkbox = new VBox();
		lrkbox.setAlignment(Pos.CENTER);
		lrkbox.getChildren().addAll(lrk, lrkyr);
		grid.add(lrkbox, 1, 0);

		Label hrk = new Label("Highest Rank");
		Label hrkyr = new Label("[in year]");
		VBox hrkbox = new VBox();
		hrkbox.setAlignment(Pos.CENTER);
		hrkbox.getChildren().addAll(hrk, hrkyr);
		grid.add(hrkbox, 2, 0);
		GridPane.setMargin(hrkbox, new Insets(5, 10, 5, 10));

		Label trend = new Label("Gross Trend");
		grid.add(trend, 3, 0);
		
		// start making data rows		
		// name, int[]: lowYear, lowRank, HiYear, HiRank, counter
		int mapRow = 1;
		for(var me : ret.entrySet()) {
			grid.add(new Label(me.getKey()), 0, mapRow);  // name
			
			Label loRk = new Label(String.valueOf(me.getValue()[1]));
			Label loRkYr = new Label("[" + me.getValue()[0] + "]");
			VBox loRkbox = new VBox();
			loRkbox.setAlignment(Pos.CENTER);
			loRkbox.getChildren().addAll(loRk, loRkYr);
			grid.add(loRkbox, 1, mapRow);
			GridPane.setMargin(loRkbox, new Insets(5, 10, 5, 10));
			
			Label hiRk = new Label(String.valueOf(me.getValue()[3]));
			Label hiRkYr = new Label("[" + me.getValue()[2] + "]");
			VBox hiRkbox = new VBox();
			hiRkbox.setAlignment(Pos.CENTER);
			hiRkbox.getChildren().addAll(hiRk, hiRkYr);
			grid.add(hiRkbox, 2, mapRow);
			GridPane.setMargin(hiRkbox, new Insets(5, 10, 5, 10));
			
			String gtrend = me.getValue()[0] == me.getValue()[2] ? "FLAT" : me.getValue()[0] > me.getValue()[2] ? "DOWN" : "UP";
			grid.add(new Label(gtrend), 3, mapRow);  // gross trend
			
			mapRow++;
		}
		
		ScrollPane s1 = new ScrollPane();
		s1.setContent(grid);
		s1.setPrefHeight(400);
		s1.setFitToWidth(true);
		
		root.getChildren().addAll(s1, textArea);
		Scene scene = new Scene(root);
		task3Stage.setScene(scene);
		task3Stage.setTitle("Task 3");
		task3Stage.show();
	}

	/**
	 * Display an alert dialog of input error
	 * 
	 * @param msg Input error specification
	 */
	public static void showAlert(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Please input again");
		alert.setContentText(msg);

		alert.showAndWait();
	}

	/**
	 * Task One
	 * 
	 */

	@FXML
	void doTask1() {

		String oReport = "";
		int n;
		int y1;
		int y2;
		
		textAreaConsole.setStyle("-fx-font-family: monospace");
		
		//null input
		if(textfieldtopN.getText().trim().equals("") || textfieldtopN.getText().trim().isEmpty()) {
			oReport = "N cannot be empty";
			textAreaConsole.setText(oReport);
			return;
		}
		else
			n = Integer.parseInt(textfieldtopN.getText());
		
		if(textfieldy1.getText().trim().equals("") || textfieldy1.getText().trim().isEmpty()) {
			oReport = "year cannot be empty";
			textAreaConsole.setText(oReport);
			return;
		}
		else
			y1 = Integer.parseInt(textfieldy1.getText());
		
		if(textfieldy2.getText().trim().equals("") || textfieldy2.getText().trim().isEmpty()) {
			oReport = "year cannot be empty";
			textAreaConsole.setText(oReport);
			return;
		}
		else
			y2 = Integer.parseInt(textfieldy2.getText());

		// invalid input
		if (n < 1) {
			oReport += "Please input a number that is greater than or equal to 1 for the value N\n";
		}
		if (y1 < 1880 || y2 > 2019) {
			oReport += "The period of interest must be between 1880 and 2019\n";
		}

		if (y1 > y2) {
			oReport += "Incorrect period\n";
		}

		// valid input
		if (male.isSelected() && n >= 1 && y1 >= 1880 && y2 <= 2019 && y1 <= y2) {
			String[] arr = new String[y2 - y1 + 1];
			for (int i = 0; i <= y2 - y1; i++)
				arr[i] = AnalyzeNames.getName(i + y1, 1, "M");
			String topname = AnalyzeNames.FrequentWordname(arr);
			int topnum = AnalyzeNames.FrequentWordnum(arr);

			oReport = String.format("Year\t");
			for (int k = 1; k <= n; k++)
				oReport += String.format("Top%d\t\t", k);
			oReport += String.format("\n");

			for (int i = y1; i <= y2; i++) {
				oReport += String.format("%d\t", i);
				for (int j = 1; j <= n; j++) {
					String name = AnalyzeNames.getName(i, j, "M");
					if (name.length() > 7)
						oReport += String.format("%s\t", name);
					else
						oReport += String.format("%s\t\t", name);
				}
				oReport += String.format("\n");
			}

			oReport += String.format(
					"\nOver the period %d to %d, %s for Male has hold the top spot \nmost often for a total of %d times.",
					y1, y2, topname, topnum);

		}

		if (female.isSelected() && n >= 1 && y1 >= 1880 && y2 <= 2019 && y1 <= y2) {
			String[] arr = new String[y2 - y1 + 1];
			for (int i = 0; i <= y2 - y1; i++)
				arr[i] = AnalyzeNames.getName(i + y1, 1, "F");
			String topname = AnalyzeNames.FrequentWordname(arr);
			int topnum = AnalyzeNames.FrequentWordnum(arr);

			oReport = String.format("Year\t");
			for (int k = 1; k <= n; k++)
				oReport += String.format("Top%d\t\t", k);
			oReport += String.format("\n");

			for (int i = y1; i <= y2; i++) {
				oReport += String.format("%d\t", i);
				for (int j = 1; j <= n; j++) {
					String name = AnalyzeNames.getName(i, j, "F");
					if (name.length() > 7)
						oReport += String.format("%s\t", name);
					else
						oReport += String.format("%s\t\t", name);
				}
				oReport += String.format("\n");
			}

			oReport += String.format(
					"\nOver the period %d to %d, %s for Female has hold the top spot \nmost often for a total of %d times.",
					y1, y2, topname, topnum);

		}
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
    	textAreaConsole.setStyle("-fx-font-family: default");

    	
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
    	
    	//handle null input 
    	if(!invalid) {
	    	if(periodTask2_2.getText().trim().equals("") || periodTask2_1.getText().trim().isEmpty()) {
	    		oReport = "Period field cannot be blank";
	    		invalid = true;
	    	}
    	}
    	
    	//retrieve period fields
    	int period1 = 0;
    	int period2 = 0;
    	if(!invalid) {
    		Boolean parsable = true;
    		try {
    		period1 = Integer.parseInt(periodTask2_2.getText());
        	period2 = Integer.parseInt(periodTask2_1.getText());
    		} catch(NumberFormatException e) {
    			parsable = false;
    		}
    		
    		if(!parsable) {
    			oReport = "Please input numbers into period field";
    			invalid = true;
    		}
    	}
    	
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
    	
    	int arrayIndexFix = 1;
    
    	if(!invalid && period2-period1+2 > 1) arrayIndexFix = period2-period1+2;
    	String table[][] = new String[arrayIndexFix][4];
    	if(!invalid) {
        	table[0][0] = "YEAR";
        	table[0][1] = "RANK";
        	table[0][2] = "COUNT";
        	table[0][3] = "PERCENTAGE";
        	for(int row = 1; row<period2-period1+2; row++) {
        			table[row][0] = Integer.toString(period1-1+row);
        			table[row][1] = Integer.toString(AnalyzeNames.getRank(period1-1+row, name, rbValue[0]));
        			if(table[row][1].equals("-1")) table[row][1] = "not ranked";
        			table[row][2] = Integer.toString(AnalyzeNames.getNameCount(name, rbValue[0], period1-1+row));
        			table[row][3] = String.format("%2f", (double) AnalyzeNames.getNameCount(name, rbValue[0], period1-1+row) * 100 / 
        					AnalyzeNames.getTotalBirths(period1-1+row, rbValue[0]));
        	}
    	}
    	
    	//print table
    	if(!invalid) {
    		oReport += "\n";
        	for(int row = 0; row<period2-period1+2; row++) {
        		for(int col = 0; col<4; col++) {
        			int numSpaces = 15 - table[row][col].length();
            		String spaces = "";
            		for(int i = 0; i<numSpaces; i++) {
            			spaces += " ";
            		}
            		oReport += "\t\t\t" + table[row][col] + spaces;
        		}
        		oReport += String.format("\n");
        	}	
        	oReport += String.format("\n");
    	}
    	
    	//valid oReport
    	int popular_year = 0;
    	if(!invalid) {
    		popular_year = AnalyzeNames.mostPopularYear(period1, period2, name, rbValue[0]);
    		if(popular_year == 0) {
    			oReport = String.format("There was no %s (%s) born from %d to %d!", name, rbValue[0], period1, period2);
    			invalid = true;
    		}
    	}
    	
    	if(!invalid) {
        	int popularYearNamesBirth = AnalyzeNames.getNameCount(name, rbValue[0], popular_year);
        	int popularYearTotalBirth = AnalyzeNames.getTotalBirths(popular_year, rbValue[0]);
    		if(AnalyzeNames.getRank(period2, name, rbValue[0]) == -1) oReport += String.format("The name %s (%s) has not been ranked in the year %d.\n", name, rbValue[0], period2);
    		else {
    			oReport += String.format("In the year %d the number of birth with name %s is %d, ", period2, name, numCount);
    			oReport += "which represents " + String.format("%.5f", (double)(numCount * 100)/totalBirth) 
				+ " percent of total " + gender + " births in " + period2 +".\n";
    		}
    		if(popularYearNamesBirth != 0) {
    			oReport += String.format("Within the specified period, the year when the name %s was most popular is %d.\n", name, popular_year);
        		oReport += String.format("In that year, the number of births is %d, "
        				+ "which represents a %s percent of the total %s birth in %d."
        				 ,popularYearNamesBirth, String.format("%.5f", (double)(popularYearNamesBirth * 100)/popularYearTotalBirth), gender, popular_year);
    		}
    	}
    	textAreaConsole.setText(oReport);
    }
  
    @FXML
    void doTask5() {
    	Boolean valid = true;
    	String oReport = "";
    	String rbValue[] = {"M", "M", "younger"};
    	String name = "";
    	String YOB = "";
    	
    	while(valid) {
    		//retrieve text fields
    		name = task5Name.getText();
    		if(name.trim().equals("") || name.trim().isEmpty()) {
    			valid = false;
    			oReport = "Name field cannot be blank";
    			break;
    		}
    		
    		YOB = task5YOB.getText();
    		Boolean parsable = true;
    		try {
    			Integer.parseInt(YOB);
    		} catch(NumberFormatException e) {
    			parsable = false;
    		}
    		
    		if(!parsable) {
    			oReport = "Please input a number in the YOB field.";
    			valid = false;
    			break;
    		}
    		
    		if(Integer.parseInt(YOB) < 1880 || Integer.parseInt(YOB) > 2019) {
    			valid = false;
    			oReport = "Please input valid year of birth (1880 - 2019)";
    			break;
    		}
    		     	
        	//retrieve radio button value
        	rbTask5_male.setToggleGroup(TG5_1);
        	rbTask5_mate_male.setToggleGroup(TG5_2);
        	rbTask5_younger.setToggleGroup(TG5_3);
        	rbTask5_male.setUserData("M");
        	rbTask5_mate_male.setUserData("M");
        	rbTask5_younger.setUserData("younger");
        	
        	rbTask5_female.setToggleGroup(TG5_1);
        	rbTask5_mate_female.setToggleGroup(TG5_2);
        	rbTask5_older.setToggleGroup(TG5_3);
        	rbTask5_female.setUserData("F");
        	rbTask5_mate_female.setUserData("F");
        	rbTask5_older.setUserData("older");
        	
        	RadioButton selectedRadioButtonTG5_1 = (RadioButton) TG5_1.getSelectedToggle();
        	rbValue[0] = selectedRadioButtonTG5_1.getText();
        	
        	RadioButton selectedRadioButtonTG5_2 = (RadioButton) TG5_2.getSelectedToggle();
        	rbValue[1] = selectedRadioButtonTG5_2.getText();
        	
        	RadioButton selectedRadioButtonTG5_3 = (RadioButton) TG5_3.getSelectedToggle();
        	rbValue[2] = selectedRadioButtonTG5_3.getText();
        	
        	//update rbValue[] 
        	if(rbValue[0].equals("Male")) rbValue[0] = "M";
        	else rbValue[0] = "F";
        	
        	if(rbValue[1].equals("Male")) rbValue[1] = "M";
        	else rbValue[1] = "F";
        	
        	if(rbValue[2].equals("Younger")) rbValue[2] = "younger";
        	else rbValue[2] = "older";
        	
        	if((YOB.equals("1880")) && rbValue[2].equals("older")) {
        		valid = false;
        		oReport = "There exists no data for anyone born in year before 1880";
        		break;
        	} else if((YOB.equals("2019")) && rbValue[2].equals("younger")) {
        		valid = false;
        		oReport = "There exists no data for anyone born in year after 2019";
        		break;
        	}
        	
        	oReport = "Name = " + name + " YOB = " + YOB + "Gender: " + rbValue[0] + " Mate Gender = " + rbValue[1] + " Preference: " +rbValue[2];
        	break;
    	}
    	
    	if(valid) {
    		//NTK algorithm
    		int oRank = AnalyzeNames.getRank(Integer.parseInt(YOB), name, rbValue[0]);
    		if(oRank == -1) oRank = 1;
    		
    		int oYOB = 0;
    		if(rbValue[2] == "younger") oYOB = Integer.parseInt(YOB) + 1;
    		else oYOB = Integer.parseInt(YOB) - 1;
    		
    		String oName = AnalyzeNames.getName(oYOB, oRank, rbValue[1]);
    		if(oName.equals("NoResult")) {
    			oName = AnalyzeNames.getName(oYOB, 1, rbValue[1]);
    		}
    
    		oReport = "According to the NK-T5 Algorithm of Universal Compatibility, the recommended name of the soulmate is " + oName + ".";
    	}
    	textAreaConsole.setText(oReport);
    }
	
    /**
	 * Task 4
	 * 
	 * 
	 */
	
    @FXML
	void doTask4() {
		String oReport = "";
		String dadName = textfieldDadName.getText();
		int dadYOB;
		int dadRank;
		String momName = textfieldMomName.getText();
		int momYOB;
		int momRank;
		int vinYear;
		
		//empty name input
		if(textfieldDadName.getText().trim().equals("") || textfieldDadName.getText().trim().isEmpty()
				||textfieldMomName.getText().trim().equals("") || textfieldMomName.getText().trim().isEmpty()) {
    		oReport = "Name field cannot be blank";
    		textAreaConsole.setText(oReport);
    		return;
    	}
		
		//vintage year
		if(textfieldVinYear.getText().trim().equals("") || textfieldVinYear.getText().trim().isEmpty())
			vinYear = 2019;
		
		else if(Integer.parseInt(textfieldVinYear.getText())<1880||Integer.parseInt(textfieldVinYear.getText())>2019) {
			oReport = "Vintage year must be between 1880 and 2019";
			textAreaConsole.setText(oReport);
			return;
		}
		
		else
			vinYear = Integer.parseInt(textfieldVinYear.getText());
		
		//dadYOB
		if(textfieldDadYOB.getText().trim().equals("") || textfieldDadYOB.getText().trim().isEmpty()) {
			oReport = "Year of birth cannot be blank";
			textAreaConsole.setText(oReport);
			return;
		}
		else
			dadYOB = Integer.parseInt(textfieldDadYOB.getText());
		
		//momYOB
		if(textfieldMomYOB.getText().trim().equals("") || textfieldMomYOB.getText().trim().isEmpty()) {
			oReport = "Year of birth cannot be blank";
			textAreaConsole.setText(oReport);
			return;
		}
		else
			momYOB = Integer.parseInt(textfieldMomYOB.getText());
		
		if(dadYOB<1880||dadYOB>2019||momYOB<1880||momYOB>2019) {
			oReport = "Year of birth must be between 1880 and 2019";
			textAreaConsole.setText(oReport);
			return;
		}
		
		//dadRank	
		if (AnalyzeNames.getRank(dadYOB, dadName, "M") >= 1)
			dadRank = AnalyzeNames.getRank(dadYOB, dadName, "M");
		
		else 
			dadRank = 1;
		
		//momRank
		if (AnalyzeNames.getRank(momYOB, momName, "F") >= 1)
			momRank = AnalyzeNames.getRank(momYOB, momName, "F");
		else 
			momRank = 1;
		
		//babyName
		String boyName = AnalyzeNames.getName(vinYear, dadRank, "M");
		String girlName = AnalyzeNames.getName(vinYear, momRank, "F");
		
		oReport = String.format("Recommended name for baby boy: %s\nRecommended name for baby girl: %s\n", boyName, girlName);
		textAreaConsole.setText(oReport);
		
		
	}

    /**
     * Prediction on Scores for Compatible Pairs
     * 
     * @author Peter Chau Chun Wang
     */
    @FXML
    public void doTask6() {
    	String userName = task6userName.getText();
    	String userGender = ((RadioButton) T61.getSelectedToggle()).getText().equals("Male") ? "M" : "F";
    	String userYobString = task6userYob.getText();
    	String mateName = task6mateName.getText();
    	String mateGender = ((RadioButton) T62.getSelectedToggle()).getText().equals("Male") ? "M" : "F";
    	String preference = (String) task6pref.getSelectionModel().getSelectedItem();
    	
//    	String oReport = userName + userGender + userYob + mateName + mateGender + preference;
//		textAreaConsole.setText(userYobString);
    	
    	// start validation
    	if(userName == null || userName.isEmpty()) {
    		showAlert("Your name cannot be empty!");
    		return;
    	}
    	if(userYobString == null || userYobString.isEmpty()) {
    		showAlert("Your YOB cannot be empty!");
    		return;
    	}
    	if(mateName == null || mateName.isEmpty()) {
    		showAlert("Soulmate's name cannot be empty!");
    		return;
    	}
    	int userYob = Integer.parseInt(userYobString);
    	if(userYob < 1880 || userYob > 2019) {
    		showAlert("Your YOB is our of range!");
    		return;
    	}
    	if(userYob == 1880 && preference.equals("Older")) {
    		showAlert("Your soulmate is too old!");
    		return;
    	}
    	if(userYob == 2019 && preference.equals("Younger")) {
    		showAlert("Your soulmate is too young!");
    		return;
    	}
    	// end validation
    	
    	// start calculating score
    	int oRank = AnalyzeNames.getRank(userYob, userName, userGender);
    	if(oRank == -1) oRank = userName.hashCode() % 100;
    	
    	int oYOB = userYob;
    	if(preference.equals("Younger")) oYOB++;
    	if(preference.equals("Older")) oYOB--;
    	
    	int oRankMate = AnalyzeNames.getRank(oYOB, mateName, mateGender);
    	if(oRankMate == -1) oRankMate = mateName.hashCode() % 100;
    	
    	double magicFraction = (oRankMate < oRank) ? (double) oRankMate / (oRank + 1) : (double) oRank / (oRankMate + 1);
    	
    	double oScore = Math.sqrt(Math.sqrt(Math.abs(magicFraction))) * 100;
    	
    	if(oScore > 100) oScore = 100;
    	if(oScore < 0 ) oScore = 0;
    	
    	// finish calculation
    	String oReport = String.format("According to the NK-T5 Algorithm of Universal Compatibility:\nThe score of compatibility for you and your soulmate is %.1f%%", oScore);
		textAreaConsole.setText(oReport);
    }
}
