package com.orasi.bluesource.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class AddNewEmployeePage {

	WebDriver driver;
	public static StringBuffer verificationErrors = new StringBuffer();
	
	//All the page elements:
	@FindBy(id = "employee_username")
	WebElement usernameField;
	
	@FindBy(id = "employee_first_name")
	WebElement firstnameField;
	
	@FindBy(id = "employee_last_name")
	WebElement lastnameField;
	
	@FindBy(id = "employee_title_id")
	WebElement titleSelect;
	
	@FindBy(id = "employee_role")
	WebElement roleSelect;
	
	@FindBy(id = "employee_manager_id")
	WebElement managerSelect;
	
	@FindBy(id = "employee_status")
	WebElement statusSelect;
	
	@FindBy(id = "employee_location")
	WebElement locationSelect;
	
	@FindBy(id = "employee_start_date")
	WebElement startdateField;
	
	@FindBy(id = "employee_cell_phone")
	WebElement cellphoneField;
	
	@FindBy(id = "employee_office_phone")
	WebElement officephoneField;
	
	@FindBy(id = "employee_email")
	WebElement emailField;
	
	@FindBy(id = "employee_department_id")
	WebElement deptSelect;
	
	@FindBy(name = "commit")
	WebElement createEmpButton;

	//Constructor
	public AddNewEmployeePage(WebDriver driver){
		this.driver = driver;
	}
	

	//adds a new employee on the new employee page
	public void addEmployee(String username, String firstName, String lastName, String title, String role, String manager,
							String status, String location, String startDate, String cellPhone, String officePhone, 
							String email, String dept) throws Exception {
		  

		  //variables	
		  WebDriverWait wait = new WebDriverWait(driver, 60);
		  Select select;

		  //wait until page loads
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("employee_username")));

		  //Fill in the details
		  try {
			  usernameField.sendKeys(username);
			  firstnameField.sendKeys(firstName);
			  lastnameField.sendKeys(lastName);
			  select = new Select(titleSelect);
			  select.selectByVisibleText(title);
			  select = new Select(roleSelect);
			  select.selectByVisibleText(role);
			  select = new Select(managerSelect);
			  select.selectByVisibleText(manager);
			  select = new Select(statusSelect);
			  select.selectByVisibleText(status);
			  select = new Select(locationSelect);
			  select.selectByVisibleText(location);
			  startdateField.sendKeys(startDate);
			  cellphoneField.sendKeys(cellPhone);
			  officephoneField.sendKeys(officePhone);
			  emailField.sendKeys(email);
			  select = new Select(deptSelect);
			  select.selectByVisibleText(dept);
		  
			  //submit
			  createEmpButton.click();
			  
		  }catch (Exception e){
			  verificationErrors.append(e.toString());
			  Reporter.log("Element not found on the add employee frame: " + e);
			  throw(e);
		  }
		  
	  }
}
