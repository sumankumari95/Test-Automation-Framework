package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UsedCarSearchObjects {
	
	@FindBy(how = How.XPATH, using="//h1[contains(text(), \"Used\")]")
	public WebElement header;
}
