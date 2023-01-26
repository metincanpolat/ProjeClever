

Feature:Register Functionality

  Scenario: Register to Clever website TC-01
    Given Navigate to Clever
    And Navigate to Registration Page
    When Enter user information
      |firstname|met|
      |lastname|can|
      |password|123456|
    Then User should register successfully
