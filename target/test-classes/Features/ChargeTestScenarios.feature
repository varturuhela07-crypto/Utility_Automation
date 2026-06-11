@ChargeWebApplication
Feature: This feature is for Partner portal

  @TC01_login @CatalogManagement
  Scenario: User should be able to login
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    Then Click on Logout

  @TC02_addingSuperCatogory @CatalogManagement
  Scenario: Adding Super Category and Category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And I wait for Sometime
    Then Click on Logout

  @TC03_addingItem @CatalogManagement
  Scenario: Adding Item into category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    Then Click on Logout

  @TC04_editItem @CatalogManagement
  Scenario: Edit Item from category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Click on item edit button and enter the "CategoryName" "ItemName2" "ItemPrice2" then click on save and verify
    Then Click on Logout

  @TC05_deleteItem @CatalogManagement
  Scenario: Delete Item from category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Click on delete "ItemName" "CategoryName" and verify the item is deleted
    Then Click on Logout

  @TC06_editCatogory @CatalogManagement
  Scenario: validate that user is able to edit created category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And I wait for Sometime
    And Click on category edit button and enter the "CategoryName" "CategoryName2" then click on save and verify
    Then Click on Logout

  @TC07_deleteCatogory @CatalogManagement
  Scenario: validate that user is able to delete created category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And I wait for Sometime
    And Click on category edit button and click the "CategoryName" then click on delete and verify
    Then Click on Logout

  @TC08_addingItemintoCart @CatalogManagement
  Scenario: Items added to the cart and verify Items amount as per their quantities added
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    Then Click on Logout

  @TC09_verifySubTotalValue @CatalogManagement
  Scenario: verify Sub total value in cart as per added Items and their quantity
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And Add the Item and enter the "ItemName2" "ItemPrice2" "Tax" then click on save and verify
    And Add the item "itemName2" with "Quantity2" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    Then Click on Logout

  @TC10_applyDiscountPercentandVerify @CatalogManagement
  Scenario: Apply discount percentage to the cart price and verify the discount value is properly calculated
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And Add the Item and enter the "ItemName2" "ItemPrice2" "Tax" then click on save and verify
    And Add the item "itemName2" with "Quantity2" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount percentage "Discount_Percentage" to the cart value and verify the discount amount
    Then Click on Logout

  @TC11_applyDiscountAmountandVerify @CatalogManagement
  Scenario: Apply discount amount to the cart price and verify the discount value is properly calculated
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And Add the Item and enter the "ItemName2" "ItemPrice2" "Tax" then click on save and verify
    And Add the item "itemName2" with "Quantity2" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    Then Click on Logout

  @TC12_verifyPaymentProcessViaCash @CatalogManagement
  Scenario: Verify Payment process via cash and verify the Receipt Amount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName" and "Tax" and click on Save and Verify
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details and Continue on Payment option and pay via "Payment_Method"
    Then Click on Logout
