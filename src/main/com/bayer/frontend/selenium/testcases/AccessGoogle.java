package main.com.bayer.frontend.selenium.testcases;

import main.com.bayer.frontend.selenium.pages.GoogleHomePage;
import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.com.bayer.frontend.selenium.utils.test.BaseTest;
@Listeners(ExtentReportManager.class)
public class AccessGoogle extends BaseTest{
    @Test(description="Click in Gmail")
    public void clickGmail() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.openGoogleURL();
        googleHomePage.clickGmailLink();
    }
    @Test(description="Search in Google Home Page")
    public void searchGoogle() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.openGoogleURL();
        googleHomePage.search("Bayer Account");
    }
}