# demoblaze.feature
Feature: Demoblaze Product Store Functionality

  Scenario Outline: Purchase a laptop successfully
    Given I launch the Demoblaze application
    And I verify that I am in the product store
    When I click Laptops under categories
    And I click on "<LaptopName>" laptop
    And I add the laptop to cart
    Then I verify the popup message "Product added" and click OK
    When I navigate to Cart
    Then I verify the added laptop "<LaptopName>" is available
    When I place an order
    And I complete the Place order screen with data from excel for row <RowNumber>
    And I click Purchase to confirm order
    Then I verify that the order was successfully purchased

    Examples:
      | LaptopName     | RowNumber |
      | Sony vaio i7   | 2         |
      | Dell i7 8GB    | 3         |

  Scenario: Verify error message when placing order without details
    Given I launch the Demoblaze application
    And I verify that I am in the product store
    When I click Laptops under categories
    And I click on "Sony vaio i7" laptop
    And I add the laptop to cart
    Then I verify the popup message "Product added" and click OK
    When I navigate to Cart
    Then I verify the added laptop "Sony vaio i7" is available
    When I place an order
    And I click Purchase without filling information
    Then I verify the error message returned