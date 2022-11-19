Feature: Bank admin creation by bank admin


  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When bank admin logs into the application with valid email ID and password <testcase>
    Then bank admin lands on the Dashboard page

  @1
  Scenario Outline: Verify that bank admin is able to add initiate another bank admin successfully in the system when 2_FACTOR_AUTH = N in the system
    When admin clicks on the User Management link from LHS <testcase>
    Then lands on User Management screen
    When admin clicks on Add button from User Management summary screen
    Then lands on User addition screen
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then new bank admin is initiated successfully
    And bank admin is navigated to the User Management summary screen

    Examples:
      | testcase  |
      | DB-TC-32  |


    #undeveloped features
#  Scenario Outline: Verify that the bank admin is able to approve another bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
#    Then bank admin lands on the Dashboard page
#    And clicks on the User Management link from quick links section
#    When admin clicks on the User Management link from LHS
#    Then lands on User Management screen
#    When admin searches for authorization pending as status
#    And clicks on authorization pending user
#    Then admin lands on approval screen
#    And clicks approve
#    Then bank admin is created successfully
#    And bank admin is navigated to the User Management summary screen
#    Examples:
#    DB-TC-33