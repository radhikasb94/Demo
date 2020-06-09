package main.com.bayer.frontend.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;
import main.com.bayer.frontend.selenium.utils.handlers.ActionHandler;
import main.com.bayer.frontend.selenium.utils.handlers.ElementHandler;
import main.com.bayer.frontend.selenium.utils.handlers.ExcelHandler;
import main.com.bayer.frontend.selenium.utils.handlers.PopUpHandler;
import main.com.bayer.frontend.selenium.utils.handlers.WindowHandler;
import main.com.bayer.frontend.selenium.utils.reports.TestNGCustomReporter;
import main.com.bayer.frontend.selenium.utils.test.BaseTest;



public class CleartripHomepage extends BaseTest {

	private WebDriver driver;
	private ElementHandler elementHandler;
	private ActionHandler actionHandler;
	private WindowHandler windowHandler;
	private PopUpHandler popuphandler;
	private ExcelHandler excelHandler;
	
	
	public CleartripHomepage (WebDriver driver){
		this.driver = driver;
		elementHandler= new ElementHandler(driver);
		actionHandler=new ActionHandler(driver);
		windowHandler=new WindowHandler(driver);
		popuphandler=new PopUpHandler(driver);
	}
	
	public void openCleartripUrl(){
		driver.get(PropertiesRepository.getString("cleartrip.url"));
		TestNGCustomReporter.log(logger, "Entered The URL");
		TestNGCustomReporter.log(logger, "Home Page is Displaed Sucessfully ");
	}
   
	public void clickOneway() {
		elementHandler.clickElement("cleartrip.oneway");
		TestNGCustomReporter.log(logger, "Clicked On oneway checkbox");
	}
	
	public void FromTag(String fromcity) throws InterruptedException{
		elementHandler.writeText("cleartrip.fromCity", fromcity);
		Thread.sleep(5000);
		actionHandler.keyboardAction(Keys.ENTER);
		TestNGCustomReporter.log(logger, "Entered Fromcity Name Sucessfully ");
	}
	public void ToTag(String tocity) throws InterruptedException{
		elementHandler.writeText("cleartrip.toCity", tocity);
		Thread.sleep(5000);
		actionHandler.keyboardAction(Keys.ENTER);
		TestNGCustomReporter.log(logger, "Entered To city Name Sucessfully ");
	}
	
	public void clickDateBox(){
		elementHandler.clickElement("cleartrip.clickdate");
		TestNGCustomReporter.log(logger, "Clicked On Date Box");
	}
	 
	public void clickTodayDate() {
		elementHandler.clickElement("cleartrip.date");
		TestNGCustomReporter.log(logger, "Clicked On Date");
	}
	
	public void noOfAdults(int index) {
		elementHandler.selectByIndex("cleartrip.dropdownAdults", index);
		TestNGCustomReporter.log(logger, "Successfully executed dropdown Adults");
	}
	public void Alert(){
		popuphandler.isAlertPresent();
		TestNGCustomReporter.log(logger, "Successfully executed Alert");
	}
	public void Notification(){
		actionHandler.keyboardAction(Keys.ESCAPE);
		TestNGCustomReporter.log(logger, "Successfully dismissed notification");
	}
	
	public void SearchFlight(){
		elementHandler.clickElement("cleartrip.search");
		TestNGCustomReporter.log(logger, "Successfully executed Search");
	}
	
	public void Profile(){
		elementHandler.clickElement("cleartrip.user");
		TestNGCustomReporter.log(logger, "clicked on your trips");
	}
	
	public void Register(){
		elementHandler.clickElement("cleartrip.register");
		TestNGCustomReporter.log(logger, "clicked on Register");
	}
	
	public void SignupUser(String email){
		elementHandler.writeText("cleartrip.signupUser", email);
		TestNGCustomReporter.log(logger, "Entered user name");
	}
	
	public void Signin(){
		elementHandler.clickElement("cleartrip.signin");
		TestNGCustomReporter.log(logger, "clicked on signin");
	}
	
	public void Frameswitch(){
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='ModalFrame']/iframe[@id='modal_window']")));
		//windowHandler.switchToFrame("cleartrip.signinFrame");
		TestNGCustomReporter.log(logger, "Switched Frame");
	}
	public void uname(String uname){
		elementHandler.writeText("cleartrip.uname",uname);
		TestNGCustomReporter.log(logger, "Entered uname");
	}
	
	public void pwd(String pwd){
		elementHandler.writeText("cleartrip.pwd",pwd);
		TestNGCustomReporter.log(logger, "Entered password");
	}
	
	public void ClickCreate(){
		elementHandler.clickElement("cleartrip.createAccount");
		TestNGCustomReporter.log(logger, "Create Account Clicked");
	}
	public void Excel(int col , int row) throws Exception{
		excelHandler.getCellData(col, row);
		TestNGCustomReporter.log(logger, "Accessed");
	}
	}

