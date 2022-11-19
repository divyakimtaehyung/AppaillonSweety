@2FT
Feature: Bank admin creation by bank admin

  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When bank admin logs into the application with valid email ID and password <testcase>
    Then bank admin lands on the Dashboard page

  @bank
  Scenario Outline: Verify that the bank admin is able to add initiate another bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When admin clicks on the User Management link from LHS
    Then lands on User Management screen
    When admin clicks on Add button from User Management summary screen
    Then lands on User addition screen
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then new bank admin is initiated successfully
    And bank admin is navigated to the User Management summary screen
    Examples:
      | testcase |
      | DB-TC-30 |


  @optOut
  Scenario Outline: Verify that the bank admin is able to add initiate another bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When admin clicks on the User Management link from LHS
    Then lands on User Management screen
    When admin clicks on Add button from User Management summary screen
    Then lands on User addition screen
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then new bank admin is initiated successfully
    And bank admin is navigated to the User Management summary screen
    Examples:
      | testcase |
      | DB-TC-35 |


    #undeveloped feature
  @1
  Scenario Outline: Verify that the bank admin is able to approve another bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And bank authorizer is navigated to the UserManagement summary screen<testcase>
    When admin clicks on the User Management link from LHS
    Then lands on User Management screen
    When enters bank admin UnAuthorized user Email Id search criteria and click search <testcase>
    When select Unauthorized in Status search criteria and click search
    When clicks on one unauthorized record
    And bank admin lands on confirmation screen and clicks on approve button
    Then bank admin is created successfully
    And bank admin is navigated to the UserManagement summary screen<testcase>
    When admin clicks on the User Management link from LHS
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    Then bank admin record of search match will be displayed in the result
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase |
      | DB-TC-36 |

  @2
  Scenario Outline: Verify that the bank admin is able to approve another bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And bank authorizer is navigated to the UserManagement summary screen<testcase>
    When admin clicks on the User Management link from LHS
    Then lands on User Management screen
    When enters bank admin UnAuthorized user Email Id search criteria and click search <testcase>
    When select Unauthorized in Status search criteria and click search
    When clicks on one unauthorized record
    And bank admin lands on confirmation screen and clicks on approve button
    Then bank admin is created successfully
    And bank admin is navigated to the UserManagement summary screen<testcase>
    When admin clicks on the User Management link from LHS
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    Then bank admin record of search match will be displayed in the result
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase |
      | DB-TC-31 |


