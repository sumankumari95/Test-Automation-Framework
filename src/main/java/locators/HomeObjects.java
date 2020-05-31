package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeObjects {

	@FindBy(how = How.LINK_TEXT, using="buy + sell")
	public WebElement carBuyAndSellLink;
	
	@FindBy(how = How.LINK_TEXT, using="Search Cars")
	public WebElement newAndUsedCarSearchLink;
	
	@FindBy(how = How.LINK_TEXT, using="New")
	public WebElement newCarSearchLink;
	
	@FindBy(how = How.LINK_TEXT, using="Used")
	public WebElement usedCarSearchLink;
}
