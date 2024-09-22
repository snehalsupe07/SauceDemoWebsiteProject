package sauceSteps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartFunctionalitySteps {
	
	static WebDriver driver;	

	@Given("User already has item in the cart")
	public void user_already_has_item_in_the_cart() {
		driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	    driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
	}

	@When("User clicks cart icon")
	public void user_clicks_cart_icon() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}

	@Then("User should see the products added in the cart are displyed correctly")
	public void user_should_see_the_products_added_in_the_cart_are_displyed_correctly() {
		WebElement item = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		Assert.assertTrue(item.isDisplayed());
	}

	@When("User removes an item from cart")
	public void user_removes_an_item_from_cart() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
	}

	@Then("Item is removed")
	public void item_is_removed() {
		boolean isProductRemoved = driver.findElements(By.xpath("//a[@class='shopping_cart_link']")).isEmpty();
        Assert.assertFalse(isProductRemoved);
	}

	@Then("Cart count is updated accordingly")
	public void cart_count_is_updated_accordingly() {
		String cartCount = driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).getText(); 
		Assert.assertTrue(cartCount.isEmpty());
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String checkout) {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    driver.findElement(By.xpath("//button[@id='checkout']")).click();
	}

	@When("User enters valid checkout information")
	public void user_enters_valid_checkout_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>>  data = dataTable.asMaps();
	    WebElement fname = driver.findElement(By.xpath("//input[@id='first-name']"));
	    fname.sendKeys(data.get(0).get("First Name"));
	    WebElement lname = driver.findElement(By.xpath("//input[@id='last-name']"));
	    lname.sendKeys(data.get(0).get("Last Name"));
	    WebElement code = driver.findElement(By.xpath("//input[@id='postal-code']"));
	    code.sendKeys(data.get(0).get("Postal Code"));
	    
	}

	@When("Complete checkout process")
	public void complete_checkout_process() {
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
	}

	@Then("User should see order confirmation process")
	public void user_should_see_order_confirmation_process() {
	    WebElement confirm = driver.findElement(By.xpath("//div[@class='cart_item_label']"));
	    Assert.assertTrue(confirm.isDisplayed());
	}
}
