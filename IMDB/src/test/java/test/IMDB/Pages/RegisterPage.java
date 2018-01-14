package test.IMDB.Pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.IMDB.Commons.Base;

@SuppressWarnings("unused")
public class RegisterPage {

	@FindBy(id="ap_customer_name")
	private WebElement userName;

	@FindBy(id="ap_email")
	private WebElement userEmail;

	@FindBy(id="ap_password")
	private WebElement userPassword;

	@FindBy(id="ap_password_check")
	private WebElement userRePassword;

	@FindBy(id="continue")
	private WebElement regContinue;

	private WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage enterUserName(String uName) {
		userName.sendKeys(uName);
		return this;
	}

	public RegisterPage enterUserpassword(String uPass) {
		userPassword.sendKeys(uPass);
		return this;
	}
	
	public RegisterPage enterUserPasswordAgain(String uPass) {
		userRePassword.sendKeys(uPass);
		return this;
	}
	
	public RegisterPage enterUserEmail(String uEmail) {
		userEmail.sendKeys(uEmail);
		return this;
	}
	
	public void clickRegisterButton() {
		regContinue.click();
	}

	public String completeRegistrationFormAndSubmit(Map<String, String> userDetails) {
		String timeStamp = Base.timeStamp();
		this.enterUserName(userDetails.get("userName")+timeStamp)
			.enterUserpassword(userDetails.get("userPass")+timeStamp)
			.enterUserPasswordAgain(userDetails.get("userRePass")+timeStamp)
			.enterUserEmail(userDetails.get("userEmail")+timeStamp+"@email.com")
			.clickRegisterButton();
		return (userDetails.get("userName")+timeStamp);
	}
}
