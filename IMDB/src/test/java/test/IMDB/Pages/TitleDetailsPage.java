package test.IMDB.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")
public class TitleDetailsPage {
	
	@FindBy(css="div.credit_summary_item span[itemprop='creator'] span")
	private WebElement creatorName;
	
	private WebDriver driver;
	public TitleDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkCreatorName(String name) {
		Assert.assertTrue("Incorrect Creator name on details page", creatorName.getText().contentEquals(name));
	}
}
