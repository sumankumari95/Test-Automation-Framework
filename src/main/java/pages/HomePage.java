package pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import locators.HomeObjects;
import utils.DriverManager;

public class HomePage {

	HomeObjects homePageLocators = null;
	
	public HomePage() {
		this.homePageLocators = new HomeObjects();
		PageFactory.initElements(DriverManager.getDriver(), homePageLocators);
	}
	
	public void moveToBuyAndSellMenu() {
		Actions action = new Actions(DriverManager.getDriver());
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
