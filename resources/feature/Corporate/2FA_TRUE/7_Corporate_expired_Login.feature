@2FAT @expiry
Feature: An expired corporate user has to change the password before login and irrespective of 2FA_REQUIRED is true / false

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application

  @DB-TC-58
  Scenario Outline: Verify that before login the customer has to change the password if the login password is expired and the customer can log in to the application with the changed password when 2_FACTOR_AUTH = N in the system
    When expired user enters the Email ID & Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    When user enters valid Old password, New password and Confirm password
    And clicks on the Change Password Button
    Then system should display a success message <messagecode1>
    And user is navigated to the Login screen
    And user receives a password changed email
    When user logs into the application with valid email ID and password
    Then user lands on the Dashboard page
    Examples:
      | testcase | messagecode1 |
      | DB-TC-58 | CF_024      |

   @DB-TC-59
  Scenario Outline: Verify that before login the customer has to change the password if the login password is expired and the customer can log in to the application with the changed password when 2_FACTOR_AUTH = Y in the system and the customer has opted in for 2FA
    When expired user enters the Email ID & Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    When user enters valid Old password, New password and Confirm password
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
    Then user lands on OTP screen
    And OTP sent to Email and Mobile message should appear <messagecode3>
    And user should receive an email with the OTP
    When user enters the OTP
    And clicks on the Verify button
    Then user lands on the Dashboard page
    Examples:
        | testcase | messagecode1 |  messagecode2 |  messagecode3 |
        | DB-TC-59 | CF_002       | CF_024      | CF_003     |




