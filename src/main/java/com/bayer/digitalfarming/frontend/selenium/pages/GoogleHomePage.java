package com.bayer.digitalfarming.frontend.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.bayer.digitalfarming.frontend.selenium.utils.handlers.ActionHandler;
import com.bayer.digitalfarming.frontend.selenium.utils.handlers.ElementHandler;
import com.bayer.digitalfarming.frontend.selenium.utils.handlers.WindowHandler;
import com.bayer.digitalfarming.frontend.selenium.utils.reports.TestNGCustomReporter;
import com.bayer.digitalfarming.frontend.selenium.utils.test.BaseTest;

public class GoogleHomePage extends BaseTest {
	private WebDriver driver;
	private ElementHandler elementHandler;
	private ActionHandler actionHandler;
	private WindowHandler windowHandler;

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		elementHandler = new ElementHandler(driver);
		actionHandler = new ActionHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	public void openGoogleURL() {
		driver.get("http://www.google.com");
		driver.navigate().refresh();
		TestNGCustomReporter.log(logger, "Entered the url");
		TestNGCustomReporter.log(logger, "Digital Farming Login page is displayed as expected");
	}

	public void search(String Text) {
		elementHandler.writeText("com.googleHome.search", Text);
		TestNGCustomReporter.log(logger, "Digital Farming Login page is displayed as expected");
	}
}