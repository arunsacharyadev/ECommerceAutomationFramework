package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@example.com", "password123");
        Thread.sleep(5000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account"), "Login might have failed");
    }
}
