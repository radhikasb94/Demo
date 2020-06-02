package main.com.bayer.frontend.selenium.utils.page;

import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;
import main.com.bayer.frontend.selenium.utils.handlers.ElementHandler;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourPage extends BaseTest {

	private WebDriver driver;
	public YourPage(WebDriver webDriver) {
		this.driver=webDriver;
	}

	private void loadMainPageURL() {
		driver.get("https://www.google.co.in/");
		System.out.println("My URL :"+ PropertiesRepository.getString("mainpage.url"));
		//setDriverWait(PropertiesRepository.getString("jblearning.mainpage.url.waitfor"));
	}

	public void functionalityMethod() {
		// Load main page
		loadMainPageURL();
		ElementHandler eleHandler=new ElementHandler(driver);
		eleHandler.findElement(By.xpath(PropertiesRepository.getString("com.mainpage.extertext")),200);
		
	}
}
