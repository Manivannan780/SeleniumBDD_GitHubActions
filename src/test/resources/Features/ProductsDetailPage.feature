Feature: Product Details Page

Scenario: TC:01- Verify that the user is able to add and remove the product from the cart by selecting the add to cart button in the Products Details page
    Given Launch the application
    Then User checks if the login page contents are displayed properly
    When Enter the username and password and click login
    Then Check the Products title are displayed
    Then Check the Products Names are displayed correctly
      | Sauce Labs Backpack      |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    And User clicks the Product title link on the Products page "Test.allTheThings() T-Shirt (Red)"
    And Check that Product detail page elements are displayed correctly and interactable
    Then Check if the Product name is displayed correctly "Test.allTheThings() T-Shirt (Red)"
    Then Check if the Product Price is displayed correctly "$15.99"
    Then Check if the Product Description is displayed correctly "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."
    And User clicks on the Add Cart button on the Products details page
    Then Check if the Add to Cart button has changed to the Remove button after clicking the Add to Cart button on the Products Detail page
    Then Verify that the cart icon displays the count of products added to the cart "1" 
    And User clicks on the product Remove button on the products details page
    Then Check if the Remove button has changed to the Add to Cart button after clicking the Remove button on the Products Detail page
    And Logout the Application
    