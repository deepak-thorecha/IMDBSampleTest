package test.IMDB.StepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.IMDB.Commons.Base;
import test.IMDB.Pages.HomePage;
import test.IMDB.Pages.OtherSignInOptionsPage;
import test.IMDB.Pages.RegisterPage;

public class IMDBRegisterStepDefinitions {
	
	Map<String, String> regUserData = new HashMap<String, String>();
	WebDriver driver;

	@When("^I click on <Other Sign in options>$")
	public void i_click_on_Other_Sign_in_options() throws Throwable {
		new HomePage(Base.getDriver()).clickOtherSignInOptions();
	}

	@When("^I click on <Create a New Account>$")
	public void i_click_on_Create_a_New_Account() throws Throwable {
		new OtherSignInOptionsPage(Base.getDriver()).clickRegisterButton();
	}

	static String registeredUser = new String();
	@When("^Fill all the details$")
	public void fill_all_the_details() throws Throwable {
		regUserData = Base.readPropertiesFor(Base.USERDETAILS_FILEPATH);
		registeredUser = new RegisterPage(Base.getDriver()).completeRegistrationFormAndSubmit(regUserData);
	}

	@Then("^I verify that user is logged in$")
	public void i_verify_that_user_is_logged_in() throws Throwable {
		new HomePage(Base.getDriver()).checkLoggedInUserName(registeredUser);
	}
	
	@When("^I click LogOut option in UserMenu$")
	public void i_click_LogOut_option_in_UserMenu() throws Throwable {
		new HomePage(Base.getDriver()).logOut();
	}
	
	@Then("^I verify user is logged out$")
	public void i_verify_user_is_logged_out() throws Throwable {
		new HomePage(Base.getDriver()).checkNoUserLoggedIn();
	}
	
}
