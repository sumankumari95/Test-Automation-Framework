package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"json:target/cucumber-reports/cucumber.json",
				"pretty",
				"html:target/cucumber-reports",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		features = {"src/test/resources/features/"},
		glue = "steps",
		monochrome = true
		)

public class RunCuke extends AbstractTestNGCucumberTests{
	
//	@BeforeClass
//	public String parallelCheck() throws IOException {
//		Properties config = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
//		config.load(fis);
//		return config.getProperty("parallel");
//	}
	
	
	//	private TestNGCucumberRunner testNGCucumberRunner;
	//	ExtentHtmlReporter htmlReporter;
	//    ExtentReports extent;

	//	@BeforeClass(alwaysRun = true)
	//	public void setup() {
	////		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	//        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	//        extentProperties.setReportPath("target/Extent_Reports/"+timeStamp.replace(":","_").replace(".","_")+".html");
	//		System.out.println("Before Class.........."); 
	//    }

	//	@BeforeClass(alwaysRun = true)
	//    public void setup()
	//    {
	//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/target/RunCuke/advanced-reports/extentreports/extent.html");
	//        extent = new ExtentReports();
	//        extent.attachReporter(htmlReporter);
	//        test = extent.createTest("captureScreenshot");?
	//    }

	//	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios")
	//    public void feature(PickleWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
	//        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	//
	//    }
	//
	//	@AfterClass
	//	public static void writeExtentReport() {
	//		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	//        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	//        Reporter.setSystemInfo("Browser Name", "Chrome");
	//        Reporter.setSystemInfo("Selenium Version", "3.14.9");
	//	}
	//	@AfterClass(alwaysRun = true)
	//    public void tearDownClass() {
	//		extent.flush();
	//        testNGCucumberRunner.finish();
	//    }
}
