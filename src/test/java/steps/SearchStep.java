package steps;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

public class SearchStep {
	
	SharedSteps shared=new SharedSteps();
	public WebDriver driver=shared.getDriver();
	HomePage hp=new HomePage(driver);
	SearchPage sp=new SearchPage(driver);
	
	@When("User search for {string}")
	public void user_search_for(String string) throws InterruptedException {
		 hp.EnterProduct(string);
	}

	@When("select product from the search results")
	public void select_product_from_the_search_results() {
		sp.clickonFirstProduct();
	}
	

	@When("User switches focus to the new tab")
	public void user_switches_focus_to_the_new_tab() {
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1));
	}

	@Then("title should be {string}")
	public void title_should_be(String expectedTitle) throws InterruptedException {
	    String actualTitle = driver.getTitle();
	    assert expectedTitle.equals(actualTitle);

	    hp.clickOnFirstcryIcon();
	    hp.hovertoMyAccount();
	    hp.clickOnLogout();
	}

}
