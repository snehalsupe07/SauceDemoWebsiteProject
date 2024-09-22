package sauceSteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationSteps {

	static WebDriver driver;
	@Given("User logged in to the application")
	public void user_logged_in_to_the_application() {
		driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	    Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user navigates to the product page")
	public void user_navigates_to_the_product_page() {
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	}

	@Then("the product page should be displayed")
	public void the_product_page_should_be_displayed() {
		WebElement name = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		Assert.assertEquals("Sauce Labs Backpack", name.getText());
	}

	@When("User navigates to the cart page")
	public void user_navigates_to_the_cart_page() {
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}

	@Then("the cart page should be displayed")
	public void the_cart_page_should_be_displayed() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));;
	}

	@When("User navigates to the checkout page")
	public void user_navigates_to_the_checkout_page() {
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
	}

	@Then("the checkout page should be displayed")
	public void the_checkout_page_should_be_displayed() {
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
	}

	@When("User clicks the {string} button")
	public void user_clicks_the_button(String logout) {
	    driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
	    driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	}

	@Then("User should be redirected to the login page")
	public void user_should_be_redirected_to_the_login_page() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
	}

	@Then("User should be logged out")
	public void user_should_be_logged_out() {
		WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
		Assert.assertTrue(login.isDisplayed());
	}

}
