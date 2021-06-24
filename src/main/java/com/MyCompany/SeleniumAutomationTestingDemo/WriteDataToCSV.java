package com.MyCompany.SeleniumAutomationTestingDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.testng.annotations.Test;

public class WriteDataToCSV {
	
	
	@Test
	public void writeToCSV() {
	 try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

	      StringBuilder sb = new StringBuilder();
	      sb.append("FolderName");
	      sb.append(',');
	      sb.append("TimeTakenToLoad");
	      sb.append('\n');

	      sb.append("1");
	      sb.append(',');
	      sb.append("Test");
	      sb.append('\n');

	      writer.write(sb.toString());

	      System.out.println("done!");

	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
	    }
	}

}
