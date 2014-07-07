package com.orasi.bluesource.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	private WebDriver driver;

	//constructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Methods
	
	  public void login(String username, String password) {
		  //Login
		  //driver.findElement(By.id("employee_username")).sendKeys(testData.getloginUsername());
		  //driver.findElement(By.id("employee_password")).sendKeys(testData.getloginPassword());
		  driver.findElement(By.id("employee_username")).sendKeys(username);
		  driver.findElement(By.id("employee_password")).sendKeys(password);
		  driver.findElement(By.name("commit")).click();  
	  }
}
