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
		System.out.println("Scenario Name = " + scenarioName);
		System.out.println("Header1 = " + header1);
		System.out.println("Header2 = " + header2);

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

	@When("User clicks on Billings menu")
	public void user_clicks_on_billings_menu() {
	    System.out.println("Inside Step Definition");

	    ocwPageObject.clickBillingsMenu();

	}
	@And("User clicks on Bill Generation option")
	public void user_clicks_on_bill_generation_option() {

	    ocwPageObject.clickBillGeneration();
	}
	@Then("Bill Generation page should be displayed")
	public void bill_generation_page_should_be_displayed() {
	    ocwPageObject.verifyBillGenerationPage();
	}
	@And("User enters CAN number")
	public void user_enters_can_number() throws Exception {
		
	
	    String can = excelReader(scenarioName, "CAN");

	    System.out.println("CAN = " + can);

	    ocwPageObject.enterCAN(can);

	    
	    String meterStatus = excelReader(scenarioName, "MeterStatus");
	    System.out.println("Meter Status = "+meterStatus);
	   
	}
	
	@And("User opens Meter Status dropdown")
	public void user_opens_meter_status_dropdown() throws InterruptedException {
	    Thread.sleep(3000);


	    ocwPageObject.openMeterStatusDropdown();

	}
	
	
	@And("User selects Meter Status")
	public void user_selects_meter_status() throws Exception{

		String meterStatus = excelReader(scenarioName, "MeterStatus");

		System.out.println("Meter Status = " + meterStatus);

		ocwPageObject.selectMeterStatus(meterStatus);

	}
	@And("User enters Previous Meter Reading")
	public void user_enters_previous_meter_reading() throws Exception {

	    String reading = excelReader(scenarioName, "Previous Meter Reading");

	    System.out.println("Previous Meter Reading = " + reading);

	    ocwPageObject.enterPreviousMeterReading(reading);
	}
	
	@And("User enters current Meter Reading")
	public void user_enters_current_meter_reading() throws Exception{
		
		String currentReading = excelReader(scenarioName, "current Meter Reading");
		System.out.println("Current Meter Reading = "+  currentReading);
		
		ocwPageObject.enterCurrentMeterReading(currentReading);
	}
	
	@And("User enters system Reading")
	public void user_enters_system_reading() throws Exception{
		
		String systemReading = excelReader(scenarioName,"system Reading");
		
		System.out.println("System Reading="+systemReading);
		
		ocwPageObject.enterSystemReading(systemReading);
		
	}
	
	@And("User enters current Water Charges")
	public void user_enters_current_water_charges() throws Exception{
		
	String currentWaterCharges = excelReader(scenarioName,"current Water Charges");
	System.out.println("Current Water Charges="+currentWaterCharges);
	
	ocwPageObject.enterCurrentWaterCharges(currentWaterCharges);
	}
	
	@And("user enters raw Water Surcharge")
	public void user_enter_raw_water_surcharge() throws Exception{
		
		String rawWaterSurcharge = excelReader(scenarioName, "raw Water Surcharge");
		System.out.println("Raw Water Surcharge="+ rawWaterSurcharge);
		
		ocwPageObject.enterRawWaterSurcharge(rawWaterSurcharge);
		
	
	}
	
	@And("user enters electricity Surcharge")
	public void user_enter_electricity_surcharge() throws Exception{
		
		String electricitySurcharge = excelReader(scenarioName, "electricity Surcharge");
		System.out.println("Electricity Surcharge="+ electricitySurcharge);
		
		ocwPageObject.enterElectricitySurcharge(electricitySurcharge);
	
	}
	
	@And("user enters meter Rent")
	public void user_enter_meter_Rent() throws Exception{
		
		String meterRent = excelReader(scenarioName, "meterRent");
		System.out.println("MeterRent="+ meterRent);
		
		ocwPageObject.enterMeterRent(meterRent);
}
	@And("user enters other Charges")
	public void user_enter_other_charges() throws Exception{
		
		String otherCharges = excelReader(scenarioName, "otherCharges");
		System.out.println("OtherCharges="+ otherCharges);
		
		ocwPageObject.enterOtherCharges(otherCharges);
	
	}
	
	@And("user upload image")
	public void user_upload_image() throws Exception{
		
		String imagePath = excelReader(scenarioName, "uploadImage");
		System.out.println("ImagePath="+ imagePath);
		
		ocwPageObject.UploadImage(imagePath);
	
	}
	
	@And("user click submit button")
	public void user_click_submit_button() throws Exception{
		
		String submitButton = excelReader(scenarioName, "submitButton");
		System.out.println("SubmitButton="+ submitButton);
		
		ocwPageObject.SubmitButton(submitButton);
	
	}
}
	

