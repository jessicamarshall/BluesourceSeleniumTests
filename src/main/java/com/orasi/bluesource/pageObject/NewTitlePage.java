package com.orasi.bluesource.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orasi.bluesource.interfaces.Button;
import com.orasi.bluesource.interfaces.Listbox;
import com.orasi.bluesource.interfaces.Textbox;
import com.orasi.bluesource.interfaces.impl.internal.ElementFactory;

public class NewTitlePage {
	
	private static WebDriver driver;

	//All the page elements
	@FindBy(id = "title_name")
	private static Textbox txtTitle;
	
	@FindBy(name = "commit")
	private Button btnCreateTitle;
	

	//Constructor
	public NewTitlePage(WebDriver driver){
		NewTitlePage.driver = driver;
		ElementFactory.initElements(driver, this); 
	}
	
	private static void newTitlePageLoaded(){
		  while (txtTitle==null){
		      initialize(driver);
		     }
	}
	
	private static NewTitlePage initialize(WebDriver driver) {
	     return ElementFactory.initElements(driver, NewTitlePage.class);         
	 }
	
	//method to create a new title
	public void CreateNewTitle(String newTitle){
		txtTitle.safeSet(newTitle);
		btnCreateTitle.click();
	}

}
