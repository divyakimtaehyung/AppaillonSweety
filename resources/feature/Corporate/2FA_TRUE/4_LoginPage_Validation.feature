@2FAT  @Login
Feature: Validating the invalid cases in the corporate application's Login page

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application

  @DB-TC-43
  Scenario Outline: Verify that a customer is not able to login into the customer application if a wrong or an invalid Email ID is entered
    When user in Login screen
    And clicks on Login button
    Then proper error pop-up message should display <messagecode1>
    And user enters invalid data in Email <testcase>
    And clicks on Login button
    Then error message should display <messagecode2>
    Examples:
        | testcase | messagecode1 | messagecode2 |
        | DB-TC-43 | CF_005       | CF_007       |

  @DB-TC-44
  Scenario Outline: Verify that the system will lock the customer after a consecutive number of failed logins attempts due to the wrong password entered
    When user in Login screen
    And user enters registered Email ID and invalid password <testcase>
    And clicks on Login button
    Then proper error pop-up message should display <messagecode1>
    And user repeats the 2nd and 3rd step for n times
    Then error message should display <messagecode2>
    Examples:
        | testcase | messagecode1 | messagecode2 |
        | DB-TC-44 | CF_007       | CF_008       |


