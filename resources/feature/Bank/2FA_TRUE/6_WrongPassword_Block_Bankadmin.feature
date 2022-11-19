@2FT
Feature: Validating the fields in the bank admin application's Login page

  Background:
    Given a valid bank application
    When admin is in Login screen

  @1
  Scenario Outline: Verify that the bank admin is not able to login into the bank application if entered Email ID is wrong or invalid
    Then create new bank admin <testcase>
    When bank admin enters invalid email ID and password <testcase>
    And clicks on the Login button
    Then system should display a proper error message
    Examples:
      | testcase |
      | DB-TC-11 |


  @2
  Scenario Outline: Verify that system will lock the bank admin after a consecutive number of failed login attempts due to the wrong password
    Then create new bank admin <testcase>
    When admin enters a valid email ID and invalid password for N-1 th time <testcase>
    And clicks on the Login button
    Then system should display a proper error message
    And failed count should increase for the admin in the database
    When admin enters a valid email ID and password <testcase>
    And clicks on the Login button
    Then admin should login successfully
    When admin enters a valid email ID and invalid password for Nth time <testcase>
    And clicks on the Login button
    Then system should display an user locked error message
    When admin enters a valid email ID and password <testcase>
    And clicks on the Login button
    Then system should display an user locked error message
    Examples:
      | testcase |
      | DB-TC-12 |
