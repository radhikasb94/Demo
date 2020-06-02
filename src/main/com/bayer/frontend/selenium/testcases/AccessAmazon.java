package main.com.bayer.frontend.selenium.testcases;

import main.com.bayer.frontend.selenium.pages.AmazonHomePage;
import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.com.bayer.frontend.selenium.utils.test.BaseTest;

@Listeners(ExtentReportManager.class)
public class AccessAmazon extends BaseTest{
	@Test(description="Login on Application")
	public void login(){
		AmazonHomePage amazonHomepage=new AmazonHomePage(driver);
		amazonHomepage.openAmazonURL();
		amazonHomepage.enterUser("sysadmin1");
		amazonHomepage.enterPwd("abcd1234");
		amazonHomepage.clkSubmitButton();
		amazonHomepage.clkHome();
		amazonHomepage.logOut();
	}
}
