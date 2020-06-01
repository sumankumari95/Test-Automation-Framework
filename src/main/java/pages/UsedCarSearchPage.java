package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.UsedCarSearchObjects;
import utils.Actions;
import utils.DriverManager;

public class UsedCarSearchPage {

	UsedCarSearchObjects usedCarSearchLocators = null;
	Page page = new Page();
	
	public UsedCarSearchPage() {
		this.usedCarSearchLocators = new UsedCarSearchObjects();
		PageFactory.initElements(DriverManager.getDriver(), usedCarSearchLocators);
	}
	
	public void validatePageUrl() {
		page.validatePageUrl("used-car-search");
	}
	
	public void validatePageHeader() {
		Assert.assertEquals(Actions.getText(usedCarSearchLocators.header), "Used Cars For Sale");
	}

}
