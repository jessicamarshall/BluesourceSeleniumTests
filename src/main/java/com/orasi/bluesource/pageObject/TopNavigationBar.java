package com.orasi.bluesource.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNavigationBar {
	WebDriver driver;
	
	public TopNavigationBar(WebDriver driver){
		this.driver = driver;
	}
	
	//methods
	public void clickAdminLink(){
		driver.findElement(By.xpath("//a[text() = 'Admin ']")).click();
	}
	public void clickDepartmentsLink(){
		driver.findElement(By.cssSelector("a[href = '/admin/departments']")).click();		
	}
	public void clickTitlesLink(){
		driver.findElement(By.cssSelector("a[href = '/admin/titles']")).click();
	}

}
