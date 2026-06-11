package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

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

	public void loginUser(String username, String password) {
		userNameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginBtn.click();
	}

	public void verifyUserlogin() {
		if (dashboardLabel.isDisplayed() == true) {
			System.out.println("User logged in successfully");
		} else {
			System.out.println("User noot logged in");
		}
		TakeSS("Homepage");

	}

}