package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
	protected WebDriver driver;
	protected Properties config;

	public void loadConfig() throws IOException {
		config = new Properties();
		FileInputStream fis = new FileInputStream("config/config.properties");
		config.load(fis);
	}

	public void initializeDriver() throws IOException {
		loadConfig();
		String browser = config.getProperty("browser");

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
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
