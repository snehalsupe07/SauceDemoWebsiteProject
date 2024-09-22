package sauceRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\SauceFeature\\CartFunctionality.feature"},
		glue = {"sauceSteps"},
		plugin = {"pretty" , "html:target/cucumber-reports/cartfunctionalityreport.html"}
		
		)

public class CartFunctionalityRunner extends AbstractTestNGCucumberTests {

}
