package steps;

import io.cucumber.java.en.When;
//import cucumber.api.java.en.When;
import pages.NewAndUsedCarSearchPage;
import pages.Page;

public class NewAndUsedCarSearchPageSteps {
	NewAndUsedCarSearchPage newAndUsedCarSearchPage = new NewAndUsedCarSearchPage();
	Page page = new Page();

	@When("I provide new and used car details to find my next car")
	public void i_provide_new_and_used_car_details_to_find_my_next_car() throws InterruptedException {
		page.selectCarMake("BMW");
		page.selectCarModel("116I");
		page.selectCarLocation("NSW - All");
		page.selectCarPrice("25000");
		page.clickOnFindMyNextCarButton();
	}
}
