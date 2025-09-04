package tests;

import org.testng.Assert;

import org.testng.annotations.*;

import base.BaseTest;
import pages.HomePage;
import pages.SignUpPage;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Random;

public class SignUpTest extends BaseTest {
	SignUpPage signUpPage;
	HomePage homePage;

	@BeforeClass
	public void setup() throws IOException {
		initializeDriver();
		driver.get(ConfigReader.getProperty("url"));
		signUpPage = new SignUpPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void testRegisterUser() {
		// Step 3: Verify that home page is visible successfully
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		// step 4: Click on 'Signup / Login' button
		homePage.clickSignupLogin();

		// Step 5: Verify 'New User Signup!' is visible
		Assert.assertTrue(signUpPage.isNewUserSignupVisible());

		// Step 6: Enter name and email address
		String name = "Test User";
		String randomEmail = "testuser" + new Random().nextInt(10000) + "@gmail.com";
		signUpPage.enterNameAndEmail(name, randomEmail);

		// Step 7: Click 'Signup' button
		signUpPage.clickSignupButton();

		// Step 8: Verify that 'ENTER ACCOUNT INFORMATION' is visible
		Assert.assertTrue(signUpPage.isEnterAccountInfoVisible());

		// Step 9: Fill details: Title, Name, Email, Password, Date of birth
		signUpPage.fillAccountInfo("Password123", "10", "May", "1995");

		// Step 10: Select checkbox 'Sign up for our newsletter!'
		// Step 11: Select checkbox 'Receive special offers from our partners!'
		signUpPage.selectNewsletterAndOffers();

		// Step 12: Fill details: First name, Last name, Company, Address, Address2,
		// Country, State, City, Zipcode, Mobile Number
		signUpPage.fillAddressDetails("Test", "User", "QA Corp", "123 Main St", "Apt 4B", "Canada", "Ontario",
				"Toronto", "M1A1A1", "1234567890");

		// Step 13: Click 'Create Account button'
		signUpPage.clickCreateAccount();

		// Step 14: Verify that 'ACCOUNT CREATED!' is visible
		Assert.assertTrue(signUpPage.isAccountCreatedVisible());

		// Step 15: Click 'Continue' button
		signUpPage.clickContinue();

		// Step 16: Verify that 'Logged in as username' is visible
		Assert.assertTrue(signUpPage.isLoggedInAsVisible());

		// Step 17: Click 'Delete Account' button
		signUpPage.clickDeleteAccount();

		// Step 18: Verify that 'ACCOUNT DELETED!' is visible and click 'Continue'
		// button
		Assert.assertTrue(signUpPage.isAccountDeletedVisible());
		signUpPage.clickContinue();
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
