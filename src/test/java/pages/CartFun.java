package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartFun {
	public WebDriverWait wait;
	@FindBy(xpath="//label[@id='ShortlistTab']")
	WebElement CheckForProducts;
	@FindBy(xpath="//span[@class=' M14_42 ']")
	WebElement dropdown;
	
	//label[@id='ShortlistTab']
	
	public CartFun(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void checkforproducts(String expectedText) {
		String actualText =CheckForProducts.getText();
		Assert.assertEquals(expectedText, actualText);
	}
	
	public String qualityValue(String expectedValue) {
	    return dropdown.getText();
	}

}
