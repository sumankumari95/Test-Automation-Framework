package pages;

import utils.SeleniumDriver;

public class LaunchUrl {
	public void launchCarsHomePage(String url) {
		SeleniumDriver.openPage(url);
	}
}
