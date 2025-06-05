Feature: DemoBlaze Application Test

  Scenario: Verify product purchase journey
   # Given I launch the Demoblaze application
    Given I verify that I am in the product store
    When I click Laptops under categories
    And I click on "Sony vaio i5" laptop
    And I add the laptop to cart
    Then I verify the popup message "Product added" and click OK
    When I navigate to Cart
    Then I verify the added laptop "Sony vaio i5" is available
    When I place an order
    And I click Purchase without filling information
    Then I verify the error message returned
    And I complete the Place order screen with the following details:
      | Name          | Country | City     | CreditCard | Month | Year |
      | Marang Montle | RSA     | Pretoria | 1234567890 | 12    | 2024 |
    And I click Purchase to confirm order
    Then I verify that the order was successfully purchased