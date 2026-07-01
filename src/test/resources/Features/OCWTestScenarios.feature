@OCWWebFuctionalities
Feature: OCW Website functionality
 
  @TC_01LoginFuctionality
  Scenario: User should be able to login with valid credentials
    Given Open the OCW browser
    And Enter "Username" and "Password" and click on login button
    Then User should login successfully
    
 @TC_02BillGeneration_001
Scenario: Verify user is able navigate to bill Generation page
Given Open the OCW browser
And Enter "Username" and "Password" and click on login button
Then User should login successfully
When User clicks on Billings menu
And User clicks on Bill Generation option
Then Bill Generation page should be displayed
And User enters CAN number
And User opens Meter Status dropdown
And User selects Meter Status
And User enters Previous Meter Reading
And User enters current Meter Reading
And User enters system Reading 
And User enters current Water Charges
And user enters raw Water Surcharge
And user enters electricity Surcharge
And user enters meter Rent
And user enters other Charges
And user upload image
And user click submit button
