package sauceRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\SauceFeature\\Navigation.feature"},
		glue = {"sauceSteps"},
		plugin = {"pretty" , "html:target/cucumber-reports/navigationreport.html"}
		
		)

public class NavigationRunner extends AbstractTestNGCucumberTests {

}
