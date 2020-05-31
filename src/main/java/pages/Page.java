package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.CommonObjects;
import utils.Actions;
import utils.SeleniumDriver;

public class Page {
	
	CommonObjects commonLocators = null;
	WebDriver driver;
	
	public Page() {
		driver = SeleniumDriver.getDriver();
		this.commonLocators = new CommonObjects();
		PageFactory.initElements(SeleniumDriver.getDriver(), commonLocators);
	}
	
	public void validatePageUrl(String expUrl) {
		Assert.assertTrue((driver.getCurrentUrl().contains(expUrl)==true));
	}

	public void selectCarMake(String value) {
		Actions.selectByValue(commonLocators.carMakeDropDown, value);
	}
	
	public void selectCarModel(String value) {
		Actions.selectByValue(commonLocators.carModelDropDown, value);
	}
	
	public void selectCarLocation(String value) {
		Actions.selectByValue(commonLocators.carLocationDropDown, value);
	}
	
	public void selectCarPrice(String value) {
		Actions.selectByValue(commonLocators.carPriceDropDown, value);
	}
	
	public void clickOnFindMyNextCarButton() {
		Actions.click(commonLocators.carSearchButton);
	}
}
