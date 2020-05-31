package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static SeleniumDriver seleniumDriver;
	private static FileInputStream fis;
	private static Properties config = new Properties();
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static int TIMEOUT = 30;
	public static int PAGE_LOAD_TIMEOUT = 50;

	private SeleniumDriver() throws IOException {
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		
		if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(config.getProperty("browser").equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		setDr(driver);
		
		getDriver().manage().window().maximize();

		wait = new WebDriverWait(driver, TIMEOUT);
		getDriver().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

//	public static WebDriver getDriver() {
//		return driver;
//	}
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDr(WebDriver driver) {
		dr.set(driver);;
	}

	public static void openPage(String url) {
		getDriver().get(url);
	}

	public static void setUpDriver() throws IOException {
		if(seleniumDriver==null) {
			seleniumDriver = new SeleniumDriver();
		}
	}

	public static void tearDown() {
		if(getDriver()!=null) {
			getDriver().close();
			getDriver().quit();
		}
		seleniumDriver=null;
	}
}
