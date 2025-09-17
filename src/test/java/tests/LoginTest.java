package tests;

import pages.AccountPage;

import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Log;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	AccountPage accountPage;

	@BeforeMethod
	public void setup() throws IOException {
		initializeDriver();
		driver.get(ConfigReader.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		accountPage = new AccountPage(driver);
	}

	@Test
	public void testLoginUserwithcorrectemailandPassword() {
		Log.info("testLoginUserwithcorrectemailandPassword");
		// Step 3: Verify that home page is visible successfully
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		// Step 4: Click on 'Signup / Login' button
		homePage.clickSignupLogin();

		// Step 5: Verify 'Login to your account' is visible
		Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Login header not visible");

		// Step 6: Enter correct email address and password
		loginPage.enterEmailAndPassword("testuser4320@gmail.com", "Password123");

		// Step 7: Click 'login' button
		loginPage.clickLoginButton();

		// Step 8: Verify that 'Logged in as username' is visible
		Assert.assertTrue(accountPage.isLoggedInAsVisible(), "User not logged in");

		// Step 9: Click 'Delete Account' button
		accountPage.clickDeleteAccount();

		// Step 10: Verify that 'ACCOUNT DELETED!' is visible
		Assert.assertTrue(accountPage.isAccountDeletedVisible(), "Account not deleted!");
	}

	@Test
	public void testLoginUserwithincorrectemailandpassword() {
		Log.info("testLoginUserwithincorrectemailandpassword");
		// Step 3: Verify that home page is visible successfully
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		// Step 4: Click on 'Signup / Login' button
		homePage.clickSignupLogin();

		// Step 5: Verify 'Login to your account' is visible
		Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Login header not visible");

		// Step 6: Enter incorrect email address and password
		loginPage.enterEmailAndPassword("testuser@gmail.com", "Password123");

		// Step 7: Click 'login' button
		loginPage.clickLoginButton();

		// Step 8: Verify error 'Your email or password is incorrect!' is visible
		Assert.assertTrue(loginPage.isErrorVisible(), "Error message is not visible");
	}

	@Test
	public void testLogoutUser() {
		Log.info("testLogoutUser");
		// Step 3: Verify that home page is visible successfully
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		// Step 4: Click on 'Signup / Login' button
		homePage.clickSignupLogin();

		// Step 5: Verify 'Login to your account' is visible
		Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Login header not visible");

		// Step 6: Enter correct email address and password
		loginPage.enterEmailAndPassword("testuser4320@gmail.com", "Password123");

		// Step 7: Click 'login' button
		loginPage.clickLoginButton();

		// Step 8: Verify that 'Logged in as username' is visible
		Assert.assertTrue(accountPage.isLoggedInAsVisible(), "User not logged in");

		// Step 9: Click 'Logout' button
		accountPage.clickLogout();

		// Step 10: Verify that user is navigated to login page
		Assert.assertTrue(loginPage.isLoginHeaderVisible(), "User was not redirected to login page after logout");
	}

	@AfterMethod
	public void tearDown() {
		quitDriver();
	}
}
