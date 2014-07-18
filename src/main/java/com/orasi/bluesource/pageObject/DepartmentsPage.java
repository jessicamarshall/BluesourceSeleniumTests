package com.orasi.bluesource.pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepartmentsPage {
	
	WebDriver driver;
	
	//All the page elements
	@FindBy(linkText = "Add Department")
	WebElement addDeptLink;
	
	@FindBy(xpath = "//h1[text() = 'Departments']")
	WebElement titleHeader;

	@FindBy(css = ".alert-success.alert-dismissable")
	WebElement successMessage;
	
	//constructor
	public DepartmentsPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Methods
	
	//click add dept link
	public void ClickAddDeptLink(){
		addDeptLink.click();
	}
	
	public boolean isTitleHeaderDisplayed(){
		return titleHeader.isDisplayed();
	}
	
	//return if the success message is displayed
	public boolean IsSuccessMsgDisplayed(){
		return successMessage.isDisplayed();
	}
	
	//search page for a dept, return if displayed
	public boolean SearchTableByDept(String dept){
		//Get all the rows in the table by CSS
		List<WebElement> elementList = driver.findElements(By.cssSelector(".list-group-item"));
		for(WebElement element:elementList){
			//if it matches the title, then return true
			if(element.getText().contains(dept)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean DeleteDept(String dept){
		//Get all the rows in the table by CSS
		List<WebElement> elementList = driver.findElements(By.cssSelector(".list-group-item"));
		for(WebElement element:elementList){
			
			//if it matches the title, then click on the trash element
			if(element.getText().equals(dept)){
		
				//click on the trash element
				element.findElement(By.cssSelector("a[data-method = 'delete']")).click();
				
				//accept the alert that pops up
				Alert alert = driver.switchTo().alert();
				alert.accept();
				return true;
			}
		}
		return false;
	}
	
	

}
