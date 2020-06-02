package main.com.bayer.frontend.selenium.pages;

import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;
import main.com.bayer.frontend.selenium.utils.handlers.ActionHandler;
import main.com.bayer.frontend.selenium.utils.handlers.ElementHandler;
import main.com.bayer.frontend.selenium.utils.handlers.WindowHandler;
import main.com.bayer.frontend.selenium.utils.reports.TestNGCustomReporter;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;
import org.openqa.selenium.WebDriver;

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
		driver.get(PropertiesRepository.getString("mainpage.url"));
		TestNGCustomReporter.log(logger, "Entered the url");
		TestNGCustomReporter.log(logger, "Digital Farming Login page is displayed as expected");
	}
	public void clickGmailLink(){
		elementHandler.clickWebElement("mainpage.gmail");
		TestNGCustomReporter.log(logger, "Clicked on Gamil Link Sucessfully ");
	}
	public void search(String text) {
		
		elementHandler.clickWebElement("mainpage.search");
		TestNGCustomReporter.log(logger,"Clicked on Google Search box ");
		elementHandler.writeText("mainpage.search",text);
		TestNGCustomReporter.log(logger, "Contain Has been searched sucessfully ");
		
	}
}