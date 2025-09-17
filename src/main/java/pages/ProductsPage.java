package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;

	// Locators
	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement allProductsHeading;

	@FindBy(id = "search_product")
	private WebElement searchInput;

	@FindBy(id = "submit_search")
	private WebElement searchButton;

	@FindBy(xpath = "//h2[text()='Searched Products']")
	private WebElement searchedProductsHeading;

	@FindBy(xpath = "//div[@class='productinfo text-center']")
	private List<WebElement> searchedProductsList;

	// Constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAllProductsPageVisible() {
		return allProductsHeading.isDisplayed();
	}

	public void searchProduct(String productName) {
		searchInput.sendKeys(productName);
		searchButton.click();
	}

	public boolean isSearchedProductsVisible() {
		return searchedProductsHeading.isDisplayed();
	}

	public boolean areSearchResultsVisible() {
		return searchedProductsList.size() > 0;
	}
}