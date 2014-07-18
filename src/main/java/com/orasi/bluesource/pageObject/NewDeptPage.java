package com.orasi.bluesource.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewDeptPage {

	WebDriver driver;

	//All the page elements
	@FindBy(id = "department_name")
	WebElement deptField;
	
	@FindBy(id = "department_department_id")
	WebElement parentDeptField;
	
	@FindBy(name = "commit")
	WebElement createDeptButton;
	
	//Constructor
	public NewDeptPage(WebDriver driver){
		this.driver = driver;
	}	
	
	//method to create a new title
	public void CreateNewDept(String dept){
		deptField.sendKeys(dept);
		createDeptButton.click();
	}
}
