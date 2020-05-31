package steps;

import io.cucumber.java.en.When;
//import cucumber.api.java.en.When;
import pages.HomePage;
import pages.NewAndUsedCarSearchPage;
import pages.UsedCarSearchPage;

public class HomePageSteps {
	HomePage homePage = new HomePage();
	NewAndUsedCarSearchPage newAndUsedCarSearchPage = new NewAndUsedCarSearchPage();
	UsedCarSearchPage usedCarSearchPage = new UsedCarSearchPage();

	@When("^I navigate to search (newandused||used) cars page$")
	public void i_navigate_to_search_cars_page(String carsSearchType) {
		if(carsSearchType.equals("newandused")) {
			homePage.moveToBuyAndSellMenu();
			homePage.navigateToNewAndUsedCarSearchPage();
			newAndUsedCarSearchPage.validatePageUrl();
			newAndUsedCarSearchPage.validatePageHeader();
		} else if(carsSearchType.equals("used")) {
			homePage.moveToBuyAndSellMenu();
			homePage.navigateToUsedCarSearchPage();
			usedCarSearchPage.validatePageUrl();
			usedCarSearchPage.validatePageHeader();
		} else {
			throw new Error("Not matching search categary!!");
		}
//		switch(carsSearchType) {
//		case str:
//			homePage.moveToBuyAndSellMenu();
//			homePage.navigateToNewAndUsedCarSearchPage();
//			newAndUsedCarSearchPage.validatePageUrl();
//			newAndUsedCarSearchPage.validatePageHeader();
//			break;
//		case "used":
//			homePage.moveToBuyAndSellMenu();
//			homePage.navigateToUsedCarSearchPage();
//			usedCarSearchPage.validatePageUrl();
//			usedCarSearchPage.validatePageHeader();
//			break;
//		default: 
//			throw new Error("Not matching search categary!!");
//		}
		
	}
}
