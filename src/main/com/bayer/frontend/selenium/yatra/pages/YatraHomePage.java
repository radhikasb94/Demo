package main.com.bayer.frontend.selenium.yatra.pages;

import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;
import main.com.bayer.frontend.selenium.utils.handlers.ActionHandler;
import main.com.bayer.frontend.selenium.utils.handlers.ElementHandler;
import main.com.bayer.frontend.selenium.utils.handlers.PopUpHandler;
import main.com.bayer.frontend.selenium.utils.handlers.WindowHandler;
import main.com.bayer.frontend.selenium.utils.reports.TestNGCustomReporter;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YatraHomePage extends BaseTest {
    private WebDriver driver;
    private ElementHandler elementHandler;
    private ActionHandler actionHandler;
    private WindowHandler windowHandler;
    private PopUpHandler popUpHandler;

    public YatraHomePage(WebDriver driver){
        this.driver=driver;
        elementHandler=new ElementHandler(driver);
        actionHandler=new ActionHandler(driver);
        windowHandler=new WindowHandler(driver);
        popUpHandler=new PopUpHandler(driver);
    }
    public void launchYartaUrl(){
         driver.get(PropertiesRepository.getString("yatra.url"));
        if(elementHandler.isElementPresent("yatra.logo")){
            TestNGCustomReporter.log(logger,"URL Launched sucessfully");
        }
        else{
            TestNGCustomReporter.log(logger,"Not able to Loanch URL");
        }
        
    }
    public void oneWaytrip(){
        elementHandler.clickElement("yatra.oneway");
        TestNGCustomReporter.log(logger,"one Way Trip has been Selected");
    }
    public void departFrom(String text){
        elementHandler.clickWebElement("yatra.departfrom");
        elementHandler.writeText("yatra.departfrom",text);
        actionHandler.keyboardAction(Keys.ENTER);
        TestNGCustomReporter.log(logger,"Depart from Enterted");
    }
    public void goingTo(String text){
        elementHandler.clickWebElement("yatra.goingto");
        elementHandler.writeText("yatra.goingto",text);
        actionHandler.keyboardAction(Keys.ENTER);
        TestNGCustomReporter.log(logger,"Going to entered");
    }
}
