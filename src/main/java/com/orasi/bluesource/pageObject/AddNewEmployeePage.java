package com.orasi.bluesource.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class AddNewEmployeePage {

	private WebDriver driver;
	public static StringBuffer verificationErrors = new StringBuffer();
	
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
		  driver.findElement(By.id("employee_username")).sendKeys(username);
		  driver.findElement(By.id("employee_first_name")).sendKeys(firstName);
		  driver.findElement(By.id("employee_last_name")).sendKeys(lastName);
		  select = new Select(driver.findElement(By.id("employee_title_id")));
		  select.selectByVisibleText(title);
		  select = new Select(driver.findElement(By.id("employee_role")));
		  select.selectByVisibleText(role);
		  select = new Select(driver.findElement(By.id("employee_manager_id")));
		  select.selectByVisibleText(manager);
		  select = new Select(driver.findElement(By.id("employee_status")));
		  select.selectByVisibleText(status);
		  select = new Select(driver.findElement(By.id("employee_location")));
		  select.selectByVisibleText(location);
		  driver.findElement(By.id("employee_start_date")).sendKeys(startDate);
		  driver.findElement(By.id("employee_cell_phone")).sendKeys(cellPhone);
		  driver.findElement(By.id("employee_office_phone")).sendKeys(officePhone);
		  driver.findElement(By.id("employee_email")).sendKeys(email);
		  select = new Select(driver.findElement(By.id("employee_department_id")));
		  select.selectByVisibleText(dept);
		  
		  //submit
		  driver.findElement(By.name("commit")).click();
		  }catch (Exception e){
			  verificationErrors.append(e.toString());
			  Reporter.log("Element not found on the add employee frame: " + e);
			  throw(e);
		  }
		  
	  }
}
