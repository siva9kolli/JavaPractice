package com.MyCompany.SeleniumAutomationTestingDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.testng.annotations.Test;

public class NewCSV {
	
	@Test
	public void test() throws IOException {
		writeToCSV("test");
	}
	
	 public void writeToCSV(String fileName) throws IOException{
		 FileWriter pw = null;
	        try {
	        	 pw = new FileWriter(fileName+".csv",true); 

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        StringBuilder builder = new StringBuilder();
	        String columnNamesList = "Id,Name";
	        builder.append(columnNamesList +"\n");
	        //pw.write(builder.toString());
	        append(pw, "Appium", "Mobile");
	    }
	 
	 public void append(FileWriter pw, String d1, String d2) throws IOException {
		  StringBuilder builder = new StringBuilder();
	        builder.append(d1+",");
	        builder.append(d2);
	        builder.append('\n');
	        pw.write(builder.toString());
	        pw.close();
	        System.out.println("done!");
	 }

}
