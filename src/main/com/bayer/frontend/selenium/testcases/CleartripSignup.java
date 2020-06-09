package main.com.bayer.frontend.selenium.testcases;

import main.com.bayer.frontend.selenium.pages.GoogleHomePage;
import main.com.bayer.frontend.selenium.utils.handlers.DataHandler;
import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.com.bayer.frontend.selenium.pages.CleartripHomepage;

import main.com.bayer.frontend.selenium.utils.test.BaseTest;


@Listeners(main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager.class)
public class CleartripSignup extends BaseTest {
	@Test(description= "Cleartrip Signup",dataProvider ="CleartripSignup",dataProviderClass= DataHandler.class)
	public void signUp(String email) throws InterruptedException{
		CleartripHomepage Homepage = new CleartripHomepage(driver);
		Homepage.openCleartripUrl();
		Homepage.Profile();
		Homepage.Register();
		Thread.sleep(1000);
		Homepage.Frameswitch();
		Homepage.SignupUser(email);
		
	}
}
