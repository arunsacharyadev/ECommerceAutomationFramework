package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    final WebDriver driver;

    // ====== Locators ======
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupText;

    @FindBy(name = "name")
    WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    WebElement enterAccountInfoText;

    @FindBy(id = "id_gender1")
    WebElement mrTitle;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "days")
    WebElement dayDropdown;

    @FindBy(id = "months")
    WebElement monthDropdown;

    @FindBy(id = "years")
    WebElement yearDropdown;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement optinCheckbox;

    @FindBy(id = "first_name")
    WebElement firstNameInput;

    @FindBy(id = "last_name")
    WebElement lastNameInput;

    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement address1Input;

    @FindBy(id = "address2")
    WebElement address2Input;

    @FindBy(id = "country")
    WebElement countryDropdown;

    @FindBy(id = "state")
    WebElement stateInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "zipcode")
    WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInAsText;

    @FindBy(linkText = "Delete Account")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement accountDeletedText;

    // ====== Constructor ======
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ====== Actions ======

    public boolean isNewUserSignupVisible() {
        return newUserSignupText.isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        nameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public boolean isEnterAccountInfoVisible() {
        return enterAccountInfoText.isDisplayed();
    }

    public void fillAccountInfo(String password, String day, String month, String year) {
        mrTitle.click();
        passwordInput.sendKeys(password);
        dayDropdown.sendKeys(day);
        monthDropdown.sendKeys(month);
        yearDropdown.sendKeys(year);
    }

    public void selectNewsletterAndOffers() {
        newsletterCheckbox.click();
        optinCheckbox.click();
    }

    public void fillAddressDetails(String first, String last, String company,
                                   String addr1, String addr2, String country,
                                   String state, String city, String zip, String mobile) {
        firstNameInput.sendKeys(first);
        lastNameInput.sendKeys(last);
        companyInput.sendKeys(company);
        address1Input.sendKeys(addr1);
        address2Input.sendKeys(addr2);
        countryDropdown.sendKeys(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zip);
        mobileNumberInput.sendKeys(mobile);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public boolean isAccountCreatedVisible() {
        return accountCreatedText.isDisplayed();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isLoggedInAsVisible() {
        return loggedInAsText.isDisplayed();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }

    public boolean isAccountDeletedVisible() {
        return accountDeletedText.isDisplayed();
    }
}
