package com.bayer.digitalfarming.frontend.selenium.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bayer.digitalfarming.frontend.selenium.pages.GoogleHomePage;
import com.bayer.digitalfarming.frontend.selenium.utils.test.BaseTest;
@Listeners(com.bayer.digitalfarming.frontend.selenium.utils.reports.ExtentReportManager.class)
public class AccessGoogle extends BaseTest{
    @Test(description="Search in Google Home Page")
    public void searchGoogle() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.openGoogleURL();
        googleHomePage.search("Bayer Account");
    }
}