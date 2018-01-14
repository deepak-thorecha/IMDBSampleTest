package test.IMDB.Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")
public class PopularTVShowsResultsPage {
	
	@FindBy(css="table.chart > tbody > tr > td.titleColumn")
	private List<WebElement> popularResultTitles;
	
	private WebDriver driver;
	public PopularTVShowsResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTitleName(String title) {
		boolean flag = false;
		for (WebElement resTitle : popularResultTitles) {
			if(resTitle.getText().contains(title))
			{
				flag = true;
				resTitle.findElement(By.xpath(".//a")).click();
				break;
			}
		}
		if(!flag)
			Assert.fail("Specified title ["+title+"] was not found...!");
	}
}
