package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignUpLoginPage;

import java.io.IOException;
import java.util.Random;

public class SignUpLoginTest extends BaseTest {
    SignUpLoginPage signUpLoginPage;

    @BeforeClass
    public void setup() throws IOException {
        initializeDriver();
        driver.get(config.getProperty("url"));
        signUpLoginPage = new SignUpLoginPage(driver);
    }

    @Test
    public void testRegisterUser() {
        // Step 3: Verify home page is visible
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        // Step 4: Click Signup/Login
        signUpLoginPage.clickSignupLogin();

        // Step 5: Verify new user signup text
        Assert.assertTrue(signUpLoginPage.isNewUserSignupVisible());

        // Step 6: Enter name and email
        String name = "Test User";
        String randomEmail = "testuser" + new Random().nextInt(10000) + "@mail.com";
        signUpLoginPage.enterNameAndEmail(name, randomEmail);

        // Step 7: Click Signup
        signUpLoginPage.clickSignupButton();

        // Step 8: Verify enter account info
        Assert.assertTrue(signUpLoginPage.isEnterAccountInfoVisible());

        // Step 9: Fill details
        signUpLoginPage.fillAccountInfo("Password123", "10", "May", "1995");

        // Step 10 & 11: Select checkboxes
        signUpLoginPage.selectNewsletterAndOffers();

        // Step 12: Fill address details
        signUpLoginPage.fillAddressDetails(
                "Test", "User", "QA Corp", "123 Main St", "Apt 4B",
                "Canada", "Ontario", "Toronto", "M1A1A1", "1234567890"
        );

        // Step 13: Create Account
        signUpLoginPage.clickCreateAccount();

        // Step 14: Verify ACCOUNT CREATED!
        Assert.assertTrue(signUpLoginPage.isAccountCreatedVisible());

        // Step 15: Continue
        signUpLoginPage.clickContinue();

        // Step 16: Verify Logged in as username
        Assert.assertTrue(signUpLoginPage.isLoggedInAsVisible());

        // Step 17: Delete account
        signUpLoginPage.clickDeleteAccount();

        // Step 18: Verify ACCOUNT DELETED!
        Assert.assertTrue(signUpLoginPage.isAccountDeletedVisible());

        signUpLoginPage.clickContinue();
    }

    @AfterClass
    public void tearDown() {
        quitDriver();
    }
}
