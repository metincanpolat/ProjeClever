Feature:Add To Cart Functionality
  Background:
    Given Navigate to Clever
    And Navigate to Login Page
    When Enter email and password and click Sign in button
    Then User should be able to login successfully

    Scenario: Add to Cart a product on TopNav
      And Add to cart a product
      Then Check the shopping cart




#      Then Success message should be displayed
#      And Go to the shopping cart
#      Then Check the shopping cart
#      And Proceed the checkout
#      Then Complete the shopping


