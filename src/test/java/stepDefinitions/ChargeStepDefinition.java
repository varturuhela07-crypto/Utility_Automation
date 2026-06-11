//package stepDefinitions;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.text.DecimalFormat;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pageObjects.ChargePageObjects;
//
//public class ChargeStepDefinition extends BaseTest {
//
//	static ChargePageObjects ChargePage;
//	static String scenarioName;
//
//	@Before
//	public void before(Scenario scenario) {
//		scenarioName = scenario.getName();
//	}
//
//	@Given("open the browser1")
//	public void browser_is_open() throws FileNotFoundException, IOException, InterruptedException {
//		openBrowser();
//
//		ChargePage = new ChargePageObjects(driver);
//	}
//
//	@When("Navigate to URL")
//	public void open_the_Url() throws FileNotFoundException, IOException {
//		ChargePage.openURL1();
//	}
//
//	@And("I wait for Sometime")
//	public void external_wait() throws InterruptedException {
//		Thread.sleep(2000);
//	}
//
//	@And("Enter the details {string} and {string} and Click on login button")
//	public void enter_the_loginCre_partner_portal(String Header1, String Header2)
//			throws FileNotFoundException, IOException, InterruptedException {
//		String str = excelReader(scenarioName, Header1);
//		System.out.println(str);
//		String str2 = excelReader(scenarioName, Header2);
//		System.out.println(str2);
//		ChargePage.login(str, str2);
//	}
//
//	@And("Navigate to Catalog Section and add super category {string} click on Save button")
//	public void clickAddSupCat(String SupCatName) throws FileNotFoundException, IOException, InterruptedException {
//		String name = excelReader(scenarioName, SupCatName);
//		System.out.println(name);
//		ChargePage.createSupCat(name);
//	}
//
//	@And("Enter the {string},{string} and {string} and click on Save and Verify")
//	public void createcategory(String catName, String SupCatName, String Tax)
//			throws FileNotFoundException, IOException, InterruptedException {
//		String cat_name = excelReader(scenarioName, catName);
//		String supcat_name = excelReader(scenarioName, SupCatName);
//		String tax = excelReader(scenarioName, Tax);
//		ChargePage.createCategory(cat_name, supcat_name, tax);
//	}
//
//	@And("Add the Item and enter the {string} {string} {string} then click on save and verify")
//	public void add_item(String itemName, String price, String tax) throws FileNotFoundException, IOException, InterruptedException {
//		String item_name = excelReader(scenarioName, itemName);
//		String itemPrice = excelReader(scenarioName, price);
//		String item_tax = excelReader(scenarioName, tax);
//		ChargePage.createItem(item_name, itemPrice, item_tax);
//	}
//	
//	@And("Click on item edit button and enter the {string} {string} {string} then click on save and verify")
//	public void edit_Item(String catName,String name,String price) throws FileNotFoundException, IOException, InterruptedException {
//		String item_name2 = excelReader(scenarioName, name);
//		String cat_name = excelReader(scenarioName, catName);
//		String itemPrice2 = excelReader(scenarioName, price);
//		ChargePage.verify_and_editItem(cat_name,item_name2,itemPrice2);
//	}
//	
//	@And("Click on delete {string} {string} and verify the item is deleted")
//	public void delete_Item(String item_Name,String category) throws FileNotFoundException, IOException, InterruptedException {
//		String item_name = excelReader(scenarioName, item_Name);
//		String cat_name = excelReader(scenarioName, category);
//		ChargePage.deleteItem(item_name,cat_name);
//	}
//	
//	@Then("Click on Logout")
//	public void logout() throws InterruptedException {
//		ChargePage.logout();
//	}
//	
//	@And("Click on category edit button and enter the {string} {string} then click on save and verify")
//	public void edit_Category(String catName,String catname2) throws FileNotFoundException, IOException, InterruptedException {
//		String cat_name2 = excelReader(scenarioName, catname2);
//		String cat_name = excelReader(scenarioName, catName);
//		
//		ChargePage.verify_and_editCategory(cat_name,cat_name2);
//	}
//	
//	@And("Click on category edit button and click the {string} then click on delete and verify")
//	public void delete_Category(String catName) throws FileNotFoundException, IOException, InterruptedException {
//		
//		String cat_name = excelReader(scenarioName, catName);
//		
//		ChargePage.deleteCategory_and_verify(cat_name);
//	}
//	
//	 @And("Add the item {string} with {string} to the cart and verify the item is added successfully")
//	public void addItem(String itemName,String quantity) throws FileNotFoundException, IOException, InterruptedException {
//	 String item_name = excelReader(scenarioName, itemName);
//	 String quant = excelReader(scenarioName, quantity);
//	 ChargePage.addItemToCart_and_verify(item_name,quant);
//	
//	 }
//	 
//	 @And("Verify the Sub Total Amount is correct as per the items value added in the cart")
//	 public void verifySubTotalAmount() {
//		 ChargePage.verify_Cart_SubtotalAmount();
//	 }
//	 
//	 @And("Enter the discount percentage {string} to the cart value and verify the discount amount")
//		public void discount_Percent(String discountPercentage) throws FileNotFoundException, IOException, InterruptedException {
//		 String discountPer = excelReader(scenarioName, discountPercentage);
//		 float discountpercent = convertingStringToFloat(discountPer);
//		 ChargePage.discount_Percentage_verify(discountpercent);
//		
//		 }
//	 @And("Enter the discount amount {string} to the cart value and verify the discount amount")
//		public void discount_Amount(String discountAmount) throws FileNotFoundException, IOException, InterruptedException {
//		 String discountAmt = excelReader(scenarioName, discountAmount);
//		 float discountAmoun = convertingStringToFloat(discountAmt);
//		 ChargePage.discount_Amount_verify(discountAmoun);
//		
//		 }
//	 @And("verify cart details and Continue on Payment option and pay via {string}")
//		public void payment_Process(String paymentMethod)
//				throws FileNotFoundException, IOException, InterruptedException {
//		 String paymenttype = excelReader(scenarioName, paymentMethod);
//		 ChargePage.verifycartdetails();
//		 ChargePage.paymentProcess(paymenttype);
//		 ChargePage.verifyReceiptDetails(paymenttype);
//	 }
//	 @After
//		public void after() {
//			driver.close();
//
//		}
//		
//}