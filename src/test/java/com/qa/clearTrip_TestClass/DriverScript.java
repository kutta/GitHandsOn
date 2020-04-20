package com.qa.clearTrip_TestClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.clearTrip_PageObject.Base;
import com.qa.clearTrip_PageObject.FlightSearchPage;
import com.qa.clearTrip_PageObject.SearchPageResult;

public class DriverScript extends Base{
	
	FlightSearchPage fsp = new FlightSearchPage();
	SearchPageResult spr = new SearchPageResult();
	
	@BeforeSuite
	public void start() throws Exception{
		
		setup();
	}
	
	@AfterSuite
	public void close() throws Exception{
		
		closeBrowser();
	}
	
	@Test
	public void roundTripFlightSearch() throws Exception{
		
		
		
		fsp.searchRoundTripFlight("Bangalore, IN - Kempegowda International Airport (BLR)", "Chennai, IN - Chennai Airport (MAA)");
		
		spr.searchFlighResult();
	}

}
