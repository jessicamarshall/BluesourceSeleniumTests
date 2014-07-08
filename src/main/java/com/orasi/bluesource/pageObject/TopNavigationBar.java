package com.orasi.bluesource.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationBar {
	WebDriver driver;
	
	//All the page elements:
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[text() = 'Admin ']")
	WebElement adminDropLink;
	
	@FindBy(css = "a[href = '/admin/departments']")
	WebElement deptLink;
	
	@FindBy(css = "a[href = '/admin/titles']")
	WebElement titleLink;
	
	//Constructor
	public TopNavigationBar(WebDriver driver){
		this.driver = driver;
	}
	
	//methods
	public void clickAdminLink(){
		adminDropLink.click();
	}
	public void clickDepartmentsLink(){
		deptLink.click();
	}
	public void clickTitlesLink(){
		titleLink.click();
	}
	
	//Verify logout link is displayed
	public boolean isLoggedIn(){
		return logoutLink.isDisplayed();
	}
	
	//Click logout
	public void logout(){
		logoutLink.click();
	}
}
