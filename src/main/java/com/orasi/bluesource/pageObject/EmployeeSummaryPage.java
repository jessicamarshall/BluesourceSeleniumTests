package com.orasi.bluesource.pageObject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EmployeeSummaryPage {
	WebDriver driver;
	
	//All the page elements
	@FindBy(xpath = "//*[@id='accordion']/div/div[6]/div[1]/a[2]")
	WebElement manageTimeOffButton;
	
	@FindBy(linkText = "View")
	WebElement viewTimeOffButton;
	
	//Constructor
	public EmployeeSummaryPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Methods:
	public void ClickManageTimeOff(){
		manageTimeOffButton.click();
	}
	
	public void ViewManageTimeOff(){
		viewTimeOffButton.click();
	}
	
	
}
