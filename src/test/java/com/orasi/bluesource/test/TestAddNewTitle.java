package com.orasi.bluesource.test;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orasi.bluesource.core.Driver;
import com.orasi.bluesource.pageObject.ListingTitlesPage;
import com.orasi.bluesource.pageObject.LoginPage;
import com.orasi.bluesource.pageObject.NewTitlePage;
import com.orasi.bluesource.pageObject.TopNavigationBar;
import com.orasi.bluesource.dataObject.TestAddNewTitleData;
public class TestAddNewTitle extends Driver{
	

	//Create a new title
	@Test(dataProvider = "createNewTitleData", dataProviderClass = TestAddNewTitleData.class)
	public void testCreateNewTitle(TestAddNewTitleData testData){
		
		//Login to the application
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(testData.getloginUsername(), testData.getloginPassword());
	  
		//Verify user is logged in
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Reporter.log("User was logged in successfully<br>");
		
		//Instantiate the top navigation bar and navigate to the title page
		TopNavigationBar topNavigationBar = new TopNavigationBar(driver);
		topNavigationBar.clickAdminLink();
		topNavigationBar.clickTitlesLink();
		
		//Verify navigated to the title page
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text() = 'Listing titles']")).isDisplayed());
		Reporter.log("Navigated to the listing titles page<br>");

		//Instantiate the title page and click new title
		ListingTitlesPage listingTitlesPage = new ListingTitlesPage(driver);
		listingTitlesPage.ClickNewTitle();
		
		//Instantiate the New titles page and create a new title
		Reporter.log("Navigated to the new title page<br>");
		NewTitlePage newTitlePage = new NewTitlePage(driver);
		newTitlePage.CreateNewTitle(testData.getNewTitle());
		
		//Verify the title was created
		Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success.alert-dismissable")).isDisplayed());
		Reporter.log("New Title was created: " + testData.getNewTitle());
		
		//Verify the title is displayed on the title page
		Assert.assertTrue(listingTitlesPage.SearchTableByTitle(testData.getNewTitle()));
		Reporter.log("New title was found in table of titles<br>");
		
		//Delete the new title
		listingTitlesPage.DeleteTitle(testData.getNewTitle());
		
		//Verify the title is deleted
		Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success.alert-dismissable")).isDisplayed());
		Reporter.log("New title was deleted successfully<br>");
		
		//logout
		topNavigationBar.logout();
		
	}
	


}
