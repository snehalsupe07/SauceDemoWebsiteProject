package sauceSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalitySteps {
	
	static WebDriver driver;
	
	@Given("User should be at login page")
	public void login_page() {
	    driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	}

	@When("User enters valid username as {string}")
	public void user_enters_valid_username_as(String user) {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	}

	@And("User enters valid password as {string}")
	public void user_enters_valid_password_as(String pass) {
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	}

	@And("Click on login button")
	public void login_button() {
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Then("User is redirected to products page")
	public void products_page() {
	    String url = driver.getCurrentUrl();
	    Assert.assertTrue(url.contains("inventory.html"), "Logged in successfully");
	}

	@Then("Verify username is displayed")
	public void verify_username_is_displayed() {
	  WebElement title = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
	   Assert.assertTrue(title.isDisplayed());
	}
	
	@When("User enters invalid username as {string}")
	public void user_enters_invalid_username_as(String user) {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("wrong_user");
	}

	@When("User enters invalid password as {string}")
	public void user_enters_invalid_password_as(String pass) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wrong_password");
	}

	@Then("User should see an error message for invalid credntials")
	public void user_should_see_an_error_message_for_invalid_credntials() {
	    WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
	    Assert.assertTrue(errorMsg.isDisplayed());
	}
	
	@When("User Leaves both username and password fields empty")
	public void user_leaves_both_username_and_password_fields_empty() {
		//Leave fields empty
	}

	@Then("Verify that an error message is displayed for empty credentials")
	public void verify_that_an_error_message_is_displayed_for_empty_credentials() {
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
	    Assert.assertTrue(errorMessage.isDisplayed());
	}

}
