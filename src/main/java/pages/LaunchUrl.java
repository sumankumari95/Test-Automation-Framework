package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import locators.HomeObjects;
import utils.SeleniumDriver;

public class LaunchUrl {
	public void launchCarsHomePage(String url) {
		SeleniumDriver.openPage(url);
	}
}
