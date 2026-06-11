package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//test//resources//Features",
		glue={"stepDefinitions"},
		tags = "@TC_01LoginFuctionality",
		dryRun=false,		
		plugin= {"pretty", "html:target/cucumberReports/reports.html"},
		monochrome = true
		//tags = {'@Regression'}
			
		)
public class Runner {
	
	
}
