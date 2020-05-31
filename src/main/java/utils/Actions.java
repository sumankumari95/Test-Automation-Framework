package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Actions {

	public static void selectByValue(WebElement locator, String value) {
		Select selectCar = new Select(locator);
		selectCar.selectByValue(value);
	}
	
	public static void click(WebElement locator) {
		locator.click();
	}
	
	public static String getText(WebElement locator) {
		return locator.getText();
	}
}
