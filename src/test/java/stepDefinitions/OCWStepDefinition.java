package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.OCWPageObject;

public class OCWStepDefinition extends BaseTest{
		
	static OCWPageObject ocwPageObject;
	static String scenarioName;
	
	@Before //Hooks
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
	}
	@Given("Open the OCW browser")
	public void open_OCW_browser() throws FileNotFoundException, IOException {

	    BaseTest.openBrowser();

	    ocwPageObject = new OCWPageObject(driver);

	    ocwPageObject.openURL();
	}
	@And("Enter {string} and {string} and click on login button")
	public void login(String header1, String header2) throws FileNotFoundException, IOException {

	    String username = excelReader(scenarioName, header1);
	    String password = excelReader(scenarioName, header2);

	    System.out.println("Username = " + username);
	    System.out.println("Password = " + password);

	    ocwPageObject.loginUser(username, password);
	}
	
	@Then("User should login successfully")
	public void verifyUserLogin() {
		ocwPageObject.verifyUserlogin();
	}

	/*@After
	public void after() {
	    if(driver != null) {
	        driver.close();
	    }
	}
*/
		}

