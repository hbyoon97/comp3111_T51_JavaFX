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
	//No input
	public void testTask1_1() {
		clickOn("#tabReport1");
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "N cannot be empty";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//Input N only
	public void testTask1_2() {
		clickOn("#tabReport1");
		TextField task1_N = (TextField)s.lookup("#textfieldtopN");
		task1_N.setText("10");
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "year cannot be empty";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//Input N with y1 only
	public void testTask1_3() {
		clickOn("#tabReport1");
		TextField task1_N = (TextField)s.lookup("#textfieldtopN");
		TextField task1_y1 = (TextField)s.lookup("#textfieldy1");
		task1_N.setText("10");
		task1_y1.setText("1880");
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "year cannot be empty";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//All inputs filled(invalid N)
	public void testTask1_4() {
		clickOn("#tabReport1");
		TextField task1_N = (TextField)s.lookup("#textfieldtopN");
		TextField task1_y1 = (TextField)s.lookup("#textfieldy1");
		TextField task1_y2 = (TextField)s.lookup("#textfieldy2");
		task1_N.setText("0");
		task1_y1.setText("1880");
		task1_y2.setText("1900");
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "Please input a number that is greater than or equal to 1 for the value N\n";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//All inputs filled(invalid period 1)
	public void testTask1_5() {
		clickOn("#tabReport1");
		TextField task1_N = (TextField)s.lookup("#textfieldtopN");
		TextField task1_y1 = (TextField)s.lookup("#textfieldy1");
		TextField task1_y2 = (TextField)s.lookup("#textfieldy2");
		task1_N.setText("10");
		task1_y1.setText("1700");
		task1_y2.setText("2020");
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "The period of interest must be between 1880 and 2019\n";
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//All inputs filled(invalid period 2)
		public void testTask1_6() {
			clickOn("#tabReport1");
			TextField task1_N = (TextField)s.lookup("#textfieldtopN");
			TextField task1_y1 = (TextField)s.lookup("#textfieldy1");
			TextField task1_y2 = (TextField)s.lookup("#textfieldy2");
			task1_N.setText("10");
			task1_y1.setText("1900");
			task1_y2.setText("1880");
			clickOn("#doTask1");
			String s1 = t.getText();
			String s2 = "Incorrect period\n";
			assertTrue(s1.equals(s2));
	}
	
	@Test
	//Valid inputs(Male)
	public void testTask1_7() {
		clickOn("#tabReport1");
		TextField task1_N = (TextField)s.lookup("#textfieldtopN");
		TextField task1_y1 = (TextField)s.lookup("#textfieldy1");
		TextField task1_y2 = (TextField)s.lookup("#textfieldy2");
		task1_N.setText("3");
		task1_y1.setText("1880");
		task1_y2.setText("1883");
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "Year\t";
		for (int k = 1; k <= 3; k++)
			s2 += String.format("Top%d\t\t", k);
		s2 += String.format("\n");

		for (int i = 1880; i <= 1883; i++) {
			s2 += String.format("%d\t", i);
			for (int j = 1; j <= 3; j++) {
				String name = AnalyzeNames.getName(i, j, "M");
				if (name.length() > 7)
					s2 += String.format("%s\t", name);
				else
					s2 += String.format("%s\t\t", name);
			}
			s2 += String.format("\n");
		}

		s2 += String.format(
				"\nOver the period 1880 to 1883, John for Male has hold the top spot \nmost often for a total of 4 times.");
		assertTrue(s1.equals(s2));
	}
	
	@Test
	//Valid inputs(Female)
	public void testTask1_8() {
		clickOn("#tabReport1");
		TextField task1_N = (TextField)s.lookup("#textfieldtopN");
		TextField task1_y1 = (TextField)s.lookup("#textfieldy1");
		TextField task1_y2 = (TextField)s.lookup("#textfieldy2");
		task1_N.setText("3");
		task1_y1.setText("1880");
		task1_y2.setText("1883");
		RadioButton task1_female = (RadioButton)s.lookup("#female");
		task1_female.setSelected(true);
		clickOn("#doTask1");
		String s1 = t.getText();
		String s2 = "Year\t";
		for (int k = 1; k <= 3; k++)
			s2 += String.format("Top%d\t\t", k);
		s2 += String.format("\n");

		for (int i = 1880; i <= 1883; i++) {
			s2 += String.format("%d\t", i);
			for (int j = 1; j <= 3; j++) {
				String name = AnalyzeNames.getName(i, j, "F");
				if (name.length() > 7)
					s2 += String.format("%s\t", name);
				else
					s2 += String.format("%s\t\t", name);
			}
			s2 += String.format("\n");
		}

		s2 += String.format(
				"\nOver the period 1880 to 1883, Mary for Female has hold the top spot \nmost often for a total of 4 times.");
		assertTrue(s1.equals(s2));
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
	
	@Test
	//No Name for either Dad or Mom
	public void testTask4_1() {
		clickOn("#tabApp1");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = "Name field cannot be blank";
		assertTrue(s1.equals(s2));
		
	}
	
	@Test
	//No YOB for Dad
	public void testTask4_2() {
		clickOn("#tabApp1");
		TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
		TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
		TextField task4_dadYOB = (TextField)s.lookup("#textfieldDadYOB");
		task4_dadname.setText("Gary");
		task4_momname.setText("Mary");
		task4_dadYOB.setText("1900");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = "Year of birth cannot be blank";
		assertTrue(s1.equals(s2));
		
	}
	
	@Test
	//No YOB for Mom
	public void testTask4_3() {
		clickOn("#tabApp1");
		TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
		TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
		TextField task4_momYOB = (TextField)s.lookup("#textfieldMomYOB");
		task4_dadname.setText("Gary");
		task4_momname.setText("Mary");
		task4_momYOB.setText("1905");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = "Year of birth cannot be blank";
		assertTrue(s1.equals(s2));
		
	}
	
	@Test
	//Invalid YOB
	public void testTask4_4() {
		clickOn("#tabApp1");
		TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
		TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
		TextField task4_dadYOB = (TextField)s.lookup("#textfieldDadYOB");
		TextField task4_momYOB = (TextField)s.lookup("#textfieldMomYOB");
		task4_dadname.setText("Gary");
		task4_momname.setText("Mary");
		task4_dadYOB.setText("1879");
		task4_momYOB.setText("1905");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = "Year of birth must be between 1880 and 2019";
		assertTrue(s1.equals(s2));
		
	}
	
	@Test
	//Invalid VinYear
	public void testTask4_5() {
		clickOn("#tabApp1");
		TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
		TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
		TextField task4_dadYOB = (TextField)s.lookup("#textfieldDadYOB");
		TextField task4_momYOB = (TextField)s.lookup("#textfieldMomYOB");
		TextField task4_VinYear = (TextField)s.lookup("#textfieldVinYear");
		task4_dadname.setText("Gary");
		task4_momname.setText("Mary");
		task4_dadYOB.setText("1900");
		task4_momYOB.setText("1905");
		task4_VinYear.setText("1879");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = "Vintage year must be between 1880 and 2019";
		assertTrue(s1.equals(s2));
		
	}
	
	@Test
	//Special case 1
	public void testTask4_6() {
		clickOn("#tabApp1");
		TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
		TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
		TextField task4_dadYOB = (TextField)s.lookup("#textfieldDadYOB");
		TextField task4_momYOB = (TextField)s.lookup("#textfieldMomYOB");
		task4_dadname.setText("XXX");
		task4_momname.setText("Mary");
		task4_dadYOB.setText("1995");
		task4_momYOB.setText("1999");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = String.format("Recommended name for baby boy: Liam\nRecommended name for baby girl: Aubrey\n");
		assertTrue(s1.equals(s2));
		
	}
	
	@Test
	//Special case 2
	public void testTask4_7() {
		clickOn("#tabApp1");
		TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
		TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
		TextField task4_dadYOB = (TextField)s.lookup("#textfieldDadYOB");
		TextField task4_momYOB = (TextField)s.lookup("#textfieldMomYOB");
		TextField task4_VinYear = (TextField)s.lookup("#textfieldVinYear");
		task4_dadname.setText("Gary");
		task4_momname.setText("YYY");
		task4_dadYOB.setText("1900");
		task4_momYOB.setText("1905");
		task4_VinYear.setText("1999");
		clickOn("#doTask4");
		String s1 = t.getText();
		String s2 = String.format("Recommended name for baby boy: Syed\nRecommended name for baby girl: Emily\n");
		assertTrue(s1.equals(s2));
	}
		
		@Test
		//Normal case
		public void testTask4_8() {
			clickOn("#tabApp1");
			TextField task4_dadname = (TextField)s.lookup("#textfieldDadName");
			TextField task4_momname = (TextField)s.lookup("#textfieldMomName");
			TextField task4_dadYOB = (TextField)s.lookup("#textfieldDadYOB");
			TextField task4_momYOB = (TextField)s.lookup("#textfieldMomYOB");
			TextField task4_VinYear = (TextField)s.lookup("#textfieldVinYear");
			task4_dadname.setText("Gary");
			task4_momname.setText("Mary");
			task4_dadYOB.setText("1900");
			task4_momYOB.setText("1905");
			task4_VinYear.setText("1999");
			clickOn("#doTask4");
			String s1 = t.getText();
			String s2 = String.format("Recommended name for baby boy: Syed\nRecommended name for baby girl: Emily\n");
			assertTrue(s1.equals(s2));
		
	}
	
}
