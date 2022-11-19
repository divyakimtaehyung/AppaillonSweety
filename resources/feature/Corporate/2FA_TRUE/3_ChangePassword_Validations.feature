@2FAT @changePSd
Feature: Fields and Functionality validations of corporate application where 2FA Required value doesn't affect the action

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application


  @DB-TC-54
  Scenario Outline: Verify that during first-time login, a newly registered customer has to change the password and OTP verification is required when 2_FACTOR_AUTH = Y in the system, and the customer can log in with the changed password
    When a newly created user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    And user does not enters the data in mandatory fields
    And clicks on the Change Password Button
    Then proper error message should display under the all fields "<messagecode1>" and "<messagecode2>" and "<messagecode3>"
    When user enters invalid Old Password
#    And clicks on the Change Password Button
    Then old password field under error message should display <messagecode4>
    Examples:
      | testcase | messagecode1 |  messagecode2 |  messagecode3 | messagecode4 |
      | DB-TC-54 | CF_018       | CF_019      | CF_020      | CF_021      |


  @DB-TC-55
  Scenario Outline: Verify that system should not allow the customer to change the password and display a proper error message when the new password and confirm password doesn't match while changing the password
    When a newly created user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    When user enters generated password in Old Password
    And enters a valid New Password and distinct in Confirm Password field
    And clicks on the Change Password Button
    Then confirm password field under error message should display <messagecode1>
    Examples:
      | testcase | messagecode1 |
      | DB-TC-55 | CF_022       |


    #password policies indicated by colors ,in Mobile devices, we cannot identify colors.
  @DB-TC-56
  Scenario Outline: Verify that system should not allow the customer to change the password if the new password doesn't meet all the password policies while changing password
    When a newly created user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    When user enters generated password in Old Password
    And enters invalid password in New Password and Confirm password
    And clicks on the Change Password Button
    Then password policies should indicate failed cases <messagecode1>
    Examples:
      | testcase | messagecode1 |
      | DB-TC-56 | CF_023       |


  @DB-TC-57
  Scenario Outline: Verify that system should not allow the customer to change the password and display a proper error message when the new password exists in the password history as configured in the system while changing the password
    When a newly created user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then system should navigate the user to the Change Password screen
    When user enters generated password in Old Password
    And enters same generated password in New Password and confirm password
    And clicks on the Change Password Button
    Then user should not allowed to change Old password as New Password message should appear <messagecode1>
    Examples:
      | testcase | messagecode1 |
      | DB-TC-57 | CF_026       |


