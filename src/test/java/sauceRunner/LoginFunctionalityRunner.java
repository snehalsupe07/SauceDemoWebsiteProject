package sauceRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\SauceFeature\\LoginFunctionality.feature"},
		glue = {"sauceSteps"},
		plugin = {"pretty", "html:target/cucumber-reports/loginreport.html"}
		
		)

public class LoginFunctionalityRunner extends AbstractTestNGCucumberTests {

}
