package com.orasi.bluesource.pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOffDetailsPage {
	
	WebDriver driver;
	Select select;
	
	//All the page elements
	@FindBy(id = "new_vacation_date_requested")
	WebElement dateRequestedField;
	
	@FindBy(id = "new_vacation_start_date")
	WebElement startDateField;
	
	@FindBy(id = "new_vacation_end_date")
	WebElement endDateField;
	
	@FindBy(className = "business-days")
	WebElement totalDaysLabel;
	
	@FindBy(id = "new_vacation_vacation_type")
	WebElement vacationTypeSelect;
	
	@FindBy(id = "new_vacation_half_day")
	WebElement halfDayButton;
	
	//@FindBy(name = "commit")
	//WebElement saveButton;
	
	@FindBy(css = "input[value = 'Save Time Off']")
	WebElement saveButton;
	
	@FindBy(css = ".alert-success.alert-dismissable")
	WebElement successMessage;
	
	@FindBy(name = "new[vacation][reason]")
	WebElement reasonField;
	
	//Constructor
	public TimeOffDetailsPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Methods
	public boolean isSuccessMsgDisplayed(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success.alert-dismissable")));
		return successMessage.isDisplayed();
	}
	
	public String getSuccessMsgText(){
		return successMessage.getText();
	}
	
	public void hoverOverElement(WebElement element){
		Actions builder = new Actions(driver);
		Actions hoverOverRegistrar = builder.moveToElement(element);
		hoverOverRegistrar.perform();
	}
	
	//Enter time off
	public void enterTimeOff(String dateRequested, String startDate, String endDate, String vacationType,
								String otherReason, String halfDay ) {
		//Enter the data
		dateRequestedField.sendKeys(dateRequested);
		startDateField.sendKeys(startDate);
		endDateField.sendKeys(endDate);
		select = new Select(vacationTypeSelect);
		select.selectByVisibleText(vacationType);
		
		//If the vacation type is 'Other', then need to fill out the reason field
		if (vacationType.equalsIgnoreCase("Other")) {
			//first you must hover over the vacation type field after selecting other
			hoverOverElement(vacationTypeSelect);
			reasonField.sendKeys(otherReason);
		}

		//If its a half day
		if (halfDay.equalsIgnoreCase("TRUE")){
			halfDayButton.click();
		}
		

		saveButton.click();

	}
	
	//Delete a specific time off entry
	public void DeleteTimeOff(String startDate, String endDate){
		
	}
	
	//Clean up - delete all the time off requests
	public void DeleteAllTimeOff(){
		
		List<WebElement> deleteIconsList = driver.findElements(By.cssSelector("a[data-method = 'delete']"));
		if (deleteIconsList.size() > 0){
			for(WebElement element:deleteIconsList){
				element.click();
				
				//accept the alert that pops up
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		}

	}
	
}
