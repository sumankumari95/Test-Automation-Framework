package steps;

import io.cucumber.java.en.When;
//import cucumber.api.java.en.When;
import pages.AllNewAndUsedPage;

public class AllNewAndUsedPageSteps {
	AllNewAndUsedPage allNewAndUsedPage = new AllNewAndUsedPage();

	@When("I get list of new and used cars as per the search")
	public void i_get_list_of_new_and_used_cars_as_per_the_search() {
		allNewAndUsedPage.getNumberOfSeachResults();
	}
}
