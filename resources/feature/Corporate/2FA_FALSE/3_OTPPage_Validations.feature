@2FAF
Feature: Validating the OTP functionalities in the process of corporate Login

  Background: 2FA_REQUIRED is False in the system
    Given a valid corporate application
    When user in Login screen

  @DB-TC-48
  Scenario Outline: Verify that during login, OTP verification is not required after entering a valid email ID and password of a customer when 2_FACTOR_AUTH = N in the system
    And  user enters valid Email ID and Password <testcase>
    And clicks on Login button
    And user lands on the Dashboard page
    Examples:
      | testcase |
      | DB-TC-48 |





