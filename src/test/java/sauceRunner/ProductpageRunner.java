package sauceRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\SauceFeature\\ProductpageFunctionality.feature"},
		glue = {"sauceSteps"},
		plugin = {"pretty" , "html:target/cucumber-reports/productpagreport.html"}
		
		)

public class ProductpageRunner extends AbstractTestNGCucumberTests {

}
