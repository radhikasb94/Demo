package main.com.bayer.frontend.selenium.yatra.testcases;

import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;
import main.com.bayer.frontend.selenium.yatra.pages.YatraHomePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportManager.class)
public class AccessYatra extends BaseTest {
    @Test(description="One way Trip")
    public void oneWayTrip(){
        YatraHomePage yatraHomePage=new YatraHomePage(driver);
        yatraHomePage.launchYartaUrl();
        yatraHomePage.oneWaytrip();
        yatraHomePage.departFrom("Bhopal");
        yatraHomePage.goingTo("Delhi");
    }
}
