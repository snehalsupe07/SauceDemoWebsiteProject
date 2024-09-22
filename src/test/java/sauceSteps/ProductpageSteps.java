package sauceSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductpageSteps {
	
	static WebDriver driver;

	@Given("User is logged in to the application")
	public void user_is_logged_in_to_the_application() {
		driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Then("User should see the products list")
	public void user_should_see_the_products_list() {
	    WebElement productList = driver.findElement(By.xpath("//div[@class='inventory_container']"));
	    Assert.assertTrue(productList.isDisplayed());
	}

	@Then("User should see the following products")
	public void user_should_see_the_following_products(io.cucumber.datatable.DataTable dataTable) {
		List<String> products = dataTable.asList();
		for(String product:products) {
			WebElement backpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
			Assert.assertTrue(backpack.isDisplayed());
			WebElement bikelight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
			Assert.assertTrue(bikelight.isDisplayed());
		}
	}
	
	@When("User click on the product {string}")
	public void user_click_on_the_product(String product) {
	   driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	}

	@Then("Verify that the product details page displays the productname as {string}")
	public void verify_that_the_product_details_page_displays_the_productname_as(String Productname) {
		WebElement name = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		Assert.assertEquals(Productname, name.getText());
	}

	@Then("Verify that the product details page displays the description as {string}")
	public void verify_that_the_product_details_page_displays_the_description_as(String Productdescription) {
		WebElement name = driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']"));
		Assert.assertEquals(Productdescription, name.getText());
	}

	@Then("Verify that the product details page displays the price as {string}")
	public void verify_that_the_product_details_page_displays_the_price_as(String Productprice) {
		WebElement name = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
		Assert.assertEquals(Productprice, name.getText());
	}

	@When("User clicks the {string} button for {string}")
	public void user_clicks_the_button_for(String button, String product) {
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	}

	@Then("the cart count should increase")
	public void the_cart_count_should_increase() {
		WebElement count = driver.findElement(By.xpath("//span[text()='1']"));
	    Assert.assertTrue(count.isDisplayed());
	    Assert.assertEquals(count.getText(), "1");
	}

	@Then("the product {string} should be in the cart")
	public void the_product_should_be_in_the_cart(String string) {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		WebElement item = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		Assert.assertTrue(item.isDisplayed());
	}




}
