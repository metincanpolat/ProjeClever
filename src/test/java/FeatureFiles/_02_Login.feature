Feature: Login Functionality

  Scenario Outline: Login to Clever website nagative TC-02
    Given Navigate to Clever
    And Navigate to Login Page
    When Enter email as "<email>" and password as "<password>"and click Sign in button
    Then User should NOT be able to login successfully
    Examples:
      | email                | password      |
      | sdcd@invalid.com     | invalid521254 |
      | abcd@technostudy.com | invalid521254 |

  Scenario: Login to Clever website positive TC-02
    Given Navigate to Clever
    And Navigate to Login Page
    When Enter email and password and click Sign in button
    Then User should be able to login successfully



