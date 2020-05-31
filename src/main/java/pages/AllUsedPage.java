package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.AllNewAndUsedObjects;
import utils.Actions;
import utils.SeleniumDriver;

public class AllUsedPage {

	Page page = new Page();
	
	public void validatePageUrl() {
		page.validatePageUrl("all-used");
	}
}
