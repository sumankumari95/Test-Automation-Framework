package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static SeleniumDriver seleniumDriver;
	private static FileInputStream fis;
	private static Properties config = new Properties();
	public boolean grid;
	public static String browser;

	public static int TIMEOUT = 30;
	public static int PAGE_LOAD_TIMEOUT = 50;

	private SeleniumDriver() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
//---------------------------------------------------------------------------
		if(System.getProperty("browser") != null) {
			browser = System.getProperty("browser");
		}else if(System.getenv("browser") !=null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
		} else {
			browser = config.getProperty("browser");
		}
		
		config.setProperty("browser", browser);
//----------------------------------------------------------------------------
		if(System.getProperty("isremote") != null) {
			grid = Boolean.parseBoolean(System.getProperty("isremote"));
		}else if(System.getenv("executionType")!=null && System.getenv("executionType").equals("Grid")) {
			grid=true;
		} else {
			grid = Boolean.parseBoolean(config.getProperty("isRemote"));
		}
//---------------------------------------------------------------------------------
		DriverFactory.setGridPath(config.getProperty("gridPath"));
		DriverFactory.setRemote(grid);

		if (DriverFactory.isRemote()) {
			DesiredCapabilities cap = null;

			if(config.getProperty("browser").equals("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if(config.getProperty("browser").equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			} else if(config.getProperty("browser").equals("IE")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("IE");
				cap.setPlatform(Platform.WINDOWS);
			}

			driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);

		} else {
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
		}
//-----------------------------------------------------------------------
		DriverManager.setDriver(driver);
		//		log.info("Driver Initialized !!!");

		DriverManager.getDriver().manage().window().maximize();

		wait = new WebDriverWait(driver, TIMEOUT);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public static void openPage(String url) {
		DriverManager.getDriver().get(url);
	}

	public static void setUpDriver() throws IOException {
		if(seleniumDriver==null) {
			seleniumDriver = new SeleniumDriver();
		}
	}

	public static void tearDown() {
		if(DriverManager.getDriver()!=null) {
			DriverManager.getDriver().close();
			DriverManager.getDriver().quit();
			//			log.info("Test Execution Completed !!!");
		}
		seleniumDriver=null;
	}
}
