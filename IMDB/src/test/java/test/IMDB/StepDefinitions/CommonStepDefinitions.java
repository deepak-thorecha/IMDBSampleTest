package test.IMDB.StepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import test.IMDB.Commons.Base;

public class CommonStepDefinitions {
	
	public static WebDriver driver;
	@Given("^\"([^\"]*)\" is opened$")
	public void is_opened(String browser) throws Throwable {
		Base.setDriver(browser);
	}
	
	@Given("^I am on HomePage$")
	public void i_am_on_HomePage() throws Throwable {
		driver.get(Base.HOME_URL);
	}
	
}
