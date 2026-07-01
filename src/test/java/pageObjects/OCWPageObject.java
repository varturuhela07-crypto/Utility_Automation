package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseTest;

public class OCWPageObject extends BaseTest {

	WebDriverWait wait;
	WebDriver driver;

	public OCWPageObject(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void openURL() throws FileNotFoundException, IOException {
		String URL = BaseTest.configMethod("URL");
		driver.get(URL);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameTextfield;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextfield;

	@FindBy(xpath = "//span[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[text()='Dashboard']")
	WebElement dashboardLabel;
	
	@FindBy(xpath = "//span[text()='Billings']")
	WebElement billingsMenu;
	
	@FindBy(xpath = "//a[@href='/be/bill-generation']")
	WebElement billingGeneration;
	
	@FindBy(xpath="//input[@placeholder='Enter CAN']")
	WebElement canTextBox;
	
	//@FindBy(xpath="//input[@role='combobox' and @aria-haspopup='listbox']")
	//WebElement meterStatusDropdown;

	@FindBy(xpath="//span[@title='Meter Ok']")
	WebElement meterOkOption;
	
	
	@FindBy(xpath="//div[@name='currentMeterStatus']")
	WebElement meterStatusDropdown;
	
	@FindBy(xpath="//input[@name='pastMeterReading']")
	WebElement previousMeterReading;
	

	@FindBy(xpath="//input[@name='currentMeterReading']")
	WebElement currentMeterReading;

	@FindBy(xpath="//input[@name='systemReading']")
	WebElement systemReading;
	
	@FindBy(xpath="//input[@name='consumptionCharge']")
	WebElement currentWaterCharges;
	
	@FindBy(xpath="//input[@name='totalWaterSurcharge']")
	WebElement rawWaterSurcharge;
	
	
	@FindBy(xpath= "//input[@name='totalElectricitySurcharge']")
	WebElement electricitySurcharge;
	
	@FindBy(xpath= "//input[@name='meterRent']")
	WebElement meterRent;
	
	@FindBy(xpath="//input[@name='otherCharges']")
	WebElement otherCharges;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement uploadImage;
	
	@FindBy(xpath="//button[@id='action-btn']")
	WebElement submitButton;
	
public void SubmitButton(String button) {
		
		System.out.println("SubmitButton="+ button);
		
		submitButton.sendKeys(button);
}
	
	
public void UploadImage(String image) {
		
		System.out.println("UploadImage="+ image);
		
		uploadImage.sendKeys(image);
}
	
	
public void enterOtherCharges(String charges) {
		
		System.out.println("OtherCharges="+ charges);
		
		otherCharges.sendKeys(charges);
}
	
	
public void enterMeterRent(String rent) {
		
		System.out.println("MeterRent="+ rent);
		
		meterRent.sendKeys(rent);
}
	
public void enterElectricitySurcharge(String surcharge) {
		
		System.out.println("ElectricitySurcharge="+ surcharge);
		
		electricitySurcharge.sendKeys(surcharge);
}

	
	public void enterRawWaterSurcharge(String surcharge) {
		
		System.out.println("RawWaterSurcharge="+ surcharge);
		
		rawWaterSurcharge.sendKeys(surcharge);
	}
	
	
	
	public void enterCurrentWaterCharges(String charges) {
		
		System.out.println("Current Water Charges="+ charges);
		
		currentWaterCharges.sendKeys(charges);
		
	}	
	
	public void enterSystemReading(String reading) {
		
		System.out.println("System Reading = "+reading);
		
		systemReading.sendKeys(reading);
	}
	
	
	
	public void enterCurrentMeterReading(String reading) {

	    System.out.println("Current Meter Reading = " + reading);

	    currentMeterReading.sendKeys(reading);
	}
	
	
	
	
	public void openMeterStatusDropdown() throws InterruptedException {
	    System.out.println("Opening Meter Status Dropdown");

	    Thread.sleep(5000);
	    
	    meterStatusDropdown.click();
	    System.out.println("Dropdown Clicked");

	}
	
	public void selectMeterStatus(String meterStatus) throws Exception {

	    System.out.println("Selecting = " + meterStatus);

	    Thread.sleep(2000);

	    driver.findElement(
	    		By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='" + meterStatus + "']")
	    ).click();
	
	
	}
	
	public void enterCAN(String can) {
	    System.out.println("Entering CAN = " + can);

	    canTextBox.sendKeys(can);
	}

	public void enterPreviousMeterReading(String reading) {

	    System.out.println("Previous Meter Reading = " + reading);

	    previousMeterReading.sendKeys(reading);
	}
	
	
	public void loginUser(String username, String password) {
		userNameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginBtn.click();
	}
	public void clickBillingsMenu() {
		System.out.println("Clicking Billings Menu");
	    billingsMenu.click();
	}
	public void clickBillGeneration() {
	    billingGeneration.click();
	}
	//@FindBy(xpath="//h1[text()='Bill Generation']")
	//WebElement billGenerationPage;
	
	public void verifyBillGenerationPage() {

	    String url = driver.getCurrentUrl();

	    if(url.contains("bill-generation")) {
	        System.out.println("Bill Generation page displayed successfully");
	    }
	    else {
	        System.out.println("Bill Generation page is not displayed");
	    }

	    TakeSS("BillGenerationPage");
	}
	
	public void verifyUserlogin() {

	    System.out.println("Inside verifyUserlogin");

	    try {
	        Thread.sleep(5000);

	        System.out.println(driver.getCurrentUrl());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    TakeSS("Homepage");
	}
	

	
	}
	


	

