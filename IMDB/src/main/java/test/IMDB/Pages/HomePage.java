package test.IMDB.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.IMDB.Commons.QuickSearchOptions;

public class HomePage {
	
	@FindBy(id="quicksearch")
	private WebElement quickSrchSelect; 
	
	@FindBy(id="navbar-query")
	private WebElement txtSrchBar;
	
	@FindBy(id="navbar-submit-button")
	private WebElement sbmtSrch;
	
	@FindBy(css="#navTitleMenu span.downArrow")
	private WebElement navMoviesMenu;
	
	@FindBy(xpath="//a[text()='Most Popular TV Shows']")
	private WebElement popularTVShows;
	
	@FindBy(css="a#nblogin")
	private WebElement otherSignInOptions;
	
	@FindBy(css="a[href*='register']")
	private WebElement registerNewAcct;
	
	@FindBy(css="#navUserMenu > p > a")
	private WebElement signedInUserName;
	
	@FindBy(css="#navUserMenu span.downArrow")
	private WebElement signedInUserMenu;
	
	@FindBy(id="nblogout")
	private WebElement logOutLink;
	
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage selectQuickSrchOption(QuickSearchOptions option) {
		Select qSrch = new Select(quickSrchSelect);
		qSrch.selectByVisibleText(option.getVisibleValueText());
		return this;
	}
	
	public HomePage enterSrchKeyText(String text) {
		txtSrchBar.sendKeys(text);
		sbmtSrch.click();
		return this;
	}
	
	public HomePage clickMostPopularTVShows() {
		navMoviesMenu.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(popularTVShows)).click();
		return this;
	}
	
	public OtherSignInOptionsPage clickOtherSignInOptions() {
		otherSignInOptions.click();
		/*((JavascriptExecutor)driver).executeScript("argument[0].click()", otherSignInOptions);*/
		return new OtherSignInOptionsPage(driver);
	}
	
	public void logOut() {
		signedInUserMenu.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(logOutLink)).click();
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(otherSignInOptions));
	}
	
	public void checkLoggedInUserName(String uName) {
		Assert.assertTrue("Logged In UserName is incorrect... Should be: "+uName, signedInUserName.getText().contentEquals(uName));
	}
	
	public void checkNoUserLoggedIn() {
		Assert.assertTrue("Seems some User is Logged In right now...!", otherSignInOptions.isDisplayed());
	}
	
}
