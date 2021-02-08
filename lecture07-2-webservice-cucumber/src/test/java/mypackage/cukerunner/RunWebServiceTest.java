package mypackage.cukerunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
        glue = "mypackage.cukesteps",
		features = "classpath:cukefeatures/webservice.feature")
public class RunWebServiceTest {
		
}