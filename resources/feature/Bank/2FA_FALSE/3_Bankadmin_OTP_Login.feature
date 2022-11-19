
Feature: Validating the OTP functionalities in the process of bank admin Login

  #Note: befor run this feature ,run superAdmin created by bank admin for newly creating User

  Background: 2FA_REQUIRED is false in the system
    Given a valid bank application
    When admin is in Login screen

  @1
  Scenario Outline: Verify that during login, OTP verification is not required after entering a valid email ID and password of a bank admin when 2FA_REQUIRED = false in the system
    Then create new bank admin <testcase>
    When admin enters registered Email and password <testcase>
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button for 2FA_False
    And clicks ok
    Then Admin lands on OTP screen
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button
    Examples:
      | testcase |
      | DB-TC-22 |


  Scenario Outline: Verify that during first-time login, a newly created bank admin has to change the password and OTP verification is required when 2FA_REQUIRED = true in the system, and the admin can log in with the changed password
    When bank admin enters the Email ID and Password <testcase>
    Then admin lands on the Dashboard page
    Examples:
      | testcase |
      | DB-TC-22 |