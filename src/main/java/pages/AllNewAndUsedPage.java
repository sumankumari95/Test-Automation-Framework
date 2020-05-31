package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.AllNewAndUsedObjects;
import utils.Actions;
import utils.SeleniumDriver;

public class AllNewAndUsedPage {

	AllNewAndUsedObjects allNewAndUsedLocators = null;
	Page page = new Page();
	
	public AllNewAndUsedPage() {
		this.allNewAndUsedLocators = new AllNewAndUsedObjects();
		PageFactory.initElements(SeleniumDriver.getDriver(), allNewAndUsedLocators);
	}
	
	public void validatePageUrl() {
		page.validatePageUrl("all-new-and-used");
	}
	
	public void getNumberOfSeachResults() {
		String listingSearchTitle = allNewAndUsedLocators.listingSearchTitleText.getText();
		System.out.println(listingSearchTitle);
	}
}
