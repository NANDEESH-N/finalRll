package steps;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindStoresPage;
import pages.HomePage;
import pages.LoginPage;

public class StoreLocatorStep {
	
	SharedSteps shared=new SharedSteps();
	public WebDriver driver=shared.getDriver();
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	FindStoresPage sp=new FindStoresPage(driver);
	
	@When("User must hover over the stores&preschool")
	public void user_must_hover_over_the_stores_preschool() {
	   hp.hovertoStoresandPreSchool();
	}

	@When("User must click on the find stores from drop down")
	public void user_must_click_on_the_find_stores_from_drop_down() {
	   hp.clickOnStores();
	}

	@When("User switches focus to the new tab")
	public void user_switches_focus_to_the_new_tab() throws InterruptedException {
	    ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	@Then("User should be on storelocator page {string}")
	public void user_should_be_on_storelocator_page(String expectedTitle) {
		String actualTitle = driver.getTitle();
	    assert expectedTitle.equals(actualTitle);
	}

	@When("User select the {string},{string} and {string}")
	public void user_select_the_and(String string, String string2, String string3) {
	   sp.selectOneStore(string);
	   sp.selectOneState(string2);
	   sp.selectOneCity(string3);
	}
	
	

	@When("User click on the search button")
	public void user_click_on_the_search_button() {
		sp.clickOnSearchStore();
	}

	@Then("User must be able to view the storeresult")
	public void user_must_be_able_to_view_the() throws InterruptedException {
		WebElement element= driver.findElement(By.xpath("//div[@class='middle']//img[6]"));
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");
		 hp.clickOnFirstcryIcon();
		  hp.hovertoMyAccount();
		  hp.clickOnLogout();
	}
}
