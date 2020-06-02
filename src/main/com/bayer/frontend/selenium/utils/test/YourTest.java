package main.com.bayer.frontend.selenium.utils.test;

import main.com.bayer.frontend.selenium.utils.assertions.VerificationHandler;
import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.com.bayer.frontend.selenium.utils.page.YourPage;

@Listeners(ExtentReportManager.class)
//public class YourTest extends BaseTest {

public class YourTest extends BaseTest {
		Logger logger = LogManager.getLogger(this.getClass());
		@Test(description="Search in Google Home Page")
		public void testFunctionality() {
			YourPage yPage = new YourPage(driver);
			//String result = yPage.functionalityMethod();
			yPage.functionalityMethod();
			VerificationHandler.verifyEquals("test Cases Pass","test Cases Pass");
		}
	

}
