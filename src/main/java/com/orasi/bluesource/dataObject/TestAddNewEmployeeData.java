package com.orasi.bluesource.dataObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.DataProvider;


public class TestAddNewEmployeeData  {
	
	private String loginUsername;
	private String loginPassword;
    private String username;
	private String firstName;
    private String lastName;
    private String title;
    private String role;
    private String manager;
    private String status;
    private String location;
    private String startDate;
    private String cellPhone;
    private String officePhone;
    private String email;
    private String dept;
    
	//Getters & Setters
	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
    public String getUsername(){
    	return username;
    }
    public void setUsername(String username){
    	this.username = username;
    }
 
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    public String getTitle(){
    	return title;
    }
    public void setTitle(String title){
    	this.title = title;
    }
    public String getRole(){
    	return role;
    }
    public void setRole(String role){
    	this.role = role;
    }
    public String getManager(){
    	return manager;
    }
    public void setManager(String manager){
    	this.manager = manager;
    }
    public String getStatus(){
    	return status;
    }
    public void setStatus(String status){
    	this.status = status;
    }
    public String getLocation(){
    	return location;
    }
    public void setLocation(String location){
    	this.location = location;
    }
    public String getStartDate(){
    	return startDate;
    }
    public void setStartDate(String startDate){
    	this.startDate = startDate;
    }
    public String getCellPhone(){
    	return cellPhone;
    }
    public void setCellPhone(String cellPhone){
    	this.cellPhone = cellPhone;
    }
    public String getOfficePhone(){
    	return officePhone;
    }
    public void setOfficePhone(String officePhone){
    	this.officePhone = officePhone;
    }
    public String getEmail(){
    	return email;
    }
    public void setEmail(String email){
    	this.email = email;
    }
    public String getDept(){
    	return dept;
    }
    public void setDept(String dept){
    	this.dept = dept;
    }
    //methods
    public static int createRandomNum(){
    	Random rand = new Random();
	    int randomNum = rand.nextInt((800) + 1) + 100;
	    return randomNum;    
    }
    
    //data providers
	@DataProvider(name = "addEmpData")
	public static Object[][] createEmployeeData(){
		//to get the current date and format it
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("MM-dd-yyyy");
		  
		//Create & set the data
		TestAddNewEmployeeData testData1 = new TestAddNewEmployeeData();
		
		testData1.setLoginUsername("company.admin");
		testData1.setLoginPassword("test123");
	    testData1.setFirstName("Firstname" + createRandomNum());
	    testData1.setLastName("Lastname" + createRandomNum());
		testData1.setUsername(testData1.getFirstName() + testData1.getLastName());
		testData1.setTitle("Consultant");
		testData1.setRole("Base");
		testData1.setManager("Adam Thomas");
		testData1.setStatus("Permanent");
		testData1.setLocation("Greensboro");
		testData1.setStartDate(ft.format(date));
		testData1.setCellPhone("336-999-1234");
		testData1.setOfficePhone("336-789-7894");
		testData1.setEmail("test" + createRandomNum() + "@test.com");
		testData1.setDept("Services");
		
		return new Object[][]{
				{	testData1
				}
			
		};
	
	}

}
