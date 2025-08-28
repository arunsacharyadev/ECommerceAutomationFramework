package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpLoginPage;

public class SignUpLoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
        signUpLoginPage.login("test@example.com", "password123");
        Thread.sleep(5000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account"), "Login might have failed");
    }
}
