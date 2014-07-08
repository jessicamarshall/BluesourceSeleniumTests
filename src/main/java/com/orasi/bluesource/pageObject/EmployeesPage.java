package com.orasi.bluesource.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class EmployeesPage {
	WebDriver driver;
	
	//All the page elements
	@FindBy(css = "button[type = 'submit']")
	WebElement addButton;
	
	@FindBy(css = "input[id = 'search-bar']")
	WebElement searchField;
	
	@FindBy(css = "a.ng-binding")
	WebElement tableCell;
	
	@FindBy(css = ".alert-success.alert-dismissable")
	WebElement successMessage;
	
	//Constructor
	public EmployeesPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Methods
	
	//Click the add button
	public void clickAddNewEmployee(){
		//Click add
		addButton.click();
	}
	
	public boolean isSuccessMsgDisplayed(){
		return successMessage.isDisplayed();
	}
	
	public String getSuccessMsgText(){
		return successMessage.getText();
	}
	
	//search the employee results table by first & last name & click on it
	public boolean searchTableByFirstAndLastName(String firstName, String lastName){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//enter the name to search by
		//driver.findElement(By.cssSelector("input[id = 'search-bar']")).sendKeys(firstName + " " + lastName);
		searchField.sendKeys(firstName + " " + lastName);
		
		//wait for page to load/refresh
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ng-binding")));
		
		//Get all the elements by CSS in the table that are the individual cells
		List<WebElement> elementList = driver.findElements(By.cssSelector("a.ng-binding"));
		for (int i = 0; i < elementList.size(); i++){
			
			//if it's the last element then just stop as it won't match
			if (i == elementList.size() - 1){
				
				break;
			}
			if (elementList.get(i).getText().trim().equals(firstName)){
				Reporter.log("First name was found in table of employees");
				
				//If it matches, then see if the following element matches the last name
				if (elementList.get(i+1).getText().trim().equals(lastName)){
					Reporter.log("Last name was found in table of employees");
					//click on the element 
					elementList.get(i).click();
					
					//return true
					Reporter.log("The employee was found in the table of employees");
					return true;
				}
			}
		}
		
		//element not found that matches first and last name
		Reporter.log("The employee was not found in search results" + firstName + " " + lastName );
		return false;
		
	}

}
