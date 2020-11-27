package comp3111.popnames;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class ControllerTest extends ApplicationTest {

	private Scene s;
	private TextArea t;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Popular Names");
   		stage.show();
   		s = scene;
		t = (TextArea)s.lookup("#textAreaConsole");
	}

    
	@Test
	//no name
	public void testTask2_1() {	
		clickOn("#tabReport2");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		String s2 = "Name field cannot be blank";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//no period
	public void testTask2_2() {	
		clickOn("#tabReport2");
		TextField task2_name = (TextField)s.lookup("#textfieldTask2");
		task2_name.setText("Tommy");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		String s2 = "Period field cannot be blank";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//female + invalid period
	public void testTask2_3() {	
		clickOn("#tabReport2");
		TextField task2_name = (TextField)s.lookup("#textfieldTask2");
		task2_name.setText("Ida");
		
		RadioButton task2_rbF = (RadioButton) s.lookup("#rbTask2_female");
		task2_rbF.setSelected(true);
		TextField task2_period1 = (TextField)s.lookup("#periodTask2_1");
		task2_period1.setText("2000");
		TextField task2_period2 = (TextField)s.lookup("#periodTask2_2");
		task2_period2.setText("2019");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		String s2 = "Please input valid period (1880 - 2019)";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//unparseable period
	public void testTask2_4() {
		clickOn("#tabReport2");
		TextField task2_name = (TextField)s.lookup("#textfieldTask2");
		task2_name.setText("John");
		RadioButton task2_rbF = (RadioButton) s.lookup("#rbTask2_female");
		task2_rbF.setSelected(true);
		TextField task2_period1 = (TextField)s.lookup("#periodTask2_1");
		task2_period1.setText("asdf");
		TextField task2_period2 = (TextField)s.lookup("#periodTask2_2");
		task2_period2.setText("asdf");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		String s2 = "Please input numbers into period field";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//no name born in specified period
	public void testTask2_5() {
		clickOn("#tabReport2");
		TextField task2_name = (TextField)s.lookup("#textfieldTask2");
		task2_name.setText("Ida");
		TextField task2_period1 = (TextField)s.lookup("#periodTask2_1");
		task2_period1.setText("2019");
		TextField task2_period2 = (TextField)s.lookup("#periodTask2_2");
		task2_period2.setText("2000");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		String result = "There was no Ida (M) born from 2000 to 2019!";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//no one born in that year!!
	public void testTask2_6() {
		clickOn("#tabReport2");
		TextField task2_name = (TextField)s.lookup("#textfieldTask2");
		task2_name.setText("Ida");
		TextField task2_period1 = (TextField)s.lookup("#periodTask2_1");
		task2_period1.setText("1968");
		TextField task2_period2 = (TextField)s.lookup("#periodTask2_2");
		task2_period2.setText("1967");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		
		String result = "";
		String table[][] = new String[3][4];
		table[0][0] = "YEAR";
    	table[0][1] = "RANK";
    	table[0][2] = "COUNT";
    	table[0][3] = "PERCENTAGE";
		for(int row = 1; row<3; row++) {
			table[row][0] = Integer.toString(1966+row);
			table[row][1] = Integer.toString(AnalyzeNames.getRank(1966+row, "Ida", "M"));
			if(table[row][1].equals("-1")) table[row][1] = "not ranked";
			table[row][2] = Integer.toString(AnalyzeNames.getNameCount("Ida", "M", 1966+row));
			table[row][3] = String.format("%2f", (double) AnalyzeNames.getNameCount("Ida", "M", 1966+row) * 100 / 
					AnalyzeNames.getTotalBirths(1966+row, "M"));
		}
		result += "\n";
		for(int row = 0; row<3; row++) {
    		for(int col = 0; col<4; col++) {
    			int numSpaces = 15 - table[row][col].length();
        		String spaces = "";
        		for(int i = 0; i<numSpaces; i++) {
        			spaces += " ";
        		}
        		result += "\t\t\t" + table[row][col] + spaces;
    		}
    		result += String.format("\n");
    	}	
    	result += String.format("\n");
		
		result += "The name Ida (M) has not been ranked in the year 1968.\n";
		result += "Within the specified period, the year when the name Ida was most popular is 1967.\n";
		result += "In that year, the number of births is 8, which represents a 0.00046 percent of the total male birth in 1967.";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//valid oReport
	public void testTask2_7() {
		clickOn("#tabReport2");
		TextField task2_name = (TextField)s.lookup("#textfieldTask2");
		task2_name.setText("William");
		TextField task2_period1 = (TextField)s.lookup("#periodTask2_1");
		task2_period1.setText("2019");
		TextField task2_period2 = (TextField)s.lookup("#periodTask2_2");
		task2_period2.setText("2000");
		clickOn("#doTask2");
//		sleep(1000);
		String s1 = t.getText();
//		sleep(1000);
		
		String result = "";
		String table[][] = new String[21][4];
		table[0][0] = "YEAR";
    	table[0][1] = "RANK";
    	table[0][2] = "COUNT";
    	table[0][3] = "PERCENTAGE";
    	for(int row = 1; row<21; row++) {
			table[row][0] = Integer.toString(1999+row);
			table[row][1] = Integer.toString(AnalyzeNames.getRank(1999+row, "William", "M"));
			if(table[row][1].equals("-1")) table[row][1] = "not ranked";
			table[row][2] = Integer.toString(AnalyzeNames.getNameCount("William", "M", 1999+row));
			table[row][3] = String.format("%2f", (double) AnalyzeNames.getNameCount("William", "M", 1999+row) * 100 / 
					AnalyzeNames.getTotalBirths(1999+row, "M"));
    	}
    	
    	result += "\n";
    	for(int row = 0; row<21; row++) {
    		for(int col = 0; col<4; col++) {
    			int numSpaces = 15 - table[row][col].length();
        		String spaces = "";
        		for(int i = 0; i<numSpaces; i++) {
        			spaces += " ";
        		}
        		result += "\t\t\t" + table[row][col] + spaces;
    		}
    		result += String.format("\n");
    	}	
    	result += String.format("\n");
    	
    	result += "In the year 2019 the number of birth with name William is 13542, which represents 0.76081 percent of total male births in 2019.\n";
    	result += "Within the specified period, the year when the name William was most popular is 2011.\n";
    	result += "In that year, the number of births is 17314, which represents a 0.91452 percent of the total male birth in 2011.";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//Tommy, 1997, male, mate=female, younger = Meredith
	public void testTask5_1() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		task5name.setText("Tommy");
		task5YOB.setText("1997");
		RadioButton rbTask5_mate_female = (RadioButton)s.lookup("#rbTask5_mate_female");
		rbTask5_mate_female.setSelected(true);
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "According to the NK-T5 Algorithm of Universal Compatibility, the recommended name of the soulmate is Meredith.";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//Angel, female, mate=male, older = Colin
	public void testTask5_2() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		
		task5name.setText("Angel");
		task5YOB.setText("2000");
		RadioButton rbTask5_female = (RadioButton)s.lookup("#rbTask5_female");
		RadioButton rbTask5_older = (RadioButton)s.lookup("#rbTask5_older");
		rbTask5_female.setSelected(true);
		rbTask5_older.setSelected(true);
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "According to the NK-T5 Algorithm of Universal Compatibility, the recommended name of the soulmate is Colin.";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//empty name
	public void testTask5_3() {
		clickOn("#tabApp2");
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "Name field cannot be blank";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//empty YOB
	public void testTask5_4() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		task5name.setText("Angel");
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "Please input a number in the YOB field.";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//invalid YOB
	public void testTask5_5() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		task5name.setText("Angel");
		task5YOB.setText("2020");
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "Please input valid year of birth (1880 - 2019)";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//can't older
	public void testTask5_6() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		RadioButton older = (RadioButton)s.lookup("#rbTask5_older");
		task5name.setText("Tommy");
		task5YOB.setText("1880");
		older.setSelected(true);
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "There exists no data for anyone born in year before 1880";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//can't younger
	public void testTask5_7() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		RadioButton younger = (RadioButton)s.lookup("#rbTask5_younger");
		task5name.setText("Tommy");
		task5YOB.setText("2019");
		younger.setSelected(true);
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "There exists no data for anyone born in year after 2019";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//unparseable YOB
	public void testTask5_8() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		task5name.setText("Tommy");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		task5YOB.setText("asdf");
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "Please input a number in the YOB field.";
		assertTrue(s1.equals(result));
	}
	
	@Test
	//weird name, no rank 
	public void testTask5_9() {
		clickOn("#tabApp2");
		TextField task5name = (TextField)s.lookup("#task5Name");
		task5name.setText("123");
		TextField task5YOB = (TextField)s.lookup("#task5YOB");
		task5YOB.setText("1990");
		clickOn("#doTask5");
		String s1 = t.getText();
		String result = "According to the NK-T5 Algorithm of Universal Compatibility, the recommended name of the soulmate is Michael.";
		assertTrue(s1.equals(result));
	}
}
