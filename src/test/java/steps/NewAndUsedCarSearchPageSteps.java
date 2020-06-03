package steps;

import io.cucumber.java.en.When;
//import cucumber.api.java.en.When;
import pages.NewAndUsedCarSearchPage;
import pages.Page;

public class NewAndUsedCarSearchPageSteps {
	NewAndUsedCarSearchPage newAndUsedCarSearchPage = new NewAndUsedCarSearchPage();
	Page page = new Page();
	
	@When("I provide new and used car details to find my next car {string} {string} {string} {string}")
	public void i_provide_new_and_used_car_details_to_find_my_next_car(String make, String model, String location, String price) {
		page.selectCarMake(make);
		page.selectCarModel(model);
		page.selectCarLocation(location);
		page.selectCarPrice(price);
		page.clickOnFindMyNextCarButton();
	}
}
