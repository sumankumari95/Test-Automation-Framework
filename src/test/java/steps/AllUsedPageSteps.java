package steps;

import io.cucumber.java.en.Then;
import pages.AllUsedPage;

public class AllUsedPageSteps {
	AllUsedPage allUsedPage = new AllUsedPage();
	
	@Then("I get list of used cars as per the search")
	public void i_get_list_of_used_cars_as_per_the_search() throws Throwable {
		allUsedPage.validatePageUrl();
	}
}
