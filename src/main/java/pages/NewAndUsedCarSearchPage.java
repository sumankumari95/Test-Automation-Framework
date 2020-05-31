package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.NewAndUsedCarSearchObjects;
import utils.Actions;
import utils.SeleniumDriver;

public class NewAndUsedCarSearchPage {

	NewAndUsedCarSearchObjects newAndUsedCarSearchLocators = null;
	Page page = new Page();
	
	public NewAndUsedCarSearchPage() {
		this.newAndUsedCarSearchLocators = new NewAndUsedCarSearchObjects();
		PageFactory.initElements(SeleniumDriver.getDriver(), newAndUsedCarSearchLocators);
	}
	
	public void validatePageUrl() {
		page.validatePageUrl("new-and-used-car-search");
	}
	
	public void validatePageHeader() {
		Assert.assertEquals(Actions.getText(newAndUsedCarSearchLocators.header), "New & Used Car Search - carsguide");
	}
}
