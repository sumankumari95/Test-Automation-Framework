package steps.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.io.Files;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import utils.SeleniumDriver;

public class AfterSteps {

	@After(order = 1)
	public static void captureFailedScreenshot(Scenario scenario) throws IOException {
		WebDriver driver=SeleniumDriver.getDriver();

		if (scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String destinationPath = System.getProperty("user.dir")+"/target/screenshots/"+screenshotName+dateName+".png";
			
			File destinationFile = new File(destinationPath);
			
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);
			byte[] sourcePathInBytes = scrShot.getScreenshotAs(OutputType.BYTES);
			
			FileUtils.copyFile(sourcePath, destinationFile);
			
			scenario.embed(sourcePathInBytes, "image/png");
			ExtentCucumberAdapter.addTestStepLog("Failed Screenshot is attached!!");
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destinationPath);
		}
	}

	@After(order = 0)
	public void tearDown() {
		System.out.println("test completed");
		SeleniumDriver.tearDown();

	}
}
