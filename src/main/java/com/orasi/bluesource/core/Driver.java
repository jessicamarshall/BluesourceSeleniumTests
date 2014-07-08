package com.orasi.bluesource.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;







public class Driver extends CommonUtils{
	

	public static WebDriver driver;
	public static StringBuffer verificationErrors = new StringBuffer();
	
	  @BeforeTest
	  public void launchBrowser() {
		  
			File file = new File("C:/Selenium/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		
			//launch the browser
			driver.get("http://bluesourcestaging.herokuapp.com/login");
			
		
			//verify browser is opened
			Assert.assertEquals("Login", driver.findElement(By.cssSelector("h1")).getText());
	  }

	  @AfterMethod(alwaysRun=true)
	  public void catchExceptions(ITestResult result){
		  
		  String methodName = result.getName();
		  
		  //take a screenshot if the result is failure
		  if(!result.isSuccess()){
			  TakeScreenshot(methodName, driver);
		  }
		  
//	      Calendar calendar = Calendar.getInstance();
//	      SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//	      String methodName = result.getName();
//	      String failFileName;
//	      if(!result.isSuccess()){
//	          File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	          try {
//	        	  failFileName = "failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png";
//	        	  System.out.println(failFileName);
//	        	  File failFile = new File(failFileName);
//	        	  FileUtils.moveFile(imageFile, failFile);
//	          } catch (IOException e1) {
//	              e1.printStackTrace();
//	          }
//	      }
	  }
	  
	  @AfterTest
	  public void cleanUp() {
		  driver.close();
		  driver.quit();
		  
	  }

}

