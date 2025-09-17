package tests;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.Log;

public class SearchProductTest extends BaseTest {
	ProductsPage productsPage;
	HomePage homePage;

	@BeforeTest
	public void setup() throws IOException {
		initializeDriver();
		driver.get(ConfigReader.getProperty("url"));
		productsPage = new ProductsPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void testSearchProduct() {
		Log.info("testSearchProduct");

		// Step 3: Verify that home page is visible successfully
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		// Step 4: Click on 'Products' button
		homePage.clickProducts();

		// Step 5: Verify user is navigated to ALL PRODUCTS page successfully
		Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page not visible!");

		// Step 6: Enter product name in search input and click search button
		productsPage.searchProduct("Dress");

		// Step 7: Verify 'SEARCHED PRODUCTS' is visible
		Assert.assertTrue(productsPage.isSearchedProductsVisible(), "SEARCHED PRODUCTS heading not visible!");

		// Step 8: Verify all the products related to search are visible
		Assert.assertTrue(productsPage.areSearchResultsVisible(), "No search results found!");
	}

	@AfterTest
	public void tearDown() {
		quitDriver();
	}

}
