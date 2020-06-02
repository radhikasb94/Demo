package main.com.bayer.frontend.selenium.utils.test;

import java.util.concurrent.TimeUnit;

import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;
import main.com.bayer.frontend.selenium.utils.driverfactory.DriverFactory;
import main.com.bayer.frontend.selenium.utils.reports.ExtentReportManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ExtentReportManager.class)
public class BaseTest {
	protected static WebDriver driver = null;
	protected static Logger logger = LogManager.getLogger(BaseTest.class);

	static {
		try {
			PropertiesRepository.loadAllProperties();
		} catch (Exception e) {
			logger.error("Unable to load properties files", e);
		}
	}

	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getInstance().getDriver();
		ExtentReportManager.setDriver(driver);
		manageDriver(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		DriverFactory.getInstance().removeDriver();
	}

	private void manageDriver(WebDriver webDriver) {
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().implicitlyWait(PropertiesRepository.getInt("global.implicit.wait"),
				TimeUnit.SECONDS);
	}
}
