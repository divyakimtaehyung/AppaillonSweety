Feature: An expired bank admin has to change the password before login and irrespective of 2FA_REQUIRED is true / false

  Background: 2FA_REQUIRED is false in the system
    Given a valid bank application

  @1
  Scenario Outline: Verify that before login the bank admin has to change the password if the admin's password is expired and the admin can log in to the bank application with the changed password when 2FA_REQUIRED = false in the system
    Then create new bank admin <testcase>
    When expired 2FA_False bank admin enters the Email ID & Password  <testcase>
    Then system should navigate the admin to the Change Password screen
    When admin enters the expiray Password, New Password and Confirm Password and click change password Button
    Then Admin lands on OTP screen
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button
    Then system should show change password successfull message
    Then click ok it wil land on login page
    Then admin lands on Login screen
    When admin logs into the application with valid email ID and new password
    Then Admin lands on OTP screen
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button

    Examples:
      | testcase |
      | DB-TC-29 |