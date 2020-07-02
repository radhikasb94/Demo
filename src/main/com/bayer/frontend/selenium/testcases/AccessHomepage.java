package main.com.bayer.frontend.selenium.testcases;

import main.com.bayer.frontend.selenium.pages.HomePage;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager.class)
public class AccessHomepage extends BaseTest {

    @Test(description = "Launch URL")
    public void launchURL() throws InterruptedException {
        HomePage homePage=new HomePage();
        homePage.getURL();
        Thread.sleep(3000);

    }


}
