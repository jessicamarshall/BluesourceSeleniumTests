package com.orasi.bluesource.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewTitlePage {
	
	WebDriver driver;

	//All the page elements
	@FindBy(id = "title_name")
	WebElement titleField;
	
	@FindBy(name = "commit")
	WebElement createTitleButton;
	
	//Constructor
	public NewTitlePage(WebDriver driver){
		this.driver = driver;
	}	
	
	//method to create a new title
	public void CreateNewTitle(String newTitle){
		titleField.sendKeys(newTitle);
		createTitleButton.click();
	}

}
