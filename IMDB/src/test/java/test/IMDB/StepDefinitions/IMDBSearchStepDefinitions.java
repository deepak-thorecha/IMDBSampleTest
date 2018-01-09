package test.IMDB.StepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.IMDB.Commons.Base;
import test.IMDB.Commons.QuickSearchOptions;
import test.IMDB.Pages.CustomSearchResultPage;
import test.IMDB.Pages.HomePage;
import test.IMDB.Pages.PopularTVShowsResultsPage;
import test.IMDB.Pages.TitleDetailsPage;

public class IMDBSearchStepDefinitions {
	
	@When("^I select \"([^\"]*)\" in dropdown$")
	public void i_select_in_dropdown(String option) throws Throwable {
		boolean found = false;
		for (QuickSearchOptions srchOpt : QuickSearchOptions.values()) {
			if(srchOpt.getVisibleValueText().contentEquals(option)) {
				new HomePage(Base.getDriver()).selectQuickSrchOption(srchOpt);
				found = true;
				break;
			}
		}
		if(!found)
			Assert.fail("No dropdown option available with Value as: "+option);
	}

	@When("^Enter search keyword as \"([^\"]*)\"$")
	public void enter_search_keyword_as(String srchKeyword) throws Throwable {
		new HomePage(Base.getDriver()).enterSrchKeyText(srchKeyword);
	}

	@Then("^I verify the \"([^\"]*)\" in results$")
	public void i_verify_the_in_results(String resultText) throws Throwable {
		new CustomSearchResultPage(Base.getDriver()).checkResultsFor(resultText);
		Base.getDriver().quit();
	}
	
	@When("^I click <Most Popular TV Shows> in <Movies, TV, & ShowTime’s> submenu$")
	public void i_click_Most_Popular_TV_Shows_in_Movies_TV_ShowTime_s_submenu() throws Throwable {
		new HomePage(Base.getDriver()).clickMostPopularTVShows();
	}

	@When("^Click on \"([^\"]*)\"$")
	public void click_on(String title) throws Throwable {
		new PopularTVShowsResultsPage(Base.getDriver()).clickTitleName(title);
	}

	@Then("^I verify that creator name is \"([^\"]*)\" on details$")
	public void i_verify_that_creator_name_is_on_details(String creator) throws Throwable {
		new TitleDetailsPage(Base.getDriver()).checkCreatorName(creator);
		Base.getDriver().quit();
	}
	
}
