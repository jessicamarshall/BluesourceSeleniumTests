package com.orasi.bluesource.dataObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class TestEnterTimeOffDetailsData {
	
	private String dateRequested;
	private String startDate;
	private String endDate;
	private String vacationType;
	private String halfDay;


	//Getters & setters
	public String getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}
	public String isHalfDay() {
		return halfDay;
	}

	public void setHalfDay(String halfDay) {
		this.halfDay = halfDay;
	}



	//Get data from a csv file - first row is a header
    @DataProvider(name = "createTimeOffData")
    public static Object [][] createTimeOffData() throws Exception{
    	
		//to get the current date and format it
		Calendar startDate = Calendar.getInstance();    
		Calendar endDate = Calendar.getInstance(); 
		Calendar requestedDate = Calendar.getInstance(); 
		SimpleDateFormat ft = new SimpleDateFormat ("MM-dd-yyyy");
		
		//open the CSV file
		CSVReader csvReader;
		String path = "C:\\Maven\\BluesourceSeleniumTests\\src\\resources\\TestAddNewTitle.csv";
		try {
			csvReader = new CSVReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			
			Reporter.log("CSV file was not found in path: " + path + "<br>");
			throw (e);
		}
		
		//get the contents into a list
		List<String[]>dataList = csvReader.readAll();
		
		//create a data object for the data provider the size of the contents of the csv file minus the heading
		Object[][] data = new Object[dataList.size()-1][1];
		
		//create a list to hold all the data objects
		List<TestEnterTimeOffDetailsData> timeOffList = new ArrayList<TestEnterTimeOffDetailsData>();
		
		//set each row of data into the test data object which is held in the employee list
		for(String[] strArray:dataList) {
			

			TestEnterTimeOffDetailsData testData = new TestEnterTimeOffDetailsData();
			
			//for the requested date, if its marked skipped, use todays date
			if (strArray[0].equalsIgnoreCase("<SKIP>")) {
				requestedDate.setTime(new Date());
				testData.setDateRequested(ft.format(requestedDate));
			}
			else {
				testData.setDateRequested(strArray[0]);
			}
				
			
			//for the start date, if its marked skipped, pick today 
			if (strArray[1].equalsIgnoreCase("<SKIP>")) {
				startDate.setTime(new Date());
				testData.setStartDate(ft.format(startDate));
			}
			else {
				testData.setStartDate(strArray[1]);
			}
			
			//for the end date, if its marked skipped, pick today + 1 unless its a weekend
			if (strArray[2].equalsIgnoreCase("<SKIP>")) {
				endDate.setTime(new Date());
				if (endDate.get(Calendar.DAY_OF_WEEK) == 7 || endDate.get(Calendar.DAY_OF_WEEK) == 1){
					endDate.add(Calendar.DATE, 2);
				}
				testData.setEndDate(ft.format(startDate));
			}
			else {
				testData.setEndDate(strArray[2]);
			}
			
			//vacation type
			testData.setVacationType(strArray[3]);
			
			//half day (true or false)
			testData.setHalfDay(strArray[4]);
			

		}
		
		//add the employee list to the data object to be returned from the data provider
		//since the first row is a header, start at the second row
		for(int i=1; i<timeOffList.size(); i++){
			for(int j=0; j<data[i-1].length; j++){
				data[i-1][j]=timeOffList.get(i);
			}
		}


		csvReader.close();
		return data;
    }
}
