@super @2FAF
Feature: Bank admin creation by super admin


  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When super admin enters a valid email ID and password <testcase>
    And clicks on the Login button
    Then super admin lands on the Dashboard page


  @superAdmin
  Scenario Outline: Create a bank admin by super admin when 2FA_REQUIRED is true in the system and super admin has opted in for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And super admin is navigated to the User Management summary screen
    And new bank admin should receive an email with the login password <testcase>
    Examples:
      | testcase  |
      |  DB-TC-10 |

@optout
  Scenario Outline: Create a bank admin by super admin when 2FA_REQUIRED is true in the system and super admin has opted out for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And super admin is navigated to the User Management summary screen
    And new bank admin should receive an email with the login password <testcase>
    Examples:
      | testcase  |
      |  DB-TC-34 |