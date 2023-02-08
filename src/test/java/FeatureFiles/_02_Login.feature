Feature: Login Functionality

  @Smoke
  Scenario Outline: Login to Clever website negative TC-02
    Given Navigate to Clever
    And Navigate to Login Page
    When "<Try>" Enter email as "<email>" and password as "<password>"and click Sign in button
    Then User should NOT be able to login successfully
    Examples:
       |Try                                | email            | password      |
       |invalid email and invalid password | sdcd@invalid.com | invalid521254 |
       |valid email and invalid password   | abc@metcan.com   | invalid521254 |

  Scenario: Login to Clever website positive TC-02
    Given Navigate to Clever
    And Navigate to Login Page
    When Enter email and password and click Sign in button
    Then User should be able to login successfully

  Scenario: Login to Clever website positive with Excel TC-02
    Given Navigate to Clever
    And Navigate to Login Page
    When Enter email and password and click Sign in button with Excel
    Then User should be able to login successfully



