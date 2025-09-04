package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// Locators
	@FindBy(xpath = "//h2[normalize-space()='Login to your account']")
	private WebElement loginHeader;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isLoginHeaderVisible() {
		return loginHeader.isDisplayed();
	}


	public void enterEmailAndPassword(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginBtn.click();
	}
}
