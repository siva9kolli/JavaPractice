package com.MyCompany.SeleniumAutomationTestingDemo;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class CurrentTimeAndEndTime {
	
	@Test
	public void test() throws InterruptedException {
		long startTime = System.nanoTime();
		System.out.println(startTime);
		Thread.sleep(5000);
		long endTime   = System.nanoTime();
		System.out.println(endTime);
		long totalTime = endTime - startTime;
		System.out.println("nano seconds "+ totalTime);
		
//		long totalTime1 = (endTime - startTime)/1000; 
//		System.out.println(totalTime1);
		
		long seconds = TimeUnit.NANOSECONDS.toSeconds(endTime - startTime); 
		System.out.println("Seconds ------ " + seconds);
	}

}
