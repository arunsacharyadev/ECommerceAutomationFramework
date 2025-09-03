package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    final WebDriver driver;

    @FindBy(linkText = "Signup / Login")
    private WebElement signupLoginBtn;

    @FindBy(xpath = "//div[@class='logo pull-left']")
    private WebElement homePageBanner;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageVisible() {
        return homePageBanner.isDisplayed();
    }

    public void clickSignupLogin() {
        signupLoginBtn.click();
    }
}
