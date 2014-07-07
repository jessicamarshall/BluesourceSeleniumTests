package com.orasi.bluesource.pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ListingTitlesPage {
	
	private WebDriver driver;
	
	public ListingTitlesPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void ClickNewTitle(){
		driver.findElement(By.linkText("New Title")).click();
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
