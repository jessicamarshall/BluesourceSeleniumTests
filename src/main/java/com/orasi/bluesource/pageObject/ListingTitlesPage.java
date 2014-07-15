package com.orasi.bluesource.pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ListingTitlesPage {
	
	WebDriver driver;
	
	//All the page elements
	@FindBy(linkText = "New Title")
	WebElement newTitleLink;
	
	@FindBy(xpath = "//h1[text() = 'Listing titles']")
	WebElement titleHeader;

	@FindBy(css = ".alert-success.alert-dismissable")
	WebElement successMessage;
	
	//constructor
	public ListingTitlesPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Methods
	public void ClickNewTitle(){
		newTitleLink.click();
	}
	
	public boolean isTitleHeaderDisplayed(){
		return titleHeader.isDisplayed();
	}
	
	public boolean isSuccessMsgDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success.alert-dismissable")));
		return successMessage.isDisplayed();
	}
	
	public boolean SearchTableByTitle(String title){
		
		//Get all the rows in the table by CSS
		List<WebElement> elementList = driver.findElements(By.cssSelector("td"));
		for(WebElement element:elementList){
			//if it matches the title, then return true
			if(element.getText().equals(title)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean DeleteTitle(String title){
		//Get all the rows in the table by CSS
		List<WebElement> elementList = driver.findElements(By.cssSelector("td"));
		for(WebElement element:elementList){
			
			//if it matches the title, then click on the trash element
			if(element.getText().equals(title)){
		
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
