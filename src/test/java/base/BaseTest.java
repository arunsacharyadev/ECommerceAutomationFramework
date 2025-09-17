package base;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.Log;

public class BaseTest {

	protected WebDriver driver;

	public void initializeDriver() throws IOException {
		String browser = ConfigReader.getProperty("browser");
		Log.info("Setting up WebDriver...");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Log.info("Navigating to test URL...");
	}

	public void quitDriver() {
		if (driver != null) {
			Log.info("Quitting WebDriver...");
			driver.quit();
		}
	}
}
