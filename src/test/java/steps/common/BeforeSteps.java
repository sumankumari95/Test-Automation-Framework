package steps.common;

import java.io.IOException;

import io.cucumber.java.Before;
import utils.SeleniumDriver;

public class BeforeSteps {

	@Before
	public static void setUp() throws IOException {
		SeleniumDriver.setUpDriver();
	}
}
