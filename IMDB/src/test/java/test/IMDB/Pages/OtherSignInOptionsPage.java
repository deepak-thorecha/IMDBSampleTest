package test.IMDB.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")
public class OtherSignInOptionsPage {
	
	@FindBy(css="a[href*='register']")
	private WebElement registerNewAcct;
	
	private WebDriver driver;
	public OtherSignInOptionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegisterButton() {
		registerNewAcct.click();
	}
}
