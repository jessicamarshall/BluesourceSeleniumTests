package com.orasi.bluesource.dataObject;

import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class TestAddNewTitleData {

	private String loginUsername;
	private String loginPassword;
	private String newTitle;
	
    public String getloginUsername(){
    	return loginUsername;
    }
    public void setloginUsername(String loginUsername){
    	this.loginUsername = loginUsername;
    }
    public String getloginPassword(){
    	return loginPassword;
    } 
    public void setloginPassword(String loginPassword){
    	this.loginPassword = loginPassword;
    }
    public String getNewTitle(){
    	return newTitle;
    } 
    public void setNewTitle(String newTitle){
    	this.newTitle = newTitle;
    }
    
    public static int createRandomNum(){
    	Random rand = new Random();
	    int randomNum = rand.nextInt((800) + 1) + 100;
	    return randomNum;
	    
    }

    
    @DataProvider(name = "createNewTitleData")
    public static Object [][] createNewTitleData(){
		//Create & set the data
    	TestAddNewTitleData titleData = new TestAddNewTitleData();
    	titleData.setloginUsername("company.admin");
    	titleData.setloginPassword("test123");
    	titleData.setNewTitle("NewTitle" + createRandomNum());
    	return new Object[][]{
				{	titleData
				}
    	};
    }

}
