package com.orasi.bluesource.test;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orasi.bluesource.core.BaseTest;
import com.orasi.bluesource.dataObject.TestAddNewTitleData;
import com.orasi.bluesource.pageObject.LoginPage;
import com.orasi.bluesource.pageObject.TopNavigationBar;

public class TestEnterTimeOffDetails extends BaseTest {
	
	
	@Test(dataProvider = "createNewTitleData", dataProviderClass = TestAddNewTitleData.class)
	public void testCreateNewTitle(TestAddNewTitleData testData){
		  //Login
		  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		  loginPage.login(testData.getLoginUsername(), testData.getLoginPassword());

		  //Verify user is logged in
		  TopNavigationBar topNavigationBar = PageFactory.initElements(driver, TopNavigationBar.class);
		  Assert.assertTrue(topNavigationBar.isLoggedIn());
		  Reporter.log("User was logged in successfully");	
	
	}
}
