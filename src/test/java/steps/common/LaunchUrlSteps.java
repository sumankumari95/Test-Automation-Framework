package steps.common;

import io.cucumber.java.en.Given;
//import cucumber.api.java.en.Given;
import pages.LaunchUrl;

public class LaunchUrlSteps {
	LaunchUrl launchUrl = new LaunchUrl();
	
	@Given("I launch the home page {string} of CarsGuide website")
	public void i_launch_the_home_page_of_CarsGuide_website(String carsHomePageUrl) throws Throwable {
		launchUrl.launchCarsHomePage(carsHomePageUrl);
	}
}
