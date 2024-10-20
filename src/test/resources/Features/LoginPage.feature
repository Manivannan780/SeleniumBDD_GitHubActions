Feature: Application Login Page


Scenario: TC01: Check if the user is not allowed to login to the application with an invalid user name and a valid password
    Given Launch the application
    Then User checks if the login page contents are displayed properly
    When Fill the username and password and Click login "Invalid UserName" "UserName","Password"
    Then Check the validation error message is correctly displayed "Epic sadface: Username and password do not match any user in this service"
    
Scenario: TC02: Check if the user is not allowed to login to the application without filling user name and a password
    Given Launch the application
    Then User checks if the login page contents are displayed properly
    When Fill the username and password and Click login "Empty Credentials" "UserName","Password"
    Then Check the validation error message is correctly displayed "Epic sadface: Username is required"
    
Scenario: TC03: Check if the user is not allowed to login to the application without filling user name and a password
    Given Launch the application
    Then User checks if the login page contents are displayed properly
    When Fill the username and password and Click login "Invalid Password" "UserName","UserName"
    Then Check the validation error message is correctly displayed "Epic sadface: Username and password do not match any user in this service"
    
Scenario: TC04: Check if the user is able to login to the application filling valid user name and a password
    Given Launch the application
    Then User checks if the login page contents are displayed properly
    When Fill the username and password and Click login "Valid" "UserName","UserName"
    Then Check the Products title are displayed
    Then Check the Products Names are displayed correctly
      | Sauce Labs Backpack      |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    Then Check the Page title and other elements are displayed
    And Logout the Application
   
    
    


    
    