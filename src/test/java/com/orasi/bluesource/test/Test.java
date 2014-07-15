package com.orasi.bluesource.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver;
		URL seleniumRemoteFirefox = new URL("http", "10.238.242.73", 5555, "/wd/hub");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setJavascriptEnabled(true);
		driver = new RemoteWebDriver(seleniumRemoteFirefox, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("http://bluesourcestaging.herokuapp.com/login");

	}

}
