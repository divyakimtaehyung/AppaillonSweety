@2FT
Feature: A newly created bank admin has to change the password before login and 2FA is required irrespective of 2FA_REQUIRED is true / false

  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When admin is in Login screen


  @1
  Scenario Outline: Verify that system should not allow the bank admin to change the password and display a proper error message when entered old password doesn't match with the current password while changing the password
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin clicks on the Change Password button
    Then system should display an error message
    When admin enters wrong Old Password
    And admin clicks on the Change Password button
    Then system should display an error message
    Examples:
      | testcase |
      | DB-TC-23 |


  @2
  Scenario Outline: Verify that system should not allow the bank admin to change the password and display a proper error message when the new password and confirm password doesn't match while changing the password
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password
    And enters a New Password
    And enters a wrong password in Confirm Password field
    And admin clicks on the Change Password button
    Then system should display confirm password an error message
    Examples:
      | testcase |
      | DB-TC-24 |


  @3
  Scenario Outline: Verify that system should not allow the bank admin to change the password and display a proper error message when the new password exists in the password history as configured in the system while changing the password
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters current password in Old Password
    And enters same current password in New Password and confirm password
    And admin clicks on the Change Password button
    Then system should display an invalid error message
    Examples:
      | testcase |
      | DB-TC-25 |

  @4
  Scenario Outline: Verify that system should not allow the bank admin to change the password if the new password doesn't meet all the password policies while changing password
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters current password in Old Password
    And enters invalid password in New Password and confirm password
    And admin clicks on the Change Password button
    Then system should display an invalid error message
    Examples:
      | testcase |
      | DB-TC-26 |

  @5
  Scenario Outline: Verify that during first-time login, a newly created bank admin has to change the password and OTP verification is required when 2FA_REQUIRED = true in the system, and the admin can log in with the changed password
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button
    And clicks on the Change Password button
    Then Admin lands on OTP screen
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button
    Then system should show change password successfull message
    Then click ok it wil land on login page
    When admin logs into the application with valid email ID and new password
    Then Admin lands on OTP screen
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button
    Examples:
      | testcase |
      | DB-TC-13 |
