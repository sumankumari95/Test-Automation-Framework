package pages;

import org.openqa.selenium.support.PageFactory;

import locators.AllNewAndUsedObjects;
import utils.DriverManager;

public class AllNewAndUsedPage {

	AllNewAndUsedObjects allNewAndUsedLocators = null;
	Page page = new Page();
	
	public AllNewAndUsedPage() {
		this.allNewAndUsedLocators = new AllNewAndUsedObjects();
		PageFactory.initElements(DriverManager.getDriver(), allNewAndUsedLocators);
	}
	
	public void validatePageUrl() {
		page.validatePageUrl("all-new-and-used");
	}
	
	public void getNumberOfSeachResults() {
		String listingSearchTitle = allNewAndUsedLocators.listingSearchTitleText.getText();
		System.out.println(listingSearchTitle);
	}
}
