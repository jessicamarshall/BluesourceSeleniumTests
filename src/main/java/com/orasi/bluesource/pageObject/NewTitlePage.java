package com.orasi.bluesource.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewTitlePage {
	
	private WebDriver driver;
	public static StringBuffer verificationErrors = new StringBuffer();
	
	public NewTitlePage(WebDriver driver){
		this.driver = driver;
	}	
	
	//method to create a new title
	public void CreateNewTitle(String newTitle){
		driver.findElement(By.id("title_name")).sendKeys(newTitle);
		driver.findElement(By.name("commit")).click();
	}

}
