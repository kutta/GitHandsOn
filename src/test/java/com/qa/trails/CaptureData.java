package com.qa.trails;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CaptureData {

	WebDriver driver = null;

	final static Logger log = Logger.getLogger(CaptureData.class.getName());

	@BeforeTest
	public void baseSetup() throws Exception {

		try {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void captureSwaggerData() throws Exception{
		try {
			
			driver.get("https://haathi-api-docs.laerdalblr.in/classManagement.html");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//*[@id=\"operations-tag-Classes\"]"));
			
		}catch (Exception e) {
			e.printStackTrace();			
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		try {
			
			driver.quit();
			log.info("Session closed");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
