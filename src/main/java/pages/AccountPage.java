package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	// Locators
	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	private WebElement loggedInAsText;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	private WebElement deleteAccountBtn;

	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	private WebElement accountDeletedText;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isLoggedInAsVisible() {
		return loggedInAsText.isDisplayed();
	}

	public void clickDeleteAccount() {
		deleteAccountBtn.click();
	}

	public boolean isAccountDeletedVisible() {
		return accountDeletedText.isDisplayed();
	}
}
