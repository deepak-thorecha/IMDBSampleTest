package test.IMDB.Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")
public class CustomSearchResultPage {
	
	@FindBy(css="table.findList td.result_text")
	private List<WebElement> srchResultTxtContainer;
	
	private WebDriver driver;
	public CustomSearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkResultsFor(String value) {
		boolean flag = false;
		for (WebElement srchResult : srchResultTxtContainer) {
			String text = srchResult.getText();
			if(text.contains(value)) {
				flag = true;
				break;
			}
		}
		if(!flag)
			Assert.fail("Specified title ["+value+"] was not found...!");
	}
	
}
