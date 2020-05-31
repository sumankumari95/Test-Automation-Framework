package pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import locators.HomeObjects;
import utils.SeleniumDriver;

public class HomePage {

	HomeObjects homePageLocators = null;
	
	public HomePage() {
		this.homePageLocators = new HomeObjects();
		PageFactory.initElements(SeleniumDriver.getDriver(), homePageLocators);
	}
	
	public void moveToBuyAndSellMenu() {
		Actions action = new Actions(SeleniumDriver.getDriver());
		action.moveToElement(homePageLocators.carBuyAndSellLink).perform();;
	}
	
	public void navigateToNewAndUsedCarSearchPage() {
		homePageLocators.newAndUsedCarSearchLink.click();
	}
	
	public void navigateToUsedCarSearchPage() {
		homePageLocators.usedCarSearchLink.click();
	}
	
	public void navigateToNewCarSearchPage() {
		homePageLocators.newCarSearchLink.click();
	}
}
