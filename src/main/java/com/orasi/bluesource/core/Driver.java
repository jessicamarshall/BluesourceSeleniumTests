package com.orasi.bluesource.core;

import java.io.File;

import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class Driver {
	

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


  @AfterTest
  public void cleanUp() {
	  driver.close();
	  driver.quit();
	  
  }

}

