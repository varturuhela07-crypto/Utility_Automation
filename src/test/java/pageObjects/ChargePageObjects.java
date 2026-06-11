package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseTest;

public class ChargePageObjects extends BaseTest {

	WebDriver driver;
	public static String SupCatName;
	public static WebElement category;
	public static WebElement cat_tax;
	public static WebElement item_name;
	static float subtotalamount;
	static float cartTax;
	static float cartDiscountAmt;
	static float totalCartAmt;
	static String receiptID;
	WebDriverWait wait;

	public ChargePageObjects(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void openURL1() throws FileNotFoundException, IOException {
		String URL = BaseTest.configMethod("URL");
		driver.get(URL);

	}

	@FindBy(xpath = "//input[@id='userName']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement userPassword;

	@FindBy(xpath = "//a[@id='login']")
	WebElement loginButton;

	@FindBy(xpath = "//a[@class='ic_top_bar showLogoutMenuBtn']")
	WebElement userIcon;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutButton;

	@FindBy(xpath = "//i[@class='mp_ic_menu']")
	WebElement menuIcon;

	@FindBy(xpath = "//a[@class='nav-link catalogTab']")
	WebElement catalogTab;

	// Super category section

	@FindBy(xpath = "//a[@data-target='#superCategoryListModal']")
	WebElement superCategorylink;

	@FindBy(xpath = "//a[@data-target='#addEditSupCatModal']")
	WebElement addSupCat;

	@FindBy(xpath = "//input[@id='supCatName']")
	WebElement superCatName;

	@FindBy(xpath = "(//a[@onclick='saveSupCategory()'])[1]")
	WebElement addSupcatSave_button;

	// Category Section

	@FindBy(xpath = "//a[@title='Add Category']")
	WebElement addCategory;

	@FindBy(xpath = "//input[@id='catName']")
	WebElement catName;

	@FindBy(xpath = "//a[@id='saveCategory']")
	WebElement addcatSave_button;

	// Add Item in Catalog

	@FindBy(xpath = "//div[@class='searchitemlist']//i[@class='mp_ic_add']")
	WebElement addItems_button;

	@FindBy(xpath = "//input[@id='itemName']")
	WebElement addItemName;

	@FindBy(xpath = "//input[@id='price']")
	WebElement addItemPrice;

	@FindBy(xpath = "//a[@id='saveItem']")
	WebElement saveItem_button;

	// Edit item in catalog
	@FindBy(xpath = "//a[@id='checkEditItemBtn']")
	WebElement edit_Item_Button;

	@FindBy(xpath = "//a[@class='delete__pro']")
	WebElement delete_button;

	// Discount percentage page xpath

	@FindBy(xpath = "//span[@class='discount']")
	WebElement cartDiscountAmount;

	@FindBy(id = "discountBTN")
	WebElement discount_button;

	@FindBy(id = "discountPer")
	WebElement discountPer_textField;

	@FindBy(id = "pctDiscountReason")
	WebElement discountPer_reason;

	@FindBy(xpath = "//a[@class='save_btn_set applyDiscountPerBtn']")
	WebElement discountPer_applyButton;

	@FindBy(xpath = "//a[@class='save_btn_set applyDiscountAmtBtn']")
	WebElement discountAmt_applyButton;

	@FindBy(id = "discountAmt")
	WebElement discountAmt_textField;

	@FindBy(id = "amtDiscountReason")
	WebElement discountAmt_reason;

	@FindBy(id = "delDiscount")
	WebElement deleteDiscount_button;

	@FindBy(xpath = "//li[contains(text(),'Discount')]/a[contains(text(),'Change')]")
	WebElement discountChange_button;

	@FindBy(id = "discountm-tab")
	WebElement DiscountPer_tab;

	@FindBy(id = "amountm-tab")
	WebElement DiscountAmt_tab;

	@FindBy(xpath = "//div[@class='alert bg-danger prependToastMessageBody text-center text-white']")
	WebElement invalidDiscount;

	@FindBy(xpath = "//div[@id='discount']//a[contains(text(),'Cancel')]")
	WebElement discountCancelButton;

	@FindBy(xpath = "//li[contains(text(),'Tax')]//span")
	WebElement cartTaxAmount;

	@FindBy(xpath = "//span[contains(text(),'Total')]/text")
	WebElement totalCartAmount;

	@FindBy(xpath = "//a[@id='charge_btn']")
	WebElement chargeButton;

	// div[@class='key-pad-box form-row']//a[text()='2']
	@FindBy(xpath = "//a[@onclick='cashPaymentBtn()']")
	WebElement cashPaymentButton;

	@FindBy(xpath = "//span[@id='refNo']")
	WebElement captureReceiptID;
	
	@FindBy(xpath = "//div[@id='orderreceipt']//button[@class='close_BTN']")
	WebElement receiptcloseButton;
	
	
	//div[@id='orderreceipt']//button[@class='close_BTN']

	// a[@id='charge_btn']
	// a[@onclick='cashPaymentBtn()']
	// b[contains(text(),'Cash')]/../../td[@class='text-right']
	// span[@id='refNo']
	// worldnetRequest('CARD')

	@FindBy(xpath = "//li[contains(text(),'Sub Total:')]//span")
	WebElement SubtotalValue;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='list-table cartitem']//div[contains(text(),'$')]"))
	private List<WebElement> rowsInCart;

	public void login(String username, String password) throws InterruptedException {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);

	}

	public void createSupCat(String supCatName) throws InterruptedException {
		catalogTab.click();
		addCategory.click();
		superCategorylink.click();
		addSupCat.click();
		superCatName.sendKeys(supCatName);
		Thread.sleep(1000);
		addSupcatSave_button.click();
	}

	public void createCategory(String CatName, String supCatName, String tax) throws InterruptedException {
		catName.sendKeys(CatName);
		WebElement supcat = driver.findElement(By.xpath("//option[text()='" + supCatName + "']"));
		supcat.click();
		cat_tax = driver.findElement(By.xpath("//option[contains(text(),'" + tax + "')]"));
		cat_tax.click();
		addcatSave_button.click();
		category = driver.findElement(By.xpath("//div[@catname='" + CatName + "']"));
		Boolean verify_cat = category.isDisplayed();
		Assert.assertTrue(verify_cat);
		Thread.sleep(2000);
		category.click();

	}

	public void createItem(String itemName, String itemPrice, String tax) throws InterruptedException {

		addItems_button.click();
		Thread.sleep(2000);
		addItemName.sendKeys(itemName);
		Thread.sleep(2000);
		addItemPrice.sendKeys(itemPrice);
		// cat_tax.click();
		saveItem_button.click();
		Thread.sleep(2000);
		item_name = driver.findElement(By.xpath("(//span/p[contains(text(),'" + itemName + "')])[1]"));
		Assert.assertTrue(item_name.isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='searchitemlist']//a[@itemprice='" + itemPrice + "']"))
						.isDisplayed());

	}

	public void verify_and_editItem(String catname, String item_name2, String itemPrice2) throws InterruptedException {
		// TODO Auto-generated method stub
		edit_Item_Button.click();
		item_name.click();
		addItemName.clear();
		addItemName.sendKeys(item_name2);
		addItemPrice.clear();
		addItemPrice.sendKeys(itemPrice2);
		saveItem_button.click();
		Thread.sleep(2000);
		category = driver.findElement(By.xpath("//div[@catname='" + catname + "']"));
		category.click();
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("(//span/p[contains(text(),'" + item_name2 + "')])[1]")).isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='searchitemlist']//a[@itemprice='" + itemPrice2 + "']"))
						.isDisplayed());

	}

	public void deleteItem(String item, String cat_name) {
		try {
			edit_Item_Button.click();
			item_name.click();
			delete_button.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			catalogTab.click();
			category = driver.findElement(By.xpath("//div[@catname='" + cat_name + "']"));
			category.click();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("(//span/p[contains(text(),'" + item + "')])[1]")).isDisplayed()) {
				System.out.println("Item not deleted");
			}
		} catch (Exception e) {

			System.out.println("item is deleted");
		}
//		Assert.assertEquals(
//				0,driver.findElement(By.xpath("(//span/p[contains(text(),'" + item + "')])[1]")).getSize());

	}

	public void logout() throws InterruptedException {
		userIcon.click();
		logoutButton.click();
		Thread.sleep(1000);
	}

	public void verify_and_editCategory(String cat_name, String cat_name2) {
		edit_Item_Button.click();
		category.click();
		catName.clear();
		catName.sendKeys(cat_name2);
		addcatSave_button.click();
		category = driver.findElement(By.xpath("//div[@catname='" + cat_name2 + "']"));
		Boolean verify_cat = category.isDisplayed();
		Assert.assertTrue(verify_cat);

	}

	public void deleteCategory_and_verify(String cat_name) {
		try {
			edit_Item_Button.click();
			category.click();
			delete_button.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			catalogTab.click();
			Boolean verify_cat = category.isDisplayed();
			assertEquals(verify_cat, "Category is not deleted");
		} catch (Exception e) {
			System.out.println("Category is deleted");
			;
		}
	}

	@SuppressWarnings("deprecation")
	public void addItemToCart_and_verify(String itemName, String quantity) throws InterruptedException {
		// TODO Auto-generated method stub

		int quant = Integer.parseInt(quantity);
		for (int i = 1; i <= quant; i++) {
			item_name.click();
			Thread.sleep(1000);
		}
		String itemPrice = driver.findElement(By.xpath("(//span/p[contains(text(),'" + itemName + "')])[1]/../.."))
				.getAttribute("itemPrice");
		float actualItemprice = convertingStringToFloat(itemPrice);
		float totalItemPrice = actualItemprice * quant;
		String itemcartPrice = driver
				.findElement(
						By.xpath("(//span[contains(text(),'" + itemName + "')]/../../following-sibling::div//span)[3]"))
				.getText();
		float totalcartItemprice = convertingStringToFloat(itemcartPrice);
		if (totalItemPrice == totalcartItemprice) {
			System.out.println("Item cart total Price is Correct");
		} else {
			System.out.println("Item cart total Price is not Correct");
		}
		// assertEquals(totalItemPrice,totalcartItemprice,);
		String Quantity = driver
				.findElement(
						By.xpath("//span[contains(text(),'" + itemName + "')]/../../following-sibling::div//input"))
				.getAttribute("value");
		int cartQuantity = Integer.parseInt(Quantity);
		assertEquals(cartQuantity, quant);
	}

	public void verify_Cart_SubtotalAmount() {
		float totalCartvalue = 0;

		int itemRows = rowsInCart.size();
		if (itemRows != 0) {

			for (int i = 1; i <= itemRows; i++) {
				String itemIndividualPrices = driver
						.findElement(By.xpath(
								"(//div[@class='list-table cartitem']//div[contains(text(),'$')]/span)[" + i + "]"))
						.getText();
				float eachRowItemPrices = convertingStringToFloat(itemIndividualPrices);
				totalCartvalue = totalCartvalue + eachRowItemPrices;
			}
			System.out.println("SubTotal Cart Value is : " + totalCartvalue);
			subtotalamount = convertingStringToFloat(SubtotalValue.getText());
			if (subtotalamount == totalCartvalue) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect Subtotal Correct");
			}

		} else {
			System.out.println("Cart is empty");
		}
	}

	public void discount_Percentage_verify(float discountPercent) throws InterruptedException {
		// TODO Auto-generated method stub

		discount_button.click();
		DiscountPer_tab.click();
		discountPer_textField.sendKeys(String.valueOf(discountPercent));
		discountPer_reason.sendKeys("Discount Percentage");
		;
		discountPer_applyButton.click();
		if (discountPercent <= 100) {
			Thread.sleep(2000);
			float discountPerAmt = (discountPercent * subtotalamount) / 100;
			discountPerAmt = convertingStringToFloat(String.valueOf(discountPerAmt));

			if (cartDiscountAmount.isDisplayed()) {
				float cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
				if (discountPerAmt == cartDiscountAmt) {
					System.out.println("Discount price is Correct");
				} else {
					System.out.println("Discount price is not Correct");
				}
			} else {
				System.out.println("Discount is not Applied :");
			}
		} else {

			assertTrue(invalidDiscount.isEnabled());
			System.out.println(invalidDiscount.getText());
			discountCancelButton.click();
		}

	}

	public void discount_Amount_verify(float discountAmount) throws InterruptedException {
		// TODO Auto-generated method stub

		discount_button.click();
		DiscountAmt_tab.click();
		discountAmt_textField.sendKeys(String.valueOf(discountAmount));
		discountAmt_reason.sendKeys("Discount Amount");
		;
		discountAmt_applyButton.click();
		if (discountAmount <= subtotalamount) {

			Thread.sleep(2000);

			if (cartDiscountAmount.isDisplayed()) {
				float cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
				if (discountAmount == cartDiscountAmt) {
					System.out.println("Discount price is Correct");
				} else {
					System.out.println("Discount price is not Correct");
				}
			} else {
				System.out.println("Discount is not Applied :");
			}

		} else {

			assertTrue(invalidDiscount.isEnabled());
			System.out.println(invalidDiscount.getText());
			Thread.sleep(1000);
			discountCancelButton.click();
		}

	}

	public void paymentProcess(String paymentMethod) throws InterruptedException {
		chargeButton.click();

		if (paymentMethod.equalsIgnoreCase("Cash")) {
			cashPaymentButton.click();
		}
//		else if(paymentMethod.equalsIgnoreCase("Cash")) {
//			wait.until(ExpectedConditions.visibilityOfElementLocated((By) cashPaymentButton));
//			cashPaymentButton.click();
//		}
//		else if(paymentMethod.equalsIgnoreCase("Cash")) {
//			wait.until(ExpectedConditions.visibilityOfElementLocated((By) cashPaymentButton));
//			cashPaymentButton.click();
//		}
//		else if(paymentMethod.equalsIgnoreCase("Cash")) {
//			wait.until(ExpectedConditions.visibilityOfElementLocated((By) cashPaymentButton));
//			cashPaymentButton.click();
//		}
		Thread.sleep(2000);

		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);
	}

	public void verifycartdetails() {
		if (cartTaxAmount.isDisplayed()) {
			cartTax = convertingStringToFloat(cartTaxAmount.getText());
			totalCartAmt = subtotalamount + cartTax;
		}
		if (cartDiscountAmount.isDisplayed()) {
			cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
			totalCartAmt = subtotalamount - cartDiscountAmt;
		}
		if (cartTaxAmount.isDisplayed() && cartDiscountAmount.isDisplayed()) {
			totalCartAmt = subtotalamount + cartTax - cartDiscountAmt;
		}

		float uiTotalValue = convertingStringToFloat(totalCartAmount.getText());
		if (uiTotalValue == totalCartAmt) {
			System.out.println("Total Cart Value is correct :" + totalCartAmt);
		} else {
			System.out.println("Total Cart Value is incorrect");
		}
	}

	public void verifyReceiptDetails(String value) {
		
		WebElement receiptAmounts = driver
				.findElement(By.xpath("//b[contains(text(),'" + value + "')]/../../td[@class='text-right']"));
		String receiptAmount = receiptAmounts.getText();

		switch(value) {
		case "Cash":
			
			
			break;
		case "Card":
			
			break;
		}
		
		receiptAmount = receiptAmount.substring(1);
		System.out.println(receiptAmount);
		float receiptAmt = convertingStringToFloat(receiptAmount);
		if (totalCartAmt == receiptAmt) {
			System.out.println("Receipt Amount is Correct: ");
		} else {
			System.out.println("Receipt Amount is not Correct: ");
		}
		receiptcloseButton.click();
//		if(receiptAmounts.isDisplayed()) {
//			if(receiptAmt==cartTax) {
//				System.out.println("Tax account is correct in receipt :"+receiptAmt);
//			}else {
//				System.out.println("Tax account is not correct in receipt :"+receiptAmt);
//			}
//		}
//		if(value.equalsIgnoreCase("Discount")) {
//			if(receiptAmt==cartTax) {
//				System.out.println("Tax account is correct in receipt :"+receiptAmt);
//			}else {
//				System.out.println("Tax account is not correct in receipt :"+receiptAmt);
//			}
//		}
//		if(value.equalsIgnoreCase("Tax")) {
//			if(receiptAmt==cartTax) {
//				System.out.println("Tax account is correct in receipt :"+receiptAmt);
//			}else {
//				System.out.println("Tax account is not correct in receipt :"+receiptAmt);
//			}
//		}

	}

}
