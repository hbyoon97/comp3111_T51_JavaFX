/**
 * Building on the sample skeleton for 'ui.fxml' COntroller Class generated by SceneBuilder 
 */
package comp3111.popnames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	private Button buttonReport;

	@FXML
	private TextField textfieldtopN;

	@FXML
	private TextField textfieldy1;

	@FXML
	private TextField textfieldy2;

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
	 * Task Three
	 * 
	 */
	@FXML
	void doTask3() {
		int fromYear = task3fromYear.getValue();
		int toYear = task3toYear.getValue();
		if (fromYear < 1880) {
			showAlert("The period should not be earlier than 1880.");
			return;
		}
		if (toYear > 2019) {
			showAlert("The period should not be later than 2019.");
			return;
		}
		if (fromYear >= toYear) {
			showAlert("The period is not correct.");
			return;
		}
		String gender = ((RadioButton) T111.getSelectedToggle()).getText().equals("Female") ? "F" : "M";
		ArrayList<Object> ret = AnalyzeNames.getTask3(fromYear, toYear, gender);
		String summary = String.format(
				"%s is found to have shown the largest rise in popularity from rank %d in year %d"
						+ " to rank %d in year %d. On the other hand, %s is found to have shown the largest fall in popularity"
						+ " from rank %d in year %d to rank %d in year %d.",
				ret.get(0), ret.get(1), fromYear, ret.get(2), toYear, ret.get(3), ret.get(4), fromYear, ret.get(5),
				toYear);

//    	Platform.runLater(()->{
//    		textAreaConsole.setText(summary);
//    	});

		Stage task3Stage = new Stage();
		task3Stage.setWidth(700);
		task3Stage.setHeight(500);
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);

		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		textArea.setText(summary);

		GridPane grid = new GridPane();
		grid.setMinHeight(200);
		grid.setMaxWidth(600);
		grid.setAlignment(Pos.CENTER);
		grid.setGridLinesVisible(true);
//		grid.setVgap(5);

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
//		name.setFont(new Font("Arial", 24));
		grid.add(name, 0, 0);

		Label lrk = new Label("Lowest Rank");
		Label lrkyr = new Label("[in year]");
		VBox lrkbox = new VBox();
		lrkbox.setAlignment(Pos.CENTER);
		lrkbox.getChildren().addAll(lrk, lrkyr);
//		lrk.setFont(new Font("Arial", 24));
		grid.add(lrkbox, 1, 0);

		Label hrk = new Label("Highest Rank");
		Label hrkyr = new Label("[in year]");
//		hrk.setFont(new Font("Arial", 24));
		VBox hrkbox = new VBox();
		hrkbox.setAlignment(Pos.CENTER);
		hrkbox.getChildren().addAll(hrk, hrkyr);
		grid.add(hrkbox, 2, 0);
		grid.setMargin(hrkbox, new Insets(5, 10, 5, 10));

		Label trend = new Label("Trend");
//		trend.setFont(new Font("Arial", 24));
		grid.add(trend, 3, 0);

		grid.add(new Label((String) ret.get(0)), 0, 1); // name rise
		grid.add(new Label((String) ret.get(3)), 0, 2); // name fall

		Label loRkRise = new Label(ret.get(1).toString());
		Label loRkRiseYr = new Label("[" + fromYear + "]");
		VBox loRkRisebox = new VBox();
		loRkRisebox.setAlignment(Pos.CENTER);
		loRkRisebox.getChildren().addAll(loRkRise, loRkRiseYr);
		grid.add(loRkRisebox, 1, 1);
		grid.setMargin(loRkRisebox, new Insets(5, 10, 5, 10));

//		String hiRkRise = ret.get(2).toString() + "\n[" + toYear + "]";
//		grid.add(new Label(hiRkRise), 2, 1);
		Label hiRkRise = new Label(ret.get(2).toString());
		Label hiRkRiseYr = new Label("[" + toYear + "]");
		VBox hiRkRisebox = new VBox();
		hiRkRisebox.setAlignment(Pos.CENTER);
		hiRkRisebox.getChildren().addAll(hiRkRise, hiRkRiseYr);
		grid.add(hiRkRisebox, 2, 1);

//		String loRkFall = ret.get(5).toString() + "\n[" + toYear + "]";
//		grid.add(new Label(loRkFall), 1, 2);
		Label loRkFall = new Label(ret.get(5).toString());
		Label loRkFallyr = new Label("[" + toYear + "]");
		VBox loRkFallbox = new VBox();
		loRkFallbox.setAlignment(Pos.CENTER);
		loRkFallbox.getChildren().addAll(loRkFall, loRkFallyr);
		grid.add(loRkFallbox, 1, 2);
		grid.setMargin(loRkFallbox, new Insets(5, 10, 5, 10));

//		String hiRkFall = ret.get(4).toString() + "\n[" + fromYear + "]";
//		grid.add(new Label(hiRkFall), 2, 2);
		Label hiRkFall = new Label(ret.get(4).toString());
		Label hiRkFallyr = new Label("[" + fromYear + "]");
		VBox hiRkFallbox = new VBox();
		hiRkFallbox.setAlignment(Pos.CENTER);
		hiRkFallbox.getChildren().addAll(hiRkFall, hiRkFallyr);
		grid.add(hiRkFallbox, 2, 2);

		String trendRise = ((Integer) ret.get(1) - (Integer) ret.get(2)) + " ranks up";
		grid.add(new Label(trendRise), 3, 1);

		String trendFall = ((Integer) ret.get(5) - (Integer) ret.get(4)) + " ranks down";
		grid.add(new Label(trendFall), 3, 2);

		root.getChildren().addAll(grid, textArea);
		Scene scene = new Scene(root);
		task3Stage.setScene(scene);
		task3Stage.setTitle("Task 3");
		task3Stage.show();
	}

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
	void doReport() {

		String oReport = "";
		int n = Integer.parseInt(textfieldtopN.getText());
		int y1 = Integer.parseInt(textfieldy1.getText());
		int y2 = Integer.parseInt(textfieldy2.getText());
		String[] arr = new String[y2 - y1 + 1];
		textAreaConsole.setStyle("-fx-font-family: monospace");

		// invalid input
		if (n < 1) {
			oReport += "Please input a number that is greater than or equal to 1 for the value N\n";
		}
		if (y1 < 1880 || y2 > 2019) {
			oReport += "The period of interest must be between 1880 and 2019\n";
		}

		// valid input
		if (male.isSelected() && n >= 1 && y1 >= 1880 && y2 <= 2019) {

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

		if (female.isSelected() && n >= 1 && y1 >= 1880 && y2 <= 2019) {

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
        	for(int row = 0; row<period2-period1+2; row++) {
        		for(int col = 0; col<4; col++) {
        			int numSpaces = 15 - table[row][col].length();
            		String spaces = "";
            		for(int i = 0; i<numSpaces; i++) {
            			spaces += " ";
            		}
            		oReport += "\t\t" + table[row][col] + spaces;
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
    		if(AnalyzeNames.getRank(period2, name, rbValue[0]) == -1) oReport += String.format("The name %s (%s) has not been ranked in the year %d.\n", name, rbValue[0], period2);
    		else {
    			oReport += String.format("In the year %d the number of birth with name %s is %d, ", period2, name, numCount);
    			oReport += "which represents " + String.format("%.5f", (double)(numCount * 100)/totalBirth) 
				+ " percent of total " + gender + " births in " + period2 +".\n";
    		}
    		if(popularYearNamesBirth != 0) {
    			oReport += String.format("Within the specified period, the year when the name %s was most popular is %d.\n", name, popular_year);
        		oReport += String.format("In that year, the number of births is %d, "
        				+ "which represents a %s percent of the total %s birth in %d"
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
    		if(YOB.trim().equals("") || YOB.trim().isEmpty()) {
    			valid = false;
    			oReport = "Year of Birth field cannot be blank";
    			break;
    		} else if(Integer.parseInt(YOB) < 1880 || Integer.parseInt(YOB) > 2019) {
    			valid = false;
    			oReport = "Please input valid year of birth (1880 - 2019)";
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
    		if(oName.equals("information on the name at the specified rank is not available")) {
    			oName = AnalyzeNames.getName(oYOB, 1, rbValue[2]);
    		}
    
    		oReport = "According to the NK-T5 Algorithm of Universal Compatibility, the recommended name of the soulmate is " + oName + ".";
    	}
    	textAreaConsole.setText(oReport);
    }
}
	

    
   
