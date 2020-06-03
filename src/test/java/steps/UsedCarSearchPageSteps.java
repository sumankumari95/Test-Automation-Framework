package steps;

import io.cucumber.java.en.When;
import pages.Page;
import pages.UsedCarSearchPage;

public class UsedCarSearchPageSteps {
	UsedCarSearchPage usedCarSearchPage = new UsedCarSearchPage();
	Page page = new Page();
	
	@When("I provide used car details to find my next car {string} {string} {string} {string}")
	public void i_provide_used_car_details_to_find_my_next_car(String make, String model, String location, String price) {
		page.selectCarMake(make);
		page.selectCarModel(model);
		page.selectCarLocation(location);
		page.selectCarPrice(price);
		page.clickOnFindMyNextCarButton();
	}
}
