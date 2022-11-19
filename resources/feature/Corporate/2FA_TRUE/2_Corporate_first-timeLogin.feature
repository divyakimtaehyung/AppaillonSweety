@2FAT
Feature: A a newly registered customer has to change the password before login and irrespective of 2FA_REQUIRED is true / false

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application

  @DB-TC-41
  Scenario Outline: Verify that during first-time login, a newly registered customer has to change the password and OTP verification is required when 2_FACTOR_AUTH = Y in the system, and the customer can log in with the changed password
    When a newly created user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    When user enters valid Generated password, New password and Confirm password
    And clicks on the Change Password Button
    And OTP sent message should appear <messagecode1>
    Then user lands on OTP screen
    And user should receive an email with the OTP
    When user enters the OTP
    And clicks on the Verify button
    Then system should display a success message <messagecode2>
    And user is navigated to the Login screen
    And user receives a password changed email
    When user logs into the application with valid email ID and password
    And OTP sent to Email and Mobile message should appear <messagecode3>
    Then user lands on OTP screen
    And user should receive an email with the OTP
    When user enters the OTP
    And clicks on the Verify button
    Then user lands on the Dashboard page
    Examples:
      | testcase | messagecode1 | messagecode2 |  messagecode3 |
#      | DB-TC-41 |  CF_002       | CF_004      | CF_003     |
#      | DB-TC-41-1 |CF_002       | CF_004      | CF_003     |
#      | DB-TC-41-2 |CF_002       | CF_004      | CF_003     |
      | DB-TC-41-3 |CF_002       | CF_004      | CF_003     |


#Test Case in the order : 38,39,39-1,39-2

