package com.devzery.scenes.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.devzery.scenes.Utilities.TestUtility;
import com.devzery.scenes.Constants.Constants;
import com.devzery.scenes.Utilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	protected static WebDriver driver;
	public static Properties property;
	public static ChromeOptions chromeOptions;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger Log;
	public TestBase() {
		Log = Logger.getLogger(this.getClass());
		try {
			property = new Properties();
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\devzery\\scenes\\Configuration\\Configuration.properties");
			property.load(inputStream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeTest
	public void setLog4j() {
		TestUtility.setDateForLog4j();
	}
	public static WebDriver initialization() {
		String broswerName = property.getProperty("Browser");

		switch (broswerName) {
			case "Chrome" -> {
				chromeOptions = new ChromeOptions();
				//chromeOptions.addArguments("--headless");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);
				chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				//driver = new ChromeDriver(chromeOptions);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				chromeOptions.setExperimentalOption("prefs", prefs);
				driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
			}
			case "Edge" -> {
				//System.setProperty("webdriver.ie.driver", Constants.INTERNET_EXPLORER_DRIVER_PATH);
				//driver = new InternetExplorerDriver();
				driver = WebDriverManager.edgedriver().create();
			}
			case "Firefox" -> {
				//System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH);
				//driver = new FirefoxDriver();
				driver = WebDriverManager.firefoxdriver().create();
			}
			default -> System.out.println("Path of Driver Executable is not Set for any Browser");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(property.getProperty("Url"));

		return driver;
	}
	@AfterTest
	public void endReport()
	{
		
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		Log.info("Browser Terminated");
		Log.info("-----------------------------------------------");
	}
}
