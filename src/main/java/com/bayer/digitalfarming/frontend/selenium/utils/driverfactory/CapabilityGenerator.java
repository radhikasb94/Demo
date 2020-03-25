package com.bayer.digitalfarming.frontend.selenium.utils.driverfactory;

import java.io.File;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bayer.digitalfarming.frontend.selenium.utils.config.GlobalProperties;
import com.bayer.digitalfarming.frontend.selenium.utils.config.PropertiesRepository;

public class CapabilityGenerator {
	public static DesiredCapabilities getCapabilities(String browserType) {
		DesiredCapabilities cap = null;
		System.out.println("BROWSER : " + browserType);

		switch (browserType) {
			case GlobalProperties.FIREFOX:
				System.setProperty("webdriver.gecko.driver",
						PropertiesRepository.getString("global.browser.firefox.gecko.driver.executable"));
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.download.dir",
						PropertiesRepository.getString("global.download.location"));
				firefoxProfile.setPreference("browser.download.alertOnEXEOpen", false);
				firefoxProfile.setPreference("browser.helperApps.neverAsksaveToDisk",
						"application/x-msexcel,application/excel,application/x-excel,"
								+ "application/excel,application/x-excel,application/excel,"
								+ "application/vnd.ms-excel,application/x-excel,application/x-msexcel");
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
				firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
				firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				firefoxProfile.setPreference("browser.download.manager.closeWhenDone", false);
				firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
				firefoxProfile.setPreference("browser.download.manager.useWindow", false);
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("pdfjs.disabled", true);

				cap = DesiredCapabilities.firefox();
				cap.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
				cap.setBrowserName(PropertiesRepository.getString("global.browser.capability.browserName"));
				cap.setJavascriptEnabled(true);
				cap.setCapability("platform", PropertiesRepository.getString("global.browser.capability.platform"));
				cap.setCapability("takesScreenshot",
						PropertiesRepository.getBoolean("global.browser.capability.firefox.takesScreenshot"));
				cap.setCapability("handlesAlerts",
						PropertiesRepository.getBoolean("global.browser.capability.firefox.handlesAlerts"));
				cap.setCapability("cssSelectorsEnabled",
						PropertiesRepository.getBoolean("global.browser.capability.firefox.cssSelectorsEnabled"));
				cap.setCapability("networkConnectionEnabled", true);
				cap.setCapability("browserConnectionEnabled", true);
				break;

			case GlobalProperties.CHROME:

				ChromeOptions options = new ChromeOptions();
				cap = DesiredCapabilities.chrome();

				if (System.getProperty("os.name").startsWith("Windows")) {

					System.setProperty("webdriver.chrome.driver",
							PropertiesRepository.getString("global.browser.chrome.driver.executable.windows"));

					cap.setPlatform(Platform.WINDOWS);

					System.out.println("CHROME ON WINDOWS");
					cap.setCapability(ChromeOptions.CAPABILITY, options);

				} else

				{

				/*System.setProperty("webdriver.chrome.driver",
						PropertiesRepository.getString("global.browser.chrome.driver.executable.linux"));*/

					cap.setPlatform(Platform.LINUX);

					options.addArguments("--headless");
					options.addArguments("window-size=1920,1080");
					cap.setCapability(ChromeOptions.CAPABILITY, options);

				}

				break;

			default:
				FirefoxProfile defaultProfile = new FirefoxProfile();
				defaultProfile.setPreference("browser.download.folderList", 2);
				defaultProfile.setPreference("browser.download.dir",
						PropertiesRepository.getString("global.download.location"));
				defaultProfile.setPreference("browser.download.alertOnEXEOpen", false);
				defaultProfile.setPreference("browser.helperApps.neverAsksaveToDisk",
						"application/x-msexcel,application/excel,application/x-excel,"
								+ "application/excel,application/x-excel,application/excel,"
								+ "application/vnd.ms-excel,application/x-excel,application/x-msexcel");
				defaultProfile.setPreference("browser.download.manager.showWhenStarting", false);
				defaultProfile.setPreference("browser.download.manager.focusWhenStarting", false);
				defaultProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
				defaultProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				defaultProfile.setPreference("browser.download.manager.closeWhenDone", false);
				defaultProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
				defaultProfile.setPreference("browser.download.manager.useWindow", false);
				defaultProfile.setPreference("browser.download.manager.showWhenStarting", false);
				defaultProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
				defaultProfile.setPreference("pdfjs.disabled", true);

				cap = DesiredCapabilities.firefox();
				cap.setCapability(FirefoxDriver.PROFILE, defaultProfile);
				cap.setBrowserName(PropertiesRepository.getString("global.browser.capability.browserName"));
				cap.setJavascriptEnabled(true);
				cap.setCapability("platform", PropertiesRepository.getString("global.browser.capability.platform"));
				cap.setCapability("takesScreenshot",
						PropertiesRepository.getBoolean("global.browser.capability.firefox.takesScreenshot"));
				cap.setCapability("handlesAlerts",
						PropertiesRepository.getBoolean("global.browser.capability.firefox.handlesAlerts"));
				cap.setCapability("cssSelectorsEnabled",
						PropertiesRepository.getBoolean("global.browser.capability.firefox.cssSelectorsEnabled"));
		}
		return cap;
	}
}
