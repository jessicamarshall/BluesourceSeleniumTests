package com.orasi.bluesource.test;

import org.openqa.selenium.*;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orasi.bluesource.core.Driver;
import com.orasi.bluesource.pageObject.AddNewEmployeePage;
import com.orasi.bluesource.pageObject.EmployeesPage;
import com.orasi.bluesource.pageObject.LoginPage;
import com.orasi.bluesource.dataObject.TestAddNewEmployeeData;



public class TestAddNewEmployee extends Driver {
	
	  //Add a new employee and verify a success message	
	  @Test(dataProvider = "addEmpData", dataProviderClass = TestAddNewEmployeeData.class)
	  public void testAddEmployee(TestAddNewEmployeeData testData) throws Exception {
		  
		  //Login
		  LoginPage loginPage = new LoginPage(driver);
		  loginPage.login(testData.getLoginUsername(), testData.getLoginPassword());

		  //Verify user is logged in
		  Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		  Reporter.log("User was logged in successfully");
		  
		  //Instantiate the employee page and the add new employees page
		  EmployeesPage employeesPage = new EmployeesPage(driver);
		  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage(driver);
		  
		  //click add
		  employeesPage.clickAddNewEmployee();
		  Reporter.log("Clicked add");
		  
		  //Fill out the new employee details and submit
		  addNewEmployeePage.addEmployee(testData.getUsername(), testData.getFirstName(), testData.getLastName(), testData.getTitle(),
				  						testData.getRole(), testData.getManager(), testData.getStatus(), testData.getLocation(), 
				  						testData.getStartDate(), testData.getCellPhone(), testData.getOfficePhone(), testData.getEmail(),
				  						testData.getDept());
		

		  //verify success message
		  assert driver.findElement(By.cssSelector(".alert-success.alert-dismissable")).getText().contains("Employee added successfully");  
		  Reporter.log("New employee was added successfully");
		  
		  //search for the employee and verify it was found
		  Assert.assertTrue(employeesPage.searchTableByFirstAndLastName(testData.getFirstName(), testData.getLastName() ));
		  Reporter.log("New user was found in list of employees");
		  
		  //logout
		  loginPage.logout();
	  }
  



}
