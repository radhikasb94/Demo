package main.com.bayer.frontend.selenium.testcases;

import main.com.bayer.frontend.selenium.pages.GoogleHomePage;
import main.com.bayer.frontend.selenium.utils.handlers.DataHandler;
import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.com.bayer.frontend.selenium.pages.CleartripHomepage;

import main.com.bayer.frontend.selenium.utils.test.BaseTest;


@Listeners(main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager.class)
public class CleartripOnewayTrip extends BaseTest{
	@Test(description= "one way flight search",dataProvider= "Cleartrip",dataProviderClass=DataHandler.class)
	public void Oneway(String From , String To) throws InterruptedException{
		CleartripHomepage Homepage = new CleartripHomepage(driver);
		Homepage.openCleartripUrl();
		Thread.sleep(5000);
		Homepage.Notification();
		Homepage.clickOneway();
		Thread.sleep(2000);
	    Homepage.Alert();
		Homepage.FromTag(From);
	    Homepage.ToTag(To);
	    Homepage.clickTodayDate();  
	    Homepage.noOfAdults(1);
	    Homepage.SearchFlight();
	    Thread.sleep(5000);
	}
}
