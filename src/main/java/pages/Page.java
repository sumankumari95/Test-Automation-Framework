package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.CommonObjects;
import utils.Actions;
import utils.DriverManager;

public class Page {
	
	CommonObjects commonLocators = null;
	WebDriver driver;
	
	public Page() {
		driver = DriverManager.getDriver();
		this.commonLocators = new CommonObjects();
		PageFactory.initElements(DriverManager.getDriver(), commonLocators);
	}
	
	public void validatePageUrl(String expUrl) {
		Assert.assertTrue((driver.getCurrentUrl().contains(expUrl)==true));
	}

	public void selectCarMake(String value) {
		Actions.selectByVisibleText(commonLocators.carMakeDropDown, value);
	}
	
	public void selectCarModel(String value) {
		Actions.selectByVisibleText(commonLocators.carModelDropDown, value);
	}
	
	public void selectCarLocation(String value) {
		Actions.selectByVisibleText(commonLocators.carLocationDropDown, value);
	}
	
	public void selectCarPrice(String value) {
		Actions.selectByValue(commonLocators.carPriceDropDown, value);
	}
	
	public void clickOnFindMyNextCarButton() {
		Actions.click(commonLocators.carSearchButton);
	}
}
