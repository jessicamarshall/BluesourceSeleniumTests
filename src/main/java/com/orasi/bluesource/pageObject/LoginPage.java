package com.orasi.bluesource.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage {
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//all the page elements
	@FindBy(id = "employee_username")
	public WebElement usernameField;
	
	@FindBy(id = "employee_password")
	public WebElement passwordField;
	
	@FindBy(name = "commit")
	public WebElement loginButton;
	
	//Methods
	
	public void login(String username, String password) {
		  usernameField.sendKeys(username);
		  passwordField.sendKeys(password);
		  loginButton.click();
	}
	  

}
