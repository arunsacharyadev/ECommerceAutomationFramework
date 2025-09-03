package tests;

import base.BaseTest;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
    HomePage homePage;
    AccountPage accountPage;

    @BeforeClass
    public void setup() throws IOException {
        initializeDriver();
        driver.get(config.getProperty("url"));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void loginWithCorrectCredentials() {
    	//Step 3: Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        //Step 4: Click on 'Signup / Login' button
        homePage.clickSignupLogin();
        
        //Step 5: Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Login header not visible");

        //Step 6: Enter correct email address and password
        loginPage.enterEmailAndPassword("testuser@gmail.com", "Password123");
        
        //Step 7: Click 'login' button
        loginPage.clickLoginButton();

        //Step 8: Verify that 'Logged in as username' is visible
        Assert.assertTrue(accountPage.isLoggedInAsVisible(), "User not logged in");

        //Step 9: Click 'Delete Account' button
        accountPage.clickDeleteAccount();
        
        //Step 10: Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(accountPage.isAccountDeletedVisible(), "Account not deleted!");
    }
}
