package main.com.bayer.frontend.selenium.pages;

import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;

public class HomePage extends BaseTest {

    public void getURL(){
driver.get(PropertiesRepository.getString("URL"));
    }

}
