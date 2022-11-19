@2FT
Feature: Validating the OTP functionalities in the process of bank admin Login

  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When admin is in Login screen


  @1
     #resent otp disable is not happening -need to change once bugs fixed
  Scenario Outline: Verify that the bank admin is redirected to the login page when the admin clicks on the Resend OTP link consecutively for n no. of times
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button
    And clicks on the Change Password button
    Then Admin lands on OTP screen
    When clicks on the Resend OTP link for n times
    Then system should display an OTP error message
    Then admin lands on Login screen
    Examples:
      | testcase |
      | DB-TC-14 |


  @2
  Scenario Outline: Verify that the bank admin is redirected to the login page when the admin enters the wrong OTP consecutively for n no. of times
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button
    And clicks on the Change Password button
    Then Admin lands on OTP screen
    When enters invalid OTP for n times <testcase>
    And clicks on the Verify button system should display an error message
    And clicks ok
    Then admin lands on Login screen
    Examples:
      | testcase |
      | DB-TC-15 |

  @3
  Scenario Outline: Verify that during login, OTP verification is required after entering a valid email ID and password of a bank admin when 2FA_REQUIRED = true in the system and the admin has opted in for 2FA
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button
#    And clicks on the Change Password button
    Then Admin lands on OTP screen
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button
    Then system should show change password successfull message
    Then click ok it wil land on login page
    Examples:
      | testcase |
      | DB-TC-17 |

  @4
  Scenario Outline: Verify that during login, OTP verification is not required after entering a valid email ID and password of a bank admin when 2FA_REQUIRED = true in the system and the admin has opted out from 2FA
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button
#    And clicks on the Change Password button
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
    Then bank admin lands on the Dashboard page
    Examples:
      | testcase |
      | DB-TC-18 |


  @5
  Scenario Outline: Verify that once OTP expires, the bank admin should receive an email on click on Resend OTP link and the admin should be able to login into the bank application using the OTP in the same session
    Then create new bank admin <testcase>
    When a newly created bank admin enters the Email ID and Password <testcase>
    And clicks on the Login button
    Then system should navigate the admin to the Change Password screen
    When admin enters the Old Password, New Password and Confirm Password and click change password Button
#    And clicks on the Change Password button
    Then Admin lands on OTP screen
    When clicks on the Resend OTP after timer becomes zero
    And User should receive an email with the OTP
    When User enters the OTP
    And clicks on the Verify Button
    Then click ok it wil land on login page
    Examples:
      | testcase |
      | DB-TC-21 |
