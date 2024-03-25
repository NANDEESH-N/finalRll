package steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SearchPage;
import utilities.RetryUtility;

public class AddToCartStepDefination {
	
	SharedSteps shared = new SharedSteps();
	public WebDriver driver = shared.getDriver();
	CartPage cp = new CartPage(driver);
	LoginPage lp = new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	SearchPage sp = new SearchPage(driver);
	ProductsPage pp = new ProductsPage(driver);

	@When("User search for a {string}")
	public void user_search_for_a(String string) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		hp.EnterProduct(string);
	}

	@When("Click on one Product")
	public void click_on_one_product() throws InterruptedException {
		sp.clickonFirstProduct();
	}

	@When("click on Add to Cart for the selected product")
	public void click_on_add_to_cart_for_the_selected_product() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		pp.clickOnAddToCart();
	}

	@Then("{string} should be added to my cart")
	public void should_be_added_to_my_cart(String expectedProductName) throws InterruptedException {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	    hp.clickonCart();
	    String actualProductName = cp.getProductNameFromCart();
	    assertEquals(actualProductName, expectedProductName, "Product name mismatch in the cart");
	    hp.clickOnFirstcryIcon();
	    hp.hovertoMyAccount();
	    hp.clickOnLogout();
}}
